package main.java.dstch.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class ToolsUtil {
	
	public AnchorPane changeScene(String fxmlPath) throws IOException {
		AnchorPane pane = FXMLLoader.load(getClass().getResource(fxmlPath));
		return pane;
	}

}
