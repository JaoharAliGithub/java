package physicsengine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Label inititalVelocitySignLabel = new Label("Initital Velocity");
        pane.getChildren().add(inititalVelocitySignLabel);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Physics Engine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
