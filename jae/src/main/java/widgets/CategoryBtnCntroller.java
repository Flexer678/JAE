package widgets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Pages.sceneController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CategoryBtnCntroller implements Initializable, EventHandler<ActionEvent>{


    private String categoryName;
    @FXML
    Button getCategoryBtn;


    @FXML
    Label name;

    @Override
    public void handle(ActionEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handle'");
    }


    public void set_category(String category){
        categoryName = category;
        name.setText(category);

    }

    public void get_category(ActionEvent event) throws IOException{
        sceneController control = new sceneController();
        control.switchToSearchPage(event, categoryName, sceneController.types[2]);
        System.out.println(name.getText());
        
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
   
    }
    
}
