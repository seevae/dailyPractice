package io.github.seevae;/*
    name zhang;
    */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {


    public static void main(String[] args) {
        //分割字符串时, 有些特殊符号需要进行转义
//        String s = "10.8.9.6";
//        String[] arr = s.split("/.");
        //       System.out.println(arr);

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("aaa",123);
        map.put("aaa",456);

        Set<Map.Entry<String,Integer>> set =  map.entrySet();
        Iterator iterator  = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }

}
