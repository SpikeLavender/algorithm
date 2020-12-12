package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class LeetCodeTest {

    private LeetCode lt = new LeetCode();

    @Test
    public void randomPick() {
        // 初始化一个单链表 [1,2,3].
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LeetCode.RandomPick solution = lt.randomPick(head);

        // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
        for (int i = 0; i < 100; i++) {
            System.out.print(solution.getRandom() + " ");
        }
    }

    @Test
    public void randomArrPick() {
        // 初始化一个单链表 [1,2,3].
        LeetCode.RandomArrPick solution = lt.randomArrPick(new int[]{1, 2, 3, 4, 5, 6});
        // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
        for (int i = 0; i < 200; i++) {
            System.out.print(solution.randomGet() + " ");
        }
    }

    @Test
    public void permute() {
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> permute = lt.permute(nums);
        System.out.println(permute);
    }

    @Test
    public void permuteUnique() {
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> permute = lt.permuteUnique(nums);
        System.out.println(permute);
        nums = new int[] {1, 1, 2};
        permute = lt.permuteUnique(nums);
        System.out.println(permute);
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

        TreeNode treeNode = lt.invertTree(root);
        System.out.println(treeNode);
    }

    @Test
    public void codec() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        LeetCode.Codec codec = lt.codec();
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
        TreeNode treeNode = lt.buildTree01(preorder, inorder);

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
        TreeNode treeNode = lt.buildTree02(inorder, postorder);

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
        lt.flatten(root);
        System.out.println(root);
    }

    @Test
    public void maxPathSum() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = lt.maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void preorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = lt.preorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = lt.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void postorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = lt.postorderTraversal(root);
        System.out.println(list);
    }


    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = lt.levelOrder(root);
        System.out.println(lists);
    }

    @Test
    public void maxDepth() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = lt.maxDepth(root);
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
        boolean i = lt.isSymmetric(root);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = lt.isSymmetric(root);
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
        boolean i = lt.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = lt.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertFalse(i);
    }

    @Test
    public void connect() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, new Node(6), new Node(7), null);
        Node node = lt.connect(root);
        System.out.println(node);
    }

    @Test
    public void connect2() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);
        Node node = lt.connect2(root);
        System.out.println(node);
    }
}