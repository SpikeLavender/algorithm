package com.natsumes.company;

import org.junit.Assert;
import org.junit.Test;

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
        Node node = new Node(1,
                new Node(2, new Node(4, new Node(7), new Node(8)), new Node(5)),
                new Node(3, new Node(6), new Node(9))
        );
        Assert.assertEquals(8, bd.findLastRightNode(node).val);

        node = new Node(1,
                new Node(2,
                        new Node(4, new Node(7), new Node(8)),
                        new Node(5, new Node(10), new Node(11))
                ),
                new Node(3,
                        new Node(6, new Node(12), null),
                        new Node(9)
                )
        );
        Assert.assertEquals(12, bd.findLastRightNode(node).val);
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
}