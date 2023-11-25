package widgets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Pages.CartPage;
import Pages.sceneController;
import assets.localFiles;
import datamodel.CartItem_model;
import datamodel.Item_model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import server.BookApi;
import server.StoreApi;


//controlls all the item properties that are in the cartItem
public class CartItemController implements  EventHandler<ActionEvent> {

    //container
    @FXML
    AnchorPane cartItem;
    @FXML
    Label itemName;
    
    @FXML
    Label itemDescription;
    
    @FXML
    Label itemPrice;
    @FXML
    Label quantity;
    @FXML 
    ImageView itemImage;
    @FXML
    Button itemRemove;
    @FXML
    Button qtyMinus;
    
    @FXML
    Button getItem;
    @FXML
    Button qtyAdd; 

    //id which will later be resued for removing itself
    private String id;
    private int qty;
    private int index;


    
    public static CartItem_model model_data;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

 




    private Item_model get_search_results(String id){
        Item_model result = new Item_model();
        if(isBook()){
            try {
                System.out.println("Store");
                result = StoreApi.get_product_by_id(id);
            } catch (IOException e) {
              
                e.printStackTrace();
            }

        }else{
            try {
            System.out.println("books");
            result = BookApi.get_product_details_by_id(id);
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        }
        return result;

    }

    private Boolean isBook(){
         if(id.length() > 2){
            return true;
         }
         return false;
    }

    
    public void go_to_detailPage(ActionEvent event)  {
        try {
            sceneController controller = new sceneController();
            
            controller.switchtoDetailPage(event, get_search_results(id), isBook());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void add_qty(ActionEvent event){
        //model.add_quantity();
        //quantity.setText(Integer.toString(model.get_quantity()));
    }

    public void remove_qty(ActionEvent event){
        model_data.decrease_quantity();
        quantity.setText(Integer.toString(model_data.get_quantity()));
    }

    public void removeItem(ActionEvent event){
        localFiles.cartItems.remove(index);
    }

    public void setIndex(int in){
        in = index;

    }

    //responsible for setting all the properties to the data
    public void set_data(CartItem_model model){
        model_data = model;
        System.out.println("working");
        itemName.setText(model.get_name().substring(0, 5)+ "...");
        itemDescription.setText("click to view description");
        itemPrice.setText("$" +model.get_price().toString());
        itemImage.setImage(new Image(model.get_image()));
        quantity.setText(Integer.toString(model.get_quantity()));
        System.out.println("done");
        
    }

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }



    
    
}
