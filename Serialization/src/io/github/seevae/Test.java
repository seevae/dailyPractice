package io.github.seevae;/*
    name zhang;
    */

import java.util.Vector;

public class Test {

    public static void main(String[] args) {
        //一个可能会造成内存泄漏的代码
        Vector vector = new Vector();
        for(int i=0;i<10;i++){
            Object o = new Object();
            vector.add(o);
            //引用置空后,看似他已经没有引用会被GC回收,但其实vector还引用着这个对象
            //从而造成内存泄漏
            o = null;
        }
    }
}
