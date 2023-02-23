package main.java.dstch.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
		Scene scene = new Scene(root, 470, 350);
		primaryStage.setTitle("饥荒烹饪助手2.0");
		primaryStage.setScene(scene);
		primaryStage.setX(400);
		primaryStage.setY(200);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
