package com.wenwen.learn.linkedList.test;

public class LinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2 = new HeroNode(2,"fafa","啊嘎嘎");
        HeroNode heroNode4 = new HeroNode(4,"rr","小程序");
        HeroNode heroNode3 = new HeroNode(3,"qq","及抬起头");
        HeroNode heroNode5 = new HeroNode(1,"松将","及时送");

        LinkedList linkedList = new LinkedList();
//        linkedList.add(heroNode1);
//        linkedList.add(heroNode2);
//        linkedList.add(heroNode4);
//        linkedList.add(heroNode3);
        linkedList.addByOrder(heroNode1);
        linkedList.addByOrder(heroNode3);
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode4);
        linkedList.update(heroNode5);
        linkedList.del(heroNode5);

        linkedList.list();
        linkedList.reverseList();
        linkedList.list();
//        System.out.println(linkedList.getLength());
//
//        System.out.println(linkedList.getIndexNode(2));
    }
}

class LinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void  add(HeroNode heroNode){
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;

        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }

        if (flag){
            System.out.println("有重复节点");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null){
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        }else{
            System.out.println("找不到该节点");
        }
    }

    public void del(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null){
            if (temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            heroNode.next = temp.next.next;
            temp.next = heroNode;
        }else{
            System.out.println("删除失败");
        }
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public int getLength(){
        HeroNode temp = head;
        int length = 0;
        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //查找倒数第index个节点
    public HeroNode getIndexNode(int index){
        HeroNode temp = head;
        int length = getLength();
        if (temp.next == null){
            return null;
        }
        if (length < index || index <= 0){
            return null;
        }
        HeroNode cur = temp.next;
        for (int i = 0;i<length-index;i++){
            cur = cur.next;
        }
        return cur;
    }

    //反转链表
    public void reverseList(){
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode temp = head.next;
        if (temp == null || getLength()==1){
            System.out.println("链表为空或者链表只有一个节点");
            return;
        }
        while (true){
            HeroNode nextNode = temp.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = nextNode;
            if (temp == null){
                break;
            }
        }
        head.next = newHead.next;
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
