package com.natsumes.work;

/**
 * @author hetengjiao
 */
public class IntRedBlackTreeNode {

    int value;

    boolean isBlack;

    int num = 1;

    IntRedBlackTreeNode left;

    IntRedBlackTreeNode right;

    IntRedBlackTreeNode parent;

    public IntRedBlackTreeNode(int value) {
        this.value = value;
        this.isBlack = false;
    }

    @Override
    public String toString() {
        return "RedBlackTreeNode{" + "value=" + value + ", num = " + num
                + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
    }
}
