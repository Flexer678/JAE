package Pages;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class sceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchtoDetailPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("detailPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switch_to_MainPage(ActionEvent event, String name) throws IOException {

        root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switch_to_CartPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("cartPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchtoSignInPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("cartPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void passdata() {

    }
}
