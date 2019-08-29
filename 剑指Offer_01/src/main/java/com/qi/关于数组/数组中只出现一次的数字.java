package com.qi.关于数组;

import java.util.*;

public class 数组中只出现一次的数字 {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }

        List<Integer> list = new ArrayList();
        Set<Map.Entry<Integer,Integer>> set  = map.entrySet();
        for(Map.Entry<Integer,Integer> i:set){
            if(i.getValue() == 1){
                list.add(i.getKey());
            }
        }

        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    public static void main(String[] args) {
        int arr[] = {1,5,5,6,6,9,8,8,6};
        int arr1[] =new int[1];
        int arr2[] =new int[1];
        FindNumsAppearOnce(arr,arr1,arr2);
    }
}
