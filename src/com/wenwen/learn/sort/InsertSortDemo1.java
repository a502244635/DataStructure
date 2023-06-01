package com.wenwen.learn.sort;

import java.util.Arrays;

//插入排序
public class InsertSortDemo1 {
    public static void main(String[] args) {
        int[] arr = {10, 4, -24, 52, 11};
        insertSort(arr);
    }

    private static void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int insertIndex = i-1;
            int insertVal = arr[i];
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
