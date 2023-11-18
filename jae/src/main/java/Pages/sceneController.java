package Pages;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import assets.localFiles;
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

    public void switchtoMainPage(ActionEvent event, String name) throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("homePage.fxml"));
        root =loader.load();
        HomePage page = loader.getController();
        page.displayWelcome(name);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoCartPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("cartPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchtoSignInPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void passdata() {

    }
}
