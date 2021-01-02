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

    @Test
    public void removeElement() {
        int[] nums = new int[] {3, 2, 2, 3};
        int element = as.removeElement(nums, 3);
        Assert.assertArrayEquals(new int[] {2, 2, 2, 3}, nums);
        Assert.assertEquals(2, element);

        nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        element = as.removeElement(nums, 2);
        Assert.assertArrayEquals(new int[] {0, 1, 4, 0, 3, 0, 4, 2}, nums);
        Assert.assertEquals(5, element);

        nums = new int[] {1};
        element = as.removeElement(nums, 1);
        Assert.assertArrayEquals(new int[] {1}, nums);
        Assert.assertEquals(0, element);
    }
}