package com.natsumes.daily;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class DailyPracticeTest {

    private static DailyPractice mr = new DailyPractice();

    @Test
    public void isIsomorphic() {
        Assert.assertTrue(mr.isIsomorphic("egg", "add"));
        Assert.assertFalse(mr.isIsomorphic("foo", "bar"));
        Assert.assertTrue(mr.isIsomorphic("paper", "title"));
        Assert.assertFalse(mr.isIsomorphic("aa", "ab"));
        Assert.assertFalse(mr.isIsomorphic("ab", "aa"));
    }

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0' , '0'},
                {'1', '0', '1', '1' , '1'},
                {'1', '1', '1', '1' , '1'},
                {'1', '0', '0', '1' , '0'}
        };

        Assert.assertEquals(6, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0'}};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'1'}};
        Assert.assertEquals(1, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0', '0'}};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));
    }

    @Test
    public void findContentChildren() {
        Assert.assertEquals(2, mr.findContentChildren(new int[]{7, 8, 9, 10}, new int[]{5, 6, 7, 8}));
        Assert.assertEquals(1, mr.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        Assert.assertEquals(2, mr.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        Assert.assertEquals(1, mr.findContentChildren(new int[]{1, 2, 3}, new int[]{4}));
    }

    @Test
    public void lastStoneWeight() {
        Assert.assertEquals(1, mr.lastStoneWeight(new int[] {2,7,4,1,8,1}));
        Assert.assertEquals(2, mr.lastStoneWeight(new int[] {1,3}));
    }

    @Test
    public void testEraseOverlapIntervals() {
        Assert.assertEquals(1, mr.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        Assert.assertEquals(2, mr.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        Assert.assertEquals(0, mr.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
        Assert.assertEquals(0, mr.eraseOverlapIntervals(new int[][]{{0, 1}, {3, 4}, {1, 2}}));
        Assert.assertEquals(2, mr.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
    }
}