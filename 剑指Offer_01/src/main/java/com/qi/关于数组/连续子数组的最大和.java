package com.qi.关于数组;/*
    name zhang;
    */

//-6,2,4,-7,5,3,2,-1,6,-9,10,-2
public class 连续子数组的最大和 {

    public static int findMaxSum(int array[]){
        if(array == null){
            return -1;
        }
        int curSum = 0;
        int maxSum = array[0];

        for(int i=0;i<array.length;i++){
            if(curSum + array[i] >= array[i]){
                curSum = curSum+array[i];
            }else {
                curSum = array[i];
            }

            if(curSum > maxSum){
                maxSum = curSum;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int arr[] ={-6,2,4,-7,5,3,2,-1,6,-9,10,-2};
        int sum = findMaxSum(arr);
        System.out.println(sum);
    }
}
