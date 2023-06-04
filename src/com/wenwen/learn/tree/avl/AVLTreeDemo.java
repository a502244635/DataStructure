package com.wenwen.learn.tree.avl;

//平衡二叉树
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i = 0;i<arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }
        System.out.println(avlTree.root.height());
        System.out.println(avlTree.root.left.height());
        System.out.println(avlTree.root.right.height());

    }
}

class AVLTree{
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

    //左旋转
    public void leftRotate(){
        //创建一个值为当前节点的值的新节点
        Node newNode = new Node(value);
        //把新节点的左子树设置为当前节点的左子树
        newNode.left = left;
        //把新的节点的右节点设置为当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成当前节点右子树
        value = right.value;
        //把当前节点的右子树设置为当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置为当前节点
        left = newNode;
    }

    //右旋转
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;

    }


    //返回左子树的高度
    public int leftHeight(){
        if (left == null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if (right == null){
            return 0;
        }
        return right.height();
    }
    //返回以该节点为根节点的树的高度
    public int height(){
        //+1的原因为 当前节点也为一层
        return Math.max(left == null ? 0 : left.height() ,right == null ? 0 : right.height()) + 1;
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
        //当添加完一个节点后，（右子树的高度-左子树的高度 > 1），左旋转
        if (rightHeight() - leftHeight() > 1){
            //如果他的右子树的左子树高度大于右子树，先右旋转后左旋转
            if (right != null && right.leftHeight() > right.leftHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return;
        }
        //当添加完一个节点后，（左子树的高度-右子树的高度 > 1），右旋转
        if (leftHeight() - rightHeight() > 1){
            if (left != null && left.rightHeight() > left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else{
                rightRotate();
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
