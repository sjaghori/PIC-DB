package at.technikum.View;


import at.technikum.Business.BusinessLayerImpl;
import at.technikum.PresentationModel.MainWindowPresentationModelImpl;
import at.technikum.Utils.Binding;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
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
    public AnchorPane bigImageContainer;
    public AnchorPane photographerTabView;
    public ImageView bigImage;
    public ChoiceBox photographerBox;

    MainWindowPresentationModel mainWindowPresentationModel = MainWindowPresentationModelImpl.getInstance();
    BusinessLayer dal = BusinessLayerImpl.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        bigImage.fitWidthProperty().bind(bigImageContainer.widthProperty());
        bigImage.fitHeightProperty().bind(bigImageContainer.heightProperty());

        Binding.applyBinding(bigImage, mainWindowPresentationModel.getCurrentPicture());
        Binding.applyBinding(iptcView, mainWindowPresentationModel.getCurrentPicture().getIPTC());
        Binding.applyBinding(exifView, mainWindowPresentationModel.getCurrentPicture().getEXIF());
        photographerBox.getItems().addAll(dal.getPhotographers());


    }

    public void onSaveChanges() {
        PhotographerModel photo = (PhotographerModel)photographerBox.getSelectionModel().getSelectedItem();
        mainWindowPresentationModel.saveChanges(photo);
    }

    private static MainController instance = null;

    public static MainController getInstance() throws Exception {
        if (instance == null)
            instance = new MainController();
        return instance;
    }
}
