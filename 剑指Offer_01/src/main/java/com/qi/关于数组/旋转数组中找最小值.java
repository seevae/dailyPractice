package com.qi.关于数组;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class 旋转数组中找最小值 {

    public static int minNumberInRotateArray(int [] array) {
        //数组为空
        if(array.length == 0){
            return 0;
        }

        //数组未旋转的情况  1 2 3 4 5 6
        if(array[0] < array[array.length-1]){
            return array[0];
        }

        int left = 0;
        int right = array.length-1;
        //跳出循环的条件 : 两个指针相邻时
        while(left+1 != right && left < right){
            int mid = (left-right)/2+right;
            if(array[mid] >= array[left]){
                left = mid;
            }else if(array[mid] <= array[right]){
                right = mid;
            }

            //当数组中只有一个最小值其他数全部相同的情况
            int result = array[0];
            if(array[left] == array[right] && array[left]== array[mid]){
                for(int i=0;i<array.length;i++){
                    if(array[i] < result){
                        result = array[i];
                    }
                }
                return result;
            }

        }
        return array[right];
    }

    public static void main(String[] args) {
        int[] arr = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,
                9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,
                2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int[] arr2 = {1,0,1,1,1};
        int[] arr3 = {1};
        int[] arr4 = {2,2};
        int a = minNumberInRotateArray(arr4);
        System.out.println(a);
    }

}