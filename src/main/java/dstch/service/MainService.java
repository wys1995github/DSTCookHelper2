package main.java.dstch.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.dstch.bean.CDBean;
import main.java.dstch.bean.FIBean;
import main.java.dstch.util.DBUtil;
import main.java.dstch.util.ImageUtil;

public class MainService {

	private Connection conn = DBUtil.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public ObservableList<CDBean> getCDData() {
		String sql = "select * from t_cookedDishes ";
		ObservableList<CDBean> cdDataList = FXCollections.observableArrayList();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int cd_num = 1;
			while(rs.next()) {
				cdDataList.add(new CDBean(
					cd_num++,
					rs.getString("cd_name"),
					ImageUtil.binaryStream2Image(rs.getBinaryStream("cd_image"), 80),
					rs.getFloat("cd_hunger"),
					rs.getFloat("cd_sanity"),
					rs.getFloat("cd_health"),
					rs.getInt("cd_qualityTime"),
					rs.getInt("cd_cookTime"),
					rs.getString("cd_buff"),
					rs.getString("cd_comment")
				));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
		return cdDataList;
	}

	public ObservableList<CDBean> getCDData(String searchKey) {
		String sql = "select * from t_cookedDishes where cd_name like ? ";
		ObservableList<CDBean> cdDataList = FXCollections.observableArrayList();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchKey + "%");
			rs = ps.executeQuery();
			int cd_num = 1;
			while(rs.next()) {
				cdDataList.add(new CDBean(
					cd_num++,
					rs.getString("cd_name"),
					ImageUtil.binaryStream2Image(rs.getBinaryStream("cd_image"), 80),
					rs.getFloat("cd_hunger"),
					rs.getFloat("cd_sanity"),
					rs.getFloat("cd_health"),
					rs.getInt("cd_qualityTime"),
					rs.getInt("cd_cookTime"),
					rs.getString("cd_buff"),
					rs.getString("cd_comment")
				));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
		return cdDataList;
	}

	public ObservableList<FIBean> getFIData() {
		String sql = "select * from t_foodIngredients ";
		ObservableList<FIBean> fiDataList = FXCollections.observableArrayList();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			int fi_num = 1;
			while(rs.next()) {
				fiDataList.add(new FIBean(
					fi_num++,
					rs.getString("fi_name"),
					rs.getString("fi_type"),
					rs.getFloat("fi_degree"),
					ImageUtil.binaryStream2Image(rs.getBinaryStream("fi_image"), 55),
					rs.getFloat("fi_hunger"),
					rs.getFloat("fi_sanity"),
					rs.getFloat("fi_health"),
					rs.getInt("fi_qualityTime"),
					rs.getString("fi_comment")
				));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
		return fiDataList;
	}

	public ObservableList<FIBean> getFIData(String searchKey) {
		String sql = "select * from t_foodIngredients where fi_name like ? ";
		ObservableList<FIBean> fiDataList = FXCollections.observableArrayList();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchKey + "%");
			rs = ps.executeQuery();
			int fi_num = 1;
			while(rs.next()) {
				fiDataList.add(new FIBean(
					fi_num++,
					rs.getString("fi_name"),
					rs.getString("fi_type"),
					rs.getFloat("fi_degree"),
					ImageUtil.binaryStream2Image(rs.getBinaryStream("fi_image"), 55),
					rs.getFloat("fi_hunger"),
					rs.getFloat("fi_sanity"),
					rs.getFloat("fi_health"),
					rs.getInt("fi_qualityTime"),
					rs.getString("fi_comment")
				));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
		return fiDataList;
	}

}