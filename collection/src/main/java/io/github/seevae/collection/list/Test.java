package io.github.seevae.collection.list;/*
    name zhang;
    */

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.get(4));
        System.out.println(list.set(4,6));
        System.out.println(list.get(4));

        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);

        Set set1 = new TreeSet();
        set1.add(5);
        set1.add(6);
        set1.add(2);
        set1.add(1);
        set1.add(8);
        System.out.println(set1);


    }
}
