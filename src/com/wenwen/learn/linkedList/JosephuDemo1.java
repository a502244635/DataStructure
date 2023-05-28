package com.wenwen.learn.linkedList;


/**
 * 约瑟夫环
 */
public class JosephuDemo1 {
    public static void main(String[] args) {
        CircleList circleList = new CircleList();
        circleList.addBoy(5);
        circleList.list();
        circleList.countBoy(5,1,2); //2 4 1 5 3
    }
}

class CircleList{

    Boy first = null;
    Boy curBoy = null;

    public void addBoy(int num){
        if (num <= 0){
            System.out.println("输入数量有误");
            return;
        }

        for (int i = 1;i <= num;i++){
            Boy boy = new Boy(i);
            if (i == 1){
                first = boy;
                first.setNextBoy(first);
                curBoy = first;
            }else {
                curBoy.setNextBoy(boy);
                boy.setNextBoy(first);
                curBoy = boy;
            }
        }
    }

    /**
     *
     * @param num 节点数量
     * @param startNum 从第几个开始数
     * @param countNum 数几下
     */
    public void countBoy(int num, int startNum, int countNum){
        if (startNum > num || startNum < 1 || first.getNext() == null){
            System.out.println("参数有误");
            return;
        }
        Boy helper = first;
        //使helper的next指向最后小孩节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        for (int i = 0;i < startNum - 1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true){
            //只剩一个节点
            if (helper == first){
                break;
            }
            //数countNum次
            for (int j = 0;j < countNum - 1;j++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时候first节点就是出圈的节点
            System.out.println("出圈:" + first.getNo());
            //出圈操作
            first = first.getNext();
            helper.setNextBoy(first);
        }

        System.out.printf("最后出圈的孩子号码为%d",first.getNo());
    }

    public void list(){
        if (first.getNext() == null){
            return;
        }

        Boy cur = first;
        while (true){
            System.out.println(cur);
            if (cur.getNext() == first){
                break;
            }
            cur = cur.getNext();
        }
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNextBoy(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
