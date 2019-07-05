package io.github.seevae.map;/*
    name zhang;
    */

import java.util.*;

public class Test {


    public static void main(String[] args) {
        //分割字符串时, 有些特殊符号需要进行转义
//        String s = "10.8.9.6";
//        String[] arr = s.split("/.");
        //       System.out.println(arr);

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("aaa",123);
        map.put("aaa",456);
        map.put(null,null);
        map.put(null,2);
        map.put("3",null);

//        Hashtable hashtable = new Hashtable();
//        hashtable.put(2,null);


        Set<Map.Entry<String,Integer>> set =  map.entrySet();
        Iterator iterator  = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }

}
