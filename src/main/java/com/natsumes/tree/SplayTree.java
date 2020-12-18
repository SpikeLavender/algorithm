package com.natsumes.tree;

/**
 * 伸展树
 *
 * 伸展树的出发点是这样的：考虑到局部性原理（刚被访问的内容下次可能仍会被访问，查找次数多的内容可能下一次会被访问），
 * 为了使整个查找时间更小，被查频率高的那些节点应当经常处于靠近树根的位置。
 * 这样，很容易得想到以下这个方案：每次查找节点之后对树进行重构，把被查找的节点搬移到树根，这种自调整形式的二叉查找树就是伸展树。
 * 每次对伸展树进行操作后，它均会通过旋转的方法把被访问节点旋转到树根的位置。
 *
 * 为了将当前被访问节点旋转到树根，我们通常将节点自底向上旋转，直至该节点成为树根为止。
 * “旋转”的巧妙之处就是在不打乱数列中数据大小关系（指中序遍历结果是全序的）情况下，所有基本操作的平摊复杂度仍为 O(log n)。
 *
 * @author hetengjiao
 */
public class SplayTree<V> implements Tree<V> {

    Node<V> root;

    @Override
    public void insert(V value) {

    }

    @Override
    public boolean remove(V value) {
        return true;
    }


    /**
     * 左旋
     * RR
     * @return 新根节点
     */
    Node<V> leftRotate(Node<V> node) {
        Node<V> parent = node.parent;
        Node<V> son = node.right;

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
    Node<V> rightRotate(Node<V> node) {

        Node<V> parent = node.parent;
        Node<V> son = node.left;
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
    private Node<V> getSuccessor(Node<V> node) {
        if (node.right != null) {
            Node<V> right = node.right;
            while (right.left  != null) {
                right = right.left;
            }
            return right;
        }

        Node<V> parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    static class Node<V> {

        V value;

        Node<V> parent;

        Node<V> left;

        Node<V> right;

        public Node(V value) {
            this.value = value;
        }
    }
}
