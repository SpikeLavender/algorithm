package com.natsumes.leetcode.array;

/**
 * 数组 + 双指针
 *
 * <a href="https://leetcode-cn.com/problems/next-permutation/">31.下一个排列</a>
 * @see ArrayTopic#nextPermutation(int[])
 *
 * <a href="https://leetcode-cn.com/problems/container-with-most-water/">11.盛最多水的容器</a>
 * @see ArrayTopic#maxArea(int[])
 *
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">42.接雨水</a>
 * @see ArrayTopic#trap(int[])
 *
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.寻找两个正序数组的中位数</a>
 * @see ArrayTopic#findMedianSortedArrays(int[], int[])
 *
 * @author hetengjiao
 */
public class ArrayTopic {

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

    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器。
     *
     * 示例 1：
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     *
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     *
     * 输入：height = [1,2,1]
     * 输出：2
     *
     *
     * 提示：
     *
     * n = height.length
     * 2 <= n <= 3 * 104
     * 0 <= height[i] <= 3 * 104
     *
     * @param height height
     * @return int
     * @see ArrayTopic
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int max = 0;

        while (left < right) {
            int area;
            if (height[left] <= height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            max = Math.max(area, max);
        }

        return max;
    }

    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/
     *
     * 42.接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例 1：
     *
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     *
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * 双指针法
     *
     * @param height height
     * @return int
     *
     * @see ArrayTopic#trap(int[]) 双指针法
     * @see ArrayTopic#trap02(int[]) 备忘录解法
     * @see ArrayTopic#trap01(int[]) 暴力解法
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int left = 0;
        int right = n - 1;

        int lMax = height[0];
        int rMax = height[n - 1];
        int res = 0;

        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * 备忘录解法
     *
     * @param height height
     * @return int
     */
    public int trap02(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] lMax = new int[len];
        int[]rMax = new int[len];
        lMax[0] = height[0];
        rMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    /**
     * 暴力解法
     *
     * @param height height
     * @return int
     */
    public int trap01(int[] height) {
        int len = height.length;
        int res = 0;
        int lMax = 0;
        int rMax = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (height[j] > rMax) {
                    rMax = height[j];
                }
            }
            for (int j = i; j >= 0; j--) {
                if (height[j] > lMax) {
                    lMax = height[j];
                }
            }
            res += Math.min(lMax, rMax) - height[i];
        }
        return res;
    }

    /**
     * 4.寻找两个正序数组的中位数
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     *
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     *
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     *
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     *
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     *
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @return double
     * @see ArrayTopic
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = m;
        // median1: 前一部分最大值
        // median2: 后一部分最小值
        int median1 = 0, median2 = 0;
        while (left <= right) {
            // 前一部分包含 nums1[0...i-1]和nums2[0...j-1]
            // 后一部分包含 nums1[i...m-1]和nums2[j...n-1]
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i;
            // nums1[i - 1]
            int num1l = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            // nums1[i]
            int num1R = (i == m ? Integer.MAX_VALUE : nums1[i]);
            // nums2[j - 1]
            int num2L = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            // nums2[j]
            int num2R = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (num1l <= num2R) {
                median1 = Math.max(num1l, num2L);
                median2 = Math.min(num1R, num2R);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
