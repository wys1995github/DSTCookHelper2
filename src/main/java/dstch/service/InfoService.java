package main.java.dstch.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.dstch.bean.CLBean;
import main.java.dstch.util.DBUtil;

public class InfoService{

	private Connection conn = DBUtil.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public ObservableList<CLBean> getInfoData(String searchKey) {
		String sql = " select cl_item1, cl_item2, cl_item3, cl_item4 "
				+ "from t_compositeList where cl_name = ? ";
		ObservableList<CLBean> clDataList = FXCollections.observableArrayList();
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, "%" + searchKey + "%");
			rs = ps.executeQuery();
			int cl_num = 1;
			while(rs.next()) {
				clDataList.add(new CLBean(
					cl_num++,
					rs.getString("cl_name"),
					rs.getString("cl_item1"),
					rs.getString("cl_item2"),
					rs.getString("cl_item3"),
					rs.getString("cl_item4")
				));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
		return clDataList;
	}
	
//	private Icon getIconAsItem(String itemName) {
//		String sql = " select fi_image from t_foodIngredients where fi_name = ? ";
//		ResultSet rs = null;
//		Icon icon = null;
//		try {
//			ps = conn.prepareStatement(sql.toString());
//			ps.setString(1, itemName);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				icon = ImageUtil.loadImage(rs.getBinaryStream("fi_image"));
//			}
//			return icon;
//		} catch (SQLException e){
//			e.printStackTrace();
//		}
//		return icon;
//	}
	
}