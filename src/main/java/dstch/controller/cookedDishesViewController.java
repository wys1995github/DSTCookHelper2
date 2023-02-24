package main.java.dstch.controller;

import java.awt.Label;
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

public class cookedDishesViewController {
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
	
    
    public void initialize(String string) {    
     
    	
    	string="肉丸";
    	
    	cookedDishesName.setText(string);
    	cookedDisheshunger.setText("75");
    	cookedDishesHealth.setText("5");
    	cookedDishesSanity.setText("0");
    	//cookedDishesImage.setImage("/image/pot.png");
    	cookTime.setText("");
    	   	
    	buff.setText("无");
    	comment.setText("无");
       
    	
    }
}
