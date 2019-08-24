package com.qi.递归;

//数列从第0项开始,第0项的值为0
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
public class 斐波那契 {

    //非递归写法(优于递归写法) 时间复杂度 O(n)  空间复杂度 O(1)
    //思路: 使用一个变量sum ,从第2项开始用来记录前两项的和
    public static int Fibonacci2(int n){
        if(n == 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        //专门用来记录两项的和,也就是n处的值
        int sum = 0;
        //n-1的值
        int one = 1;
        //n-2的值
        int two = 0;
        for(int i=2;i<=n;i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }

    //递归写法 时间复杂度 O(2^n)
    public static int Fibonacci(int n) {
        if(n<=0){
            return 0;
        }

        if(n==1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = Fibonacci(8);
        int n2 = Fibonacci2(8);
        System.out.println(n+" "+n2);
    }
}
