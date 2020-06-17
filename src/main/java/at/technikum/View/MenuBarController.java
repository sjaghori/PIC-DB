package at.technikum.View;

import at.technikum.PresentationModel.SearchPresentationModelImpl;
import at.technikum.Utils.Binding;
import at.technikum.Utils.Report;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.presentationmodels.SearchPresentationModel;
import com.itextpdf.text.DocumentException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuBarController extends AbstractController {

    @FXML
    public VBox searchView;
    public MenuBar helpmenu;

    SearchPresentationModel searchPresentationModel = new SearchPresentationModelImpl();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        Binding.applyBinding(searchView, searchPresentationModel);
    }

    @FXML
    void onSearchButtonClicked() {
        String text = searchPresentationModel.getSearchText();
        System.out.println("Searched for: " + text);
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

    public void onEditPhotographer() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("photographerList.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Photographers List");
            Scene scene = new Scene(root, 400, 400);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClickAboutPage() {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("aboutPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("About");
            Scene scene = new Scene(root, 600, 400);
            stage.setScene(scene);
            //scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreateReport() {
        Report report = new Report();
        report.createReport();
    }
}
