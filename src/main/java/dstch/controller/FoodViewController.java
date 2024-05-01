package main.java.dstch.controller;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.service.FoodService;
import main.java.dstch.service.MainService;
import main.java.dstch.util.ImageUtil;
import main.java.dstch.util.SortUtil;
import main.java.dstch.view.SceneShow;

public class FoodViewController {
    @FXML
    private ImageView backImage;

    @FXML
    private ImageView cdImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label hungerLabel;

    @FXML
    private Label sanityLabel;

    @FXML
    private Label healthLabel;

    @FXML
    private Label qualityTimeLabel;
    
    @FXML
    private ImageView commentImage;

    @FXML
    private Label commentLabel;

    @FXML
    private ImageView typeImage;

    @FXML
    private Label degreeLabel;

    @FXML
    private AnchorPane foodTablePane;
    
    @FXML
    private ImageView exitImage;

    @FXML
    private ImageView back2MainViewImage;
    
    @FXML
    private Label hungerImgLabel;

    @FXML
    private Label sanityImgLabel;

    @FXML
    private Label healthImgLabel;

    private ObservableList<CDBean> cdData;

    @FXML
    public void initialize() {
    	String fiName = SceneShow.getInstance().getFiName();
    	ObservableList<FIBean> fiDataList = new MainService().getFIData(fiName);
    	FIBean fiBean = fiDataList.get(0);
        this.cdImage.setImage(fiBean.getImage());
		this.nameLabel.setText(fiBean.getName());
        this.hungerLabel.setText(String.valueOf(fiBean.getHunger()));
        this.sanityLabel.setText(String.valueOf(fiBean.getSanity()));
        this.healthLabel.setText(String.valueOf(fiBean.getHealth()));
		this.qualityTimeLabel.setText(String.valueOf(fiBean.getQualityTime()));
		if("无".equals(fiBean.getComment().trim())) {
			this.commentLabel.setVisible(false);
			this.commentImage.setVisible(false);
		}else {
			this.commentLabel.setText(fiBean.getComment());
			this.commentLabel.setTooltip(new Tooltip(this.commentLabel.getText()));
		}
        setTypeImage(fiBean.getType());
        this.degreeLabel.setText(String.valueOf(fiBean.getDegree()));
        setOrderLabelImg("饥饿值");
        this.cdData = new FoodService().getFoodData(fiBean.getName());
        this.cdData = SortUtil.CDBeanSort(this.cdData, 0, cdData.size() - 1, "饥饿值", SortUtil.ORDERTYPE_DESC);
        getOrderData();
        this.foodTablePane.getChildren().add(getFoodTableView());
    }

    @FXML
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

    @FXML
    void hungerImgLabelClicked(MouseEvent event) {
    	this.cdData = SortUtil.CDBeanSort(this.cdData, 0, cdData.size() - 1, "饥饿值", SortUtil.ORDERTYPE_DESC);
        getOrderData();
        setOrderLabelImg("饥饿值");
    }
    
    @FXML
    void sanityImgLabelClicked(MouseEvent event) {
    	this.cdData = SortUtil.CDBeanSort(this.cdData, 0, cdData.size() - 1, "精神值", SortUtil.ORDERTYPE_DESC);
        getOrderData();
        setOrderLabelImg("精神值");
    }
    
    @FXML
    void healthImgLabelClicked(MouseEvent event) {
    	this.cdData = SortUtil.CDBeanSort(this.cdData, 0, cdData.size() - 1, "生命值", SortUtil.ORDERTYPE_DESC);
        getOrderData();
        setOrderLabelImg("生命值");
    }
    
    //排序按钮图片切换
    private void setOrderLabelImg(String orderType) {
    	Image selectImg = ImageUtil.binaryStream2Image(this.getClass().getResourceAsStream("/image/按钮选中.png"), 25);
    	Image notSelectImg = ImageUtil.binaryStream2Image(this.getClass().getResourceAsStream("/image/按钮未选中.png"), 25);
    	double graphicTextGap = 3;
    	switch(orderType) {
    		case "饥饿值":
    			this.hungerImgLabel.setGraphic(new ImageView(selectImg));
    	    	this.hungerImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.sanityImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.sanityImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.healthImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.healthImgLabel.setGraphicTextGap(graphicTextGap);
    			break;
    		case "精神值":
    			this.hungerImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.hungerImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.sanityImgLabel.setGraphic(new ImageView(selectImg));
    	    	this.sanityImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.healthImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.healthImgLabel.setGraphicTextGap(graphicTextGap);
    			break;
    		case "生命值":
    			this.hungerImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.hungerImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.sanityImgLabel.setGraphic(new ImageView(notSelectImg));
    	    	this.sanityImgLabel.setGraphicTextGap(graphicTextGap);
    	    	this.healthImgLabel.setGraphic(new ImageView(selectImg));
    	    	this.healthImgLabel.setGraphicTextGap(graphicTextGap);
    			break;
    		default:
    			break;
    	}
    }
    
    //设置类型图片
    private void setTypeImage(String fiType){
        switch(fiType){
            case "meat":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/肉度_小肉.png"), 40));
                break;
            case "fruits":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/水果度_浆果.png"), 40));
                break;
            case "fish":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/鱼度_鱼.png"), 40));
                break;
            case "veggie":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/蔬菜度_胡萝卜.png"), 40));
                break;
            case "egg":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/蛋度_鸟蛋.png"), 40));
                break;
            case "dairy":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/奶度_带电的羊奶.png"), 40));
                break;
            case "sweetener":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/甜度_蜂蜜.png"), 40));
                break;
            case "frozen":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/冰度_冰.png"), 40));
                break;
            case "inedible":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/不可食用度_树枝.png"), 40));
                break;
            case "fat":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/油脂度_黄油.png"), 40));
                break;
            case "decoration":
                this.typeImage.setImage(ImageUtil.binaryStream2Image(
                        this.getClass().getResourceAsStream("/image/装饰度_蝴蝶翅膀.png"), 40));
                break;
            default:
                break;
        }
    }

    private TableView<CDBean> getFoodTableView(){
        TableView<CDBean> tableView = new TableView<>();
        //定义表格的行标
        TableColumn<CDBean, Object> numCol = new TableColumn<CDBean, Object>("序号");
        TableColumn<CDBean, Object> nameCol = new TableColumn<CDBean, Object>("名称");
        TableColumn<CDBean, Object> imageCol = new TableColumn<CDBean, Object>("图片");
        TableColumn<CDBean, Object> hungerCol = new TableColumn<CDBean, Object>("饥饿值");
        TableColumn<CDBean, Object> sanityCol = new TableColumn<CDBean, Object>("精神值");
        TableColumn<CDBean, Object> healthCol = new TableColumn<CDBean, Object>("生命值");
        TableColumn<CDBean, Object> qualityTimeCol = new TableColumn<CDBean, Object>("保质期(天)");
        TableColumn<CDBean, Object> cookTimeCol = new TableColumn<CDBean, Object>("烹饪时间(秒)");
        TableColumn<CDBean, Object> buffCol = new TableColumn<CDBean, Object>("特殊增益");
        TableColumn<CDBean, Object> commentCol = new TableColumn<CDBean, Object>("备注");
        //表格列宽宽度设置
        numCol.setMinWidth(30);
        numCol.setMaxWidth(30);
        numCol.setPrefWidth(30);
        imageCol.setMinWidth(70);
        imageCol.setMaxWidth(70);
        imageCol.setPrefWidth(70);
        hungerCol.setMinWidth(60);
        hungerCol.setMaxWidth(60);
        hungerCol.setPrefWidth(60);
        sanityCol.setMinWidth(60);
        sanityCol.setMaxWidth(60);
        sanityCol.setPrefWidth(60);
        healthCol.setMinWidth(60);
        healthCol.setMaxWidth(60);
        healthCol.setPrefWidth(60);
        //不显示列
        nameCol.setMinWidth(0);
        nameCol.setMaxWidth(0);
        nameCol.setPrefWidth(0);
        qualityTimeCol.setMinWidth(0);
        qualityTimeCol.setMaxWidth(0);
        qualityTimeCol.setPrefWidth(0);
        cookTimeCol.setMinWidth(0);
        cookTimeCol.setMaxWidth(0);
        cookTimeCol.setPrefWidth(0);
        buffCol.setMinWidth(0);
        buffCol.setMaxWidth(0);
        buffCol.setPrefWidth(0);
        commentCol.setMinWidth(0);
        commentCol.setMaxWidth(0);
        commentCol.setPrefWidth(0);
        //确定数据导入的列
        numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        imageCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        hungerCol.setCellValueFactory(new PropertyValueFactory<>("hunger"));
        sanityCol.setCellValueFactory(new PropertyValueFactory<>("sanity"));
        healthCol.setCellValueFactory(new PropertyValueFactory<>("health"));
        qualityTimeCol.setCellValueFactory(new PropertyValueFactory<>("qualityTime"));
        cookTimeCol.setCellValueFactory(new PropertyValueFactory<>("cookTime"));
        buffCol.setCellValueFactory(new PropertyValueFactory<>("buff"));
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        //设置单元格样式
        setCustomCell(numCol);
        setCustomCell(nameCol);
        setCustomCell(imageCol);
        setCustomCell(hungerCol);
        setCustomCell(sanityCol);
        setCustomCell(healthCol);
        setCustomCell(qualityTimeCol);
        setCustomCell(cookTimeCol);
        setCustomCell(buffCol);
        setCustomCell(commentCol);
        //禁用排序
        numCol.setSortable(false);
        nameCol.setSortable(false);
        imageCol.setSortable(false);
        hungerCol.setSortable(false);
        sanityCol.setSortable(false);
        healthCol.setSortable(false);
        qualityTimeCol.setSortable(false);
        cookTimeCol.setSortable(false);
        buffCol.setSortable(false);
        commentCol.setSortable(false);
        //向表中导入数据
        tableView.getColumns().add(numCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(imageCol);
        tableView.getColumns().add(hungerCol);
        tableView.getColumns().add(sanityCol);
        tableView.getColumns().add(healthCol);
        tableView.getColumns().add(qualityTimeCol);
        tableView.getColumns().add(cookTimeCol);
        tableView.getColumns().add(buffCol);
        tableView.getColumns().add(commentCol);
        tableView.setItems(this.cdData);
        tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if(event.getClickCount() == 2) {
					CDBean cdBean = tableView.getSelectionModel().getSelectedItem();
					if(cdBean != null) {
						SceneShow.getInstance().toInfoView(cdBean);
					}
				}
			}
		});
        //禁用列拖动
        tableView.getColumns().addListener(new ListChangeListener<Object>() {
            @Override
            public void onChanged(Change<?> change) {
              change.next();
              if(change.wasReplaced()) {
            	  tableView.getColumns().clear();
            	  tableView.getColumns().add(numCol);
                  tableView.getColumns().add(nameCol);
                  tableView.getColumns().add(imageCol);
                  tableView.getColumns().add(hungerCol);
                  tableView.getColumns().add(sanityCol);
                  tableView.getColumns().add(healthCol);
                  tableView.getColumns().add(qualityTimeCol);
                  tableView.getColumns().add(cookTimeCol);
                  tableView.getColumns().add(buffCol);
                  tableView.getColumns().add(commentCol);
              }
            }
        });
        tableView.getSelectionModel().select(null);
        tableView.setEditable(false);
        tableView.setPlaceholder(new Label("我觉得这个食物不应该放在锅里~"));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setId("foodTable");
        return tableView;
    }

    //自定义单元格
    private void setCustomCell(TableColumn<CDBean, Object> tableColumn) {
    	tableColumn.setCellFactory(new Callback<TableColumn<CDBean, Object>, TableCell<CDBean, Object>>() {
            @Override
            public TableCell<CDBean, Object> call(TableColumn<CDBean, Object> param) {
                TableCell<CDBean, Object> cell = new TableCell<CDBean, Object>() {
                    @Override
                    protected void updateItem(Object item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty == false && item != null) {
                        	HBox hbox = new HBox();
                            Label label = new Label();
                            label.setAlignment(Pos.CENTER);
                        	if(item instanceof String) {
                        		label.setText((String)item);
                            }else if(item instanceof Number) {
                            	label.setText(item.toString());
                            }else if(item instanceof Image) {
                            	ImageView imgView = new ImageView((Image)item);
                            	imgView.setFitWidth(40);
                            	imgView.setFitHeight(40);
                            	label.setGraphic(imgView);
                            	label.setText(cdData.get(getIndex()).getName());
                            	label.setContentDisplay(ContentDisplay.TOP);
                            	label.setGraphicTextGap(0);
                            	label.setTooltip(new Tooltip(cdData.get(getIndex()).getName()));
                            }
                        	hbox.getChildren().add(label);
                            hbox.setAlignment(Pos.CENTER);
                            this.setGraphic(hbox);
                        }
                    }
                };
                return cell;
            }
        });
    }
    
    private void getOrderData(){
        int num = 1;
        for(int i = 0; i < this.cdData.size(); i++){
            this.cdData.get(i).setNum(num++);
        }
    }

}
