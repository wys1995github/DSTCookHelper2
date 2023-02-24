package main.java.dstch.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainView {

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(MainView.class.getResource("/fxml/MainView.fxml"));
			stage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
