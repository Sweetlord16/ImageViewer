package software.ulpgc.imageviewer.control;

import software.ulpgc.imageviewer.model.ImageModel;
import software.ulpgc.imageviewer.view.ImageView;

import javax.swing.*;

public class ImageController {
    private final ImageModel model;
    private final ImageView view;

    public ImageController(ImageModel model, ImageView view) {
        this.model = model;
        this.view = view;

        initializeView();

        view.getNextButton().addActionListener(e -> {
            model.showNextImage();
            view.displayImage(model.getCurrentImage());
        });

        view.getPrevButton().addActionListener(e -> {
            model.showPreviousImage();
            view.displayImage(model.getCurrentImage());
        });

        view.getOpenButton().addActionListener(e -> openImage());
    }

    private void initializeView() {
        view.displayImage(model.getCurrentImage());
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);

        if (result == JFileChooser.APPROVE_OPTION) {
            String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            model.loadImage(imagePath);
            view.displayImage(imagePath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageModel model = new ImageModel();
            ImageView view = new ImageView();
            ImageController controller = new ImageController(model, view);
            view.setVisible(true);
        });
    }
}
