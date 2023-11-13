package Pages;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import datamodel.*;
import widgets.ItemController;

public class homePage extends Application implements EventHandler<ActionEvent>, Initializable {
    public static Button btn;

    @FXML
    private ListView<String> categoryView;

    @FXML
    private Button detail_button;

    @FXML
    HBox boxLayout;

    @FXML
    private ImageView image;

    ItemController cc = new ItemController();

    String[] food = { "apple", "banana", "cherry", "grape", "orange", };

    @Override
    public void initialize(URL url, ResourceBundle arg1) {
        // TODO Auto-generated method stub

        for (int i = 0; i < categoryView.getItems().size(); i++) {
            System.out.println(i);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("./widgets/item.fxml"));
            // ItemController controller = new ItemController();

            System.out.println(i);
            // boxLayout.getChildren().add(controller.getitemview("./assets/logo.png",
            // "ssss", 22.2));

            categoryView.getItems().addAll(food);
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
        sceneController control = new sceneController();

        try {
            control.switchtoDetailPage(actionEvent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void run(String[] args) {
        launch(args);
    }
}
