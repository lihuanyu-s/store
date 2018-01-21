package com.jk.service;


import com.jk.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("userService")
public class UserServiceImpl  implements  UserService{
           @Autowired
           private UserDao userDao;


    public long toSelectUserTotal() {

        return   userDao.toSelectUserTotal();
    }

    public List<HashMap<String,Object>> toSelectUserList(Integer startPos, Integer rows) {

        return userDao.toSelectUserList(  startPos,  rows);
    }



}
