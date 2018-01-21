package com.jk.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao {


    @Select("select count(*)  from t_user ")
    long toSelectUserTotal();


    @Select("select *  from t_user limit #{startPos} , #{rows}")
    List<HashMap<String, Object>> toSelectUserList(@Param("startPos")Integer startPos,@Param("rows") Integer rows);
}
