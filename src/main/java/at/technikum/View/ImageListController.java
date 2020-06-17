package at.technikum.View;

import at.technikum.PresentationModel.MainWindowPresentationModelImpl;
import at.technikum.interfaces.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;


import java.net.URL;
import java.util.ResourceBundle;

public class ImageListController extends AbstractController {

    @FXML
    private ListView pictureListView;

    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        list = new MainWindowPresentationModelImpl().getList().getpics();



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

                        int index = this.getIndex();
                        String filename = null;

                        // Format filename
                        if (item == null || empty) {
                            // No action to perform
                        } else {
                            filename = String.valueOf(item);
                        }

                        //imageView.setImage((Image) item);

                        //this.setText(filename);

                        setGraphic((Node) item);
                    }
                };
            }
        });
    }

    public void selectImage(MouseEvent mouseEvent) {
        ImageView selectedImage = (ImageView) pictureListView.getSelectionModel().getSelectedItem();
        int selectedIndex = pictureListView.getItems().indexOf(selectedImage);
        System.out.println(selectedIndex);
    }
}
