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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import server.BookApi;
import server.StoreApi;
import widgets.CategoryBtnCntroller;
import widgets.ItemController;
import datamodel.*;
import assets.localFiles;


public class HomePage extends Application implements EventHandler<ActionEvent>, Initializable {

    @FXML
    private Label username;

    @FXML
    Label username_profile;


    @FXML
    FlowPane item_view;

    @FXML
    FlowPane categoryList;

  
    List<String> food = new ArrayList<String>() {
        {
            add("Apple");
            add("Banana");
            add("Cherry");
            add("Grapes");
            add("Mango");
            add("Orange");
            add("Pineapple");
            add("Strawberry");
            add("Watermelon");
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle arg1) {
        System.out.println(localFiles.getName()+ "\n");
        displayWelcome(localFiles.name);

        try {
            displayItems(StoreApi.get_all());
            displayCategories(StoreApi.get_categories());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
      
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("JAE store");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    

    @Override
    public void handle(ActionEvent actionEvent) {

        // TODO Auto-generated method stub

    }
    

    //shows name in the navigationbar
    public void displayWelcome(String name) {
        username.setText(name);
        
        try {
            username_profile.setText(name.substring(0, 1).toUpperCase());
        } catch (Exception e) {
           username_profile.setText("T");
        }
    }




        private void displayCategories(List<String> categories) throws IOException {
        categoryList.getChildren().clear();

   
        for (int i = 0; i < categories.size(); i++) {
            ItemController item1 = new ItemController();
       
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../widgets/categoryBtn.fxml"));
            AnchorPane box =loader.load();

            CategoryBtnCntroller controller = loader.getController();
            controller.set_category(categories.get(i));
            
            HBox hbox = new HBox(box);
            categoryList.getChildren().add(hbox);
        }
    }

    
    //
    private void displayItems(List<Item_model> items) throws IOException {
        item_view.getChildren().clear();
        for (int i = 0; i < items.size(); i++) {
            FXMLLoader loader = new FXMLLoader();

            //loads the items  multiple times and sets them to a controller so that the 
            // data can be entered
            loader.setLocation(getClass().getResource("../widgets/item.fxml"));
            VBox box =loader.load();
            ItemController controller = loader.getController();
            controller.setId(Integer.toString(items.get(i).getId()));
            controller.set_data(items.get(i));
            HBox hbox = new HBox(box);

            //adds it to the flow pane
            item_view.getChildren().add(hbox);
        }
    }



    public void run(String[] args) {
        launch(args);
    }

   
}


/*
 *   private List<Item_model> datas (){
        
        List<Item_model> model =new ArrayList<>();
        Item_model item1 = new Item_model();
        item1.setDescription("This elegant dress is perfect for special occasions and formal events.");
        item1.setImage("https://th.bing.com/th/id/R.a22db53d418d1d44de2cea8a5ffe8216?rik=GdEMJt4G2SVCAw&pid=ImgRaw&r=0");
        item1.setId(0);
        item1.setPrice(12.3);
        item1.setTitle("Women's Evening Dress");
        item1.setIsBook(false);
        
        Item_model item2 = new Item_model();
        item2.setDescription(
                "These high-performance running shoes provide excellent cushioning and support for your daily runs.");
        item2.setImage("https://th.bing.com/th/id/R.a22db53d418d1d44de2cea8a5ffe8216?rik=GdEMJt4G2SVCAw&pid=ImgRaw&r=0");
        item2.setId(0);
        item2.setPrice(12.3);
        item2.setTitle("Men's Running Shoes");
        item2.setIsBook(false);


        Item_model item3 = new Item_model();
        item3.setDescription("Stay warm and stylish with this cozy knit sweater, perfect for the winter season.");
        item3.setImage("https://th.bing.com/th/id/R.a22db53d418d1d44de2cea8a5ffe8216?rik=GdEMJt4G2SVCAw&pid=ImgRaw&r=0");
        item3.setId(0);
          item3.setPrice(12.3);
        item3.setTitle("Women's Knit Sweater");
        item3.setIsBook(false);

        Item_model item4 = new Item_model();
        item4.setDescription("Experience the ultimate gaming performance with this high-end gaming laptop.");
        item4.setImage("https://th.bing.com/th/id/R.a22db53d418d1d44de2cea8a5ffe8216?rik=GdEMJt4G2SVCAw&pid=ImgRaw&r=0");
        item4.setId(0);
        item4.setPrice(12.3);
        item4.setTitle("Gaming Laptop");
        item4.setIsBook(false);


        model.add(item1);
        model.add(item2);
        model.add(item3);
        model.add(item4);
        return model;
    };

 */