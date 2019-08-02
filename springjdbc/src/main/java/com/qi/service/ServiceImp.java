package com.qi.service;/*
    name zhang;
    */

import com.qi.dao.DaoImpl;

public class ServiceImp implements Service{

    private DaoImpl daoImp;

    public void setDaoImp(DaoImpl daoImp) {
        this.daoImp = daoImp;
    }

    //service调用dao层
    public void serAdd() throws Exception {
        daoImp.add();
    }

}
