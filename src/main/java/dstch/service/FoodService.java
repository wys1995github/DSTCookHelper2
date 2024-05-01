package main.java.dstch.service;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.java.dstch.bean.CDBean;
import main.java.dstch.dao.CDBeanDao;
import main.java.dstch.util.ImageUtil;
import main.java.dstch.util.MyBatisUtil;

public class FoodService {
    
    private SqlSession sqlSession;

    public ObservableList<CDBean> getFoodData(String fiName) {
    	fiName = fiName.replace("烤", "");
        ObservableList<CDBean> cdDataList = FXCollections.observableArrayList();
        try {
        	sqlSession = MyBatisUtil.getSqlSession();
            CDBeanDao mapper = sqlSession.getMapper(CDBeanDao.class);
            List<Map<String, Object>> result = mapper.getFoodData(fiName);
            int cd_num = 1;
            for (Map<String, Object> rs : result) {
                cdDataList.add(new CDBean(
                        cd_num++,
                        String.valueOf(rs.get("cd_name")),
                        ImageUtil.obj2Image(rs.get("cd_image"), 80),
                        (Float) rs.get("cd_hunger"),
                        (Float) rs.get("cd_sanity"),
                        (Float) rs.get("cd_health"),
                        Integer.valueOf(String.valueOf(rs.get("cd_qualityTime"))),
                        Integer.valueOf(String.valueOf(rs.get("cd_cookTime"))),
                        String.valueOf(rs.get("cd_buff")),
                        String.valueOf(rs.get("cd_comment"))
                ));
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return cdDataList;
    }

}