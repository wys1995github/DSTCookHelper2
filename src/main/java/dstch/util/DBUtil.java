package main.java.dstch.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description 数据库连接工具类
 * @author wys
 * @createDate 2023年2月15日 下午3:14:14
 */
public class DBUtil {

	private static String dbDriver;//数据库驱动类
	private static String dbUrl;//数据库地址
	private static String dbUsername;//数据库名称
	private static String dbPassword;//数据库密码

	//加载数据库配置文件
	static {
		Properties rp = new Properties();
		InputStream ips = DBUtil.class.getResourceAsStream("/db.properties");
		try {
			rp.load(ips);
			dbDriver = rp.getProperty("dbDriver");
			dbUrl = rp.getProperty("dbUrl");
			dbUsername = rp.getProperty("dbUsername");
			dbPassword = rp.getProperty("dbPassword");
			Class.forName(dbDriver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description 获取数据库连接
	 * @author wys
	 * @createDate 2023年2月21日 上午11:04:36
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @description 关闭Connection连接
	 * @author wys
	 * @createDate 2023年2月21日 上午11:04:36
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @description 关闭PreparedStatement连接
	 * @author wys
	 * @createDate 2023年2月21日 上午11:04:36
	 */
	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @description 关闭ResultSet连接
	 * @author wys
	 * @createDate 2023年2月21日 上午11:04:36
	 */
	public static void closeResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
