package com.wenwen.learn.sort;


import java.util.Arrays;

//选择排序
public class SelectSortDemo1 {
    public static void main(String[] args) {
        int[] arr1 = {10, 4, -24, 52, 11};
        selectSort(arr1);
    }

    public static void selectSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
