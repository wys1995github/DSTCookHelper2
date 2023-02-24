package main.java.dstch.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.CLBean;
import main.java.dstch.service.*;
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
    	String buff1 = cdBean.getBuff();
    	String comment1 = cdBean.getComment();
    	
    	cookedDishesName.setText(name);
    	cookedDishesImage.setImage(image);
    	cookedDisheshunger.setText(String.valueOf(hunger));
    	cookedDishesHealth.setText(String.valueOf(health));
    	cookedDishesSanity.setText(String.valueOf(sanity));
    	buff.setText(buff1);
    	comment.setText(comment1);
      
        ObservableList<CLBean> clDataList = new InfoService().getInfoData(name);
        
        if(clDataList.get(1) != null){CLBean clBean1 = clDataList.get(1); 
		    
            VBox vbox1 = new VBox();
        	Image img1 = clBean1.getImgItem1();
 			String name1 = clBean1.getItem1();
 			Label label = new Label(name1);
 			vbox1.getChildren().add(new ImageView(img1));
     		vbox1.getChildren().add(label);
     		cookedDishesGrid.add(vbox1, 0, 0);
     		
     		VBox vbox2 = new VBox();
        	Image img2 = clBean1.getImgItem2();
 			String name2 = clBean1.getItem2();
 			Label label2 = new Label(name2);
 			vbox2.getChildren().add(new ImageView(img2));
     		vbox2.getChildren().add(label2);
     		cookedDishesGrid.add(vbox2, 1, 0);
     		
     		VBox vbox3 = new VBox();
        	Image img3 = clBean1.getImgItem3();
 			String name3 = clBean1.getItem3();
 			Label label3 = new Label(name3);
 			vbox3.getChildren().add(new ImageView(img3));
     		vbox3.getChildren().add(label3);
     		cookedDishesGrid.add(vbox3, 2, 0);
     		
     		VBox vbox4 = new VBox();
        	Image img4 = clBean1.getImgItem4();
 			String name4 = clBean1.getItem4();
 			Label label4 = new Label(name4);
 			vbox4.getChildren().add(new ImageView(img4));
     		vbox4.getChildren().add(label4);
     		cookedDishesGrid.add(vbox4, 3, 0);
     		    		
        
                }
        if(clDataList.get(2) != null){
        	CLBean clBean2 = clDataList.get(2);
        	VBox vbox5 = new VBox();
        	Image img5 = clBean2.getImgItem1();
 			String name5 = clBean2.getItem1();
 			Label label5 = new Label(name5);
 			vbox5.getChildren().add(new ImageView(img5));
     		vbox5.getChildren().add(label5);
     		cookedDishesGrid.add(vbox5, 5, 0);
     		
     		VBox vbox6 = new VBox();
        	Image img6 = clBean2.getImgItem2();
 			String name6 = clBean2.getItem2();
 			Label label6 = new Label(name6);
 			vbox6.getChildren().add(new ImageView(img6));
     		vbox6.getChildren().add(label6);
     		cookedDishesGrid.add(vbox6, 6, 0);
     		
     		VBox vbox7 = new VBox();
        	Image img7 = clBean2.getImgItem3();
 			String name7 = clBean2.getItem3();
 			Label label7 = new Label(name7);
 			vbox7.getChildren().add(new ImageView(img6));
     		vbox7.getChildren().add(label7);
     		cookedDishesGrid.add(vbox7, 7, 0);
     		
     		VBox vbox8 = new VBox();
        	Image img8 = clBean2.getImgItem4();
 			String name8 = clBean2.getItem4();
 			Label label8 = new Label(name8);
 			vbox8.getChildren().add(new ImageView(img8));
     		vbox8.getChildren().add(label8);
     		cookedDishesGrid.add(vbox7, 8, 0);
        	
        	
        	
        	
        	
        	
        	
        
        }
        if(clDataList.get(3) != null){CLBean clBean3 = clDataList.get(3); 
        VBox vbox9 = new VBox();
    	Image img9 = clBean3.getImgItem1();
			String name9 = clBean3.getItem1();
			Label label9 = new Label(name9);
			vbox9.getChildren().add(new ImageView(img9));
 		vbox9.getChildren().add(label9);
 		cookedDishesGrid.add(vbox9, 0, 1);
 		
 		VBox vbox10 = new VBox();
    	Image img10 = clBean3.getImgItem2();
			String name10 = clBean3.getItem2();
			Label label10 = new Label(name10);
			vbox10.getChildren().add(new ImageView(img10));
 		vbox10.getChildren().add(label10);
 		cookedDishesGrid.add(vbox10, 1, 1);
 		
 		VBox vbox11 = new VBox();
    	Image img11 = clBean3.getImgItem3();
			String name11 = clBean3.getItem3();
			Label label11 = new Label(name11);
			vbox11.getChildren().add(new ImageView(img11));
 		vbox11.getChildren().add(label11);
 		cookedDishesGrid.add(vbox11, 2, 1);
 		
 		VBox vbox12 = new VBox();
    	Image img12 = clBean3.getImgItem4();
			String name12 = clBean3.getItem4();
			Label label12 = new Label(name12);
			vbox12.getChildren().add(new ImageView(img12));
 		vbox12.getChildren().add(label12);
 		cookedDishesGrid.add(vbox12, 3, 1);
        
                  
        
        }
        
        
        
        
        if(clDataList.get(4) != null){CLBean clBean4 = clDataList.get(4);
        
        VBox vbox13 = new VBox();
    	Image img13 = clBean4.getImgItem1();
			String name13 = clBean4.getItem1();
			Label label13 = new Label(name13);
			vbox13.getChildren().add(new ImageView(img13));
 		vbox13.getChildren().add(label13);
 		cookedDishesGrid.add(vbox13, 5, 1);
 		
 		VBox vbox14 = new VBox();
    	Image img14 = clBean4.getImgItem2();
			String name14 = clBean4.getItem2();
			Label label14 = new Label(name14);
			vbox14.getChildren().add(new ImageView(img14));
 		vbox14.getChildren().add(label14);
 		cookedDishesGrid.add(vbox14, 6, 1);
 		
 		VBox vbox15 = new VBox();
    	Image img15 = clBean4.getImgItem3();
			String name15 = clBean4.getItem3();
			Label label15 = new Label(name15);
			vbox15.getChildren().add(new ImageView(img15));
 		vbox15.getChildren().add(label15);
 		cookedDishesGrid.add(vbox15, 7, 1);
 		
 		VBox vbox16 = new VBox();
    	Image img16 = clBean4.getImgItem4();
			String name16 = clBean4.getItem4();
			Label label16 = new Label(name16);
			vbox16.getChildren().add(new ImageView(img16));
 		vbox16.getChildren().add(label16);
 		cookedDishesGrid.add(vbox16, 8, 1); }
                
       
    	
    	
    	
    	
    }
    
    @FXML
    void backButtonClicked(MouseEvent event) {
    	if(event.getClickCount() == 1) {
			SceneShow.getInstance().toMainView();
		}
    }
    
}
