package javafxbasics;

import java.util.Random;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ExerciseFifteenPointThirtyFour extends Application {

	int rowNum = 16;
	int colNum = 16;
	int gridHeight = 16;
	int gridWidth = 16;
	int rectangleWidth = 40;
	int rectangleHeight = 40;

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		drawGrid(grid);

		Scene scene = new Scene(grid, 640, 640);
		primaryStage.setTitle("SimulatingRandomWalk");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		grid.requestFocus();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void drawGrid(GridPane grid) {
		rectangleWidth = (int) (grid.getWidth() / rowNum);
		rectangleHeight = (int) (grid.getHeight() / rowNum);
		for (int row = 0; row < rowNum; row++) {
			for (int col = 0; col < colNum; col++) {
				Rectangle rec = new Rectangle(rectangleWidth - 1, rectangleHeight - 1);
				rec.setStrokeWidth(1);
				rec.setStroke(Color.BLACK);
				rec.setFill(Color.WHITE);
				GridPane.setRowIndex(rec, row);
				GridPane.setColumnIndex(rec, col);
				grid.getChildren().addAll(rec);
			}
		}
	}
}
