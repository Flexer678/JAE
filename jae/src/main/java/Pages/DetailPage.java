package Pages;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetailPage {
    @FXML
    Label name;
    Label description;

    public void display_name(String names) {
        name.setText(names);
    }


}
