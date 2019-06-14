package io.github.seevae.bz;/*
    name zhang;
    */

import io.github.seevae.po.UserExtend;

import java.util.ArrayList;
import java.util.List;

public class UserGroom {

    List<Integer>  idList = null;

    UserExtend userExtend = null;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public UserGroom(UserExtend userExtend){
        this.userExtend = userExtend;
    }

    public UserExtend getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(UserExtend userExtend) {
        this.userExtend = userExtend;
    }
}
