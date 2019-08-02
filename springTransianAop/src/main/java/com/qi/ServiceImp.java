package com.qi;/*
    name zhang;
    */

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("ServiceImp")
public class ServiceImp implements Service01 {

    @Resource
    private DaoimPL daoimPL ;

    @Transactional
    //对整个方法添加一个事务,这个方法一旦由于一些原因不能整个完成就会进行事务回滚
    public void seadd() throws Exception {
        daoimPL.add();
       // int i=1/0; //例如此处如果出现异常,则上面的添加也不会记录在数据库中
    }
}
