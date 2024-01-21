package software.ulpgc.imageviewer.model;

import java.util.ArrayList;
import java.util.List;

public class ImageModel {
    private List<String> images;
    private int currentIndex;

    public ImageModel() {
        images = new ArrayList<>();
        currentIndex = 0;
    }

    public void loadImage(String imagePath) {
        images.add(imagePath);
    }

    public String getCurrentImage() {
        if (images.isEmpty()) {
            return null;
        }
        return images.get(currentIndex);
    }

    public void showNextImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex + 1) % images.size();
        }
    }

    public void showPreviousImage() {
        if (!images.isEmpty()) {
            currentIndex = (currentIndex - 1 + images.size()) % images.size();
        }
    }
}
