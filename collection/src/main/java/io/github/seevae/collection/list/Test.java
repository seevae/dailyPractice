package io.github.seevae.collection.list;/*
    name zhang;
    */

import java.util.*;

public class Test {

    public static void main(String[] args) {

        //底层实现是一个线性表
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        System.out.println(list.get(4));
//        System.out.println(list.set(4,6));
//        System.out.println(list.get(4));

//        //底层实现是一个双向链表
//        List list1 = new LinkedList();
//
//        //底层实现也是一个线性表,但是他的多数方法都使用了synchronized修饰
//        List list2 = new Vector();
//
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer i = (Integer) iterator.next();
//
//            System.out.println(i);
////            iterator.remove();
//
//            //错误的删除方式
////            if(i.equals(1)){
////                list.remove(iterator.next());
////            }
////
//        }
//
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        if(!iterator.hasNext()){
//            System.out.println("集合为空");
//        }


//        //双向迭代器
//        ListIterator iterator1 = list.listIterator();
//        while(iterator1.hasNext()){
//            System.out.println(iterator1.next());
//        }
//
//        while(iterator1.hasPrevious()){
//            System.out.println(iterator1.previous());
//        }

        //错误的删除方式
//        for(Integer i:list){
//            if(i.equals(2)){
//                list.remove(i);
//            }
//        }

        for(Integer i:list){
            System.out.println(i);
        }

    }
}
