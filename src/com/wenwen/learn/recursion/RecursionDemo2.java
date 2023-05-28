package com.wenwen.learn.recursion;

/**使用递归解决迷宫问题
 * 墙为1；可走为2；不可通为3
 */

public class RecursionDemo2 {
    public static void main(String[] args) {
            buildMiGong();

    }

    public static void buildMiGong(){
        int[][] miGong = new int[8][7];
        //墙为1
        //左右
        for (int i = 0;i < 8;i++){
           miGong[i][0] = 1;
           miGong[i][6] = 1;
        }
        //上下
        for (int i = 0;i < 7;i++){
            miGong[0][i] = 1;
            miGong[7][i] = 1;
        }
        //设置墙
        miGong[3][1] = 1;
        miGong[3][2] = 1;

        //打印迷宫
        for (int i = 0;i < 8;i++){
            for (int j = 0;j < 7;j++){
                System.out.print(" "+miGong[i][j]);
            }
            System.out.println();
        }

        setWay(miGong,1,1);
        //打印小球走后的迷宫
        System.out.println("打印小球走后的迷宫");
        for (int i = 0;i < 8;i++){
            for (int j = 0;j < 7;j++){
                System.out.print(" "+miGong[i][j]);
            }
            System.out.println();
        }
    }
    //寻路方法 策略：下右上左
    public static boolean setWay(int[][] miGong, int i, int j){
        //找到了
        if (miGong[6][5] == 2){
            return true;
        }else {
            if (miGong[i][j] == 0){
                miGong[i][j] = 2;
                if (setWay(miGong,i+1,j)){
                    return true;
                }else if (setWay(miGong,i,j+1)){
                    return true;
                } else if (setWay(miGong,i-1,j++)) {
                    return true;
                } else if (setWay(miGong,i,j-1)) {
                    return true;
                }else {
                    //走不通
                    miGong[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }
}
