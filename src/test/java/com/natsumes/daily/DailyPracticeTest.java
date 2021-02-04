package com.natsumes.daily;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class DailyPracticeTest {

    private static DailyPractice dp = new DailyPractice();

    @Test
    public void isIsomorphic() {
        Assert.assertTrue(dp.isIsomorphic("egg", "add"));
        Assert.assertFalse(dp.isIsomorphic("foo", "bar"));
        Assert.assertTrue(dp.isIsomorphic("paper", "title"));
        Assert.assertFalse(dp.isIsomorphic("aa", "ab"));
        Assert.assertFalse(dp.isIsomorphic("ab", "aa"));
    }

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0' , '0'},
                {'1', '0', '1', '1' , '1'},
                {'1', '1', '1', '1' , '1'},
                {'1', '0', '0', '1' , '0'}
        };

        Assert.assertEquals(6, dp.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {};
        Assert.assertEquals(0, dp.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0'}};
        Assert.assertEquals(0, dp.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'1'}};
        Assert.assertEquals(1, dp.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0', '0'}};
        Assert.assertEquals(0, dp.doMaximalRectangleCommon(matrix));
    }

    @Test
    public void findContentChildren() {
        Assert.assertEquals(2, dp.findContentChildren(new int[]{7, 8, 9, 10}, new int[]{5, 6, 7, 8}));
        Assert.assertEquals(1, dp.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        Assert.assertEquals(2, dp.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        Assert.assertEquals(1, dp.findContentChildren(new int[]{1, 2, 3}, new int[]{4}));
    }

    @Test
    public void lastStoneWeight() {
        Assert.assertEquals(1, dp.lastStoneWeight(new int[] {2,7,4,1,8,1}));
        Assert.assertEquals(2, dp.lastStoneWeight(new int[] {1,3}));
    }

    @Test
    public void canPlaceFlowers() {
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{0,1,0}, 1));
        Assert.assertTrue(dp.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{1,0,0,0,0,1}, 2));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{1}, 1));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{1,0}, 1));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{0,1}, 1));
        Assert.assertFalse(dp.canPlaceFlowers(new int[]{}, 1));
        Assert.assertTrue(dp.canPlaceFlowers(new int[]{0}, 1));
        Assert.assertTrue(dp.canPlaceFlowers(new int[]{0,0}, 1));
    }

    @Test
    public void testEraseOverlapIntervals() {
        Assert.assertEquals(1, dp.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        Assert.assertEquals(2, dp.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        Assert.assertEquals(0, dp.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        Assert.assertEquals(0, dp.eraseOverlapIntervals(new int[][]{{0, 1}, {3, 4}, {1, 2}}));
        Assert.assertEquals(2, dp.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }

    @Test
    public void maxSlidingWindow() {
        Assert.assertArrayEquals(new int[] {3,3,5,5,6,7}, dp.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        Assert.assertArrayEquals(new int[] {1}, dp.maxSlidingWindow(new int[]{1}, 1));
        Assert.assertArrayEquals(new int[] {1,-1}, dp.maxSlidingWindow(new int[]{1,-1}, 1));
        Assert.assertArrayEquals(new int[] {11}, dp.maxSlidingWindow(new int[]{9,11}, 2));
        Assert.assertArrayEquals(new int[] {4}, dp.maxSlidingWindow(new int[]{4,-2}, 2));
    }

    @Test
    public void partition() {
        DailyPractice.ListNode listNode = new DailyPractice.ListNode(1);
        listNode.next = new DailyPractice.ListNode(4);
        listNode.next.next = new DailyPractice.ListNode(3);
        listNode.next.next.next = new DailyPractice.ListNode(2);
        listNode.next.next.next.next = new DailyPractice.ListNode(5);
        listNode.next.next.next.next.next = new DailyPractice.ListNode(2);
        DailyPractice.ListNode node = dp.partition(listNode, 3);
        System.out.println(node);
    }

    @Test
    public void testFib() {
        Assert.assertEquals(1, dp.fib(2));
        Assert.assertEquals(2, dp.fib(3));
        Assert.assertEquals(3, dp.fib(4));
    }

    @Test
    public void testLargeGroupPositions() {
        System.out.println(dp.largeGroupPositions("abbxxxxzzy"));
        System.out.println(dp.largeGroupPositions("abc"));
        System.out.println(dp.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(dp.largeGroupPositions("aba"));
        System.out.println(dp.largeGroupPositions("aaa"));
        System.out.println(dp.largeGroupPositions("aa"));
    }

    @Test
    public void rotate() {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        dp.rotate( nums, 3);
        Assert.assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, nums);

        nums = new int[] {-1, -100, 3, 99};
        dp.rotate( nums, 2);
        Assert.assertArrayEquals(new int[] {3, 99, -1, -100}, nums);

    }

    @Test
    public void fairCandySwap() {
        Assert.assertArrayEquals(new int[] {1, 2}, dp.fairCandySwap(new int[] {1, 1}, new int[] {2, 2}));
        Assert.assertArrayEquals(new int[] {1, 2}, dp.fairCandySwap(new int[] {1, 2}, new int[] {2, 3}));
        Assert.assertArrayEquals(new int[] {2, 3}, dp.fairCandySwap(new int[] {2}, new int[] {1, 3}));
        Assert.assertArrayEquals(new int[] {5, 4}, dp.fairCandySwap(new int[] {1, 2, 5}, new int[] {2, 4}));
    }

    @Test
    public void characterReplacement() {
        Assert.assertEquals(4, dp.characterReplacement("ABBB", 2));
        Assert.assertEquals(2, dp.characterReplacement("ABAA", 0));
        Assert.assertEquals(4, dp.characterReplacement("ABAB", 2));
        Assert.assertEquals(4, dp.characterReplacement("AABABBA", 1));
        Assert.assertEquals(1, dp.characterReplacement("A", 1));
        Assert.assertEquals(4, dp.characterReplacement("AACABBA", 1));
        Assert.assertEquals(4, dp.characterReplacement("AABABCBB", 1));
        Assert.assertEquals(6, dp.characterReplacement("AABBBABB", 1));
    }

    @Test
    public void findMaxAverage() {
        Assert.assertEquals(12.75, dp.findMaxAverage(new int[] {1, 12, -5, -6,50, 3}, 4), 0.0001);
    }
}