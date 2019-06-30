package io.github.seevae.collection.list;/*
    name zhang;
    */

import java.util.*;

public class Test {

    public static void main(String[] args) {

        //底层实现是一个线性表
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(4));
        System.out.println(list.set(4,6));
        System.out.println(list.get(4));

        //底层实现是一个双向链表
        List list1 = new LinkedList();

        //底层实现也是一个线性表,但是他的多数方法都使用了synchronized修饰
        List list2 = new Vector();



    }
}
