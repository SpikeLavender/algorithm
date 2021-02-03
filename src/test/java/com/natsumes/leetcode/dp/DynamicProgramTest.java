package com.natsumes.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class DynamicProgramTest {

    private final DynamicProgram dp = new DynamicProgram();

    @Test
    public void maxSubArray() {
        Assert.assertEquals(6, dp.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(1, dp.maxSubArray(new int[] {1}));
        Assert.assertEquals(0, dp.maxSubArray(new int[] {0}));
        Assert.assertEquals(-1, dp.maxSubArray(new int[] {-1}));
        Assert.assertEquals(-100000, dp.maxSubArray(new int[] {-100000}));
    }

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(4, dp.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, dp.lengthOfLIS(new int[] {0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, dp.lengthOfLIS(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void patienceSorting() {
        Assert.assertEquals(4, dp.patienceSorting(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, dp.patienceSorting(new int[] {0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, dp.patienceSorting(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }
}