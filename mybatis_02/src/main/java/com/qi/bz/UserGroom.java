package com.qi.bz;/*
    name zhang;
    */

import com.qi.po.UserExtend;

import java.util.List;

public class UserGroom {

    private List<Integer> idList;
    private UserExtend userExtend;

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
