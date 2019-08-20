package com.qi.关于数组;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 在一个有序数组中,找到和key的两个值
 */

public class Test2 {

    public static List<Integer> test(int[] arr, int key){
        List<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = arr.length-1;

        while(left< right){

            if(arr[left]+arr[right] > key){
                right--;
                continue;
            }

            if(arr[left]+arr[right] < key){
                left++;
                continue;
            }

            if(arr[left]+arr[right] == key){
                list.add(arr[left]);
                list.add(arr[right]);
                break;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,8,10,14,18};
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<Integer> list = test(arr,num);

        for(Integer s:list){
            System.out.println(s);
        }
    }
}