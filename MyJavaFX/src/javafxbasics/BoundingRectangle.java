package javafxbasics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class BoundingRectangle extends Application {
	PointPane pointPane = new PointPane();
	Pane pane = new Pane();

	@Override
	public void start(Stage primaryStage) {

		pointPane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				pointPane.addPoint(e.getX(), e.getY());
				;
			} else if (e.getButton() == MouseButton.SECONDARY) {;
				pointPane.removePoint();
			}
		});

		Scene scene = new Scene(pointPane, 500, 500);
		primaryStage.setTitle("RectangleBoundingPoints");
		primaryStage.setScene(scene);
		primaryStage.show();
		pointPane.requestFocus();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
