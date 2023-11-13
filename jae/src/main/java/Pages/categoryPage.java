package Pages;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class categoryPage {

    @FXML
    Label name;

    public void displayname(String names) {
        name.setText("wassup" + names);
    }

}
