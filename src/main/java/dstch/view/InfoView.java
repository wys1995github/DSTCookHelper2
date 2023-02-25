package main.java.dstch.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoView {

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(InfoView.class.getResource("/fxml/CookedDishesView.fxml"));
			stage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
