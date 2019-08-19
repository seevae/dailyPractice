package com.qi.static1;/*
    name zhang;
    */

public class Test {
    public static void main(String[] args) {
        RealWoker realWoker = new RealWoker();
        ProxyWorker proxyWorker = new ProxyWorker(realWoker);
        proxyWorker.add();
    }
}
