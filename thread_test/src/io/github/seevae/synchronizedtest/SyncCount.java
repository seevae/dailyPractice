package io.github.seevae.synchronizedtest;/*
    name zhang;
    */

/**
 * 如何保护有关联关系的对象:
 * 使用同一把锁
 *
 */

/**
 * 此时余额类如果只有一个锁,那么有一个方法执行的时候所有的方法都需要等待
 * 方法和方法之间不能够并行,例如该例,取钱的时候就不能查看密码了.这是不合理的
 * 所以进行优化:
 *      多个对象锁锁多个方法
 *
 */

class Account{
    //余额
    int sal;
    //密码
    String password;
    //余额资源的锁
    private Object salLock = new Object();
    //密码资源的锁
    private Object passwordLock = new Object();

    /*
    此时关于密码操作的行为有他自己专门的锁
    关于余额操作的行为也有他自己专门的锁
    两个类型的操作就可以同时进行了,但是每一种类型间的操作又是同步的
    如下
     */

    public int getSal() {
        synchronized(salLock){
            return sal;
        }
    }

    public void setSal(int sal) {
        synchronized (salLock){
            this.sal = sal;
        }
    }

    public String getPassword() {
        synchronized (passwordLock){
            return password;
        }
    }

    public void setPassword(String password) {
        synchronized (passwordLock){
            this.password = password;
        }
    }

    //如果此时模拟一个转账操作,需要当前类对象和一个传入进来的类对象进行转账操作
    /**
     * 例如 A->B 100
     * A -= 100;
     * B += 100;
     * 如何保护有关联关系的对象?
     * 解决方式: 使用同一把锁
     */

    public void zhuanzhang(Account target){
        //两个转账的人都是Account类的,所以直接使用全局锁就可以锁住两个人了
        synchronized (Account.class){
            this.sal -= 100;
            target.sal += 100;
        }
    }
    //由于转账涉及两个账户间的sal操作,因此需要将两个账户同时锁定
    //由于方法的synchronized只能锁住一个对象,而转账操作发生在两个人之间,因此锁不住转账操作,只能想上面那样进行处理
}

public class SyncCount {

}
