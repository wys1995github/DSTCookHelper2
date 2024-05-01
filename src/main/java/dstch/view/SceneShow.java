package main.java.dstch.view;

import java.awt.Toolkit;
import java.io.IOException;
import java.util.Stack;

import javafx.collections.ObservableList;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.bean.MVBean;
import main.java.dstch.service.MainService;
import main.java.dstch.util.ImageUtil;

public class SceneShow {
	
	private Stage stage;
	private CDBean cdBean;
	private String fiName;
	private ObservableList<CDBean> cdDataList = null;
	private ObservableList<FIBean> fiDataList = null;
	private Stack<Parent> rootStack = new Stack<Parent>();
	private Parent root;
	private MVBean mvBean = new MVBean(0, "饥饿值", "", 0);
	private double dragOffsetX;//点击鼠标时的x坐标值
	private double dragOffsetY;//点击鼠标时的y坐标值
	private final double sceneWidth = 470;
	private final double sceneHeight = 350;
	private final double screenWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private final double screenHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	private static SceneShow instance = new SceneShow();
	
	private SceneShow() {}
	
	public static SceneShow getInstance() {
		return instance;
	}
	
	public void init(Stage stage) throws IOException {
		this.stage = stage;
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, sceneWidth, sceneHeight);
		scene.setOnMousePressed((ev) -> handleMousePressed(ev));//获取坐标值
		scene.setOnMouseDragged(e -> handleMouseDragged(e));//实现窗口拖动
		stage.setTitle("饥荒烹饪助手 v2.0_beta");
		stage.setX((screenWidth - sceneWidth) / 2);
		stage.setY((screenHeight - sceneHeight) / 2);
		stage.getIcons().add(new Image(this.getClass().getResource("/image/pot.png").toString()));
		stage.setScene(scene);
		toMainView();
		Image cursorImg = ImageUtil.binaryStream2Image(this.getClass().getResourceAsStream("/image/cursor.png"), 64);
		scene.setCursor(new ImageCursor(cursorImg, 0, 0));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}
	
	public void toMainView() {
		if(this.cdDataList == null) {
			setCdDataList(new MainService().getCDData());
		}
		if(this.fiDataList == null) {
			setFiDataList(new MainService().getFIData());
		}
		MainView.load(stage);
	}
	
	public void toInfoView(CDBean cdBean) {
		setCdBean(cdBean);
		InfoView.load(stage);
	}
	
	public void toFoodView(String fiName) {
		setFiName(fiName);
		FoodView.load(stage);
	}
	
	public void toBackView() {
		stage.getScene().setRoot(this.rootStack.pop());
		if(this.rootStack.empty()) {
			toMainView();
		}
	}
	
	public void back2MainView() {
		this.rootStack.removeAllElements();
		toMainView();
	}

	public CDBean getCdBean() {
		return cdBean;
	}
	
	private void setCdBean(CDBean cdBean) {
		this.cdBean = cdBean;
	}

	public String getFiName() {
		return fiName;
	}

	public void setFiName(String fiName) {
		this.fiName = fiName;
	}

	public ObservableList<CDBean> getCdDataList() {
		return cdDataList;
	}

	private void setCdDataList(ObservableList<CDBean> cdDataList) {
		this.cdDataList = cdDataList;
	}

	public ObservableList<FIBean> getFiDataList() {
		return fiDataList;
	}

	private void setFiDataList(ObservableList<FIBean> fiDataList) {
		this.fiDataList = fiDataList;
	}
	
	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}

	public Stack<Parent> getRootStack() {
		return rootStack;
	}
	
	private void handleMousePressed(MouseEvent e) {
		//点击鼠标时，获取鼠标在窗体上点击时相对应窗体左上角的偏移
		this.dragOffsetX = e.getScreenX() - stage.getX();
		this.dragOffsetY = e.getScreenY() - stage.getY();
	}
	
	private void handleMouseDragged(MouseEvent e) {
		//拖动鼠标后，获取鼠标相对应显示器坐标减去鼠标相对窗体的坐标，并将其设置为窗体在显示器上的坐标
		stage.setX(e.getScreenX() - this.dragOffsetX);
		stage.setY(e.getScreenY() - this.dragOffsetY);
	}

	public MVBean getMvBean() {
		return mvBean;
	}

	public void setMvBean(MVBean mvBean) {
		this.mvBean = mvBean;
	}
	
}
