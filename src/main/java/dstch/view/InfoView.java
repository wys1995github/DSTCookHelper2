package main.java.dstch.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.dstch.util.ToolsUtil;

public class InfoView extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		AnchorPane pane = new ToolsUtil().changeScene("/fxml/cookedDishesView.fxml");
		Scene scene = new Scene(pane, 470, 350);
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
