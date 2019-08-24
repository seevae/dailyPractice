package com.qi.关于数组;


public class 二位数组中的查找 {

    public static boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length ==0){
            return false;
        }
        //行
        int row = array.length-1;
        //列
        int col = array[0].length-1;
        int i = 0;
        int j = col;
        while(i<=row && j>=0){
            int num = array[i][j];
            if(num < target){
                i++;
            }else if(num > target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        System.out.println(Find(5,arr));
    }
}
