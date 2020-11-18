package com.natsumes.test;

import com.natsumes.tree.*;

/**
 * @author hetengjiao
 */
public class TreeTest {
    public static void main(String[] args) {
        testBinaryTree();

        testRedBlackTree();
    }

    private static void testBinaryTree() {
        BinaryTree<Integer> btt = new BinaryTree<>(Integer::compareTo);
        TreeNode<Integer> node = btt.insert(10).insert(8).insert(11).insert(7).insert(9).insert(12)
                .build();

        System.out.println("============preOrderTraversal============");
        TreeUtils.preOrderTraversal(node);
        System.out.println("============inOrderTraversal============");
        TreeUtils.inOrderTraversal(node);
        System.out.println("===========postOrderTraversal=============");
        TreeUtils.postOrderTraversal(node);
        System.out.println("===========levelOrderTraversal=============");
        TreeUtils.levelOrderTraversal(node);
    }

    private static void testRedBlackTree() {
        System.out.println("============testRedBlackTree============");
        RedBlackTree<Integer> rb = new RedBlackTree<>(Integer::compareTo);
        RedBlackTreeNode<Integer> blackTreeNode = rb.insert(10).insert(5).insert(9).insert(3).insert(6).insert(7)
                .insert(19).insert(32).insert(24).insert(17).build();
        rb.list(blackTreeNode);
    }
}
