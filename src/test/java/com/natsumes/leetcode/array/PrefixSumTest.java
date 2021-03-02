package com.natsumes.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class PrefixSumTest {

    private final PrefixSum prefixSum = new PrefixSum();

    @Test
    public void numArray() {
        PrefixSum.NumArray numArray = new PrefixSum.NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, numArray.sumRange(0, 2));
        Assert.assertEquals(-1, numArray.sumRange(2, 5));
        Assert.assertEquals(-3, numArray.sumRange(0, 5));
    }

    @Test
    public void numMatrix() {
        PrefixSum.NumMatrix numMatrix = new PrefixSum.NumMatrix(new int[][]{
                    {3, 0, 1, 4, 2},
                    {5, 6, 3, 2, 1},
                    {1, 2, 0, 1, 5},
                    {4, 1, 0, 1, 7},
                    {1, 0, 3, 0, 5}
        });
        Assert.assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        Assert.assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        Assert.assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}