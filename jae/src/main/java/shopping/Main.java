package shopping;

//import item.java from sec/widgets
import widgets.Item;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        String ae = "https://th.bing.com/th/id/R.e1707c345d5ac10c80a674030e606643?rik=pOsTg5KBoLuNvw&riu=http%3a%2f%2fwww.snut.fr%2fwp-content%2fuploads%2f2015%2f08%2fimage-de-paysage.jpg&ehk=1O5SWKkGpZ8yU%2b%2fAnLXG1v8k6BKxgyiXgHbOWBW1ir0%3d&risl=1&pid=ImgRaw&r=0";
        Button btn = new Button("d");
        Image image3 = new Image(
                "https://th.bing.com/th/id/R.e1707c345d5ac10c80a674030e606643?rik=pOsTg5KBoLuNvw&riu=http%3a%2f%2fwww.snut.fr%2fwp-content%2fuploads%2f2015%2f08%2fimage-de-paysage.jpg&ehk=1O5SWKkGpZ8yU%2b%2fAnLXG1v8k6BKxgyiXgHbOWBW1ir0%3d&risl=1&pid=ImgRaw&r=0",
                300, 0, true, false, true);
        ImageView imageView2 = new ImageView(image3);

        Item s = new Item();
        VBox a = s.sceneview("Hello World", ae, 100.0, "123");

        Label label1 = new Label("dddddddddddd");
        Button But = new Button("wssup");
        But.setOnAction(
                e -> {
                    System.out.println("wasup");
                    window.setScene(scene2);
                });

        VBox layout1 = new VBox(1);
        layout1.getChildren().addAll(label1, But, imageView2, a);

        scene1 = new Scene(layout1, 200, 200);

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn);
        scene2 = new Scene(layout2, 200, 200);

        window.setTitle("wassup");
        window.setScene(scene1);
        window.show();
    }

    private VBox Item(String string, String string2, double d, String string3) {
        return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * Button btn = new Button();
 * btn.setText("Say 'Hello World'");
 * 
 * 
 * 
 * StackPane layout = new StackPane();
 * layout.getChildren().add(btn);
 * 
 * btn.setOnAction(e -> {
 * System.out.println("wasup");
 * });
 * 
 * 
 * scene1 = new Scene(layout, 300, 250);
 * scene2 = new Scene(layout, 300, 250);
 * primaryStage.setTitle("JAE store");
 * primaryStage.setScene(scene1);
 * primaryStage.show();
 */