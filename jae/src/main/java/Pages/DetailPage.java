package Pages;

import java.io.IOException;

import assets.localFiles;
import datamodel.Item_model;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.BookApi;

public class DetailPage  {
    @FXML
    Text name, description; 
    
    @FXML
    Label price;

    @FXML
    ImageView imageItem;

    @FXML
    FlowPane similarItems;

    public void display_name(String names) {
        name.setText(names);
    }

    //this displays the details of the item in a new page and is called by the item_controller.java file
    public void display_detail(Item_model model,Boolean isBook) throws IOException {
       if (isBook) {
        model = BookApi.get_product_details_by_id(model.getId());
            name.setText(model.getTitle());
        description.setText(model.getDescription());
        price.setText(Double.toString(model.getPrice()));
        Image image3 = new Image(model.image);
        imageItem.setImage((image3));
        
       }else{
         name.setText(model.getTitle());
        description.setText(model.getDescription());
        price.setText(Double.toString(model.getPrice()));
        Image image3 = new Image(model.image);
        imageItem.setImage((image3));
       }
    }

    //his handles the back button
    public void back_to_homepage(ActionEvent event) throws IOException{
        sceneController controller = new sceneController();
        controller.switchtoMainPage(event, localFiles.name);
    }

}
