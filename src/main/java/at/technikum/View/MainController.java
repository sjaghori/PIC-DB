package at.technikum.View;


import at.technikum.PresentationModel.MainWindowPresentationModelImpl;
import at.technikum.Utils.Binding;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends AbstractController {
    private static final Logger logger = LogManager.getLogger(MainController.class);

    @FXML
    public AnchorPane iptcView;
    public AnchorPane exifView;

    MainWindowPresentationModel mainWindowPresentationModel = new MainWindowPresentationModelImpl();

    public MainController() throws Exception {
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        Binding.applyBinding(iptcView, mainWindowPresentationModel.getCurrentPicture().getIPTC());
        Binding.applyBinding(exifView, mainWindowPresentationModel.getCurrentPicture().getEXIF());
    }

    public void onSaveChanges() {
    }
}
