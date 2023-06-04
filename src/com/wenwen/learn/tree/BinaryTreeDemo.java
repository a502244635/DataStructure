package com.wenwen.learn.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node node1 = new Node(1,"卡卡");
        Node node2= new Node(2,"ga");
        Node node3 = new Node(3,"qwe");
        Node node4 = new Node(4,"hh");
        Node node5 = new Node(5,"vv");

        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(node1);
//        binaryTree.postOrder();

//        System.out.println(binaryTree.postSearch(3));
        binaryTree.deleteNode(4);
        binaryTree.preOrder();
    }

}

class BinaryTree{
    private Node root;
    public void setRoot(Node node){
        this.root = node;
    }

    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //前、中、后序遍历查找
    public Node preSearch(int no){
        if (root != null){
            return root.preSearch(no);
        }else{
            return null;
        }
    }
    public Node infixSearch(int no){
        if (root != null){
            return root.infixSearch(no);
        }else{
            return null;
        }
    }
    public Node postSearch(int no){
        if (root != null){
            return root.postSearch(no);
        }else{
            return null;
        }
    }

    public void deleteNode(int no){
      if (root != null){
          if (root.getNo() == no){
              root = null;
          }else{
              root.delete(no);
          }
      }else{
          System.out.println("空树，不能删除~");
      }

    }
}

class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public   void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前、中、后序遍历
    public Node preSearch(int no){
        Node searchNode = null;
        if (this.no == no){
            return this;
        }
        if (this.left != null){
            searchNode = this.left.preSearch(no);
        }
        if (searchNode != null){
            return searchNode;
        }
        if (this.right != null){
            searchNode = this.right.preSearch(no);
        }
        return searchNode;
    }

    public Node infixSearch(int no){
        Node searchNode = null;
        if (this.left != null){
            searchNode = this.left.infixSearch(no);
        }
        if (this.no == no){
            return this;
        }
        if (this.right != null){
            searchNode = this.right.infixSearch(no);
        }
        return searchNode;
    }

    public Node postSearch(int no){
        Node searchNode = null;
        if (this.left != null){
            searchNode = this.left.postSearch(no);
        }
        if (searchNode != null){
            return searchNode;
        }
        if (this.right != null){
            searchNode = this.right.postSearch(no);
        }
        if (searchNode != null){
            return searchNode;
        }
        if (this.no == no){
            return this;
        }
        return searchNode;
    }

    //删除指定节点
    public void delete(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.delete(no);
        }
        if (this.right != null){
            this.right.delete(no);
        }
    }
}
