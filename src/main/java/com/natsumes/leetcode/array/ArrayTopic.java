package com.natsumes.leetcode.array;

import java.util.Random;

/**
 * <h3>数组 + 双指针 + 二分查找</h3>
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">33.搜索旋转排序数组</a>
 * {@link ArrayTopic#search(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/container-with-most-water/">11.盛最多水的容器</a>
 * {@link ArrayTopic#maxArea(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">42.接雨水</a>
 * {@link ArrayTopic#trap(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.寻找两个正序数组的中位数</a>
 * {@link ArrayTopic#findMedianSortedArrays(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">215.数组中的第K个最大元素</a>
 * {@link ArrayTopic#findKthLargest(int[], int)}
 *
 * =====================================================================================================================
 * <h4>排序</h4>
 *
 * {@link ArrayTopic#quickSort(int[]) 快速排序}
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/non-decreasing-array/">665.非递减数列</a>
 * {@link ArrayTopic#checkPossibility(int[])}
 *
 * @author hetengjiao
 */
public class ArrayTopic {

    /**
     * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
     *
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * nums 肯定会在某个点上旋转
     * -10^4 <= target <= 10^4
     *
     *
     * @param nums nums
     * @param target target
     * @return int
     */
    public int search(int[] nums, int target) {
        // 4,5,6,7,8,0,1,2  7
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        //int mid;
        while (l <= r) {
            if (target == nums[l]) {
                return l;
            }
            if (target == nums[r]) {
                return r;
            }

            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] > nums[l]) {
                // 左边是有序的，升序
                if (target > nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 右边是有序的
                if (target > nums[mid] && target < nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
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

    /**
     * 215. 数组中的第K个最大元素
     * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     *
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     * 说明:
     *
     * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     *
     * @param nums nums
     * @param k k
     * @return int
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        // 执行 k - 1 删除
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(nums, i, heapSize);
        }
    }

    private void heapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, largest, heapSize);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * 快速排序
     * [1, 3, 5, 7, 9, 4, 2, 6]
     *
     * @param nums nums
     */
    public void quickSort(int[] nums) {
        doQuickSort(nums, 0, nums.length - 1);
    }

    private void doQuickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(nums, start, end);
        doQuickSort(nums, start, p - 1);
        doQuickSort(nums, p + 1, end);
    }

    private int partition(int[] nums, int left, int right) {
        // 3, 2, 3, 1, 2, 4, 5, 5, 6    pivot = 3, left = 0, right = 8
        // 2, 2, 3, 1, 2, 4, 5, 5, 6    pivot = 3, left = 0, right = 4
        // 2, 2, 3, 1, 2, 4, 5, 5, 6    pivot = 3, left = 4, right = 4
        // 2, 2, 3, 1, 3, 4, 5, 5, 6    pivot = 3, left = 4, right = 4

        // 2, 2, 3, 1   pivot = 2, left = 0, right = 3
        // 1, 2, 3, 1   pivot = 2, left = 0, right = 3
        // 1, 2, 3, 3   pivot = 2, left = 2, right = 3
        // 1, 2, 2, 3   pivot = 2, left = 2, right = 3

        // 3, 2, 3, 1, 2, 5, 2, 5, 6    pivot = 3, left = 0, right = 8
        // 2, 2, 3, 1, 2, 5, 2, 5, 6    pivot = 3, left = 0, right = 6
        // 2, 2, 3, 1, 2, 5, 5, 5, 6    pivot = 3, left = 5, right = 6
        // 2, 2, 3, 1, 2, 5, 5, 5, 6    pivot = 3, left = 5, right = 5
        // 2, 2, 3, 1, 2, 3, 5, 5, 6    pivot = 3, left = 5, right = 5
        int index = new Random().nextInt(right - left) + left;
        int pivot = nums[index];
        nums[index] = nums[left];
        nums[left] = pivot;

        while (left != right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    /**
     *
     * 665. 非递减数列
     * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     *
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     *
     *
     * 说明：
     *
     * 1 <= n <= 10 ^ 4
     * - 10 ^ 5 <= nums[i] <= 10 ^ 5
     *
     * @param nums nums
     * @return true or false
     */
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }
                // 3, 4, 2, 5, 6, 7
                // 1, 4, 2, 5, 6, 7
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }
}
