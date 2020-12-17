package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public class RedBlackNode<V> {

    V value;

    boolean isBlack;

    int num = 1;

    RedBlackNode<V> left;

    RedBlackNode<V> right;

    RedBlackNode<V> parent;

    public RedBlackNode(V value) {
        this.value = value;
        this.isBlack = false;
    }

    @Override
    public String toString() {
        return "RedBlackNode{" + "value=" + value + ", num = " + num
                + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
    }
}
