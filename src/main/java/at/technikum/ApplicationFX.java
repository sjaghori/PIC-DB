package at.technikum;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PictureModel;
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

    public static void main(String[] args) throws Exception {

        logger.info("Hello from Log4j 2");

        BusinessLayer businessLayer = new BusinessLayerImpl();
        PictureModel pictureModel = businessLayer.getPicture(2);

        System.out.println("ID: " + pictureModel.getID() + " , name: "
                + pictureModel.getFileName());

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
