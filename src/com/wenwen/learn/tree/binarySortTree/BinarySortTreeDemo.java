package com.wenwen.learn.tree.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};

        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0;i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.delNode(10);

        binarySortTree.infixOrder();

    }
}

class BinarySortTree{
    Node root = null;

    public Node search(int value){
        if (root != null){
            return root.search(value);
        }else{
            return null;
        }
    }

    public Node searchParent(int value){
        if (root != null){
            return root.searchParent(value);
        }else{
            return null;
        }
    }

    /**
     *
     * @param node 以待删除的节点为根节点
     * @return 已node为根节点的排序二叉树的最小结点的值
     */
    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
       if (root == null){
           return;
       }
       Node targetNode = search(value);
       if (targetNode == null){
           return;
       }
       Node parentNode = searchParent(value);
       if (targetNode.left == null && targetNode.right == null){
           if (parentNode.left != null && parentNode.left.value == value){
               parentNode.left = null;
           } else if (parentNode.right != null && parentNode.right.value == value) {
               parentNode.right = null;
           }
           //删除有两颗节点的节点
       } else if (targetNode.left != null && targetNode.right != null) {
           int minVal = delRightTreeMin(targetNode.right);
            targetNode.value = minVal;

           //删除有一颗节点的节点
       }else{
           if (targetNode.left != null){
               if (parentNode != null){
                   if (parentNode.left.value == targetNode.value){
                       parentNode.left = targetNode.left;
                   }else{
                       parentNode.right = targetNode.left;
                   }
               }else{
                   root = targetNode.left;
               }

           }else{
               if (parentNode != null){
                   if (parentNode.right.value == targetNode.value){
                       parentNode.right = targetNode.right;
                   }else {
                       parentNode.left = targetNode.right;
                   }
               }else{
                   root = targetNode.right;
               }

           }
       }

    }

    public void add(Node node){
      if (root == null){
          root = node;
      }else{
          root.add(node);
      }
    }
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("二叉排序树为空,遍历失败");
        }
    }
}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找要删除的节点
    public Node search(int value){
        if (this.value == value){
            return this;
        }else if(this.value > value){
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if (value<this.value && this.left != null){
                return this.left.searchParent(value);
            } else if (value>=this.value && this.right != null) {
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }


    public void add(Node node){
        if (node == null){
            return;
        }
        if (this.value > node.value){
            if (this.left != null){
                this.left.add(node);
            }else {
                this.left = node;
            }
        }else{
            if (this.right != null){
                this.right.add(node);
            }else{
                this.right = node;
            }
        }
    }
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
}
