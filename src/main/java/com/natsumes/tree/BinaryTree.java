package com.natsumes.tree;

import java.util.Comparator;

/**
 * @author hetengjiao
 */
public class BinaryTree<V> {

    private TreeNode<V> root;

    private final Comparator<? super V> comparator;

    public BinaryTree(Comparator<? super V> comparator) {
        this.comparator = comparator;
    }

    public TreeNode<V> build() {
        return root;
    }

    public BinaryTree<V> insert(V data) {
        root = insert(root, data);
        return this;
    }

    private TreeNode<V> insert(TreeNode<V> node, V data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        int c = comparator.compare(data, node.data);
        if (c < 0) {
            node.leftChild = insert(node.leftChild, data);
        } else if (c > 0) {
            node.rightChild = insert(node.rightChild, data);
        } else {
            node.data = data;
        }
        return node;
    }

}
