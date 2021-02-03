package com.natsumes.leetcode.dp;

/**
 * 动态规划
 *
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a>
 * @see DynamicProgram#maxSubArray(int[])
 *
 * @author hetengjiao
 */
public class DynamicProgram {
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
