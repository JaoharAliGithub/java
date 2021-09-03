package javafxbasics;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.scene.shape.ArcType;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.shape.Polygon;

public class Excercise14point13 extends Application {

	@Override
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		Arc arc1 = new Arc(100, 100, 100, 100, 90, -36);
		arc1.setType(ArcType.ROUND);
		arc1.setFill(Color.BLUE);
		pane.getChildren().add(arc1);

		Arc arc2 = new Arc(100, 100, 100, 100, 54, -72);
		arc2.setType(ArcType.ROUND);
		arc2.setFill(Color.RED);
		pane.getChildren().add(arc2);

		Arc arc3 = new Arc(100, 100, 100, 100, -18, -108);
		arc3.setType(ArcType.ROUND);
		arc3.setFill(Color.GREEN);
		pane.getChildren().add(arc3);

		Arc arc4 = new Arc(100, 100, 100, 100, -126, -144);
		arc4.setType(ArcType.ROUND);
		arc4.setFill(Color.ORANGE);
		pane.getChildren().add(arc4);
		Text text1 = new Text(90, 10, "Quiz--10%");
		Text text2 = new Text(120, 90, "Project--20%");
		Text text3 = new Text(75, 160, "MidTerm Exam--30%");
		Text text4 = new Text(20, 90, "Final Exam--40%");
		pane.getChildren().addAll(text1, text2, text3, text4);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("PIECHART");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}