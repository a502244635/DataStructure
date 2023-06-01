package com.wenwen.learn.sort;

import java.util.Arrays;
//归并排序
public class MergeSortDemo {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }


    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t = 0; //指向temp的初始数组

        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        //把有剩余数据的一边的数据依次全部填充到 temp
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将 temp 数组的元素拷贝到 arr
        t=0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
