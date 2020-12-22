package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public abstract class AbstractTree<T extends Comparable<T>> {

    protected Node root;

    protected void updateNodeNum(Node node) {
        if (node == null) {
            return;
        }
        int leftSize = node.left == null ? 0 : node.left.nodeNum;
        int rightSize = node.right == null ? 0 : node.right.nodeNum;
        node.nodeNum = leftSize + rightSize + node.num;
    }

    public T getMinData() {
        Node node = root;
        Node minNode = node;
        while (node != null) {
            minNode = node;
            node = node.left;
        }
        if (minNode != null) {
            return minNode.data;
        }
        return null;
    }

    public T getMaxData() {
        Node node = root;
        Node maxNode = node;
        while (node != null) {
            maxNode = node;
            node = node.right;
        }
        if (maxNode != null) {
            return maxNode.data;
        }
        return null;
    }

    public T getTopN(long n) {
        if (root == null || n > root.nodeNum || n < 0) {
            return null;
        }
        Node node = root;
        while (node != null) {
            int left = node.left == null ? 0 : node.left.nodeNum;
            if (n <= left) {
                node = node.left;
            } else if (n > left + node.num){
                n = n - left - node.num;
                node = node.right;
            } else {
                return node.data;
            }
        }
        return null;
    }

    public int getTotalSize() {
        return root.nodeNum;
    }

    class Node {
        T data;

        /**
         * used by Red-Black
         */
        transient boolean isBlack;

        /**
         * used by Treap
         */
        transient int priority;

        /**
         * 深度，这里计算每个节点的深度，通过深度的比较可得出是否平衡
         * used by AVL tree
         */
        int depth = 0;

        int num = 1;

        /**
         * 节点的个数，用来实现top值的查找
         */
        int nodeNum;

        Node left;

        Node right;

        transient Node parent;

        Node() {
        }

        Node(T data) {
            this.data = data;
            this.nodeNum = 1;
            this.isBlack = false;
        }

        Node(T data, int priority) {
            this.data = data;
            this.nodeNum = 1;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", nodeNum = " + nodeNum + ", priority = " + priority
                    + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
        }

    }
//
//
//    /**
//     * private void rRotate(Node node) {
//     *         Node parent = node.parent;
//     *         Node son = node.left;
//     *         if (son.right != null) {
//     *             son.right.parent = node;
//     *         }
//     *         node.left = son.right;
//     *         transplant(node, son, parent);
//     *     }
//     *
//     *     private void lRotate(Node node) {
//     *         Node parent = node.parent;
//     *         Node son = node.right;
//     *         if (son.left != null) {
//     *             son.left.parent = node;
//     *         }
//     *         node.right = son.left;
//     *         transplant(node, son, parent);
//     *     }
//     *
//     *     private void transplant(Node node, Node son, Node parent) {
//     *         node.parent = son;
//     *         son.parent = parent;
//     *         updateNodeNum(node);
//     *         updateNodeNum(son);
//     *         if (parent == null) {
//     *             root = son;
//     *             return;
//     *         }
//     *         if (parent.left == node) {
//     *             parent.left = son;
//     *         } else {
//     *             parent.right = son;
//     *         }
//     *     }
//     */

    /**
     * 左旋
     * RR
     * @return 新根节点
     */
//    @SuppressWarnings("unchecked")
//    <T extends Node> T  leftRotate(T node) {
//        Node parent = node.parent;
//        Node son = node.right;
//
//        if (son.left != null) {
//            son.left.parent = node;
//        }
//        node.right = son.left;
//        son.left = node;
//        node.parent = son;
//        son.parent = parent;
//        updateSize(node);
//        updateSize(son);
//
//        if (parent == null) {
//            return (T)son;
//        }
//        if (parent.left == node) {
//            parent.left = son;
//        } else {
//            parent.right = son;
//        }
//        return (T)son;
//    }
//
//    /**
//     * 右旋
//     * LL
//     * @return 新根节点
//     */
//    @SuppressWarnings("unchecked")
//    <T extends Node> T rightRotate (T node) {
//
//        Node parent = node.parent;
//        Node son = node.left;
//        if (son.right != null) {
//            son.right.parent = node;
//        }
//        node.left = son.right;
//        son.right = node;
//        node.parent =son;
//        son.parent = parent;
//        updateSize(node);
//        updateSize(son);
//
//        if (parent == null) {
//            return (T)son;
//        }
//        if (parent.right == node) {
//            parent.right = son;
//        } else {
//            parent.left = son;
//        }
//        return (T)son;
//    }
//
//
//
//    private void updateSize(Node node) {
//        node.size = node.left.size + node.right.size + node.num;
//    }
//
//    /**
//     * 寻找后继节点 predecessor
//     */
//    protected Node getSuccessor(Node node) {
//        if (node.right != null) {
//            Node right = node.right;
//            while (right.left  != null) {
//                right = right.left;
//            }
//            return right;
//        }
//
//        Node parent = node.parent;
//        while (parent != null && node == parent.right) {
//            node = parent;
//            parent = parent.parent;
//        }
//        return parent;
//    }
//
//    public Node createNode(V data) {
//        return new Node(data);
//    }
}
