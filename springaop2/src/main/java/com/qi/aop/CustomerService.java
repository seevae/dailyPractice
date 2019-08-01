package com.qi.aop;

//主流业务的实现类
public class CustomerService implements ServiceInter{

    //使用Spring注入
    private String name;

    public void sayHello() throws Exception {
        System.out.println("你好"+this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
