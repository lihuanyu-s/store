package com.jk.controller;


import com.jk.model.ZTree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("tr")
public class TreeController {
        @Autowired
        private TreeService treeService;

    //查询
    @RequestMapping("asyncTreeList")
    @ResponseBody
    public List<ZTree> asyncTreeList(ZTree tree,HttpServletRequest request) {
        List<ZTree> list  =new ArrayList<ZTree>();
        list = treeService.asyncTreeList(tree);
        return list;
    }

}
