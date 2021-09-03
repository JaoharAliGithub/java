package javafxbasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class RandomWalk {
	Polyline line = new Polyline();
	ObservableList<Double> list = line.getPoints();
	double x = 320;
	double y = 320;

	RandomWalk() {

	}

	public void randomWalk(GridPane grid) {

		int change = (640 / 16);

		grid.getChildren().add(line);
		line.setStroke(Color.RED);
		line.setStrokeWidth(2);

		List<Integer> random = new ArrayList<>();
		random.add(0);
		random.add(1);
		random.add(2);
		random.add(3);

		while (another() == false) {

			Collections.shuffle(random);

			int result = random.get(0);

			switch (result) {
			// GO UP
			case 0:
				x = x;
				y = y - change;
				list.add(x);
				list.add(y);
				break;
			// GO DOWN
			case 1:
				x = x;
				y = y + change;
				list.add(x);
				list.add(y);
				break;
			// GO LEFT
			case 2:
				x = x - change;
				y = y;
				list.add(x);
				list.add(y);
				break;
			// GO RIGHT
			case 3:
				x = x + change;
				y = y;
				list.add(x);
				list.add(y);
				break;
			}
		}

	}

	public boolean validPath(Polyline line) {
		for (int i = 0; i < 360; i++) {
			if (line.contains(i, 360) || line.contains(360, i) || line.contains(i, 0) || line.contains(0, i)) {
				return true;
			} else {
				return false;
			}

		}

		if (line.contains((Point2D) line.getPoints())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean another() {
		if (list.size() == 40) {
			return true;
		} else {
			return false;
		}
	}
}
