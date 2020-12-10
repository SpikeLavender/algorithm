package com.natsumes.leetcode;

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
}