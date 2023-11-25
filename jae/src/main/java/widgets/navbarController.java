package widgets;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import Pages.sceneController;
import assets.localFiles;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class navbarController implements EventHandler<ActionEvent>, Initializable{
    
    @FXML
    private Label username;

    @FXML
    private Label username_profile;

    @FXML
    private Label tryAgain;

    @FXML
    private TextField searchName;

    @FXML
    private Button books;

    @FXML
    private Button store;

    @FXML
    private Button logo;

    @FXML
    private Button cart;
    
     @Override
    public void initialize(URL url, ResourceBundle arg1) {
       display_name();
    }


    
    public void go_to_cart(ActionEvent event) throws IOException{
        sceneController controller = new sceneController();
        controller.switchtoCartPage(event);
    }




    public void display_name(){
        username.setText(localFiles.getName());
        username_profile.setText(localFiles.getName().substring(0,1));
    }

    public void get_search_results(ActionEvent event) throws IOException{
        System.out.println("running");
        if (Objects.equals(searchName.getText(), " ") || searchName.getText().length() <= 3) {
            tryAgain.setText("Please enter a valid search term.");
        } else {
            sceneController controller = new sceneController();
            controller.switchToSearchPage(event, searchName.getText(), sceneController.types[0]);
        }
    }

    public void get_all(ActionEvent event) throws IOException {
        sceneController controller = new sceneController();
        controller.switchToSearchPage(event, "Store items", sceneController.types[3]);
    }
    

    
    public void go_back_hpage(ActionEvent event) throws IOException{
       sceneController controller = new sceneController();
       controller.switchtoMainPage(event, localFiles.getName());
    }


  
    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }

}
