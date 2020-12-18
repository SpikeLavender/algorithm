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
//        Node<Integer> blackTreeNode = rb.insert(10).insert(5).insert(5).insert(9).insert(3).insert(6).insert(7)
//                .insert(19).insert(32).insert(24).insert(17).insert(9).insert(32).build();
//        rb.list(blackTreeNode);
//    }
}