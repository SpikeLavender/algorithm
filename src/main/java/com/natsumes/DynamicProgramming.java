package com.natsumes;

/**
 * 动态规划问题大全
 *
 * @author hetengjiao
 */
public class DynamicProgramming {


    /**
     * 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有 n 阶台阶，小孩一次可以上 1 阶、2 阶或 3 阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。
     * 结果可能很大，你需要对结果模 1000000007。
     *
     * 示例
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     *
     * 输入：n = 5
     * 输出：13
     *
     * n 范围在 [1, 1000000] 之间
     *
     * @param n     台阶数
     * @return 走法
     */
    private static int waysToStep(int n) {
        int mod = 1000000007;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            if (i >= 2) f[i] = (f[i] + f[i - 2]) % mod;
            if (i >= 3) f[i] = (f[i] + f[i - 3]) % mod;
        }
        return f[n];
    }

    /**
     * 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * f[i][j] = [i][j] + min(f[i-1][j], f[i][j-1])
     *
     * @param grid     二维数组
     * @return sums
     */
    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int tp = Integer.MAX_VALUE;
                if (i > 0) tp = Math.min(tp, grid[i - 1][j]);
                if (j > 0) tp = Math.min(tp, grid[i][j - 1]);
                grid[i][j] += tp;
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 示例
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * nums[i] > 0:
     * f[i] = max(f[i-1] * nums[i], nums[i]);
     *
     * nums[i] <= 0:
     * f[i] = max([以i-1为右端点的连续区间的最小乘积] * nums[i], nums[i]);
     *
     * @param nums  整数数组
     * @return res
     */
    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int[] maxn = new int[n];
        int[] minn = new int[n];
        maxn[0] = minn[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                maxn[i] = Math.max(nums[i], nums[i] * maxn[i - 1]);
                minn[i] = Math.min(nums[i], nums[i] * minn[i - 1]);
            } else {
                maxn[i] = Math.max(nums[i], nums[i] * minn[i - 1]);
                minn[i] = Math.min(nums[i], nums[i] * maxn[i - 1]);
            }
            ans = Math.max(ans, maxn[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(waysToStep(5));

        int[][] grid = new int[3][3];
        grid[0][0] = 1;
        grid[0][1] = 3;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 5;
        grid[1][2] = 1;
        grid[2][0] = 4;
        grid[2][1] = 2;
        grid[2][2] = 1;

        int minPathSum = minPathSum(grid);
        System.out.println(minPathSum);

        int[] nums1 = {2,3,-2,4};
        System.out.println(maxProduct(nums1));

        int[] nums2 = {-2,0,-1};
        System.out.println(maxProduct(nums2));
    }
}
