package com.tavisca.utility;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class UtilityApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
		primaryStage.setTitle("Press Enter to Decrypt the token");
//        primaryStage.show();
		TextField token = new TextField("Enter Token");

		// create a tile pane
		GridPane pane = new GridPane();
		Label label = new Label("Press Enter to Decrypt");
		Label result = new Label("Your result here");

		//  TextField result = new TextField("Result");
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				result.setText(Decryptor.decrypt(token.getText()));
			}
		};

		token.setMaxSize(1160, 200);
		result.setMinSize(1160, 200);
		result.setWrapText(true);
		// when enter is pressed
		token.setOnAction(event);
		label.setFont(new Font(18));
		label.autosize();
		// add textfield
		pane.setPadding(new Insets(20,20,20,20));
		pane.add(label, 2, 1);
		pane.add(token,2,3);
		pane.add(result,2,4);

		Scene root = new Scene(pane, 1200,600);
		primaryStage.setScene(root);
		primaryStage.show();

	}


	public void callMe() {
		launch();
	}
}
