package com.natsumes.leetcode.topic;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class ArraySeriesTest {

    private final ArraySeries as = new ArraySeries();

    @Test
    public void moveZeroes() {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        as.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {1, 3, 12, 0, 0}, nums);

        nums = new int[] {1, 0};
        as.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {1, 0}, nums);

        nums = new int[] {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        as.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {4, 2, 4, 3, 5, 1, 0, 0, 0, 0}, nums);

        nums = new int[] {0};
        as.moveZeroes(nums);
        Assert.assertArrayEquals(new int[] {0}, nums);
    }

}