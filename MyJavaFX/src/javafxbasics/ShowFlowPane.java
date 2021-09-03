package javafxbasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*;

public class ShowFlowPane extends Application {

	@Override
	public void start(Stage primaryStage) {
// Create a pane and set its properties
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(5);
		pane.setVgap(5);

		pane.getChildren().addAll(new Label("First Name:"), new TextField(), new Label("MI:"));
		TextField tfMI = new TextField();
		tfMI.setPrefColumnCount(1);
		pane.getChildren().addAll(tfMI, new Label("Last Name:"), new TextField());

		Scene scene = new Scene(pane, 200, 250);
		primaryStage.setTitle("ShowFlowPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
