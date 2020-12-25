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
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        BST.recoverTree(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        BST.recoverTree(node);
        Assert.assertEquals(2, node.val);
    }

    @Test
    public void recoverTree1() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        BST.doRecoverTree1(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        BST.doRecoverTree1(node);
        Assert.assertEquals(2, node.val);
    }

    @Test
    public void recoverTree2() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        BST.doRecoverTree2(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        BST.doRecoverTree2(node);
        Assert.assertEquals(2, node.val);
    }
}