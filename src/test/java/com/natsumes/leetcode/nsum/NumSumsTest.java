package com.natsumes.leetcode.nsum;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class NumSumsTest {

    private final NumSums ns = new NumSums();

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(new int[]{0, 1}, ns.twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{1, 2}, ns.twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[]{0, 1}, ns.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    public void twoSum2() {
        List<List<Integer>> lists = ns.twoSumTarget(new int[]{2, 7, 11, 15}, 0, 9);
        System.out.println(lists);
    }

    @Test
    public void threeSum() {
        List<List<Integer>> lists = ns.threeSum(new int[]{1, 2, -2, -1});
        System.out.println(lists);

        lists = ns.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

        lists = ns.threeSum(new int[]{});
        System.out.println(lists);

        lists = ns.threeSum(new int[]{0});
        System.out.println(lists);

        lists = ns.threeSum(new int[]{0, 0});
        System.out.println(lists);
    }

    @Test
    public void fourSum() {
        List<List<Integer>> lists = ns.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(lists);
    }
}