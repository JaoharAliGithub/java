package javafxbasics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

public class ControlCircleWithMouseKey extends Application {
	private CirclePane circlePane = new CirclePane();

	@Override
	public void start(Stage primaryStage) {
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btEnlarge = new Button("ENLARGE");
		Button btShrink = new Button("SHRINK");
		hBox.getChildren().add(btEnlarge);
		hBox.getChildren().add(btShrink);

		btEnlarge.setOnAction(e -> circlePane.enlarge());
		btShrink.setOnAction(e -> circlePane.shrink());

		circlePane.setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.PRIMARY) {
				circlePane.enlarge();
			} else if (e.getButton() == MouseButton.SECONDARY) {
				circlePane.shrink();
			}
		});

		circlePane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.U) {
				circlePane.enlarge();
			} else if (e.getCode() == KeyCode.D) {
				circlePane.shrink();
			}
		});

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circlePane);
		borderPane.setBottom(hBox);
		BorderPane.setAlignment(hBox, Pos.CENTER);

		Scene scene = new Scene(borderPane, 200, 150);
		primaryStage.setTitle("ControlCircleWithMouseKey");
		primaryStage.setScene(scene);
		primaryStage.show();

		circlePane.requestFocus();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

	class EnlargeHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circlePane.enlarge();
		}
	}

	class ShrinkHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			circlePane.shrink();
		}
	}

	class CirclePane extends StackPane {
		private Circle circle = new Circle(50);

		public CirclePane() {
			getChildren().add(circle);
			circle.setStroke(Color.BLACK);
			circle.setFill(Color.WHITE);
		}

		public void enlarge() {
			circle.setRadius(circle.getRadius() + 2);
		}

		public void shrink() {
			if (circle.getRadius() > 2) {
				circle.setRadius(circle.getRadius() - 2);
			} else {
				circle.setRadius(circle.getRadius());
			}
		}
	}
}
