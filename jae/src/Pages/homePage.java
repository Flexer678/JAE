package Pages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class homePage extends Application implements EventHandler<ActionEvent> {
    public static Button btn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        btn = new Button();
        btn.setText("Say 'Hello World'");

        StackPane layout = new StackPane();
        layout.getChildren().add(btn);

        btn.setOnAction(this);
        /*
         * Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
         * Scene scene = new Scene(root);
         */

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("JAE store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btn) {
            System.out.println("Hello World");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
