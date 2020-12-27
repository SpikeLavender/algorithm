package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class BinaryTreeTopicTest {

    private static BinaryTreeTopic BT = new BinaryTreeTopic();

    @Test
    public void codec() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        BinaryTreeTopic.Codec codec = BT.codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }


    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    @Test
    public void buildTree() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = BT.buildTree01(preorder, inorder);

        System.out.println(treeNode.toString());
    }

    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    @Test
    public void buildTree02() {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = BT.buildTree02(inorder, postorder);

        System.out.println(treeNode.toString());
    }

    /**
     * 1 / \ 2   5 / \   \ 3   4   6
     */
    @Test
    public void flatten() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        BT.flatten(root);
        System.out.println(root);
    }

    @Test
    public void maxPathSum() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = BT.maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void preorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = BT.preorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = BT.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void postorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = BT.postorderTraversal(root);
        System.out.println(list);
    }


    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = BT.levelOrder(root);
        System.out.println(lists);
    }

    @Test
    public void maxDepth() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = BT.maxDepth(root);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }

    @Test
    public void isSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean i = BT.isSymmetric(root);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = BT.isSymmetric(root);
        System.out.println(i);
        Assert.assertFalse(i);
    }

    /**
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     */
    @Test
    public void hasPathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, null, new TreeNode(1));
        boolean i = BT.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = BT.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertFalse(i);
    }

    @Test
    public void connect() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, new Node(6), new Node(7), null);
        Node node = BT.connect(root);
        System.out.println(node);
    }

    @Test
    public void connect2() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);
        Node node = BT.connect2(root);
        System.out.println(node);
    }

    @Test
    public void lowestCommonAncestor() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode node = BT.lowestCommonAncestor(root, p, q);
        int res = node == null ? -1 : node.val;
        System.out.println(res);
        Assert.assertEquals(3, res);
    }

    /**
     *          4
     *        /   \
     *       2     7
     *      / \   / \
     *     1   3 6   9
     */
    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode treeNode = BT.invertTree(root);
        System.out.println(treeNode);
    }


    @Test
    public void mirrorTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = BT.mirrorTree(root);
        System.out.println(treeNode);
    }

    @Test
    public void diameterOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Assert.assertEquals(3, BT.diameterOfBinaryTree(root));
    }

    @Test
    public void isUnivalTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        Assert.assertTrue(BT.isUnivalTree(root));

        Assert.assertTrue(BT.isUnivalTree(null));
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        Assert.assertFalse(BT.isUnivalTree(root));
    }

    @Test
    public void mergeTrees() {
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        TreeNode node = BT.mergeTrees(t1, t2);
        System.out.println(node);
        Assert.assertEquals(3, node.val);
    }

    @Test
    public void mergeTrees0() {
//        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
//        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
//                new TreeNode(3, null, new TreeNode(7)));
//        TreeNode node = BT.mergeTrees0(t1, t2);
//        System.out.println(node);
//        Assert.assertEquals(3, node.val);
    }
}