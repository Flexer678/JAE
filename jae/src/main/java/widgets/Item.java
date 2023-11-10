package widgets;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Item extends Application {

    // constructors
    public VBox sceneview(String title, String imageUrl, Double price, String bought) {
        Label _title = new Label(title);
        Image _imageUrl1 = new Image(
                imageUrl,
                300, 0, true, false, true);
        ImageView _imageUrl = new ImageView(_imageUrl1);

        Label _price = new Label("$" + price.toString());
        Label _Bought = new Label(bought);

        VBox vbox = new VBox();

        vbox.getChildren().addAll(_title, _imageUrl, _price, _Bought);

        return vbox;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

}
