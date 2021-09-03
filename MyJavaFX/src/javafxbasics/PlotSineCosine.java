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

public class PlotSineCosine extends Application {

	public void start(Stage primaryStage) {
		Pane pane = new Pane();

		Polyline polyline1 = new Polyline();
		pane.getChildren().add(polyline1);
		polyline1.setStroke(Color.RED);
		ObservableList<Double> list = polyline1.getPoints();
		double scaleFactor = 50;

		for (int x = -170; x <= 170; x++) {
			list.add(x + 200.0);
			list.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI));
		}

		Polyline polyline2 = new Polyline();
		pane.getChildren().add(polyline2);
		polyline2.setStroke(Color.BLUE);
		ObservableList<Double> list1 = polyline2.getPoints();
		double scaleFactor1 = 50;

		for (int x = -170; x <= 170; x++) {
			list1.add(x + 200.0);
			list1.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI));
		}
		Line lineY = new Line(200, 200, 200, 0);
		Line lineX = new Line(0, 100, 400, 100);

		Line arrowY1 = new Line(lineY.getEndX(), lineY.getEndY(), 190.0, 10);
		Line arrowY2 = new Line(lineY.getEndX(), lineY.getEndY(), 210.0, 10);
		Line arrowX1 = new Line(lineX.getEndX(), lineX.getEndY(), 390, 90);
		Line arrowX2 = new Line(lineX.getEndX(), lineX.getEndY(), 390, 110);

		Text textY = new Text(lineY.getEndX() + 20, lineY.getEndY() + 20, "Y");
		Text textX = new Text(lineX.getEndX() + 10, lineX.getEndY() + 10, "X");

		Text negativeTwoPI = new Text(90, 110, "-2\u03c0");
		Text negativePI = new Text(140, 110, "-\u03c0");
		Text zero = new Text(200, 110, "0");
		Text PI = new Text(245, 110, "\u03c0");
		Text TwoPI = new Text(345, 110, "2\u03c0");
		
		pane.getChildren().addAll(lineX, lineY, arrowY1, arrowY2, arrowX1, arrowX2, textX, textY, negativeTwoPI,
				negativePI, zero, PI, TwoPI);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Sine&CosineFunctionGraph");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}