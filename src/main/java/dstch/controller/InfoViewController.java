package main.java.dstch.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import main.java.dstch.bean.CDBean;
import main.java.dstch.view.SceneShow;

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
	
    @FXML
    public void initialize() {
    	CDBean cdBean = SceneShow.getInstance().getCdBean();
    	String name = cdBean.getName();
    	Image image = cdBean.getImage();
    	float hunger = cdBean.getHunger();
    	float sanity = cdBean.getSanity();
    	float health = cdBean.getHealth();
    	int qualityTime = cdBean.getQualityTime();
    	int cookTime = cdBean.getCookTime();
    	String buff = cdBean.getBuff();
    	String comment = cdBean.getComment();
    	
    	cookedDishesName.setText(name);
    	cookedDishesImage.setImage(image);
    	
    }
    
    @FXML
    void backButtonClicked(MouseEvent event) {
    	if(event.getClickCount() == 1) {
			SceneShow.getInstance().toMainView();
		}
    }
    
}
