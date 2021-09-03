package javafxbasics;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.animation.*;

public class PointPane extends Pane {
	Pane pane = new Pane();
	Circle circle = new Circle(10);
	public static ArrayList<Double> points = new ArrayList<>();
	private Timeline animation;
	Rectangle rectangle = new Rectangle();
	int numPoints = 0;
	int pointSelect = 0;
	public static ArrayList<Circle> circleNum = new ArrayList<>();

	public PointPane() {
		getChildren().add(pane);
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> rectangleBorder()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

	}

	public void addPoint(double x, double y) {
		numPoints++;
		Circle circle1 = new Circle();
		circle1.setStroke(Color.BLACK);
		circle1.setFill(Color.WHITE);
		circle1.setRadius(10);
		points.add(x);
		points.add(y);
		circle1.setLayoutX(x);
		circle1.setLayoutY(y);
		pane.getChildren().add(circle1);
		circleNum.add(circle1);
	}

	public void removePoint() {
		if (getChildren().size() > 0) {
			getChildren().remove(getChildren().size() - 1);
		}
	}

	public ArrayList<Double> getList() {
		return points;
	}

	public double furthestHighPoint() {
		double furthestHighPoint = 0;

		for (int i = 1; i < points.size(); i += 2) {
			if (points.get(i) < furthestHighPoint) {
				furthestHighPoint = points.get(i);
			}
		}
		return furthestHighPoint;
	}

	public double furthestLeftPoint() {

		double furthestLeftPoint = 0;

		for (int i = 0; i < points.size(); i += 2) {
			if (points.get(i) < furthestLeftPoint) {
				furthestLeftPoint = points.get(i);
			}
		}
		return furthestLeftPoint;

	}

	public double furthestRightPoint() {

		double furthestRightPoint = 0;
		for (int i = 0; i < points.size(); i += 2) {
			if (points.get(i) > furthestRightPoint) {
				furthestRightPoint = points.get(i);
			}
		}

		return furthestRightPoint;
	}

	public double furthestLowPoint() {

		double furthestLowPoint = 0;

		for (int i = 1; i < points.size(); i += 2) {
			if (points.get(i) > furthestLowPoint) {
				furthestLowPoint = points.get(i);
			}
		}
		return furthestLowPoint;

	}

	public void rectangleBorder() {

		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.WHITE);
		if (points.size() == 0) {
			rectangle.setWidth(100);
			rectangle.setHeight(100);
			rectangle.setX(200);
			rectangle.setY(200);

		} else if (points.size() == 2 || points.size() == 4) {
			double firstX = points.get(0) - 10;
			double firstY = points.get(1) - 10;

			if (points.size() == 2) {
				rectangle.setX(firstX);
				rectangle.setY(firstY);
				rectangle.setWidth(20);
				rectangle.setHeight(20);
			} else if (points.size() == 4) {
				
				double secondX = points.get(2) - 10;
				double secondY = points.get(3) - 10;

				rectangle.setX(((secondX - firstX) / 2) + secondX);
				rectangle.setY(((secondY - firstY) / 2) + secondX);
				rectangle.setWidth(firstX - secondX);
				rectangle.setHeight(firstY - secondY);
			}

		} else if (points.size() > 4) {
			double rectWidth = furthestRightPoint() - furthestLeftPoint();
			double rectHeight = furthestLowPoint() - furthestHighPoint();
			double rectX = (furthestRightPoint() - furthestLeftPoint() / 2) + furthestLeftPoint();
			double rectY = (furthestLowPoint() - furthestHighPoint() / 2) + furthestHighPoint();

			rectangle.setWidth(rectWidth + 10);
			rectangle.setHeight(rectHeight + 10);
			rectangle.setY(rectY - rectHeight);
			rectangle.setX(rectX - rectWidth);

		}

		pane.getChildren().add(rectangle);

	}

}