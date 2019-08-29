package com.qi.关于数组;

import java.util.ArrayList;
import java.util.List;

public class 调整数组使奇数位于偶数后面 {

    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //采用冒泡排序的思想,如果相邻一奇一偶就换位置 时间复杂度O(n^2)
    public static void reOrderArray(int [] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]%2==0 && array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        print(array);
    }

    //空间换时间的做法
    public static void reOrderArray2(int [] array) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if(array[i]%2 == 0){
                list2.add(array[i]);
            }else{
                list1.add(array[i]);
            }
        }
        for(int i=0;i<list1.size();i++){
            array[i] = list1.get(i);
        }
        for(int i=0;i<list2.size();i++){
            array[i+list1.size()] = list2.get(i);
        }

        print(array);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        reOrderArray2(arr);
    }
}
