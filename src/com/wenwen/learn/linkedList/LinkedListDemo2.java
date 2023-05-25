package com.wenwen.learn.linkedList;

/**
 * 说明：双向链表、
 *
 */
public class LinkedListDemo2 {
    public static void main(String[] args) {
        Node node1 = new Node(1,"嘿嘿","黑黑");
        Node node2 = new Node(2,"嘿嘿2","黑黑2");
        Node node3= new Node(3,"嘿嘿3","黑黑3");
        Node node4 = new Node(4,"嘿嘿4","黑黑4");
        Node node5 = new Node(4,"xiuxiu","xiu");
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.update(node5);
        list.del(3);
        list.list();
    }
}

class DoubleLinkedList{
    public Node head = new Node(0,"","");

    public void add(Node node){
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void update(Node node){
        Node temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next.name = node.name;
            temp.next.nickName = node.nickName;
        }else {
            System.out.println("修改失败");
        }
    }

    public void del(int no){
        Node temp = head.next;
        boolean flag = false;
        while (temp != null){
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }else{
            System.out.println("删除失败");
        }
    }

    public void list(){
        Node temp = head;
        if (temp.next == null){
            System.out.println("链表为空");
            return;
        }
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}

class Node {
    public int no;
    public String name;
    public String nickName;
    public Node pre;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
