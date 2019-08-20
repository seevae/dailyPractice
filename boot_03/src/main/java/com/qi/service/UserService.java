package com.qi.service;
import com.qi.po.*;

import java.util.List;

public interface UserService {
    List<User> selectAll();
    String show();
    void insertUser();
}


