package com.qi;
import org.springframework.aop.framework.ProxyFactory;

public class Test {

    public static void main(String[] args) {
        //创建目标(主流业务)对象
        Target target = new Target();
        //创建spring aop的代理工厂
        ProxyFactory factory = new ProxyFactory();
        //指定代理对象
        factory.addAdvice(new LoggerExecute());
        //通过工厂可以将切面和主流业务相结合
        factory.setTarget(target);
        Target targ = (Target) factory.getProxy();
        targ.execute("hfc");
    }
}
