package main.java.dstch.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;

public class InterfaceView extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		SceneShow.getInstance().init(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}