package main.java.dstch.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class InfoViewController {
	@FXML
    private Button backButton;

    @FXML
    private Label cookTime;

    @FXML
    private Label qualityTime;

    @FXML
    private Label cookedDishesName;

    @FXML
    private Label cookedDisheshunger;

    @FXML
    private Label cookedDishesHealth;

    @FXML
    private Label cookedDishesSanity;

    @FXML
    private ImageView cookedDishesImage;

    @FXML
    private Label buff;

    @FXML
    private Label comment;

    @FXML
    private GridPane cookedDishesGrid;
	
    public void initialize() {

    	System.out.print("125125125");
    	
    	String string="肉丸";
    	cookedDishesName.setText(string);
    	cookedDisheshunger.setText("75");
    	cookedDishesHealth.setText("5");
    	cookedDishesSanity.setText("0");
    	//cookedDishesImage.setImage("/image/pot.png");
    	   	
    	buff.setText("无");
    	comment.setText("无");
    }
}
