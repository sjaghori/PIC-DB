package at.technikum.View;

import at.technikum.PresentationModel.MainWindowPresentationModelImpl;
import at.technikum.interfaces.AbstractController;
import at.technikum.interfaces.presentationmodels.MainWindowPresentationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;

public class ImageListController extends AbstractController {

    MainController mainController = MainController.getInstance();

    private static ImageListController instance = null;
    public static ImageListController getInstance() throws Exception {
        if (instance == null)
            instance = new ImageListController();
        return instance;
    }

    @FXML
    private ListView pictureListView;

    ObservableList list = FXCollections.observableArrayList();

    MainWindowPresentationModel main;

    public ImageListController() throws Exception { }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        main = MainWindowPresentationModelImpl.getInstance();
        list = main.getList().getpics();

        pictureListView.getItems().addAll(list);

        pictureListView.setCellFactory(new Callback<ListView, ListCell>() {
            private ImageView imageView = new ImageView();
            @Override
            public ListCell call(ListView listView) {
                return new ListCell(){
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        // Must call super
                        super.updateItem(item, empty);

                        setText(null);
                        setGraphic((Node) item);
                    }
                };
            }
        });
    }

    public void selectImage() {
        ImageView selectedImage = (ImageView) pictureListView.getSelectionModel().getSelectedItem();
        int selectedIndex = pictureListView.getItems().indexOf(selectedImage);
        selectedIndex += 1;
        if (selectedIndex == -1) {
            selectedIndex = 1;
        }
        main.selectPicture(selectedIndex);
    }

    public void refreshList() {
        list = main.getList().getpics();
        pictureListView.getItems().clear();
        pictureListView.getItems().addAll(list);
    }

}
