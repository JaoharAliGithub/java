package javafxbasics;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class test extends Application {
	int rowNum = 10;
	int colNum = 10;
	int gridHeight = 10;
	int gridWidth = 10;

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();

		// grid.getColumnConstraints().add(new ColumnConstraints(gridWidth));
		// grid.getRowConstraints().add(new RowConstraints(gridHeight));

		Scene scene = new Scene(grid, 350, 350);

		primaryStage.setTitle("Grid");
		primaryStage.setScene(scene);
		primaryStage.show();
		drawGrid(grid);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void drawGrid(GridPane grid) {

		Random rand = new Random();
		Color[] colors = { Color.BLACK, Color.BLUE, Color.GREEN, Color.RED };
		int n = rand.nextInt(4) + 1;
		for (int row = 0; row < rowNum; row++) {
			for (int col = 0; col < colNum; col++) {
				n = rand.nextInt(4);
				Rectangle rec = new Rectangle();
				rec.setWidth(350 / gridWidth);
				rec.setHeight(320 / gridHeight);
				rec.setFill(colors[n]);
				GridPane.setRowIndex(rec, row);
				GridPane.setColumnIndex(rec, col);
				grid.getChildren().addAll(rec);
			}
		}
	}
}
