package com.qi.科大讯飞笔试;/*
    name zhang;
    */

public class 二分查找 {


    public static int binarySearch(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;
        int mid = 0;

        while(left<=right){

            mid = (right-left)/2+left;

            if(arr[mid] > k){
                right = mid-1;
            }
            if(arr[mid] == k){
                return mid;
            }
            if(arr[mid] < k){
                left = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,9};
        int result =  binarySearch(arr,10);
        System.out.println(result);
    }
}
