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

    @Test
    public void testSearchBST() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = BST.isValidBST(root);
        System.out.println(validBST);
        TreeNode treeNode = BST.searchBST(root, 3);
        Assert.assertNotNull(treeNode);
    }

    @Test
    public void testInsertIntoBST() {
        TreeNode node;
        node = BST.insertIntoBST(null, 4);
        node = BST.insertIntoBST(node, 2);
        node = BST.insertIntoBST(node, 1);
        node = BST.insertIntoBST(node, 3);
        node = BST.insertIntoBST(node, 7);
        node = BST.insertIntoBST(node, 5);
        System.out.println(node);
    }

    @Test
    public void deleteNode() {
        TreeNode node;
        node = BST.insertIntoBST(null, 4);
        node = BST.insertIntoBST(node, 2);
        node = BST.insertIntoBST(node, 1);
        node = BST.insertIntoBST(node, 3);
        node = BST.insertIntoBST(node, 7);
        node = BST.insertIntoBST(node, 5);
        System.out.println(node);
        BST.deleteNode(node, 1);
        System.out.println(node);
    }

    @Test
    public void KthLargest() {
        int[] nums = new int[] {4, 5, 8, 2};
        BinarySearchTreeTopic.KthLargest kthLargest = new BinarySearchTreeTopic.KthLargest(3, nums);
        int res = kthLargest.add(3);   // return 4
        System.out.println(res);
        Assert.assertEquals(4, res);
        res = kthLargest.add(5);   // return 5
        System.out.println(res);
        Assert.assertEquals(5, res);
        res = kthLargest.add(10);  // return 5
        System.out.println(res);
        Assert.assertEquals(5, res);
        res = kthLargest.add(9);   // return 8
        System.out.println(res);
        Assert.assertEquals(8, res);
        res = kthLargest.add(4);   // return 8
        System.out.println(res);
        Assert.assertEquals(8, res);
    }

    @Test
    public void KthLargest2() {
        int[] nums = new int[] {};
        BinarySearchTreeTopic.KthLargest kthLargest = new BinarySearchTreeTopic.KthLargest(1, nums);
        int res = kthLargest.add(-3);   // return 4
        System.out.println(res);
        Assert.assertEquals(-3, res);
        res = kthLargest.add(-2);   // return 5
        System.out.println(res);
        Assert.assertEquals(-2, res);
        res = kthLargest.add(-4);  // return 5
        System.out.println(res);
        Assert.assertEquals(-2, res);
        res = kthLargest.add(0);   // return 8
        System.out.println(res);
        Assert.assertEquals(0, res);
        res = kthLargest.add(4);   // return 8
        System.out.println(res);
        Assert.assertEquals(4, res);
    }
}