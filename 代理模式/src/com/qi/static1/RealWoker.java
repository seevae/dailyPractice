package com.qi.static1;/*
    name zhang;
    */

public class RealWoker implements RealWork{
    @Override
    public void add() {
        System.out.println("我要去添加");
    }

    @Override
    public void delete() {
        System.out.println("我要去删除");
    }
}
