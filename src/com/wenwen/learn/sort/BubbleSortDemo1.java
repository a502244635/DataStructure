package com.wenwen.learn.sort;


import java.lang.reflect.Array;
import java.util.Arrays;

//冒泡排序
public class BubbleSortDemo1 {
    public static void main(String[] args) {
        int[] arr1 = {10, 4, -24, 52, 11};
        int[] arr2 = {10, 4, -24, -1, 11};
        bubbleSort1(arr1);
        System.out.println(Arrays.toString(arr1));
        bubbleSort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    //未优化的冒泡排序
    public static void bubbleSort1(int[] arr){
        int temp;
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length -1 -i;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //优化后的冒泡排序
    public static void bubbleSort2(int[] arr){
        int temp;
        boolean flag = false;
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            if (!flag){
                break;
            }else {
                flag = false;
            }
        }
    }
}
