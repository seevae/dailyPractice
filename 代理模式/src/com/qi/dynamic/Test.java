package com.qi.dynamic;

/**
 * 测试
 */
public class Test {

    public static void main(String[] args) {
        RealWorkImpl realWork = new RealWorkImpl();
        CreateProxyer createProxyer = new CreateProxyer(realWork);
        //注意,是给接口做代理,所以要转为接口的类型
        RealWorkI realWork1 = (RealWorkI)createProxyer.getInstance();
        realWork1.add();
    }
}
