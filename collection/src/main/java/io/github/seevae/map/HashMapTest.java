package io.github.seevae.map;/*
    name zhang;
    */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
//        Map map = new HashMap();
//        map.put(1,"hello");
//        map.put(1,"world");
//        map.put(2,"???");
//        map.put(3,"!!!");
//
//        String s = (String) map.get(1);
//        System.out.println(s);
//
//        Set set = map.keySet();
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //数据(k-v)插入到hashmap中的时候会拿key值做hash算法,得到的结果称为散列码也就是该键值对插入的位置
        // hash 算法: key的hashcode对数组长度len取余(--hash(key)%len--)
        //假设当前hashmap线性表的长度为16,则每个k-v插入的桶的下标:---- key.hashcode()%16
        Integer a = 12 ;
        Integer b = 28;
        Integer c = 108;

        System.out.println(a.hashCode()%16);
        System.out.println(b.hashCode()%16);
        System.out.println(c.hashCode()%16);

        /*
        通过计算可以看出来如果键值为12,28,108,则这三个键值对插入的位置都为下标为12的桶,这三个键值对会在该桶后面以链表形式排列
        */


    }
}
