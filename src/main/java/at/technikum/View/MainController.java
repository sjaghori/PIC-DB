package at.technikum.View;


import at.technikum.PresentationModel.MainWindowPresentationModelImpl;
import at.technikum.Utils.Binding;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends AbstractController {
    private static final Logger logger = LogManager.getLogger(MainController.class);
    public VBox iptcView;
    public VBox exifView;
    public HBox pictureListView;

    MainWindowPresentationModel mainWindowPresentationModel = new MainWindowPresentationModelImpl();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        Binding.applyBinding(iptcView, mainWindowPresentationModel.getCurrentPicture().getIPTC());
        Binding.applyBinding(exifView, mainWindowPresentationModel.getCurrentPicture().getIPTC());
    }

    public void onSaveChanges() {
    }
}
