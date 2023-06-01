package com.wenwen.learn.sort.test;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int [] arr = {10, 4, -24, 52, 11};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int arr[]){
        boolean flag = false;
        int temp;
        for (int i = 0;i<arr.length - 1;i++){
            for (int j = 0;j<arr.length -1 -i;j++){
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
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
