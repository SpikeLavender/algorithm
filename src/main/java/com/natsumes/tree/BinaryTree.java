package com.natsumes.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BST 二叉查找树
 * @author hetengjiao
 */
public class BinaryTree<V> {

    private TreeNode<V> root;

    private final Comparator<? super V> comparator;

    public BinaryTree(Comparator<? super V> comparator) {
        this.comparator = comparator;
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

    /**
     * 前序遍历
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * 广度优先遍历 -- 层序遍历
     */
    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    /**
     * 前序遍历
     */
    private static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     */
    private static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     */
    private static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 广度优先遍历 -- 层序遍历
     */
    private static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }

    }

    static class TreeNode<V> {

        V data;

        TreeNode<V> leftChild;

        TreeNode<V> rightChild;

        TreeNode(V data) {
            this.data = data;
        }

    }
}
