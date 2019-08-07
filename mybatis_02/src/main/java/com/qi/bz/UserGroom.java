package com.qi.bz;/*
    name zhang;
    */

import com.qi.po.UserExtend;

import java.util.HashMap;
import java.util.List;

public class UserGroom {

    private List<Integer> idList;
    private UserExtend userExtend;
    private Integer[] array;
    private HashMap<String,List<Integer>> hashMap;

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public UserGroom(UserExtend userExtend) {
        this.userExtend = userExtend;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public UserExtend getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(UserExtend userExtend) {
        this.userExtend = userExtend;
    }
}
