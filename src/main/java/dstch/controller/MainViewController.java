package main.java.dstch.controller;

import java.io.InputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MainViewController {

    @FXML
    private RadioButton cdRadioBtn;

    @FXML
    private RadioButton clRadioBtn;

    @FXML
    private ComboBox<String> priorityBox;
    
    @FXML
    private Button searchBtn;

    @FXML
    private GridPane mainGrid;

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
        //主页面下方料理grid显示图片
        mainGrid.add(getImageView("/image/pot.png"), 0, 0);
        mainGrid.add(getImageView("/image/pot.png"), 0, 1);
        mainGrid.add(getImageView("/image/icon.png"), 0, 2);
        mainGrid.add(getImageView("/image/icon.png"), 1, 0);
        mainGrid.add(getImageView("/image/icon.png"), 1, 1);
        mainGrid.add(getImageView("/image/icon.png"), 2, 1);
        mainGrid.add(getImageView("/image/icon.png"), 2, 4);
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
    
    private ImageView getImageView(String imgPath) {
    	ImageView imageView = new ImageView();
        InputStream ips = getClass().getResourceAsStream(imgPath);
        imageView.setImage(new Image(ips, 50, 50, false, false));
    	return imageView;
    }

}