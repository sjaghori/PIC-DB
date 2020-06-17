package at.technikum;

import at.technikum.View.ImageListController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ImageListView extends AnchorPane {

    ImageListController controller;

    public ImageListView() throws IOException {
        super(); //don't forget our parents!

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("View/imageListView.fxml"));

            controller = new ImageListController();
            loader.setController(controller);

            Node n = loader.load();
            this.getChildren().add(n);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
