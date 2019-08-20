package com.qi.service;/*
    name zhang;
    */
import com.qi.po.*;

import java.util.List;

public interface UserService {
    public List<User> selectAll();
    public String show();

    void insertUser();
}
