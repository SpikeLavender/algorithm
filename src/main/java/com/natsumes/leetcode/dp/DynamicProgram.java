package com.natsumes.leetcode.dp;

import java.util.Arrays;

/**
 * 动态规划
 *
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">300.最长递增子序列</a>
 * @see DynamicProgram#lengthOfLIS(int[])
 * @see DynamicProgram#patienceSorting(int[])
 *
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a>
 * @see DynamicProgram#maxSubArray(int[])
 *
 * @author hetengjiao
 */
public class DynamicProgram {

    /**
     * 300. 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     * @param nums nums
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] = max(dp[i], dp[j] + 1)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * 耐心排序
     *
     * @param nums nums
     * @return int
     */
    public int patienceSorting(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int heap = nums[i];
            int left = 0;
            int right = count;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= heap) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == count) {
                count++;
            }
            top[left] = heap;
        }
        return count;
    }

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     *
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     * dp[i] = max(nums[i] + dp[i - 1]), dp[0] = nums[0]
     *
     * @param nums nums
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = nums[0];
        int dp1;
        int res = dp0;

        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp0);
        }
        return res;
    }
}
