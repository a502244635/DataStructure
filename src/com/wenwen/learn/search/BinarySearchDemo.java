package com.wenwen.learn.search;

//二分查找法
public class BinarySearchDemo {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000, 1234 };
        int i = binarySearch(arr,0,arr.length-1,89);
        System.out.println(arr[i]);
    }

    private static int binarySearch(int arr[], int left, int right, int findVal){
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        if (findVal > arr[mid]){
            return binarySearch(arr,mid+1,right,findVal);
        } else if (findVal < arr[mid]) {
            return binarySearch(arr,left,mid,findVal);
        }else {
            return mid;
        }
    }
}
