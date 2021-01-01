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
        int left1 = 0;
        int left2 = 0;
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;
        // mid = mid1 + mid2
        // mid2 = mid - mid1
        // [1, 5, 7] [2, 3, 4, 6, 8, 9]
        // [1, 2, 3] [4, 5, 6, 7, 8, 9]
        int mid1 = left1 + (right1 - left1) / 2;
        int mid2 = left2 + (right2 - left2) / 2;
        while (left1 < right1 && left2 < right2) {
            mid1 = left1 + (right1 - left1) / 2;
            mid2 = left2 + (right2 - left2) / 2;
            if (nums1[mid1] <= nums2[mid2]) {
                left1 = mid1;
                right2 = mid2;
            } else {
                right1 = mid1;
                left2 = mid2;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            System.out.println(mid1);
            System.out.println(mid2);
        } else {

        }
        return 0;
    }
}
