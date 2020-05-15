package at.technikum;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.DataAccessLayer.Database;
import at.technikum.Model.PictureModelImpl;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PictureModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationFX extends Application {

    public static void main(String[] args) throws Exception {
        Database db = new Database();
        db.connect();
        /*BusinessLayer businessLayer = new BusinessLayerImpl();
        PictureModel pictureModel = businessLayer.getPicture(2);

        System.out.println("ID: " + pictureModel.getID() + " , name: "
                + pictureModel.getFileName());*/
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
        Scene scene = new Scene(root, 800, 800);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("stylesheet.css")));
        primaryStage.setTitle("PIC DB");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
