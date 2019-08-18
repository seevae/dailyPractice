package com.qi;


/**
 * 快速排序实现思路
 *      首先将数列最左边的数字选为基准值
 *      从数列右边开始选取一个小于基准值的数,从数列左边左边选取一个大于基准值的数,交换(循环执行)
 *      直到左右两个下标重合,将基准值与下标处数字交换
 *      一次排序便完成,基准值左边都是小于基准值的数,右边都是大于基准值的数
 *
 *      递归排序基准值左边和右边的数列
 *
 */
public class Test {

    public static void quickSort(int arr[],int left,int right){
        if(left > right){
            return;
        }

        int midValue = arr[left];
        int i = left;
        int j = right;

        while(i<j){

            //从右边找出一个小于基准值的值
            while(arr[j]>=midValue && i<j){
                j--;
            }

            //从左边找出一个大于基准值的值
            while(arr[i]<=midValue && i<j){
                i++;
            }

            //交换
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }

        //基准值和中间位置的数交换
        arr[left] = arr[i];
        arr[i] = midValue;

        //左边递归排序
        quickSort(arr,left,j-1);

        //右边递归排序
        quickSort(arr,j+1,right);
    }


    public static void main(String[] args) {
        int arr[] = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        int len = arr.length-1;
        quickSort(arr,0,len);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
