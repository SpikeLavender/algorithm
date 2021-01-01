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
}