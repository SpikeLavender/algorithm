package com.natsumes.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class ByteDanceTest {

    private ByteDance bd = new ByteDance();

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("aba", bd.longestPalindrome("babad"));
        Assert.assertEquals("bb", bd.longestPalindrome("cbbd"));
        Assert.assertEquals("a", bd.longestPalindrome("a"));
        Assert.assertEquals("c", bd.longestPalindrome("ac"));
    }

    @Test
    public void findLastRightNode() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), new TreeNode(8)), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(9))
        );
        Assert.assertEquals(8, bd.findLastRightNode(treeNode).val);

        treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(7), new TreeNode(8)),
                        new TreeNode(5, new TreeNode(10), new TreeNode(11))
                ),
                new TreeNode(3,
                        new TreeNode(6, new TreeNode(12), null),
                        new TreeNode(9)
                )
        );
        Assert.assertEquals(12, bd.findLastRightNode(treeNode).val);
    }

    @Test
    public void countBalls() {
        Assert.assertEquals(2, bd.countBalls(1, 10));
        Assert.assertEquals(2, bd.countBalls(5, 15));
        Assert.assertEquals(2, bd.countBalls(19, 28));
    }

    @Test
    public void checkPartitioning() {
        Assert.assertTrue(bd.checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv"));
        Assert.assertTrue(bd.checkPartitioning("aaa"));
        Assert.assertTrue(bd.checkPartitioning("aac"));
        Assert.assertTrue(bd.checkPartitioning("abcbdd"));
        Assert.assertFalse(bd.checkPartitioning("aa"));
        Assert.assertFalse(bd.checkPartitioning("bcbddxy"));
    }

    @Test
    public void restoreArray() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, bd.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}}));
        Assert.assertArrayEquals(new int[]{-2, 4, 1, -3}, bd.restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}}));
        Assert.assertArrayEquals(new int[]{100000, -100000}, bd.restoreArray(new int[][]{{100000, -100000}}));
    }

    @Test
    public void rightSideView() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(4)
                )
        );
        List<Integer> list = bd.rightSideView(treeNode);
        System.out.println(list);
        //Assert.assertEquals(12, bd.findLastRightNode(treeNode).val);
    }

    @Test
    public void findMedianSortedArrays() {
        Assert.assertEquals(2.0d, bd.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0.0);
        Assert.assertEquals(2.5d, bd.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0.0);
        Assert.assertEquals(0.0d, bd.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}), 0.0);
        Assert.assertEquals(1.0d, bd.findMedianSortedArrays(new int[] {}, new int[] {1}), 0.0);
        Assert.assertEquals(2.0d, bd.findMedianSortedArrays(new int[] {2}, new int[] {}), 0.0);
    }
}