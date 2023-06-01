package com.wenwen.learn.recursion.test;

public class Queen8 {
    static int count;
    int max = 8;
    int [] arr = new int[max];

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }

    private  void check(int n){
        if (n==max){
            count++;
            return;
        }
        for (int i = 0;i<max;i++){
            arr[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for (int i = 0;i< n;i++){
            if (arr[n] == arr[i] || Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
}


