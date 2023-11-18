package Pages;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import assets.localFiles;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import datamodel.*;
import widgets.ItemController;

public class SignInPage extends Application implements EventHandler<ActionEvent>, Initializable {

    @FXML
    Button signin_btn;

    @FXML
    ImageView imagelogo;

    @FXML
    TextField username;

    @FXML
    TextField password;

    @Override
    public void initialize(URL url, ResourceBundle arg1) {

        // TODO Auto-generated method stub

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("signpage.fxml"));
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

    public String getUsername(){
        return username.getText();
    }

    
    public String getPassword(){
        return password.getText();
    }


    public void signIn(ActionEvent actionEvent) {
        String name = username.getText();

        localFiles.set_name(name);
        sceneController control = new sceneController();
        try {
            control.switchtoMainPage(actionEvent, name);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void run(String[] args) {
        launch(args);
    }
}
