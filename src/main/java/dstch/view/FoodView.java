package main.java.dstch.view;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class FoodView {

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(FoodView.class.getResource("/fxml/FoodView.fxml"));
			URL foodViewCssUrl = MainView.class.getResource("/css/FoodViewCss.css");
			root.getStylesheets().add(foodViewCssUrl.toExternalForm());
			stage.getScene().setRoot(root);
			SceneShow.getInstance().getRootStack().push(SceneShow.getInstance().getRoot());
			SceneShow.getInstance().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
