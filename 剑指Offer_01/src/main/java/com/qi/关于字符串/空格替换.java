package com.qi.关于字符串;


public class 空格替换 {

    //case : 25%
    public static String replaceSpace(StringBuffer str) {
        String st = str.toString();
        StringBuffer sb = new StringBuffer();
        String[] strArr = st.split(" ");
        for(int i=0;i<strArr.length;i++){
            if(i==strArr.length-1){
                sb.append(strArr[i]);
            }else{
                sb.append(strArr[i]+"%20");
            }
        }
        String result = sb.toString();
        return result;
    }

    //case : 100%
    public static String replaceSpace1(StringBuffer str) {
        //StringBuffer可以当作一个字符串进行遍历
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c ==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("my");
        sb.append(" ");
        sb.append("baby");
        String re =  replaceSpace1(sb);
        System.out.println(re);
    }
}
