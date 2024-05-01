package main.java.dstch.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.bean.MVBean;
import main.java.dstch.service.MainService;
import main.java.dstch.util.ImageUtil;
import main.java.dstch.util.SortUtil;
import main.java.dstch.view.SceneShow;

public class MainViewController {

	@FXML
	private ImageView typeImage;

	@FXML
	private Button cdBtn;

	@FXML
	private Button fiBtn;

	@FXML
	private ImageView orderImageLeft;

	@FXML
	private Button orderBtnLeft;

	@FXML
	private Label orderLabel;

	@FXML
	private ImageView orderImageRight;

	@FXML
	private Button orderBtnRight;

	@FXML
	private TextField searchKeyText;

	@FXML
	private ImageView searchImage;

	@FXML
	private ImageView exitImage;

    @FXML
    private ScrollPane mainViewScrollPane;

	private static final int TYPE_CD = 0;//料理标记
	private static final int TYPE_FI = 1;//食材标记
	private int mainFoodType;

    @FXML
    public void initialize() {
		cdBtn.setOpacity(0);
		fiBtn.setOpacity(0);
		orderBtnLeft.setOpacity(0);
		orderBtnRight.setOpacity(0);
		loadPara();
        mainViewScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);//设置不显示水平滚动条
		mainViewScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);//设置垂直滚动条始终显示
		search4FoodType();
    }

	@FXML
	void cdBtnClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {
			String searchKey = searchKeyText.getText();
			mainViewScrollPane.setContent(getCDImgGrid(searchKey));
			typeImage.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/料理按钮.png"), 135, 33));
			cdBtn.setDisable(true);
			fiBtn.setDisable(false);
			mainFoodType = MainViewController.TYPE_CD;
		}
	}

	@FXML
	void fiBtnClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {
			String searchKey = searchKeyText.getText();
			mainViewScrollPane.setContent(getFIImgGrid(searchKey));
			fiBtn.setDisable(true);
			cdBtn.setDisable(false);
			typeImage.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/食材按钮.png"), 135, 33));
			mainFoodType = MainViewController.TYPE_FI;
		}
	}

	@FXML
	void orderBtnLeftClicked(MouseEvent event) {
		String orderType = orderLabel.getText();
		switch (orderType){
			case "饥饿值" :
				isRightBtnAvailable(true);
				search4FoodType();
				break;
			case "精神值" :
				isLeftBtnAvailable(false);
				isRightBtnAvailable(true);
				orderLabel.setText("饥饿值");
				search4FoodType();
				break;
			case "生命值" :
				isLeftBtnAvailable(true);
				isRightBtnAvailable(true);
				orderLabel.setText("精神值");
				search4FoodType();
				break;
			default:
				break;
		}
	}

	@FXML
	void orderBtnRightClicked(MouseEvent event) {
		String orderType = orderLabel.getText();
		switch (orderType){
			case "饥饿值" :
				isRightBtnAvailable(true);
				isLeftBtnAvailable(true);
				orderLabel.setText("精神值");
				search4FoodType();
				break;
			case "精神值" :
				isRightBtnAvailable(false);
				isLeftBtnAvailable(true);
				orderLabel.setText("生命值");
				search4FoodType();
				break;
			case "生命值" :
				isLeftBtnAvailable(true);
				search4FoodType();
				break;
			default:
				break;
		}
	}

	@FXML
	void keyPressed(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER) {
			search4FoodType();
		}
	}

	@FXML
	void searchImageClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {
			search4FoodType();
		}
	}
	
	@FXML
	void searchImageEntered(MouseEvent event) {
		this.searchImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/搜索按钮选中.png"), 38, 40));
	}

	@FXML
	void searchImageExited(MouseEvent event) {
		this.searchImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/搜索按钮.png"), 38, 40));
	}

	@FXML
	void exitImageClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {
			Platform.exit();
		}
	}

	@FXML
	void exitImageEntered(MouseEvent event) {
		this.exitImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/exitBtnEnter.png"), 36));
	}

	@FXML
	void exitImageExited(MouseEvent event) {
		this.exitImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/exitBtn.png"), 36));
	}

    //组装料理列表
	private GridPane getCDImgGrid(String searchKey) {
    	GridPane mainGrid = new GridPane();
    	ObservableList<CDBean> cdDataList = FXCollections.observableArrayList();
    	if("".equals(searchKey.trim()) || searchKey == null) {
    		cdDataList = SceneShow.getInstance().getCdDataList();
    	}else {
    		cdDataList = new MainService().getCDData(searchKey);
    	}
		cdDataList = SortUtil.CDBeanSort(cdDataList, 0, cdDataList.size() - 1, orderLabel.getText(), SortUtil.ORDERTYPE_DESC);
		int colNum = 0;//列号
		int rowNum = 0;//行号
    	//组装grid，判断每五个数据图片换一行
		for (int i = 0; i < cdDataList.size(); i++) {
    		if(i > 4 && i%5 == 0) {
				colNum = 0;
				rowNum++;
    		}
    		CDBean cdBean = cdDataList.get(i);
    		VBox vbox = new VBox();
    		ImageView imageView = new ImageView(cdBean.getImage());
			Label label = new Label(cdBean.getName());
			label.setTextFill(Paint.valueOf("#F4E3A1"));
			vbox.getChildren().add(imageView);
			vbox.getChildren().add(label);
    		vbox.setAlignment(Pos.CENTER);
    		//设置每个图片点击事件，双击鼠标左键进入详细信息页面InfoView
			vbox.setOnMouseClicked(event -> {
    			if(event.getClickCount() == 2) {
    				SceneShow.getInstance().toInfoView(cdBean);
    				MVBean mvBean = new MVBean(mainFoodType, orderLabel.getText(), searchKeyText.getText(), mainViewScrollPane.getVvalue());
					SceneShow.getInstance().setMvBean(mvBean);
    			}
    		});
    		mainGrid.add(vbox, colNum++, rowNum);
    	}
		mainGrid.setId("mainGrid");
        return mainGrid;
    }

	//组装食材列表
	private GridPane getFIImgGrid(String searchKey) {
    	GridPane mainGrid = new GridPane();
    	ObservableList<FIBean> fiDataList = FXCollections.observableArrayList();
    	if("".equals(searchKey.trim()) || searchKey == null) {
    		fiDataList = SceneShow.getInstance().getFiDataList();
    	}else {
    		fiDataList = new MainService().getFIData(searchKey);
    	}
		fiDataList = SortUtil.FIBeanSort(fiDataList, 0, fiDataList.size() - 1, orderLabel.getText(), SortUtil.ORDERTYPE_DESC);
    	int colNum = 0;//列号
    	int rowNum = 0;//行号
		//组装grid，判断每五个数据图片换一行
		for (int i = 0; i < fiDataList.size(); i++) {
    		if(i > 4 && i%5 == 0) {
				colNum = 0;
				rowNum++;
    		}
			FIBean fiBean = fiDataList.get(i);
    		HBox hbox = new HBox();
			hbox.getChildren().add(new ImageView(fiBean.getImage()));
			hbox.setMinWidth(80);
			hbox.setMinHeight(80);
			hbox.setPrefWidth(80);
			hbox.setPrefHeight(80);
			BackgroundImage bkgImg = new BackgroundImage(
					ImageUtil.binaryStream2Image(this.getClass().getResourceAsStream("/image/食材边框.png"),80),
					BackgroundRepeat.REPEAT,
					BackgroundRepeat.REPEAT,
					BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			hbox.setBackground(new Background(bkgImg));
			hbox.setAlignment(Pos.CENTER);
			
			VBox vbox = new VBox();
			vbox.getChildren().add(hbox);
			Label label = new Label(fiBean.getName());
			label.setTextFill(Paint.valueOf("#F4E3A1"));
    		vbox.getChildren().add(label);
    		vbox.setAlignment(Pos.CENTER);
			//设置每个图片点击事件，双击鼠标左键进入详细信息页面InfoView
			vbox.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					SceneShow.getInstance().toFoodView(fiBean.getName());
					MVBean mvBean = new MVBean(mainFoodType, orderLabel.getText(), searchKeyText.getText(), mainViewScrollPane.getVvalue());
					SceneShow.getInstance().setMvBean(mvBean);
				}
			});
    		mainGrid.add(vbox, colNum++, rowNum);
    	}
		mainGrid.setId("mainGrid");
        return mainGrid;
    }
	
	private void isLeftBtnAvailable(boolean flag) {
		if(flag) {
			orderBtnLeft.setDisable(false);
			orderImageLeft.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/左箭头黄.png"), 25));
		}else {
			orderBtnLeft.setDisable(true);
			orderImageLeft.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/左箭头灰.png"), 25));
		}
	}
	
	private void isRightBtnAvailable(boolean flag) {
		if(flag) {
			orderBtnRight.setDisable(false);
			orderImageRight.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/右箭头黄.png"), 25));
		}else {
			orderBtnRight.setDisable(true);
			orderImageRight.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/右箭头灰.png"), 25));
		}
	}
	
	private void search4FoodType() {
		if(mainFoodType == MainViewController.TYPE_CD) {
			mainViewScrollPane.setContent(getCDImgGrid(searchKeyText.getText()));
		}else if(mainFoodType == MainViewController.TYPE_FI) {
			mainViewScrollPane.setContent(getFIImgGrid(searchKeyText.getText()));
		}
	}
	
	private void loadPara() {
		MVBean mvBean = SceneShow.getInstance().getMvBean();
		if(mvBean.getMainFoodType() == MainViewController.TYPE_CD) {
			cdBtn.setDisable(true);
			fiBtn.setDisable(false);
			typeImage.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/料理按钮.png"), 135, 33));
			mainFoodType = MainViewController.TYPE_CD;
		}else if(mvBean.getMainFoodType() == MainViewController.TYPE_FI) {
			fiBtn.setDisable(true);
			cdBtn.setDisable(false);
			typeImage.setImage(ImageUtil.binaryStream2Image(
					this.getClass().getResourceAsStream("/image/食材按钮.png"), 135, 33));
			mainFoodType = MainViewController.TYPE_FI;
		}
		switch(mvBean.getOrderType()) {
			case "饥饿值":
				isLeftBtnAvailable(false);
				isRightBtnAvailable(true);
				orderLabel.setText("饥饿值");
				break;
			case "精神值":
				isLeftBtnAvailable(true);
				isRightBtnAvailable(true);
				orderLabel.setText("精神值");
				break;
			case "生命值":
				isLeftBtnAvailable(true);
				isRightBtnAvailable(false);
				orderLabel.setText("生命值");
				break;
			default:
				break;
		}
		searchKeyText.setText(mvBean.getSearchKey());
		mainViewScrollPane.setVvalue(mvBean.getScrollVvalue());
	}

}