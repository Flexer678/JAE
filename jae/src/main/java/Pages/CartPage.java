
package Pages;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import datamodel.Item_model;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;

import widgets.CartItemController;

import datamodel.*;
import assets.localFiles;

public class CartPage implements Initializable ,EventHandler<ActionEvent>{
    //where the cart is stored
    @FXML
    VBox cartContainer;

    @FXML
    FlowPane cartItem_view;
    //the summary and the total price of the items
    @FXML 
    Label subtotalNum, shippingNum, taxNum, totalNum;
    
    //the checkout button
    @FXML
    Button checkout;

    //the total price the customer has to pay

    static Double total_price = 0.00;
    ArrayList<Item_model> cartItems = new ArrayList<Item_model>();
    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }



    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
      //  throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }



    //switches to main page and is called by the back button in the cartpage
   public void switchtoMainPage(ActionEvent event) throws IOException{
        sceneController controller = new sceneController();
        controller.switchtoMainPage(event, localFiles.getName());
    }


    
  
    public  void display_price(){
        subtotalNum.setText("$" + (total_price).toString());
        shippingNum.setText("$00.00");
        taxNum.setText("$" + "0:00");
        totalNum.setText("$" + (total_price).toString());
        
    }

    //this removes all the cart items and is called when the checkout button is clicked
    public void remove_all(ActionEvent event){
        remove_all_cartItem();
    }

    
    public static void remove_all_cartItem(){
      localFiles.cartItems = new ArrayList<CartItem_model>();
    }
     


    public void displayItems(ArrayList<CartItem_model> arrayList) throws IOException {
        System.out.println("working");
        System.out.println(arrayList.size());
       //this is responsible for displaying all the cartitems
       // it uses the cartitem model and sets the data to the fxml file we are loading and then adds it to a box o be displayed
      try {
          cartItem_view.getChildren().clear();
         for (int i = 0; i < arrayList.size() ; i++) {
            System.out.println("working 0");
            FXMLLoader loader = new FXMLLoader();
            // loads the items multiple times and sets them to a controller so that the
            // data can be entered
            System.out.println("working 1");
            loader.setLocation(getClass().getResource("../widgets/cartItem.fxml"));
            System.out.println( "working 2");
            AnchorPane box = loader.load();
            CartItemController controller = loader.getController();
            controller.setId(arrayList.get(i).get_id());
  
            controller.set_data(arrayList.get(i));
            //controller.setIndex(i);
            System.out.println("working3");
            HBox hbox = new HBox(box);
            total_price += arrayList.get(i).get_price();
            // adds it to the flow pane
            cartItem_view.getChildren().add(hbox);
            display_price();
        }
     
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    
  
}