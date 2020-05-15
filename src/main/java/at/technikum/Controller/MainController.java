package at.technikum.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;

public class MainController extends AbstractController {

    @FXML
    public Button search_button;
    public TextField search_field;
    public Label search_output_label;

    @FXML
    BorderPane root;

    @FXML
    public MenuBar helpmenu;

    @FXML
    public Menu help_bar;

    @FXML
    void onSearchButtonClicked() {
        String text = search_field.getText();
        search_output_label.setText(text);
    }


}
