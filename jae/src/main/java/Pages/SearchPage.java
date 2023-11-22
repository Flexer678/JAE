package Pages;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import assets.localFiles;
import datamodel.Item_model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import server.BookApi;
import server.StoreApi;
import widgets.ItemController;

public class SearchPage implements  EventHandler<ActionEvent> {
    @FXML
    FlowPane result_view;

 
    @FXML
    Label search_name;
    

    @FXML
    Button backBtn;
    



    public void go_back_hpage (ActionEvent event) throws IOException {
        sceneController controller = new sceneController();
        controller.switchtoMainPage(event, localFiles.getName());
    }

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }


    public void get_book_results(String searchName) throws IOException{
        System.out.println(searchName+  "alex");
        ArrayList<Item_model> model = BookApi.get_search_results(searchName);
        System.out.println(model);
        displayItems(model);
    }



    public void get_category_results(String searchName) throws IOException{
        System.out.println(searchName+  "alex");
        ArrayList<Item_model> model = StoreApi.get_products_by_category(searchName);
        System.out.println(model);
        displayItems(model);
    }
    
    public void get_all_results() throws IOException{
        ArrayList<Item_model> model = StoreApi.get_all();
        displayItems(model);
    }

    public void display_search_results_name(String searchName) throws IOException{
        search_name.setText("Search results for: " + searchName);
    }


    public void add_to_cart(ActionEvent event) throws IOException {
        //
        System.out.println("ss");
    }

       private void displayItems(ArrayList<Item_model> items) throws IOException {
        result_view.getChildren().clear();
        System.out.println(items);

        if (items.size() == 0) {
            result_view.getChildren().add(new Label("No results found"));
        }else if (items.size() >= 30) {
            for (int i = 0; i < items.size()-10; i++) {
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
        }else{
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
        }

    }

    public void get_detail(ActionEvent event) throws IOException {}




  
    
}
