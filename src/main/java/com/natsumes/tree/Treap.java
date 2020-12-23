package com.natsumes.tree;

import java.util.Random;

/**
 * 树堆（Treap）
 *
 * 树堆（Treap）是二叉排序树（Binary Sort Tree）与堆（Heap）结合产生的一种拥有堆性质的二叉排序树。
 *
 * 但是这里要注意两点，第一点是Treap和二叉堆有一点不同，就是二叉堆必须是完全二叉树，而Treap并不一定是；
 * 第二点是Treap并不严格满足平衡二叉排序树（AVL树）的要求，即树堆中每个节点的左右子树高度之差的绝对值可能会超过1，
 * 只是近似满足平衡二叉排序树的性质。
 *
 * Treap每个节点记录两个数据，一个是键值，一个是随机附加的优先级，Treap在以关键码构成二叉排序树的同时，
 * 又以结点优先级形成最大堆和最小堆。所以Treap必须满足这两个性质，一是二叉排序树的性质，二是堆的性质。
 *
 * @author hetengjiao
 */
public class Treap<T extends Comparable<T>> extends AbstractTree<T> implements Tree<T> {

    private Random rd = new Random();

    private static final int DEFAULT_RD = 1 << 10;

    public Treap() {
        root = null;
    }

    public Treap(T data) {
        root = new Node(data, rd.nextInt(DEFAULT_RD));
    }

    public Treap(T data, int priority) {
        root = new Node(data, priority);
    }

    @Override
    protected Node initNode(T data) {
        return new Node(data, rd.nextInt(DEFAULT_RD));
    }

    @Override
    protected void afterAdd(Node node) {
        balanceInsert(node);
    }

    /**
     * 给节点随机分配一个优先级，先和二叉搜索树的插入一样，先把要插入的点插入到一个叶子上，
     * 然后 跟维护堆一样，
     * 如果当前节点的优先级比根大就旋转，如果 当前节点是根的左儿子就右旋，
     * 如果当前节点是根的右儿子就左旋
     */
    private void balanceInsert(Node node) {
        if (node == null) {
            return;
        }
        Node father = node.parent;
        while (father != null) {

            int result = father.priority - node.priority;
            if (result >= 0) {
                return;
            }
            if (node == father.left) {
                //右旋
                father = rRotate(node);

            } else if (node == father.right){
                //左旋
                father = lRotate(node);
            }
        }
    }


    @Override
    public boolean remove(T data) {
        return false;
    }

    /**
     * 右旋 L
     * @param node node
     *
     *
     * 	  			 │			│
     * 	  		   p─┘          └─l
     * 	  		  ││     ->		  ││
     * 	  		l─┘└  			 ─┘└─p
     * 	  		││					 ││
     * 	  	   ─┘└				    ─┘└
     */
    private Node rRotate(Node node) {
        Node parent = node.parent;
        node.parent = parent.parent;
        if (parent.parent != null) {
            if (parent == parent.parent.left) {
                parent.parent.left = node;
            } else {
                parent.parent.right = node;
            }
        }
        parent.left = node.right;
        if (node.right != null) {
            node.right.parent = parent;
        }
        node.right = parent;
        parent.parent = node;
        updateNodeNum(parent);
        updateNodeNum(node);
        if (root == parent) {
            root = node;
        }
        return node;
    }

    private Node lRotate(Node node) {
        Node parent = node.parent;
        node.parent = parent.parent;
        if (parent.parent != null) {
            if (parent == parent.parent.right) {
                parent.parent.right = node;
            } else {
                parent.parent.left = node;
            }
        }
        parent.right = node.left;
        if (node.left != null) {
            node.left.parent = parent;
        }
        node.left = parent;
        parent.parent = node;
        updateNodeNum(parent);
        updateNodeNum(node);
        if (root == parent) {
            root = node;
        }
        return node;
    }



//    class Node extends AbstractTree.Node {
//
//        transient int priority;
//
//        Node left;
//
//        Node right;
//
//        Node parent;
//
//        public Node(T data) {
//            this.data = data;
//        }
//
//        public Node(T data, Node left, Node right) {
//            this.data = data;
//            this.left = left;
//            this.right = right;
//            int leftSize = left == null ? 0 : left.nodeNum;
//            int rightSize = right == null ? 0 : right.nodeNum;
//            this.nodeNum = leftSize + rightSize + 1;
//        }
//
//        Node(T data, int priority) {
//            super(data);
//            this.priority = priority;
//        }
//
//        public Node(T data, int priority, Node left, Node right, Node parent) {
//            this.data = data;
//            this.priority = priority;
//            this.left = left;
//            this.right = right;
//            this.parent = parent;
//            int leftSize = left == null ? 0 : left.nodeNum;
//            int rightSize = right == null ? 0 : right.nodeNum;
//            this.nodeNum = leftSize + rightSize + 1;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" + "data=" + data + ", priority = " + priority + ", nodeNum = " + nodeNum + '}';
//        }
//    }

}
