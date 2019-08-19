package com.qi.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 创建代理对象
 */
public class CreateProxyer implements InvocationHandler {

    private Object destObj = null;

    public CreateProxyer(Object destObj){
        this.destObj = destObj;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(
                            destObj.getClass().getClassLoader(),
                            destObj.getClass().getInterfaces(),
                         this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
       try{
           safeCheck();
           o = method.invoke(this.destObj,args);
           return o;
       }catch (Exception e){
           e.printStackTrace();
       }
       return o;
    }

    public void safeCheck(){
        System.out.println("安全性检测");
    }
}
