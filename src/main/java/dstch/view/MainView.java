package main.java.dstch.view;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.java.dstch.bean.CDBean;
import main.java.dstch.service.MainService;

public class MainView extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Scene scene = new Scene(this.getMainTableView(), 1000, 800);
		primaryStage.setScene(scene);
		primaryStage.setTitle("饥荒烹饪助手");
		primaryStage.setX(200);
		primaryStage.setY(100);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private TableView<CDBean> getMainTableView(){
		//从数据库加载数据
		ObservableList<CDBean> cdData = new MainService().getCDData();
		TableView<CDBean> tableView = new TableView<>();
		//定义表格的行标
		TableColumn<CDBean, Number> numCol = new TableColumn<CDBean, Number>("序号");
		TableColumn<CDBean, String> nameCol = new TableColumn<CDBean, String>("名称");
		TableColumn<CDBean, Image> imageCol = new TableColumn<CDBean, Image>("图片");
		TableColumn<CDBean, Number> hungerCol = new TableColumn<CDBean, Number>("饥饿值");
		TableColumn<CDBean, Number> sanityCol = new TableColumn<CDBean, Number>("精神值");
		TableColumn<CDBean, Number> healthCol = new TableColumn<CDBean, Number>("生命值");
		TableColumn<CDBean, Number> qualityTimeCol = new TableColumn<CDBean, Number>("保质期(天)");
		TableColumn<CDBean, Number> cookTimeCol = new TableColumn<CDBean, Number>("烹饪时间(秒)");
		TableColumn<CDBean, String> buffCol = new TableColumn<CDBean, String>("特殊增益");
		TableColumn<CDBean, String> commentCol = new TableColumn<CDBean, String>("备注");
		//表格列宽宽度设置
		numCol.setMinWidth(30);
		nameCol.setMinWidth(0);
		nameCol.setMaxWidth(0);
		nameCol.setPrefWidth(0);
		imageCol.setMinWidth(100);
		hungerCol.setMinWidth(40);
		sanityCol.setMinWidth(40);
		healthCol.setMinWidth(40);
		qualityTimeCol.setMinWidth(40);
		cookTimeCol.setMinWidth(40);
		buffCol.setMinWidth(150);
		commentCol.setMinWidth(120);
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
		numCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		nameCol.setCellFactory(new Callback<TableColumn<CDBean, String>, TableCell<CDBean, String>>() {
			@Override
			public TableCell<CDBean, String> call(TableColumn<CDBean, String> param) {
				TableCell<CDBean, String> cell = new TableCell<CDBean, String>() {
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
		imageCol.setCellFactory(new Callback<TableColumn<CDBean, Image>, TableCell<CDBean, Image>>() {
			@Override
			public TableCell<CDBean, Image> call(TableColumn<CDBean, Image> param) {
				TableCell<CDBean, Image> cell = new TableCell<CDBean, Image>() {
					@Override
					protected void updateItem(Image item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							VBox vbox = new VBox();
							Label labelImg = new Label();
							labelImg.setGraphic(new ImageView(item));
							Label labelText = new Label(cdData.get(getIndex()).getName());
							vbox.getChildren().addAll(labelImg, labelText);
							vbox.setAlignment(Pos.CENTER);
							this.setGraphic(vbox);
						}
					}
				};
				return cell;
			}
		});
		hungerCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		sanityCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		healthCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		qualityTimeCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		cookTimeCol.setCellFactory(new Callback<TableColumn<CDBean, Number>, TableCell<CDBean, Number>>() {
			@Override
			public TableCell<CDBean, Number> call(TableColumn<CDBean, Number> param) {
				TableCell<CDBean, Number> cell = new TableCell<CDBean, Number>() {
					@Override
					protected void updateItem(Number item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item.toString());
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		buffCol.setCellFactory(new Callback<TableColumn<CDBean, String>, TableCell<CDBean, String>>() {
			@Override
			public TableCell<CDBean, String> call(TableColumn<CDBean, String> param) {
				TableCell<CDBean, String> cell = new TableCell<CDBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							label.setWrapText(true);//设置换行
							label.setMaxHeight(40);
							hbox.getChildren().add(label);
							hbox.setAlignment(Pos.CENTER);
							this.setGraphic(hbox);
						}
					}
				};
				return cell;
			}
		});
		commentCol.setCellFactory(new Callback<TableColumn<CDBean, String>, TableCell<CDBean, String>>() {
			@Override
			public TableCell<CDBean, String> call(TableColumn<CDBean, String> param) {
				TableCell<CDBean, String> cell = new TableCell<CDBean, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if(empty == false && item != null) {
							HBox hbox = new HBox();
							Label label = new Label(item);
							label.setWrapText(true);//设置换行
							label.setMaxHeight(40);
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
		tableView.setItems(cdData);
		return tableView;
	}
	
	public static void main(String[] args) {
		launch(args);//启动
	}
}
