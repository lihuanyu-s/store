package com.jk.service;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    long toSelectUserTotal();

    List<HashMap<String,Object>> toSelectUserList(Integer startPos, Integer rows);

}
