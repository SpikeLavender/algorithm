package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public class AVLNode {

    /**
     * 深度，这里计算每个节点的深度，通过深度的比较可得出是否平衡
     */
    int depth = 0;

    AVLNode parent;

    AVLNode left;

    AVLNode right;

    int value;

    int num;

    public AVLNode(int value) {
        this.value = value;
        this.num = 1;
    }
}
