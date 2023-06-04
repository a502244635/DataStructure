package com.wenwen.learn.tree.test;

import java.util.Arrays;

public class HeapSortTest {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        for (int i = arr.length/2 -1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length-1;j>0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);

        }
        System.out.println("数组=" + Arrays.toString(arr));
    }


    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];
        for (int k = i*2+1;k<length;k = k*2+1){
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k]>arr[i]){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}
