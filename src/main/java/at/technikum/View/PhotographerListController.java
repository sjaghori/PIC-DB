package at.technikum.View;

import at.technikum.Business.BusinessLayerImpl;
import at.technikum.PresentationModel.PhotographerListPresentationModelImpl;
import at.technikum.PresentationModel.PhotographerPresentationModelImpl;
import at.technikum.Utils.Binding;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.BusinessLayer;
import at.technikum.interfaces.models.PhotographerModel;
import at.technikum.interfaces.presentationmodels.PhotographerListPresentationModel;
import at.technikum.interfaces.presentationmodels.PhotographerPresentationModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhotographerListController extends AbstractController {

    private static final Logger logger = LogManager.getLogger(PhotographerListController.class);

    PhotographerPresentationModel photographerPresentationModel = new PhotographerPresentationModelImpl();
    PhotographerListPresentationModel photographerListPresentationModel = new PhotographerListPresentationModelImpl();

    @FXML
    public HBox photographerManagerView;

    @FXML
    public ListView photographerListView;
    ArrayList<PhotographerModel> photographerList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        Binding.applyBinding(photographerManagerView, photographerPresentationModel);

        BusinessLayer businessLayer = new BusinessLayerImpl();
        try {
            photographerList = (ArrayList<PhotographerModel>) businessLayer.getPhotographers();
            for (PhotographerModel photographer : photographerList) {
                photographerListView.getItems().add(photographer.getLastName());
            }
        } catch (Exception e) {
            logger.error("Exception: " + e.toString());
        }
    }

    public void savePhotographer() {

    }


    public void selectPhotographer() {
        ObservableList selectedIndices = photographerListView.getSelectionModel().getSelectedIndices();
        int selectedIndex = 0;
        for(Object o : selectedIndices){
            selectedIndex = (Integer)o;
        }
        System.out.println(photographerList.get(selectedIndex).getBirthDay());
    }
}
