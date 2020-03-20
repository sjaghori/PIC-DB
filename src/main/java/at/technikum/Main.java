package at.technikum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // https://stackoverflow.com/a/39328704
        Parent root = null;
        try {
            URL url = new File("src/main/resources/at/technikum/main.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("PIC DB");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
