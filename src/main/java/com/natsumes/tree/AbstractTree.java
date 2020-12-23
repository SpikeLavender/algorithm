package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

    protected Node root;

    @Override
    public void add(T data) {
        if (root == null) {
            root = initNode(data);
            return;
        }
        Node node = initNode(data);
        if (doAdd(data, node) != null) {
            afterAdd(node);
        }
    }

    /**
     * add之前构造新节点
     * @param data 插入数据
     * @return 新节点
     */
    protected abstract Node initNode(T data);

    /**
     * 执行插入
     * @param data 插入的数据
     * @param node 需要插入的节点
     * @return 返回需要调整的节点
     */
    protected Node doAdd(T data, Node node) {
        Node temp = root;
        Node parent = temp;

        int res = 0;
        while (temp != null) {
            parent = temp;
            parent.nodeNum++;
            res = data.compareTo(temp.data);
            if (res > 0) {
                temp = temp.right;
            } else if (res < 0) {
                temp = temp.left;
            } else {
                temp.num++;
                return null;
            }
        }
        if (res > 0) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        node.parent = parent;
        return node;
    }

    /**
     * 插入之后进行平衡操作
     * @param node 需要处理的节点
     */
    protected abstract void afterAdd(Node node);

    @Override
    public boolean remove(T data) {
        return false;
    }



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
        int depth = 1;

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

        public Node(T data, boolean isBlack) {
            this.data = data;
            this.isBlack = isBlack;
            this.nodeNum = 1;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", nodeNum = " + nodeNum
                    + ", depth = " + depth
                    + ", priority = " + priority
                    + ", color=" + (isBlack ? "BLACK" : "RED")
                    + '}';
        }

    }
}
