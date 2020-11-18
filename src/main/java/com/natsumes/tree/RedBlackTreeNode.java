package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public class RedBlackTreeNode<V> {

    private V value;

    private boolean isBlack;

    private RedBlackTreeNode<V> left;

    private RedBlackTreeNode<V> right;

    private RedBlackTreeNode<V> parent;

    public RedBlackTreeNode(V value) {
        this.value = value;
        this.isBlack = false;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public RedBlackTreeNode<V> getLeft() {
        return left;
    }

    public void setLeft(RedBlackTreeNode<V> left) {
        this.left = left;
    }

    public RedBlackTreeNode<V> getRight() {
        return right;
    }

    public void setRight(RedBlackTreeNode<V> right) {
        this.right = right;
    }

    public RedBlackTreeNode<V> getParent() {
        return parent;
    }

    public void setParent(RedBlackTreeNode<V> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" + "value=" + value + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
    }
}
