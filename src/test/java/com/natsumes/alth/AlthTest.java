package com.natsumes.alth;

import com.natsumes.alth.back.NQueens;
import com.natsumes.alth.divide.CharUpCase;
import com.natsumes.alth.divide.Pow;
import com.natsumes.alth.greedy.Goods;
import com.natsumes.alth.greedy.GreedyBag;
import org.junit.Assert;
import org.junit.Test;

import static com.natsumes.alth.dp.DynamicProgramming.*;

/**
 * @author hetengjiao
 */
public class AlthTest {

    @Test
    public void testGreedy() {
        GreedyBag bag = new GreedyBag();
        Goods goods1 = new Goods("A", 10, 60);
        Goods goods2 = new Goods("B", 20, 100);
        Goods goods3 = new Goods("C", 30, 120);
        Goods[] goods = {goods2, goods3, goods1};

        bag.setMax(50);
        bag.getMaxValue(goods);
    }

    @Test
    public void testToUpCase() {
        String s = "hello";
        char[] chars = CharUpCase.toUpCase(s.toCharArray(), 0);
        System.out.println(chars);
        Assert.assertEquals("HELLO", String.valueOf(chars));
    }

    @Test
    public void testCommonPow() {
        long i = Pow.commomPow(2, 32);
        System.out.println(i);
        Assert.assertEquals(4294967296L, i);
    }

    @Test
    public void testPow() {
        long i = Pow.pow(2, 32);
        System.out.println(i);
        Assert.assertEquals(4294967296L, i);
    }

    @Test
    public void testNQueen() {
        NQueens queens = new NQueens();
        queens.setQueens(0);
    }


    @Test
    public void testDp() {
        System.out.println(waysToStep(5));

        int[][] grid = {{1, 3, 1},{1, 5, 1},{4, 2, 1}};

        int minPathSum = minPathSum(grid);
        System.out.println(minPathSum);

        int[] nums1 = {2,3,-2,4};
        System.out.println(maxProduct(nums1));

        int[] nums2 = {-2,0,-1};
        System.out.println(maxProduct(nums2));

        int[] nums3 = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums3));

        System.out.println(longestCommonSubSequence("abcde", "ace"));
        System.out.println(longestCommonSubSequence("abc", "def"));

        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(minimumTotal(triangle));

        int[] robs1 = {1,2,3,1};
        System.out.println(rob(robs1));
        int[] robs2 = {2,7,9,3,1};
        System.out.println(rob(robs2));

        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));

        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("intention", "execution"));

        int[] nums4 = {1, 5, 11, 5};
        System.out.println(canPartition(nums4));
        int[] nums5 = {1, 2, 3, 5};
        System.out.println(canPartition(nums5));

        int[] nums6 = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums6, 3));

        int[] coins1 = {1, 2, 5};
        System.out.println(coinChange(coins1, 11));
        int[] coins2 = {2};
        System.out.println(coinChange(coins2, 3));

        int[] coins3 = {1, 2, 5};
        System.out.println(coinChange2(coins3, 5));
        int[] coins4 = {2};
        System.out.println(coinChange2(coins4, 3));
        int[] coins5 = {10};
        System.out.println(coinChange2(coins5, 10));

        String[] array1 = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(array1, 5, 3));
        String[] array2 = {"10", "0", "1"};
        System.out.println(findMaxForm(array2, 1, 1));
    }
}
