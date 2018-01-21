package com.jk.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {


    void seleUserlist();

    List<HashMap<String,Object>> toSelectUserList(Integer startPos, Integer rows);

    long toSelectUserTotal();
}
