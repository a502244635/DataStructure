package com.wenwen.learn.recursion;

//递归初练习
public class RecursionDemo1 {
    public static void main(String[] args) {
        practice(5);

        System.out.println(fac(3));
    }

    public static void practice(int num){
        if (num > 1){
            practice(num-1);
        }
        System.out.println("现在的数为："+num);

    }

    //n的阶乘
    public static int fac(int n){
        if (n == 1){
            return 1;
        }else{
            return fac(n-1) * n;
        }
    }
}
