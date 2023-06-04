package com.wenwen.learn.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        HuNode root = createHuffman(arr);
        preOrder(root);
    }

    public static void preOrder(HuNode root){
        if (root != null){
            root.preOrder();
        }else{
            System.out.println("树为空");
        }
    }

    public static HuNode createHuffman(int[] arr){
        List<HuNode> list = new ArrayList<>();
        for (int i = 0;i<arr.length;i++){
            list.add(new HuNode(arr[i]) );
        }
        while (list.size() > 1){
            Collections.sort(list);
            System.out.println(list);
            HuNode leftNode = list.get(0);
            HuNode rightNode = list.get(1);
            HuNode parent = new HuNode(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }
        return list.get(0);
    }
}




class HuNode implements Comparable<HuNode>{

    int value;//权值
    HuNode left;
    HuNode right;

    public HuNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "HuNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HuNode o) {

        return this.value - o.value;
    }

    //写一个前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
}
