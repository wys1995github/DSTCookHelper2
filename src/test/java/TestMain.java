package test.java;
	
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class TestMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		//从数据库加载数据
		ObservableList<CLBean> data = new InfoService().getInfoData();
		//创建表视图
		TableView<CLBean> tableView = new TableView<>();
		//定义表格的行标
		TableColumn<CLBean, String> item1Col = new TableColumn<CLBean, String>("食材1");
		TableColumn<CLBean, String> item2Col = new TableColumn<CLBean, String>("食材2");
		TableColumn<CLBean, String> item3Col = new TableColumn<CLBean, String>("食材3");
		TableColumn<CLBean, String> item4Col = new TableColumn<CLBean, String>("食材4");
		//表格列宽宽度设置
		item1Col.setMinWidth(100);
		item2Col.setMinWidth(100);
		item3Col.setMinWidth(100);
		item4Col.setMinWidth(100);
		//确定数据导入的列
		item1Col.setCellValueFactory(new PropertyValueFactory<>("item1"));
		item2Col.setCellValueFactory(new PropertyValueFactory<>("item2"));
		item3Col.setCellValueFactory(new PropertyValueFactory<>("item3"));
		item4Col.setCellValueFactory(new PropertyValueFactory<>("item4"));
		
		item1Col.setCellFactory(new Callback<TableColumn<CLBean,String>, TableCell<CLBean,String>>() {
			@Override
			public TableCell<CLBean, String> call(TableColumn<CLBean, String> param) {
				TableCell<CLBean, String> cell = new TableCell<CLBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		item2Col.setCellFactory(new Callback<TableColumn<CLBean,String>, TableCell<CLBean,String>>() {
			@Override
			public TableCell<CLBean, String> call(TableColumn<CLBean, String> param) {
				TableCell<CLBean, String> cell = new TableCell<CLBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		item3Col.setCellFactory(new Callback<TableColumn<CLBean,String>, TableCell<CLBean,String>>() {
			@Override
			public TableCell<CLBean, String> call(TableColumn<CLBean, String> param) {
				TableCell<CLBean, String> cell = new TableCell<CLBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							ImageView imageView = new ImageView();
//							Image image = new Image("file:C://chat/1.gif");
//							new Image(getClass().getResourceAsStream("manage.png"),40,40,false,false); 
//							imageView.setImage(image);
							label.setGraphic(imageView);
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		item4Col.setCellFactory(new Callback<TableColumn<CLBean,String>, TableCell<CLBean,String>>() {
			@Override
			public TableCell<CLBean, String> call(TableColumn<CLBean, String> param) {
				TableCell<CLBean, String> cell = new TableCell<CLBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		
		//向表中导入数据
		tableView.getColumns().add(item1Col);
		tableView.getColumns().add(item2Col);
		tableView.getColumns().add(item3Col);
		tableView.getColumns().add(item4Col);
		tableView.setItems(data);
		Scene scene = new Scene(tableView, 400, 200);
		primaryStage.setTitle("合成列表");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
