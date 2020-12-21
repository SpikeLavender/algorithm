package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public abstract class AbstractTree<V extends Comparable<V>> {

    protected Node root;

    /**
     * 左旋
     * RR
     * @return 新根节点
     */
    @SuppressWarnings("unchecked")
    <T extends Node> T  leftRotate(T node) {
        Node parent = node.parent;
        Node son = node.right;

        if (son.left != null) {
            son.left.parent = node;
        }
        node.right = son.left;
        son.left = node;
        node.parent = son;
        son.parent = parent;
        updateSize(node);
        updateSize(son);

        if (parent == null) {
            return (T)son;
        }
        if (parent.left == node) {
            parent.left = son;
        } else {
            parent.right = son;
        }
        return (T)son;
    }

    /**
     * 右旋
     * LL
     * @return 新根节点
     */
    @SuppressWarnings("unchecked")
    <T extends Node> T rightRotate (T node) {

        Node parent = node.parent;
        Node son = node.left;
        if (son.right != null) {
            son.right.parent = node;
        }
        node.left = son.right;
        son.right = node;
        node.parent =son;
        son.parent = parent;
        updateSize(node);
        updateSize(son);

        if (parent == null) {
            return (T)son;
        }
        if (parent.right == node) {
            parent.right = son;
        } else {
            parent.left = son;
        }
        return (T)son;
    }

    private void updateSize(Node node) {
        node.size = node.left.size + node.right.size + node.num;
    }

    /**
     * 寻找后继节点 predecessor
     */
    protected Node getSuccessor(Node node) {
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

    public Node createNode(V value) {
        return new Node(value);
    }

    class Node {

        V value;

        /**
         * 当前节点数
         */
        int num;

        /**
         * 以当前节点为根子树的总节点个数
         */
        int size;

        transient int priority;

        Node left;

        Node right;

        Node parent;

        public Node(V value) {
            this.value = value;
            this.num = 1;
            this.size = 1;
        }

        public Node(V value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + value + ", nodeNum = " + size + '}';
        }
    }

}
