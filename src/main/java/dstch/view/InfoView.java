package main.java.dstch.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class InfoView {

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(InfoView.class.getResource("/fxml/InfoView.fxml"));
			stage.getScene().setRoot(root);
			SceneShow.getInstance().getRootStack().push(SceneShow.getInstance().getRoot());
			SceneShow.getInstance().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
