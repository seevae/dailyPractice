package com.qi.static1;/*
    name zhang;
    */

public class ProxyWorker  implements RealWork{

    private RealWoker realWoker;

    public ProxyWorker(RealWoker realWoker){
        this.realWoker = realWoker;
    }

    public void safeCheck(){
        System.out.println("安全性检查");
    }

    @Override
    public void add() {
        safeCheck();
        realWoker.add();
    }

    @Override
    public void delete() {
        safeCheck();
        realWoker.delete();
    }
}
