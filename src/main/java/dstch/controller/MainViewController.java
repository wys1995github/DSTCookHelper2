package main.java.dstch.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.java.dstch.bean.CDBean;
import main.java.dstch.view.SceneShow;

public class MainViewController {

	@FXML
    private AnchorPane anchorPane;
	
	@FXML
    private RadioButton cdRadioBtn;

    @FXML
    private RadioButton clRadioBtn;

    @FXML
    private ComboBox<String> priorityBox;
    
    @FXML
    private Button searchBtn;

    @FXML
    private ScrollPane mainViewScrollPane;
    
    public void initialize() {
    	//设置料理和食材按钮互斥
    	ToggleGroup group = new ToggleGroup();
    	cdRadioBtn.setToggleGroup(group);
    	clRadioBtn.setToggleGroup(group);
    	cdRadioBtn.setSelected(true);
    	//设置优先度下拉框选项
    	ObservableList<String> itemList = FXCollections.observableArrayList();
        itemList.add("饥饿值");
        itemList.add("精神值");
        itemList.add("生命值");
        priorityBox.setItems(itemList);
        priorityBox.getSelectionModel().selectFirst();//默认选中第一项
        //将Grid装载进ScrollPane
        mainViewScrollPane.setContent(getImgGrid());
        mainViewScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }
    
    @FXML
    void cdRadioBtnClicked(MouseEvent event) {

    }

    @FXML
    void clRadioBtnClicked(MouseEvent event) {

    }

    @FXML
    void searchBtnClicked(MouseEvent event) {

    }

    @FXML
    void searchBtnKeyPressed(KeyEvent event) {

    }
    
    private GridPane getImgGrid() {
    	GridPane mainGrid = new GridPane();
    	ObservableList<CDBean> cdDataList = SceneShow.getInstance().getCdDataList();
    	int colNum = 0;//列号
    	int rowNum = 0;//行号
    	for (int i = 0; i < cdDataList.size(); i++) {
    		if(i > 4 && i%5 == 0) {
				colNum = 0;
				rowNum++;
    		}
    		VBox vbox = new VBox();
			CDBean cdBean = cdDataList.get(i);
			Image img = cdBean.getImage();
			String name = cdBean.getName();
			Label label = new Label(name);
			vbox.getChildren().add(new ImageView(img));
    		vbox.getChildren().add(label);
    		vbox.setAlignment(Pos.CENTER);
    		vbox.setOnMouseClicked(event -> {
    			if(event.getClickCount() == 2) {
    				SceneShow.getInstance().toInfoView(cdBean);
    			}
    		});
    		mainGrid.add(vbox, colNum++, rowNum);
    	}
    	mainGrid.setHgap(10);
		mainGrid.setVgap(10);
		mainGrid.setPadding(new Insets(10));
        return mainGrid;
    }
    
}