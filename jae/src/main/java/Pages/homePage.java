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
import widgets.ItemController;
import datamodel.*;
import assets.localFiles;

public class homePage extends Application implements EventHandler<ActionEvent>, Initializable {
    public static Button btn;

    @FXML
    Label welcomeLabel;

    @FXML
    FlowPane item_view;

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
        // TODO Auto-generated method stub
        displayWelcome(localFiles.name);

        displayItems(food);
        // categoryView.getItems().addAll(food);
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

    public void displayWelcome(String username) {
        System.out.println("hellio" + welcomeLabel.getText());
        welcomeLabel.setText("Welcome " + username);
    }

    public void displayItems(List<String> items) {
        item_view.getChildren().clear();

        ItemController item1 = new ItemController();
        // VBox item2 = item1.getitemview("", "Alex", );
        for (int i = 0; i < items.size(); i++) {

            String item = items.get(i);
            Label imageView = new Label(item);

            HBox hbox = new HBox(imageView);
            hbox.setSpacing(10);
            hbox.setPadding(new javafx.geometry.Insets(10));
            // item_view.getChildren().add(item1.getitemview(item, items.get(i),
            // Double.parseDouble(items.get(i))));
            item_view.getChildren().add(hbox);
        }
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sceneController control = new sceneController();
        try {
            control.switchtoDetailPage(actionEvent);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void getDetail() {
        System.out.println("clicked");
    }

    public void run(String[] args) {
        launch(args);
    }
}
