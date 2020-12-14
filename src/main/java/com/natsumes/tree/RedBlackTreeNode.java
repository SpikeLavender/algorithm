package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public class RedBlackTreeNode<V> {

    V value;

    boolean isBlack;

    int num = 1;

    RedBlackTreeNode<V> left;

    RedBlackTreeNode<V> right;

    RedBlackTreeNode<V> parent;

    public RedBlackTreeNode(V value) {
        this.value = value;
        this.isBlack = false;
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" + "value=" + value + ", num = " + num
                + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
    }
}
