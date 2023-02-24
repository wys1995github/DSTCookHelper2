package main.java.dstch.view;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.service.MainService;

public class SceneShow {
	
	private Stage stage;
	private CDBean cdBean;
	private ObservableList<CDBean> cdDataList = null;
	private ObservableList<FIBean> fiDataList = null;

	private static SceneShow instance = new SceneShow();
	
	private SceneShow() {}
	
	public static SceneShow getInstance() {
		return instance;
	}
	
	public void init(Stage stage) throws IOException {
		this.stage = stage;
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 470, 350);
		stage.setTitle("饥荒烹饪助手2.0");
		stage.setScene(scene);
		setCdDataList(new MainService().getCDData());
		toMainView();
		stage.show();
	}
	
	public void toMainView() {
		MainView.load(stage);
	}
	
	public void toInfoView(CDBean cdBean) {
		setCdBean(cdBean);
		InfoView.load(stage);
	}

	public CDBean getCdBean() {
		return cdBean;
	}
	
	private void setCdBean(CDBean cdBean) {
		this.cdBean = cdBean;
	}
	
	public ObservableList<CDBean> getCdDataList() {
		return cdDataList;
	}

	private void setCdDataList(ObservableList<CDBean> cdDataList) {
		if(this.cdDataList == null) {
			this.cdDataList = cdDataList;
		}
	}
	
	public ObservableList<FIBean> getFiDataList() {
		return fiDataList;
	}

	public void setFiDataList(ObservableList<FIBean> fiDataList) {
		if(this.fiDataList == null) {
			this.fiDataList = fiDataList;
		}
	}

}
