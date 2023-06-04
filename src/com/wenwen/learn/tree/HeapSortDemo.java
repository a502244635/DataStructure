package com.wenwen.learn.tree;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    public static void heapSort(int[] arr){
        int temp = 0;
        for (int i = arr.length/2 - 1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length-1;j>0;j--){
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("数组=" + Arrays.toString(arr));
    }

    /**
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i]; //取出当前元素的值
        for (int k = i*2+1;k<length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k]>temp){
                arr[i] = arr[k];
                i=k;
            }else {
                break;
            }

        }
        arr[i] = temp;
    }
}


