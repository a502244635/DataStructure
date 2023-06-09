package com.wenwen.learn.sort;


import java.util.Arrays;

public class ShellSortDemo1 {
    public static void main(String[] args) {
        int[] arr = {10, 4, -24, 52, 11};
        shellSort(arr);
    }

    //交换式
    private static void shellSort(int[] arr){
        int temp;
        for (int gap = arr.length/2;gap > 0;gap /= 2){
            for (int i = gap;i < arr.length;i++){
                for (int j = i-gap;j >= 0;j -= gap){
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //移位式
    private static void shellSort2(int[] arr){
        for (int gap = arr.length/2;gap > 0;gap /= 2){
            for (int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j - gap >= 0 && temp < arr[j - gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
}
