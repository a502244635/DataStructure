package com.wenwen.learn.stack;

import java.sql.Array;

/**
 * 使用数组模拟栈
 */
public class ArrayStackDemo1 {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();
        System.out.println("出栈的是："+stack.pop());
    }
}

class ArrayStack{
    public  int maxsize;
    public int top = -1;
    public int[] stack;

    public ArrayStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[maxsize];
    }

    public boolean isFull(){
        return top == maxsize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        return stack[top--];
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈为空");
        }
        for (int i = top;i >= 0;i--){
            System.out.println("出栈：" + stack[i]);
        }
    }
}
