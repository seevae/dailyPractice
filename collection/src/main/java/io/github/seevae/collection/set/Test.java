package io.github.seevae.collection.set;/*
    name zhang;
    */

import java.util.*;

public class Test {

    public static void main(String[] args) {

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

        Map m = new Hashtable();

        int arr[] = {1,2,3,4,5,6,7,8};
        for(int i:arr){
            System.out.println(i);
        }

    }
}
