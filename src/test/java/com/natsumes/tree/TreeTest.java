package com.natsumes.tree;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class TreeTest {

    @Test
    public void testBinaryTree() {
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

    @Test
    public void testRedBlackTree() {
        System.out.println("============testRedBlackTree============");
        RedBlackTree<Integer> rb = new RedBlackTree<>(Integer::compareTo);
        RedBlackNode<Integer> blackTreeNode = rb.insert(10).insert(5).insert(5).insert(9).insert(3).insert(6).insert(7)
                .insert(19).insert(32).insert(24).insert(17).insert(9).insert(32).build();
        rb.list(blackTreeNode);
    }
}
