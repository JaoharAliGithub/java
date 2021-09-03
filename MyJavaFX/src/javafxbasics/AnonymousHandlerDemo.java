package javafxbasics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AnonymousHandlerDemo extends Application {
	public void start(Stage primaryStage) {
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		Button btNew = new Button("New");
		Button btSave = new Button("Save");
		Button btOpen = new Button("Open");
		Button btPrint = new Button("Print");
		hBox.getChildren().addAll(btNew, btSave, btPrint, btOpen);

		btNew.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process New");
			}
		});
		btOpen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Open");
			}
		});
		btSave.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Save");
			}
		});
		btPrint.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Process Print");
			}
		});

		Scene scene = new Scene(hBox, 300, 50);
		primaryStage.setTitle("AnonymousHandlerDemo");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
