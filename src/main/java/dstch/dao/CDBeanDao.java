package main.java.dstch.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface CDBeanDao {
    List<Map<String, Object>> getFoodData(@Param("fiName") String fiName);
}
