package com.natsumes.work;

/**
 * @author hetengjiao
 */
public class IntRedBlackNode {

    int value;

    boolean isBlack;

    int num = 1;

    IntRedBlackNode left;

    IntRedBlackNode right;

    IntRedBlackNode parent;

    public IntRedBlackNode(int value) {
        this.value = value;
        this.isBlack = false;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", num = " + num
                + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
    }
}
