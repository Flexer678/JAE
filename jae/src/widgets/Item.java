import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Item extends Application {

    String title;
    String imageUrl;
    Double price;
    String bought;

    // constructors
    public Item(String title, String imageUrl, Double price, String bought) {
        Label _title = new Label(title);
        Image _imageUrl1 = new Image(
                imageUrl,
                300, 0, true, false, true);
        ImageView _imageUrl = new ImageView(_imageUrl1);

        Label _price = new Label(price);
        Label _Bought = new Label(bought);

        Box vbox = new Box();

        vbox.setSpacing(10);
        vbox.setHeight(100.0);
        vbox.setDepth(80.0);
        vbox.setWidth(60.0);

        scene2 = new Scene(vbox, 200, 200);
        return scene2;

    }

    @Override
    public void viedItem(Stage primaryStage) throws Exception {
        Label _title = new Label(title);
        Image _imageUrl1 = new Image(
                imageUrl,
                300, 0, true, false, true);
        ImageView _imageUrl = new ImageView(_imageUrl1);

        Label _price = new Label(price);
        Label _Bought = new Label(bought);

        Box vbox = new Box();

        vbox.setSpacing(10);
        vbox.setHeight(100.0);
        vbox.setDepth(80.0);
        vbox.setWidth(60.0);

        scene2 = new Scene(vbox, 200, 200);

    }
}
