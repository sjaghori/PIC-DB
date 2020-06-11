package at.technikum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ApplicationFX extends Application {

    private static final Logger logger = LogManager.getLogger(ApplicationFX.class);

    public static void main(String[] args) {
        logger.info("Log4j2: launching application!");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
        assert root != null;
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("stylesheet.css")));
        primaryStage.setTitle("PIC DB");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
