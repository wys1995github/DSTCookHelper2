package main.java.dstch.view;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MainView {

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(MainView.class.getResource("/fxml/MainView.fxml"));
			URL mainViewCssUrl = MainView.class.getResource("/css/MainViewCss.css");
			root.getStylesheets().add(mainViewCssUrl.toExternalForm());
			stage.getScene().setRoot(root);
			SceneShow.getInstance().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
