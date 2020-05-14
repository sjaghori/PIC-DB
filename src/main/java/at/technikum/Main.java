package at.technikum;

import at.technikum.DataAccessLayer.Database;
import at.technikum.Model.PhotographerModelImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        Database db = new Database();
        db.connect();
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
        primaryStage.setTitle("PIC DB");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }
}
