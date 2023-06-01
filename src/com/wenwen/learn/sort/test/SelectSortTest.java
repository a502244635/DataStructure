package com.wenwen.learn.sort.test;

import java.util.Arrays;

public class SelectSortTest {
    public static void main(String[] args) {
        int[] arr = {10, 4, -24, 52, 11};
        selectSort(arr);
    }

    private static void selectSort(int[] arr){
        for (int i = 0;i<arr.length - 1;i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (min >= arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
