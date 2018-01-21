package com.jk.service;

import com.jk.dao.TreeDao;
import com.jk.model.ZTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("treeService")
public class TreeServiceImpl  implements  TreeService{

    @Autowired
    private TreeDao treeDao;



    public List<ZTree> asyncTreeList(ZTree tree) {

        List<ZTree> list =new ArrayList<ZTree>();
        if(tree.getId()!=null && !"".equals(tree.getId())){
            list = treeDao.queryTreeList(tree);
        }else{
            list=treeDao.asyncTreeList(tree);
        }
        List<ZTree> asyncList =new ArrayList<ZTree>();
        for (ZTree tree2 : list) {
            if(isHaveChild(tree2)){
                tree2.setIsParent("true");
            }
            asyncList.add(tree2);
        }
        return asyncList;
    }

        private boolean isHaveChild(ZTree tree2) {

            boolean flag =false;
            try {
                List<ZTree> queryTreeList = treeDao.queryTreeList(tree2);
                if(queryTreeList.size()>0){
                    flag=true;
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return flag;
        }


}
