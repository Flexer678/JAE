package widgets;

import java.net.URL;
import java.util.ResourceBundle;

import datamodel.Item_model;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class ItemController implements Initializable {

    @FXML
    ImageView image;

    @FXML
    Label name;

    @FXML
    Label price;

    @FXML
    VBox itemview;

    public void setdata(Item_model item) {
        image.setImage(new Image(item.getImage_url()));
        name.setText(item.getName());
        price.setText(item.getPrice().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    public VBox getitemview(String image, String name, Double price) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Item.fxml"));

        ItemController controller = fxmlLoader.getController();

        Item_model model = new Item_model();
        model.setName(name);
        model.setPrice(price);
        model.setImage_url(image);
        controller.setdata(model);
        System.out.println(name);
        return itemview;

    }

}
