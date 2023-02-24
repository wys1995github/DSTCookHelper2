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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.service.MainService;
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
    private TextField searchKeyText;
    
    @FXML
    private Button searchBtn;

    @FXML
    private ScrollPane mainViewScrollPane;
    
    @FXML
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
        mainViewScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        mainViewScrollPane.setContent(getCDImgGrid(searchKeyText.getText()));
    }
    
    @FXML
    void cdRadioBtnClicked(MouseEvent event) {
    	if(event.getClickCount() == 1) {
    		String searchKey = searchKeyText.getText();
    		mainViewScrollPane.setContent(getCDImgGrid(searchKey));
		}
    }

    @FXML
    void clRadioBtnClicked(MouseEvent event) {
    	if(event.getClickCount() == 1) {
    		String searchKey = searchKeyText.getText();
    		mainViewScrollPane.setContent(getFIImgGrid(searchKey));
		}
    }

    @FXML
    void keyPressed(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER) {
    		String searchKey = searchKeyText.getText();
    		mainViewScrollPane.setContent(getCDImgGrid(searchKey));
    	}
    }
    
    @FXML
    void searchBtnClicked(MouseEvent event) {
    	if(event.getClickCount() == 1) {
    		String searchKey = searchKeyText.getText();
    		mainViewScrollPane.setContent(getCDImgGrid(searchKey));
		}
    }
    
    private GridPane getCDImgGrid(String searchKey) {
    	GridPane mainGrid = new GridPane();
    	ObservableList<CDBean> cdDataList = FXCollections.observableArrayList();
    	if("".equals(searchKey) || searchKey == null) {
    		cdDataList = SceneShow.getInstance().getCdDataList();
    	}
    	cdDataList = new MainService().getCDData(searchKey);
    	cdDataList = cdSort(cdDataList);
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
    
    private GridPane getFIImgGrid(String searchKey) {
    	GridPane mainGrid = new GridPane();
    	ObservableList<FIBean> fiDataList = FXCollections.observableArrayList();
    	if("".equals(searchKey) || searchKey == null) {
    		fiDataList = SceneShow.getInstance().getFiDataList();
    	}
    	fiDataList = new MainService().getFIData(searchKey);
    	int colNum = 0;//列号
    	int rowNum = 0;//行号
    	for (int i = 0; i < fiDataList.size(); i++) {
    		if(i > 4 && i%5 == 0) {
				colNum = 0;
				rowNum++;
    		}
    		VBox vbox = new VBox();
			FIBean fiBean = fiDataList.get(i);
			Image img = fiBean.getImage();
			String name = fiBean.getName();
			Label label = new Label(name);
			vbox.getChildren().add(new ImageView(img));
    		vbox.getChildren().add(label);
    		vbox.setAlignment(Pos.CENTER);
    		mainGrid.add(vbox, colNum++, rowNum);
    	}
    	mainGrid.setHgap(10);
		mainGrid.setVgap(10);
		mainGrid.setPadding(new Insets(10));
        return mainGrid;
    }
    
    private ObservableList<CDBean> cdSort(ObservableList<CDBean> cdDataList){
    	for (int i = 0; i < cdDataList.size(); i++) {
            for (int j = 0; j < cdDataList.size() - 1; j++) {
            	if(cdDataList.get(j).getHunger() > cdDataList.get(j + 1).getHunger()){
            		CDBean temp = cdDataList.get(j);
            		cdDataList.set(j, cdDataList.get(j + 1));
            		cdDataList.set(j + 1, temp);
                }
            }
        }
    	return cdDataList;
    }
    
    private ObservableList<FIBean> fiSort(ObservableList<FIBean> fiDataList){
    	for (int i = 0; i < fiDataList.size(); i++) {
            for (int j = 0; j < fiDataList.size() - 1; j++) {
            	if(fiDataList.get(j).getHunger() > fiDataList.get(j + 1).getHunger()){
            		FIBean temp = fiDataList.get(j);
            		fiDataList.set(j, fiDataList.get(j + 1));
            		fiDataList.set(j + 1, temp);
                }
            }
        }
    	return fiDataList;
    }
    
}