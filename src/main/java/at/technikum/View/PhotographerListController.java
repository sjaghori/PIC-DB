package at.technikum.View;

import at.technikum.PresentationModel.PhotographerManagerPresentationModel;
import at.technikum.Utils.Binding;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.models.PhotographerModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PhotographerListController extends AbstractController {

    private static final Logger logger = LogManager.getLogger(PhotographerListController.class);

    private PhotographerManagerPresentationModel photographerManagerPresentationModel = new PhotographerManagerPresentationModel();

    @FXML
    public HBox photographerManagerView;

    @FXML
    public ListView photographerListView;

    ArrayList<PhotographerModel> photographerList = new ArrayList<>();
    ObservableList<PhotographerModel> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        super.initialize(url, resources);

        Binding.applyBinding(photographerManagerView, photographerManagerPresentationModel.getPhotographerPresentationModel());

        list.addAll(photographerManagerPresentationModel.getPhotographerListPresentationModel().getList());

        photographerListView.setItems(list);

        photographerListView.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell<PhotographerModel> call(ListView listView) {
                return new ListCell<PhotographerModel>() {
                    @Override
                    protected void updateItem(PhotographerModel item, boolean empty) {
                        // Must call super
                        super.updateItem(item, empty);
                        int index = this.getIndex();
                        String name = null;

                        // Format Display Name of Photographer
                        if (item == null || empty) {
                            // No action to perform
                        } else {
                            if (item.getFirstName() == null){
                                name = item.getLastName();
                            } else {
                                name = item.getFirstName() + ", " + item.getLastName();
                            }
                        }
                        this.setText(name);
                        this.setGraphic(null);
                    }
                };
            }
        });


    }

    public void savePhotographer() {
        photographerManagerPresentationModel.updateDatabase();
        list.clear();
        list.addAll(photographerManagerPresentationModel.getPhotographerListPresentationModel().getList());

        photographerListView.setItems(list);
    }


    public void selectPhotographer() {
        ObservableList selectedIndices = photographerListView.getSelectionModel().getSelectedIndices();
        int selectedIndex = 1;
        for (Object o : selectedIndices) {
            selectedIndex = (Integer) o + 1;
        }
        photographerManagerPresentationModel.selectPhotographer(selectedIndex);
    }
}
