package javafxbasics;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class NodeStyleRotateDemo extends Application {

	@Override
	public void start(Stage primaryStage){
		StackPane pane = new StackPane();
		Button btOK = new Button("OK");
		btOK.setStyle("-fx-border-color: blues;");
		pane.getChildren().add(btOK);

		pane.setRotate(45);
		pane.setStyle("-fx-border-color: red; -fx-background-color:lightgray;");

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("NodeStyleRotateDemo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
