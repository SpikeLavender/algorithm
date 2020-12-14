package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class BinarySearchTreeTopicTest {

    private static BinarySearchTreeTopic BST = new BinarySearchTreeTopic();

    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = BST.isValidBST(root);
        Assert.assertTrue(validBST);

        TreeNode node = new TreeNode(5, new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBSTFalse = BST.isValidBST(node);
        Assert.assertFalse(validBSTFalse);
    }

    @Test
    public void isValidBST2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = BST.isValidBST2(root);
        Assert.assertTrue(validBST);

        TreeNode node = new TreeNode(5, new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBSTFalse = BST.isValidBST2(node);
        Assert.assertFalse(validBSTFalse);
    }

    @Test
    public void recoverTree() {
    }
}