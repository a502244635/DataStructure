package com.wenwen.learn.linkedList;

/**说明：
 * 创建一个单链表,实现他增删改查的方法
 * 首先创建一个节点对象node,再创建一个单链表，这个单链表里有一个head节点
 *
 * 1.add方法，把节点添加到单链表中，按添加到节点末尾的方式进行添加。
 * 思路：添加节点的时候使用while循环进行遍历查找最后一个节点，节点的next为空既是找到了，这时候就可以跳出循环，
 * 进行节点的添加，不为空就继续进行指针的后移。
 *
 * 2.addByOrder方法，根据节点的序号no进行节点的有序添加 （升序）
 * 思路：使用while对链表进行遍历，如果初节点的next为空则跳出循环，直接把节点添加到末尾。如果初节点的next的序号大于添加节点
 * 的序号，那么把添加节点插入初节点与初节点的next之间
 *
 *
 */
public class LinkedListDemo1 {
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
        linkedList.addByOrder(heroNode2);
        linkedList.addByOrder(heroNode4);
        linkedList.addByOrder(heroNode3);
        linkedList.update(heroNode5);
        linkedList.del(heroNode2);

        linkedList.list();

        System.out.println(linkedList.getLength(linkedList.getHead()));

        System.out.println(linkedList.findIndexNode(3,linkedList.getHead()));
        linkedList.reverseList(linkedList.getHead());

        linkedList.list();
    }



}

/**
 * 创建一个含有方法的单链表
 */
class LinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //查找链表中的最后一个节点
        while (true){
            if (temp.next != null){
                temp =  temp.next;
            }else{
                break;
            }
        }
        temp.next = heroNode;
    }

    public void list(){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
            System.out.println(temp);
        }
    }
//todo 添加的节点序号在链表中有重复，那么添加节点失败
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        Boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){
                break;
            }
            temp = temp.next;
        }

        if (flag){

        }else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == heroNode.no){
                //已经找到修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next.name = heroNode.name;
            temp.next.nickName = heroNode.nickName;
        }else{
            System.out.println("没有找到该节点");
        }
    }

    public void del(HeroNode heroNode){
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
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到该节点");
        }
    }
    //获得链表中的有效节点
    public int getLength(HeroNode head){
        if (head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head;
        while (true){
            if (temp.next != null){
                length++;
                temp = temp.next;
            }else{
                break;
            }
        }
        return length;

    }

    public  HeroNode getHead(){
        return this.head;
    }

    //查找倒数第index个节点
    public HeroNode findIndexNode(int index,HeroNode head){
        //如果链表为空
        if (head.next==null){
            return null;
        }
        int length = getLength(head);
        if (index <= 0 || index>length){
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0;i<length-index;i++){
            cur = cur.next;
        }
        return cur;
    }

    //反转链表
    public void reverseList(HeroNode head){
        //判断链表是否为空，是否只有一个节点
        if (head.next == null || head.next.next ==null){
            return;
        }
        //创建一个新的头
        HeroNode newHead = new HeroNode(0,"","");
        //cur当前节点
        HeroNode cur = head.next;
        //next存放下一个节点
        HeroNode nextNode = null;
        while (cur != null){
            nextNode = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = nextNode;
        }
        head.next = newHead.next;
    }
}

//创建一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName +
                '}';
    }
}