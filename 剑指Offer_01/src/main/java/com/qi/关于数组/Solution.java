package com.qi.关于数组;

import java.util.*;


/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 思路: 其实不用考虑多对数字乘积最小的情况, 因为当两个数离的越远的时候他们的成绩就越小,所以第一次遇到的两个数成绩肯定是最小的
 *
 */


public class Solution {

    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0;
        int right = array.length-1;

        ArrayList<Integer> arrayList = new ArrayList();

        while(left < right){

            if(array[left] + array[right] == sum){
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                break;
            }

            if(array[left] + array[right] > sum){
                right -- ;
                continue;
            }

            if(array[left] + array[right] < sum){
                left++;
                continue;
            }

        }

       return arrayList;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,5,8,10,14,18};
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ArrayList<Integer> list = FindNumbersWithSum(arr,num);
        System.out.println(list);
    }

}
