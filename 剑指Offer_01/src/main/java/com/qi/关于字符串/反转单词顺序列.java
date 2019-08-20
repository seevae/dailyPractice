package com.qi.关于字符串;

public class 反转单词顺序列 {

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
        reverseSentence(str);
    }
}
