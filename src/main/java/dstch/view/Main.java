package main.java.dstch.view;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Pane root = FXMLLoader.load(getClass().getResource("/fxml/mainview.fxml"));//加载fxml文件
		Scene scene = new Scene(root, 600, 400);//设置场景，宽度600，高度400
		primaryStage.setScene(scene);//把场景加入窗口
		primaryStage.setTitle("饥荒烹饪助手");//设置窗口标题
		primaryStage.setX(400);//设置起始X坐标
		primaryStage.setY(200);//设置起始Y坐标
		primaryStage.setResizable(false);//设置窗口是否可缩放
		primaryStage.show();//显示窗口
	}
	
	public static void main(String[] args) {
		launch(args);//启动窗口程序
	}
}
