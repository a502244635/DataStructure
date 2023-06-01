package com.wenwen.learn.recursion.test;

public class MiGong {
    public static void main(String[] args) {
        buildMiGong();
    }

    public static void buildMiGong(){
        int[][] arr = new int[8][7];
        for (int i = 0;i<7;i++){
            arr[0][i] = 1;
            arr[7][i] = 1;
        }

        for (int i = 0;i<8;i++){
            arr[i][0] = 1;
            arr[i][6] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;

        if (setWay(arr,1,1)){
            for (int i = 0;i < 8;i++){
                for (int j = 0;j < 7;j++){
                    System.out.print(" "+arr[i][j]);
                }
                System.out.println();
            }
        }



    }
    public static boolean setWay(int[][] arr,int i, int j){
        if (arr[6][2] == 2){
            return true;
        }else{
            if (arr[i][j]==0){
                arr[i][j] = 2;
                //下右上左策略
                if (setWay(arr,i+1,j)){
                    return true;
                } else if (setWay(arr,i,j+1)){
                    return true;
                } else if (setWay(arr,i-1,j)) {
                    return true;
                } else if (setWay(arr,i,j-1)) {
                    return true;
                }else{
                    //走不通
                    arr[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }

    }

}
