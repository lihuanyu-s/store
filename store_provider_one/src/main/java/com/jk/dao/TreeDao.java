package com.jk.dao;

import com.jk.model.ZTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TreeDao {


    @Select(" select * from z_tree where pid =#{id} ")
    List<ZTree> queryTreeList(ZTree tree);

    @Select(" select * from z_tree where pid =0 ")
    List<ZTree> asyncTreeList(ZTree tree);
}
