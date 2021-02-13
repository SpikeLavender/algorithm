package com.natsumes.leetcode.permute;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class PermuteTest {
    private final Permute pm = new Permute();
    @Test
    public void nextPermutation() {
        int[] nums = new int[] {1, 2, 3};
        pm.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 3, 2}, nums);

        nums = new int[] {3, 2, 1};
        pm.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 2, 3}, nums);

        nums = new int[] {1, 1, 5};
        pm.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 5, 1}, nums);

        nums = new int[] {1};
        pm.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1}, nums);

        nums = new int[] {1, 3, 4, 8, 7, 6, 9, 2, 3, 4, 3, 1, 5, 8, 6, 5, 3, 2};
        pm.nextPermutation(nums);
        Assert.assertArrayEquals(new int[] {1, 3, 4, 8, 7, 6, 9, 2, 3, 4, 3, 1, 6, 2, 3, 5, 5, 8}, nums);
    }

    @Test
    public void combinationSum() {
        List<List<Integer>> lists = pm.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);

        lists = pm.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}