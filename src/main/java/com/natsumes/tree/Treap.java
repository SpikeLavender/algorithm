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
public class Treap<T extends Comparable<T>> implements Tree<T> {

    private Node root;

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
    public void insert(T data) {
        add(data, rd.nextInt(DEFAULT_RD));
    }

    private void add(T data, int priority) {
        Node newNode = new Node(data, priority);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = current;
        int result = 0;
        while (current != null) {
            parent = current;
            result = data.compareTo(current.data);
            if (result > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (result > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        newNode.parent = parent;
        // 自平衡
        balanceInsert(newNode);
    }

    private void balanceInsert(Node node) {
        if (node.parent != null) {
            int result = node.priority - node.parent.priority;
            if (result >= 0) {
                return;
            }
            if (node == node.parent.left) {
                //右旋
                rRotate(node);
                balanceInsert(node);
            } else {
                //左旋
                lRotate(node);
                balanceInsert(node);
            }
        }
    }


    @Override
    public boolean remove(T data) {
        return false;
    }

    private void rRotate(Node node) {
        Node parent = node.parent;
        Node son = node.left;
        if (son.right != null) {
            son.right.parent = node;
        }
        node.left = son.right;
        transplant(node, son, parent);
    }

    private void lRotate(Node node) {
        Node parent = node.parent;
        Node son = node.right;
        if (son.left != null) {
            son.left.parent = node;
        }
        node.right = son.left;
        transplant(node, son, parent);
    }

    private void transplant(Node node, Node son, Node parent) {
        node.parent = son;
        son.parent = parent;
        updateNodeNum(node);
        updateNodeNum(son);
        if (parent == null) {
            root = son;
            return;
        }
        if (parent.left == node) {
            parent.left = son;
        } else {
            parent.right = son;
        }
    }

    private void updateNodeNum(Node node) {
        node.nodeNum = node.left.nodeNum + node.right.nodeNum + node.num;
    }

    class Node {

        T data;

        /**
         * 当前节点数
         */
        int num = 1;

        /**
         * 以当前节点为根子树的总节点个数
         */
        int nodeNum = 1;

        transient int priority;

        Node left;

        Node right;

        Node parent;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            int leftSize = left == null ? 0 : left.nodeNum;
            int rightSize = right == null ? 0 : right.nodeNum;
            this.nodeNum = leftSize + rightSize + 1;
        }

        public Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }

        public Node(T data, int priority, Node left, Node right, Node parent) {
            this.data = data;
            this.priority = priority;
            this.left = left;
            this.right = right;
            this.parent = parent;
            int leftSize = left == null ? 0 : left.nodeNum;
            int rightSize = right == null ? 0 : right.nodeNum;
            this.nodeNum = leftSize + rightSize + 1;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", priority = " + priority + ", nodeNum = " + nodeNum + '}';
        }
    }

}
