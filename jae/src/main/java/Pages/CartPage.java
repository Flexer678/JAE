package Pages;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import datamodel.Item_model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class CartPage implements Initializable {

    @FXML
    VBox cartContainer;

    ArrayList<Item_model> cartItems = new ArrayList<Item_model>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

}
