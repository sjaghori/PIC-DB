package at.technikum.View;

import at.technikum.interfaces.AbstractController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MenuBarController extends AbstractController {

    @FXML
    public Button search_button;
    public TextField search_field;

    @FXML
    public MenuBar helpmenu;

    @FXML
    public Menu help_bar;

    @FXML
    void onSearchButtonClicked() {
        String text = search_field.getText();
        System.out.println("Searched for: " + text);
    }

    @FXML
    public void onClickAboutPage() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("aboutPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("About");
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            scene.getStylesheets().add(String.valueOf(getClass().getResource("../stylesheet.css")));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onExitButton() {
        Platform.exit();
    }

    public void onChooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(".."));
        File selectedDirectory = null;
        try {
            selectedDirectory = directoryChooser.showDialog(getStage());
            System.out.println(selectedDirectory.getAbsolutePath());
        } catch (NullPointerException e) {
            System.out.println("no Directory was Selected!");
        }
    }

    public void onEditPhotographer(ActionEvent actionEvent) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("photographerList.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Photographers List");
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            scene.getStylesheets().add(String.valueOf(getClass().getResource("../stylesheet.css")));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
