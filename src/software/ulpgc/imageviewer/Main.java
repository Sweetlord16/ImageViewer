package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.control.ImageController;
import software.ulpgc.imageviewer.model.ImageModel;
import software.ulpgc.imageviewer.view.ImageView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageModel imageModel = new ImageModel();
            ImageView imageView = new ImageView();
            ImageController imageController = new ImageController(imageModel, imageView);
            imageView.setVisible(true);
        });
    }
}
