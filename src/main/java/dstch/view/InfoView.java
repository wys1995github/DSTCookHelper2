package main.java.dstch.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import main.java.dstch.bean.CDBean;

public class InfoView {

	private CDBean cdBean;

	public static void load(Stage stage) {
		try {
			Parent root = FXMLLoader.load(InfoView.class.getResource("/fxml/cookedDishesView.fxml"));
			stage.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CDBean getCdBean() {
		return cdBean;
	}

	public void setCdBean(CDBean cdBean) {
		this.cdBean = cdBean;
	}

}
