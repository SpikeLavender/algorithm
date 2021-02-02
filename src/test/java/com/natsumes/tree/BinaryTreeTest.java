package com.natsumes.tree;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class BinaryTreeTest {

    private static BinaryTree<Integer> btt = new BinaryTree<>(Integer::compareTo);

    private BinaryTree<Integer> tree = btt.insert(10).insert(8).insert(11).insert(7).insert(9).insert(12);

    @Test
    public void preOrderTraversal() {

        tree.preOrderTraversal();
    }

    @Test
    public void inOrderTraversal() {
        tree.inOrderTraversal();
    }

    @Test
    public void postOrderTraversal() {
        tree.postOrderTraversal();
    }

    @Test
    public void levelOrderTraversal() {
        tree.levelOrderTraversal();
    }


//    @Test
//    public void testRedBlackTree() {
//        System.out.println("============testRedBlackTree============");
//        RedBlackTree<Integer> rb = new RedBlackTree<>(Integer::compareTo);
//        TreeNode<Integer> blackTreeNode = rb.add(10).add(5).add(5).add(9).add(3).add(6).add(7)
//                .add(19).add(32).add(24).add(17).add(9).add(32).build();
//        rb.list(blackTreeNode);
//    }
}