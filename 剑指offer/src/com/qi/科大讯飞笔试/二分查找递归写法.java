package com.qi.科大讯飞笔试;

public class 二分查找递归写法 {


    public static int binarySearch(int key,int arr[],int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (end-start)/2+start;
        if(key<arr[mid]){
            return binarySearch(key,arr,start,mid-1);
        }else if(key>arr[mid]){
            return binarySearch(key,arr,mid+1,end);
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int len = arr.length-1;
        int result = binarySearch(6,arr,0,len);
        System.out.println(result);
    }

}
