package com.jk.controller;

import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
               @Autowired
               private UserService userService;

               @RequestMapping("seleUserlist")
               @ResponseBody
               public Map toSelectList(Integer page, Integer rows){
                   Integer startPos = (page-1)*rows;


                   long total = userService.toSelectUserTotal();

                   System.out.println(total+"1111111111111111");
                   List<HashMap<String, Object>> list = userService.toSelectUserList( startPos,  rows);

                   HashMap<String, Object> hashMap = new HashMap<String, Object>();
                   hashMap.put("total", total);
                   hashMap.put("rows", list);

                   return  hashMap;
               }


}
