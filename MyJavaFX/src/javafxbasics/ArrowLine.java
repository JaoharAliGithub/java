package javafxbasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polyline;
import java.util.Random;

public class ArrowLine extends Application {

	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		int endX = (int) Math.random() * 200;
		int endY = (int) Math.random() * 200;
		int startX = 50;
		int startY = 60;

		drawArrowLine(startX, startY, endX, endY, pane);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowArrowLine");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
		Line line = new Line(startX, startY, endX, endY);
		line.setStroke(Color.BLACK);
		Line arrow1 = new Line(line.getEndX(), line.getEndY(), line.getEndX() - (line.getEndX() / 10),
				line.getEndY() - (line.getEndY() / 10));
		arrow1.setStroke(Color.BLACK);
		Line arrow2 = new Line(line.getEndX(), line.getEndY(), (line.getEndX() / 10),
				line.getEndY() - (line.getEndY() / 10)
				);
		arrow2.setStroke(Color.BLACK);
		pane.getChildren().addAll(line, arrow1, arrow2);
	}
}
