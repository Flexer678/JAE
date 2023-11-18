package widgets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import datamodel.Item_model;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ItemController implements Initializable {

  

    @FXML
    Text name;

    @FXML
    Text price;


    public void set_data(String item) {
       // image.setImage(new Image(item.get_image_url()));
        name.setText(item);
        //price.setText(item.get_price().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    public void get_detail() {

    }

    public VBox getitemview(String image_, String name_, Double price_) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("item.fxml"));

        VBox box = new VBox();
        try {
            box.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ItemController controller = fxmlLoader.getController();

        Item_model model = new Item_model();
        // model.setName(name);
        // model.setPrice(12);
        // model.setImage_url(image);
        // controller.setdata(model);
        System.out.println(name);
        return box;

    }

}
