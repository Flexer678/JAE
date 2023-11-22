package Pages;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import datamodel.Item_model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import server.StoreApi;
import widgets.ItemController;

public class SearchPage implements  EventHandler<ActionEvent> {
    @FXML
    FlowPane result_view;

 
    @FXML
    Label search_name;
    




    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }


    public void get_category_results(String searchName) throws IOException{
        System.out.println(searchName+  "alex");
        ArrayList<Item_model> model = StoreApi.get_products_by_category(searchName);
        System.out.println(model);
        displayItems(StoreApi.get_products_by_category(searchName));
    }
    

    public void add_to_cart(ActionEvent event) throws IOException {
        //
        System.out.println("ss");
    }

       private void displayItems(ArrayList<Item_model> items) throws IOException {
        result_view.getChildren().clear();
        System.out.println(items);
        for (int i = 0; i < items.size(); i++) {
            FXMLLoader loader = new FXMLLoader();

            //loads the items  multiple times and sets them to a controller so that the 
            // data can be entered
            System.out.println("working");
            loader.setLocation(getClass().getResource("../widgets/item.fxml"));
            VBox box =loader.load();
            ItemController controller = loader.getController();
            controller.setId(items.get(i).getId());
            controller.set_data(items.get(i));
            HBox hbox = new HBox(box);

            //adds it to the flow pane
            result_view.getChildren().add(hbox);
        }
    }

    public void get_detail(ActionEvent event) throws IOException {}




  
    
}
