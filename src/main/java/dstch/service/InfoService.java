package main.java.dstch.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import main.java.dstch.bean.CLBean;
import main.java.dstch.util.DBUtil;
import main.java.dstch.util.ImageUtil;

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
				String cdName = rs.getString("cl_name");
				String item1Name = rs.getString("cl_item1");
				String item2Name = rs.getString("cl_item2");
				String item3Name = rs.getString("cl_item3");
				String item4Name = rs.getString("cl_item4");
				clDataList.add(new CLBean(
					cl_num++,
					cdName,
					item1Name,
					item2Name,
					item3Name,
					item4Name,
					getImage4Name(item1Name),
					getImage4Name(item2Name),
					getImage4Name(item3Name),
					getImage4Name(item4Name)
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
	
	private Image getImage4Name(String itemName) {
		String sql = " select fi_image from t_foodIngredients where fi_name = ? ";
		rs = null;
		Image image = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, itemName);
			rs = ps.executeQuery();
			while(rs.next()) {
				image = ImageUtil.binaryStream2Image(rs.getBinaryStream("fi_image"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return image;
	}
	
}