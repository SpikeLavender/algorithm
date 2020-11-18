package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public class TreeNode<V>{

    V data;

    TreeNode<V> leftChild;

    TreeNode<V> rightChild;

    public TreeNode(V data) {
        this.data = data;
    }
}
