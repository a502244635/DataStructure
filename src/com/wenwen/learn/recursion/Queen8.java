package com.wenwen.learn.recursion;

/**
 * 八皇后问题
 */
public class Queen8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);
    }

    private void check(int n){
        //摆完了八个皇后
        if (n == max){
            //计算摆法有多少种
            count++;
            print();
            return;
        }
        //注意：每一个递归都有八次for循环
        for (int i = 0;i<max;i++){
            //先摆放第一列
            array[n] = i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        //与之前摆放的皇后位置进行比较
        for (int i = 0;i<n;i++){
            //检查 列 与 斜线
            if (array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){
        for (int i = 0;i< array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}


