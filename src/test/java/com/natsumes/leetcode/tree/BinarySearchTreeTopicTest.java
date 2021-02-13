package com.natsumes.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class BinarySearchTreeTopicTest {

    private static BinarySearchTreeTopic bst = new BinarySearchTreeTopic();

    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = bst.isValidBST(root);
        Assert.assertTrue(validBST);

        TreeNode node = new TreeNode(5, new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBSTFalse = bst.isValidBST(node);
        Assert.assertFalse(validBSTFalse);
    }

    @Test
    public void isValidBST2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = bst.isValidBST2(root);
        Assert.assertTrue(validBST);

        TreeNode node = new TreeNode(5, new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        boolean validBSTFalse = bst.isValidBST2(node);
        Assert.assertFalse(validBSTFalse);
    }

    @Test
    public void recoverTree() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        bst.recoverTree(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        bst.recoverTree(node);
        Assert.assertEquals(2, node.val);
    }

    @Test
    public void recoverTree1() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        bst.doRecoverTree1(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        bst.doRecoverTree1(node);
        Assert.assertEquals(2, node.val);
    }

    @Test
    public void recoverTree2() {
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        bst.doRecoverTree2(root);
        Assert.assertEquals(3, root.val);

        TreeNode node = new TreeNode(3, new TreeNode(1),
                new TreeNode(4, new TreeNode(2), null));
        bst.doRecoverTree2(node);
        Assert.assertEquals(2, node.val);
    }

    @Test
    public void testSearchBST() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean validBST = bst.isValidBST(root);
        System.out.println(validBST);
        TreeNode treeNode = bst.searchBST(root, 3);
        Assert.assertNotNull(treeNode);
    }

    @Test
    public void testInsertIntoBST() {
        TreeNode node;
        node = bst.insertIntoBST(null, 4);
        node = bst.insertIntoBST(node, 2);
        node = bst.insertIntoBST(node, 1);
        node = bst.insertIntoBST(node, 3);
        node = bst.insertIntoBST(node, 7);
        node = bst.insertIntoBST(node, 5);
        System.out.println(node);
    }

    @Test
    public void deleteNode() {
        TreeNode node;
        node = bst.insertIntoBST(null, 4);
        node = bst.insertIntoBST(node, 2);
        node = bst.insertIntoBST(node, 1);
        node = bst.insertIntoBST(node, 3);
        node = bst.insertIntoBST(node, 7);
        node = bst.insertIntoBST(node, 5);
        System.out.println(node);
        bst.deleteNode(node, 1);
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

    @Test
    public void isBalanced01() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertTrue(bst.isBalanced01(root));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)),
                new TreeNode(3)), new TreeNode(2));
        Assert.assertFalse(bst.isBalanced01(root));
    }

    @Test
    public void isBalanced() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertTrue(bst.isBalanced(root));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)),
                new TreeNode(3)), new TreeNode(2));
        Assert.assertFalse(bst.isBalanced(root));
    }

    @Test
    public void sortedArrayToBST() {
        TreeNode node = bst.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }

    @Test
    public void containsNearbyAlmostDuplicate() {
        Assert.assertTrue(bst.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 1}, 3, 0));
        Assert.assertTrue(bst.containsNearbyAlmostDuplicate(new int[] {1, 0, 1, 1}, 1, 2));
        Assert.assertFalse(bst.containsNearbyAlmostDuplicate(new int[] {1, 5, 9, 1, 5, 9}, 2, 3));
        Assert.assertTrue(bst.containsNearbyAlmostDuplicate(new int[] {-2147483648, -2147483647}, 3, 3));
        Assert.assertTrue(bst.containsNearbyAlmostDuplicate(new int[] {2147483640, 2147483641}, 1, 100));
        Assert.assertFalse(bst.containsNearbyAlmostDuplicate(new int[] {-2147483648, 2147483647}, 1, 1));
    }

    @Test
    public void kthLargest1() {

        TreeNode root = new TreeNode(5, new TreeNode(3 ,
                new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                new TreeNode(6));
        Assert.assertEquals(6, bst.kthLargest(root, 1));
    }

    @Test
    public void generateTrees() {
        Assert.assertEquals(5, bst.generateTrees(3).size());
        Assert.assertEquals(1430, bst.generateTrees(8).size());
    }

    @Test
    public void numTrees() {
        Assert.assertEquals(5, bst.numTrees(3));
        Assert.assertEquals(1430, bst.numTrees(8));
    }
}