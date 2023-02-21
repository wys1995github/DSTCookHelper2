package main.java.dstch.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.dstch.util.DBUtil;

public class InfoService{

	private Connection conn = DBUtil.getConnection();
	private PreparedStatement ps = null;

	public void getInfoData() {
		String sql = " select cl_item1, cl_item2, cl_item3, cl_item4 "
				+ "from t_compositeList where cl_name = '肉丸' ";
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("cl_item1"));
				System.out.println(rs.getString("cl_item2"));
				System.out.println(rs.getString("cl_item3"));
				System.out.println(rs.getString("cl_item4"));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            DBUtil.closeConnection(conn);
		}
	}
	
}