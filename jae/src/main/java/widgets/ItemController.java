package widgets;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import Pages.sceneController;
import assets.localFiles;
import datamodel.Item_model;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ItemController implements Initializable {

    private String id;
    private Boolean isBook;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @FXML
    Label name;

    @FXML
    Text price;

    @FXML
    Button addToCartBtn;

    @FXML
    Button getDetailBtn;

    @FXML
    ImageView imageiIem;

    @FXML
    VBox itemview;

    Item_model model;



    public void set_data(Item_model item) {
        model = item;
        isBook = item.getIsBook();
       // image.setImage(new Image(item.get_image_url()));
        name.setText(item.title);
        price.setText(Double.toString(item.price));
        Image image3 = new Image(item.image);
        imageiIem.setImage((image3));
        //price.setText(item.get_price().toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }

    public void get_detail(ActionEvent actionEvent) {
        sceneController control = new sceneController();
        try {
              control.switchtoDetailPage(actionEvent, model, isBook);
          
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println(id);
         System.out.println(model.title);
    }

    public void add_to_cart() throws ExecutionException, InterruptedException {
        localFiles.add_to_cart(Item_model.itemmodel_to_CartItem_model(model));
        System.out.println(localFiles.getCartItems());
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
    
        System.out.println(name);
        return box;

    }

}
