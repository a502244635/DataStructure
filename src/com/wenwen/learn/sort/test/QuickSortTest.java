package com.wenwen.learn.sort.test;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {10, 4, 24, 52, 11,42};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        
    }

    private static void quickSort(int[] arr,int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        while (left > right){
            while (arr[l]<pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }
            if (l>=r){
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        if (l<right){
            quickSort(arr,left,r);
        }
        if (r>left){
            quickSort(arr,l,right);
        }
    }
}
