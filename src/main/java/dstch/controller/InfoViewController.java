package main.java.dstch.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.CLBean;
import main.java.dstch.service.InfoService;
import main.java.dstch.util.ImageUtil;
import main.java.dstch.view.SceneShow;

public class InfoViewController {

	@FXML
	private ImageView cdImage;

	@FXML
	private Label nameLabel;

	@FXML
	private Label healthLabel;

	@FXML
	private Label hungerLabel;

	@FXML
	private Label sanityLabel;

	@FXML
	private Label qualityTimeLabel;

	@FXML
	private Label cookTimeLabel;

	@FXML
	private Label buffLabel;
	
	@FXML
    private ImageView buffImage;

	@FXML
	private Label commentLabel;

    @FXML
    private ImageView commentImage;

	@FXML
	private AnchorPane infoViewPane;

	@FXML
	private ImageView backImage;
	
	@FXML
    private ImageView exitImage;

	@FXML
	private ImageView back2MainViewImage;

	@FXML
	public void initialize() {
		//页面数据初始化
		CDBean cdBean = SceneShow.getInstance().getCdBean();
		this.cdImage.setImage(cdBean.getImage());
		this.nameLabel.setText(cdBean.getName());
		this.healthLabel.setText(String.valueOf(cdBean.getHealth()));
		this.hungerLabel.setText(String.valueOf(cdBean.getHunger()));
		this.sanityLabel.setText(String.valueOf(cdBean.getSanity()));
		this.qualityTimeLabel.setText(String.valueOf(cdBean.getQualityTime()));
		this.cookTimeLabel.setText(String.valueOf(cdBean.getCookTime()));
		if("无".equals(cdBean.getBuff().trim())) {
			this.buffLabel.setVisible(false);
			this.buffImage.setVisible(false);
		}else {
			this.buffLabel.setText(cdBean.getBuff());
			this.buffLabel.setTooltip(new Tooltip(this.buffLabel.getText()));
		}
		if("无".equals(cdBean.getComment().trim())) {
			this.commentLabel.setVisible(false);
			this.commentImage.setVisible(false);
		}else {
			this.commentLabel.setText(cdBean.getComment());
			this.commentLabel.setTooltip(new Tooltip(this.commentLabel.getText()));
		}
		//初始化合成列表Grid
		this.infoViewPane.getChildren().add(getCLImgGrid(cdBean.getName()));
	}

	@FXML
	//设置鼠标点击返回图片事件
	void backImageMouseClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {//鼠标左键点击1次
			SceneShow.getInstance().toBackView();
		}
	}

	@FXML
	//设置鼠标进入返回图片事件
	void backImageMouseEntered(MouseEvent event) {
		this.backImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/返回按钮选中.png"), 60, 40));
	}

	@FXML
	//设置鼠标离开返回图片事件
	void backImageMouseExited(MouseEvent event) {
		this.backImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/返回按钮未选中.png"), 60, 40));
	}

	@FXML
	void back2MainViewImageClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {//鼠标左键点击1次
			SceneShow.getInstance().back2MainView();
		}
	}

	@FXML
	void back2MainViewImageEntered(MouseEvent event) {
		this.back2MainViewImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/返回主界面按钮选中.png"), 30, 25));
	}

	@FXML
	void back2MainViewImageExited(MouseEvent event) {
		this.back2MainViewImage.setImage(ImageUtil.binaryStream2Image(
				this.getClass().getResourceAsStream("/image/返回主界面按钮.png"), 30, 25));
	}

	@FXML
	//退出按钮图片事件
	void exitImageClicked(MouseEvent event) {
		if(event.getClickCount() == 1) {
			Platform.exit();
		}
    }
	
	@FXML
	void exitImageEntered(MouseEvent event) {
		this.exitImage.setOpacity(0.7);
	}

	@FXML
	void exitImageExited(MouseEvent event) {
		this.exitImage.setOpacity(1);
	}

	//加载合成列表
	private GridPane getCLImgGrid(String foodName) {
		GridPane infoGrid = new GridPane();//初始化一个空GridPane
		ObservableList<CLBean> clDataList = FXCollections.observableArrayList();//初始化一个CLBean的ObservableList
		//判断传入的foodName是否为空，如果为空，直接返回空的GridPane
		if("".equals(foodName.trim()) || foodName == null) {
			return infoGrid;
		}
		//foodName不为空，则从数据库查询合成列表
		clDataList = new InfoService().getInfoData(foodName);
		int colNum = 0;//列号
		int rowNum = 0;//行号
		//从左往右、从上往下组装GridPane，每行显示2个合成图例
		for (int i = 0; i < clDataList.size(); i++){
			//循环只显示前4条合成数据
			if(i > 3){
				break;
			}
			//如果到第三个数据，则换行rowNum++，同时清零列号colNum
			if(i == 2){
				colNum = 0;
				rowNum++;
			}
			//取出第i个合成列表数据CLBean
			CLBean clBean = clDataList.get(i);
			//组装第一个VBox
			VBox vbox1 = new VBox();
			vbox1.getChildren().add(getBkgImage(new ImageView(clBean.getImgItem1())));
			Label label1 = new Label(clBean.getItem1());
			label1.setMaxWidth(47);
			label1.setAlignment(Pos.CENTER);
			label1.setTooltip(new Tooltip(clBean.getItem1()));
			vbox1.getChildren().add(label1);
			vbox1.setAlignment(Pos.CENTER);
			vbox1.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					SceneShow.getInstance().toFoodView(clBean.getItem1());
				}
			});
			infoGrid.add(vbox1, colNum++, rowNum);
			//组装第二个VBox
			VBox vbox2 = new VBox();
			vbox2.getChildren().add(getBkgImage(new ImageView(clBean.getImgItem2())));
			Label label2 = new Label(clBean.getItem2());
			label2.setMaxWidth(47);
			label2.setAlignment(Pos.CENTER);
			label2.setTooltip(new Tooltip(clBean.getItem2()));
			vbox2.getChildren().add(label2);
			vbox2.setAlignment(Pos.CENTER);
			vbox2.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					SceneShow.getInstance().toFoodView(clBean.getItem2());
				}
			});
			infoGrid.add(vbox2, colNum++, rowNum);
			//组装第三个VBox
			VBox vbox3 = new VBox();
			vbox3.getChildren().add(getBkgImage(new ImageView(clBean.getImgItem3())));
			Label label3 = new Label(clBean.getItem3());
			label3.setMaxWidth(47);
			label3.setAlignment(Pos.CENTER);
			label3.setTooltip(new Tooltip(clBean.getItem3()));
			vbox3.getChildren().add(label3);
			vbox3.setAlignment(Pos.CENTER);
			vbox3.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					SceneShow.getInstance().toFoodView(clBean.getItem3());
				}
			});
			infoGrid.add(vbox3, colNum++, rowNum);
			//组装第四个VBox
			VBox vbox4 = new VBox();
			vbox4.getChildren().add(getBkgImage(new ImageView(clBean.getImgItem4())));
			Label label4 = new Label(clBean.getItem4());
			label4.setMaxWidth(47);
			label4.setAlignment(Pos.CENTER);
			label4.setTooltip(new Tooltip(clBean.getItem4()));
			vbox4.getChildren().add(label4);
			vbox4.setAlignment(Pos.CENTER);
			vbox4.setOnMouseClicked(event -> {
				if(event.getClickCount() == 2) {
					SceneShow.getInstance().toFoodView(clBean.getItem4());
				}
			});
			infoGrid.add(vbox4, colNum++, rowNum);
			//如果列号等于4，则中间添加一个空的VBox占位
			if(colNum == 4){//测试
				Label midLabel = new Label();
				midLabel.setMinWidth(15);
				infoGrid.add(midLabel, colNum++, rowNum);
			}
		}
		infoGrid.setHgap(2);//设置水平间距为2
		infoGrid.setVgap(1);
		infoGrid.setPadding(new Insets(5, 0, 0, 14));
		return infoGrid;
	}
	
	private HBox getBkgImage(ImageView imageView) {
		HBox hbox = new HBox();
		hbox.getChildren().add(imageView);
		hbox.setMinWidth(45);
		hbox.setMinHeight(45);
		hbox.setPrefWidth(45);
		hbox.setPrefHeight(45);
		BackgroundImage bkgImg = new BackgroundImage(
				ImageUtil.binaryStream2Image(this.getClass().getResourceAsStream("/image/食材边框.png"), 43),
				BackgroundRepeat.REPEAT,
				BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		hbox.setBackground(new Background(bkgImg));
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}

}
