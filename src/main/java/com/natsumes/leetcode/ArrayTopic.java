package com.natsumes.leetcode;

/**
 * @author hetengjiao
 */
public class ArrayTopic {

    /**
     * 4. 寻找两个正序数组的中位数
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
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int totalNum = len1 + len2;
        if (totalNum % 2 == 0) {
            int mid1 = totalNum / 2 - 1, mid2 = totalNum / 2;
            return (getKthElement(nums1, nums2, mid1 + 1)
                    + getKthElement(nums1, nums2, mid2 + 1)) / 2;
        } else {
            int mid = totalNum / 2;
            return getKthElement(nums1, nums2, mid + 1);
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int index) {
        return 0;
    }
}
