package Pages;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import assets.localFiles;
import datamodel.CartItem_model;
import datamodel.Item_model;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.BookApi;
import widgets.navbarController;

public class DetailPage implements Initializable {
    @FXML
    Text name, description; 
    
    @FXML
    Label price;

    @FXML
    ImageView imageItem;

    @FXML
    HBox navholder;

    @FXML
    FlowPane similarItems;

    public void display_name(String names) {
        name.setText(names);
    }

    //this displays the details of the item in a new page and is called by the item_controller.java file
    public void display_detail(Item_model model,Boolean isBook) throws IOException {
       if (isBook) {
        System.out.println("book is calling");
        model = BookApi.get_product_details_by_id(model.getId());
            name.setText(model.getTitle());
        description.setText(model.getDescription());
        price.setText(Double.toString(model.getPrice()));
        Image image3 = new Image(model.image);
        imageItem.setImage((image3));
        
       }else{
        System.out.println(model);
         name.setText(model.getTitle());
        description.setText(model.getDescription());

        price.setText(Double.toString(model.getPrice()));
        Image image3 = new Image(model.image);
        imageItem.setImage((image3));
       }
    }

    public void addToCart(CartItem_model model) {
        name.setText(model.get_name());
        price.setText(Double.toString(model.get_price()));

    }

    //his handles the back button
    public void back_to_homepage(ActionEvent event) throws IOException{
        sceneController controller = new sceneController();
        controller.switchtoMainPage(event, localFiles.name);
    }

        public void display_navholder() throws IOException{
        navholder.getChildren().clear();
         FXMLLoader loader = new FXMLLoader();


            loader.setLocation(getClass().getResource("../widgets/navbar.fxml"));
            AnchorPane box =loader.load();
            navbarController controller = loader.getController();
            navholder.getChildren().add(box);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            display_navholder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
