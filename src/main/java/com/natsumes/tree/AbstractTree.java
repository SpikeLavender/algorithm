package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public abstract class AbstractTree<V extends Comparable<V>> {

    /**
     * 左旋
     * RR
     * @return 新根节点
     */
    Node leftRotate(Node node) {
        Node parent = node.parent;
        Node son = node.right;

        if (son.left != null) {
            son.left.parent = node;
        }
        node.right = son.left;
        son.left = node;
        node.parent = son;
        son.parent = parent;
        if (parent == null) {
            return son;
        }
        if (parent.left == node) {
            parent.left = son;
        } else {
            parent.right = son;
        }
        return son;
    }

    /**
     * 右旋
     * LL
     * @return 新根节点
     */
    Node rightRotate(Node node) {

        Node parent = node.parent;
        Node son = node.left;
        if (son.right != null) {
            son.right.parent = node;
        }
        node.left = son.right;
        son.right = node;
        node.parent =son;
        son.parent = parent;
        if (parent == null) {
            return son;
        }
        if (parent.right == node) {
            parent.right = son;
        } else {
            parent.left = son;
        }
        return son;
    }

    /**
     * 寻找后继节点
     */
    private Node getSuccessor(Node node) {
        if (node.right != null) {
            Node right = node.right;
            while (right.left  != null) {
                right = right.left;
            }
            return right;
        }

        Node parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }


    class Node {

        V value;

        /**
         * 节点数
         */
        int num;

        transient int priority;

        Node left;

        Node right;

        Node parent;

        public Node(V value) {
            this.value = value;
            this.num = 0;
        }
    }

}
