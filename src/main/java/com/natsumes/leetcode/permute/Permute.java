package com.natsumes.leetcode.permute;

/**
 * ============================================================================
 * <h3>排列问题</h3>
 * ----------------------------------------------------------------------------
 *
 * <a href="https://leetcode-cn.com/problems/next-permutation/">31.下一个排列</a>
 * @see Permute#nextPermutation(int[])
 *
 * <a>46.全排列</a>
 *
 *
 * ============================================================================
 * @author hetengjiao
 */
public class Permute {

    /**
     * 31. 下一个排列
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     * 示例 4：
     *
     * 输入：nums = [1]
     * 输出：[1]
     * @param nums nums
     */
    public void nextPermutation(int[] nums) {
        // 找到最右边 134876923431586532
        int n = nums.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            // 逆序就行
            reverseArray(nums, 0, n - 1);
            return;
        }
        // i - 1 符合
        int j;
        for (j = n - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                break;
            }
        }
        int tmp = nums[j];
        nums[j] = nums[i - 1];
        nums[i - 1] = tmp;
        //逆序
        reverseArray(nums, i, n - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
