package javafxbasics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//Name = 32 Bytes = String length 30
//Street = 32 Bytes = String length 30
//City = 20 Bytes = String length 18
//State = 2 Bytes = String length 
//Zip = 5 Bytes

public class Exercise_17_9 extends Application {

	private TextField tfName = new TextField();
	private TextField tfStreet = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfZip = new TextField();
	private Button btAdd = new Button("Add");
	private Button btFirst = new Button("First");
	private Button btNext = new Button("Next");
	private Button btPrevious = new Button("Previous");
	private Button btLast = new Button("Last");
	private Button btUpdate = new Button("Update");

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Name"), 0, 0);
		gridPane.add(tfName, 1, 0);
		gridPane.add(new Label("Street"), 0, 1);
		gridPane.add(tfStreet, 1, 1);
		gridPane.add(new Label("City"), 0, 2);
		gridPane.add(tfCity, 1, 2);
		gridPane.add(new Label("State"), 0, 3);
		gridPane.add(tfState, 1, 3);
		gridPane.add(new Label("Zip"), 0, 4);
		gridPane.add(tfZip, 1, 4);
		gridPane.add(btAdd, 1, 5);
		gridPane.add(btFirst, 2, 5);
		gridPane.add(btNext, 3, 5);
		gridPane.add(btPrevious, 4, 5);
		gridPane.add(btLast, 5, 5);
		gridPane.add(btUpdate, 6, 5);

		gridPane.setAlignment(Pos.CENTER);
		tfName.setAlignment(Pos.BOTTOM_RIGHT);
		tfStreet.setAlignment(Pos.BOTTOM_RIGHT);
		tfCity.setAlignment(Pos.BOTTOM_RIGHT);
		tfState.setAlignment(Pos.BOTTOM_RIGHT);
		tfZip.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(btAdd, HPos.CENTER);
		GridPane.setHalignment(btFirst, HPos.CENTER);
		GridPane.setHalignment(btNext, HPos.CENTER);
		GridPane.setHalignment(btPrevious, HPos.CENTER);
		GridPane.setHalignment(btLast, HPos.CENTER);
		GridPane.setHalignment(btUpdate, HPos.CENTER);

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Exercise 17.9");
		primaryStage.setScene(scene);
		primaryStage.show();

		RandomAccessFile addresses = new RandomAccessFile("addresses.dat", "rw");

		addresses.setLength(0);

		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("addresses.dat", true));
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("addresses.dat"));

		btUpdate.setOnAction(e -> {

			String name = String.valueOf(tfName.getText());
			String street = String.valueOf(tfStreet.getText());
			String city = String.valueOf(tfCity.getText());
			String state = String.valueOf(tfState.getText());
			String zip = String.valueOf(tfZip.getText());
			Address address = new Address(name, street, city, state, zip);

			try {
				addresses.seek(addresses.getFilePointer());
				output.writeObject(address);
				addresses.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btPrevious.setOnAction(e -> {
			try {
				while (addresses.length() >= 113) {
					addresses.seek(addresses.getFilePointer() - 113);
					Address address = (Address) input.readObject();
					tfName.setText(address.getName());
					tfStreet.setText(address.getStreet());
					tfCity.setText(address.getCity());
					tfState.setText(address.getState());
					tfZip.setText(address.getZip());
					addresses.close();
				}

			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		});

		btNext.setOnAction(e -> {

			try {
				while (addresses.length() - addresses.getFilePointer() >= 113) {
					addresses.seek(addresses.getFilePointer() + 113);
					Address address = (Address) input.readObject();
					tfName.setText(address.getName());
					tfStreet.setText(address.getStreet());
					tfCity.setText(address.getCity());
					tfState.setText(address.getState());
					tfZip.setText(address.getZip());
					addresses.close();
				}
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btFirst.setOnAction(e -> {
			try {
				addresses.seek(0);
				Address address = (Address) input.readObject();
				tfName.setText(address.getName());
				tfStreet.setText(address.getStreet());
				tfCity.setText(address.getCity());
				tfState.setText(address.getState());
				tfZip.setText(address.getZip());
				addresses.close();
			} catch (IOException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		});

		btLast.setOnAction(e -> {
			try {
				addresses.seek(addresses.length());
				Address address = (Address) input.readObject();
				tfName.setText(address.getName());
				tfStreet.setText(address.getStreet());
				tfCity.setText(address.getCity());
				tfState.setText(address.getState());
				tfZip.setText(address.getZip());
				addresses.close();
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btAdd.setOnAction(e -> {

			String name = String.valueOf(tfName.getText());
			String street = String.valueOf(tfStreet.getText());
			String city = String.valueOf(tfCity.getText());
			String state = String.valueOf(tfState.getText());
			String zip = String.valueOf(tfZip.getText());
			Address address = new Address(name, street, city, state, zip);

			try {
				addresses.seek(addresses.length());
				output.writeObject(address);
				addresses.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
