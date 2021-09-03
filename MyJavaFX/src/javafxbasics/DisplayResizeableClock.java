package javafxbasics;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class DisplayResizeableClock extends Application {
	@Override
	public void start(Stage primaryStage) {

		ClockPane clock = new ClockPane();
		String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
		Label lblCurrentTime = new Label(timeString);

		BorderPane pane = new BorderPane();
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

		Scene scene = new Scene(pane);
		primaryStage.setTitle("DisplayResizeableClock");
		primaryStage.setScene(scene);
		primaryStage.show();

		pane.widthProperty().addListener(ov -> {
			clock.setW(pane.getWidth());
		});

		pane.heightProperty().addListener(ov -> {
			clock.setH(pane.getHeight());
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
