package com.qi.dynamic;


//被代理类
public class RealWorkImpl implements RealWorkI{


    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void select() {
        System.out.println("select");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
