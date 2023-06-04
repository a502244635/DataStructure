package com.wenwen.learn.tree;

//顺序存储二叉树
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrayBinaryTree arrBinaryTree = new ArrayBinaryTree(arr);
//        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
//        arrBinaryTree.infixOrder();
        arrBinaryTree.postOrder();
    }
}

class ArrayBinaryTree{
    private int[] arr;
    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        preOrder(0);
    }

    public void infixOrder(){
        infixOrder(0);
    }

    public void postOrder(){
        postOrder(0);
    }

    //完成顺序存储二叉树的遍历
    private void preOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("不能进行遍历");
        }
        //输出元素
        System.out.println(arr[index]);
        //左递归
        if ((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        //右递归
        if ((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }
    public void infixOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("不能进行遍历");
        }

        //左递归
        if ((index*2+1)<arr.length){
            infixOrder(index*2+1);
        }
        //输出元素
        System.out.println(arr[index]);
        //右递归
        if ((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }

    public void postOrder(int index){
        if (arr == null || arr.length==0){
            System.out.println("不能进行遍历");
        }

        //左递归
        if ((index*2+1)<arr.length){
            postOrder(index*2+1);
        }

        //右递归
        if ((index*2+2)<arr.length){
            postOrder(index*2+2);
        }

        //输出元素
        System.out.println(arr[index]);
    }
}