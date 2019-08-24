package com.qi.关于字符串;

public class 反转单词顺序列 {


    public static String rerverse(char[] arr,int start,int end){

        while (start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

    //方法二 : 空间复杂度O(1)
    public static String rerverseSentence(String str){
        char[] arr = str.toCharArray();
        rerverse(arr,0,arr.length-1);
        int point1 = -1;
        for(int i=0;i<arr.length;i++){
            int point2=i;
            if(arr[i] == ' '){
                rerverse(arr,point1+1,point2-1);
                point1 = point2;
            }
        }
        rerverse(arr,point1+1,arr.length-1);
        return new String(arr);
    }


    //方法一 : 空间复杂度O(n)
    public static String reverseSentence(String str) {
        if(str == null){
            return  null;
        }

        if(str.equals("")){
            return str;
        }

        StringBuffer sb = new StringBuffer();
        String[] arr = str.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            if(i == 0){
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]);
                sb.append(" ");
            }
        }
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        String str = "student. a am i";
        System.out.println(reverseSentence(str));
    }

}
