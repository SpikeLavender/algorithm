package com.natsumes.leetcode.array;

/**
 * 前缀和
 *
 * <a href="https://leetcode-cn.com/problems/range-sum-query-immutable/">303.区域和检索 - 数组不可变</a>
 * {@link NumArray}
 *
 * <a href="https://leetcode-cn.com/problems/range-sum-query-2d-immutable/">304.二维区域和检索 - 矩阵不可变</a>
 * {@link NumMatrix}
 *
 * @author hetengjiao
 */
public class PrefixSum {

    /**
     * 303. 区域和检索 - 数组不可变
     * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
     *
     * 实现 NumArray 类：
     *
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，
     * 包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
     *
     *
     * 示例：
     *
     * 输入：
     * ["NumArray", "sumRange", "sumRange", "sumRange"]
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * 输出：
     * [null, 1, -1, -3]
     *
     * 解释：
     * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
     * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
     * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
     * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 104
     * -105 <= nums[i] <= 105
     * 0 <= i <= j < nums.length
     * 最多调用 104 次 sumRange 方法
     */
    public static class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            this.sums = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                this.sums[i] = nums[i - 1] + sums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    /**
     * 304. 二维区域和检索 - 矩阵不可变
     * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
     *
     * Range Sum Query 2D
     * 上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
     *
     * 示例:
     *
     * 给定 matrix = [
     *   [3, 0, 1, 4, 2],
     *   [5, 6, 3, 2, 1],
     *   [1, 2, 0, 1, 5],
     *   [4, 1, 0, 1, 7],
     *   [1, 0, 3, 0, 5]
     * ]
     *
     * sumRegion(2, 1, 4, 3) -> 8
     * sumRegion(1, 1, 2, 2) -> 11
     * sumRegion(1, 2, 2, 4) -> 12
     * 说明:
     *
     * 你可以假设矩阵不可变。
     * 会多次调用 sumRegion 方法。
     * 你可以假设 row1 ≤ row2 且 col1 ≤ col2。
     */
    public static class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            this.sum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = matrix[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
        }
    }

}
