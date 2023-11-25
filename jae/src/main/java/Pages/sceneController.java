package Pages;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import assets.localFiles;
import datamodel.Item_model;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




///scene controller handles all the switches betweeen the pages and some of the data passing.
public class sceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    //
    public void switchtoDetailPage(ActionEvent event, Item_model model, boolean isBook) throws IOException {

        FXMLLoader loader = new  FXMLLoader(getClass().getResource("detailPage.fxml"));
        root =loader.load();
        DetailPage page = loader.getController();
        page.display_detail(model, isBook);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void switchtoMainPage(ActionEvent event, String name) throws IOException {
        FXMLLoader loader = new  FXMLLoader(getClass().getResource("homePage.fxml"));
        root =loader.load();
        HomePage page = loader.getController();
        //page.displayWelcome(name);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoCartPage(ActionEvent event) throws IOException {
          FXMLLoader loader = new  FXMLLoader(getClass().getResource("cartPage.fxml"));
        root =loader.load();
        CartPage page = loader.getController();
        page.displayItems(localFiles.getCartItems());
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


    //this list contains the types of searches that search page can use
    public static String[] types = {"books", "store", "category", "all"};
    
    public void switchToSearchPage(ActionEvent event, String search, String type) throws IOException {
       FXMLLoader loader = new  FXMLLoader(getClass().getResource("searchPage.fxml"));
        root =loader.load();
        SearchPage page = loader.getController();
        if (type == types[0]) {
            page.get_book_results(search);

        }else if(type == types[1] || type == types[3]){
            page.get_all_results();
        }
        else if(type == types[2]){
            page.get_category_results(search);
        }
        page.display_search_results_name(search);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void passdata() {

    }
}
