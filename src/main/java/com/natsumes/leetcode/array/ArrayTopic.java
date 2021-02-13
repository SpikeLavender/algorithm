package com.natsumes.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * <h3>数组 + 双指针 + 二分查找</h3>
 *
 * <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">119.杨辉三角 II</a>
 * {@link ArrayTopic#getRow(int)}
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
 * {@link ArrayTopic#findMedianSortedArrays(int[], int[])}, {@link ArrayTopic#findMedianSortedArrays02(int[], int[])}}
 *
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">215.数组中的第K个最大元素</a>
 * {@link ArrayTopic#findKthLargest(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">74.搜索二维矩阵</a>
 * {@link ArrayTopic#searchMatrix(int[][], int)}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">240.搜索二维矩阵 II</a>
 * {@link ArrayTopic#searchMatrix2(int[][], int)}
 *
 * =====================================================================================================================
 * <h4>排序</h4>
 *
 * {@link ArrayTopic#quickSort(int[]) 快速排序}
 *
 * <a href="https://leetcode-cn.com/problems/merge-intervals/">56.合并区间</a>
 * {@link ArrayTopic#merge(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/largest-number/">179.最大数</a>
 * {@link ArrayTopic#largestNumber(int[])}
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/non-decreasing-array/">665.非递减数列</a>
 * {@link ArrayTopic#checkPossibility(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">448.找到所有数组中消失的数字</a>
 * {@link ArrayTopic#findDisappearedNumbers(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix/">54.螺旋矩阵</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#spiralOrder(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">59.螺旋矩阵 II</a>
 * {@link ArrayTopic#generateMatrix(int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/next-greater-element-i/">496.下一个更大元素 I</a>
 * {@link ArrayTopic#nextGreaterElement(int[], int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/daily-temperatures/">739.每日温度</a>
 * {@link ArrayTopic#dailyTemperatures(int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">347.前 K 个高频元素</a>
 * {@link ArrayTopic#topKFrequent(int[], int)}
 *
 * @author hetengjiao
 */
public class ArrayTopic {

    /**
     * 179. 最大数
     * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
     *
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     *
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出："1"
     * 示例 4：
     *
     * 输入：nums = [10]
     * 输出："10"
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 10^9
     *
     * @param nums nums
     * @return num
     */
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        quickSort4LargestNumber(arr, 0, nums.length - 1);
        if ("0".equals(arr[0])) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String num : arr) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort4LargestNumber(String[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition4LargestNumber(nums, start, end);
        quickSort4LargestNumber(nums, start, p - 1);
        quickSort4LargestNumber(nums, p + 1, end);
    }

    private int partition4LargestNumber(String[] nums, int left, int right) {
        //int index = new Random().nextInt(right - left) + left;
        //String pivot = nums[index];
        //nums[index] = nums[left];
        //nums[left] = pivot;
        String pivot = nums[left];
        while (left != right) {
            while (left < right && compareNum(pivot, nums[right]) >= 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && compareNum(nums[left], pivot) >= 0) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    /**
     * 比较器
     * @param x x
     * @param y y
     * @return 0: x = y, >0: x > y, <0: x < y
     */
    private int compareNum(String x, String y) {
        String s1 = x + y;
        String s2 = y + x;
        return s1.compareTo(s2);
    }

    /**
     * TODO: 347. 前 K 个高频元素
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     *
     * @param nums nums
     * @param k k
     * @return int[]
     */
    public int[] topKFrequent(int[] nums, int k) {
        return nums;
    }

    /**
     * TODO: 496. 下一个更大元素 I
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     *
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
     *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
     *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     * 示例 2:
     *
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     *
     *
     * 提示：
     *
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * nums1和nums2中所有整数 互不相同
     * nums1 中的所有整数同样出现在 nums2 中
     *
     *
     * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
     *
     * @param nums1 nums1
     * @param nums2 nums1
     * @return int[]
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return null;
    }


    /**
     * TODO: 739. 每日温度
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * @param T T
     * @return day
     */
    public int[] dailyTemperatures(int[] T) {
        return T;
    }

    /**
     * 119. 杨辉三角 II
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     *
     *
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 3
     * 输出: [1,3,3,1]
     *
     * 进阶：
     *
     * 你可以优化你的算法到 O(k) 空间复杂度吗？
     *
     * @param rowIndex rowIndex
     * @return {@link List<Integer>}
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        //奇数

        for (int i = 1; i <= rowIndex; i++) {
            ans.add((int)((long)ans.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return ans;
    }

    /**
     * 56. 合并区间
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     *
     * 示例 1：
     *
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     *
     * 提示：
     *
     * 1 <= intervals.length <= 10^4
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 10^4
     *
     * @param intervals intervals
     * @return int[][]
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[] {l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(r, res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

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
     * 寻找两个正序数组的中位数
     *
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
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
     *
     * 提示：
     *
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1 nums1
     * @param nums2 nums2
     * @return res
     */
    public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays02(nums2, nums1);
        }

        //分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int k = (n1 + n2 + 1) / 2;
        // 在 nums1 的区间 [0, m]里查找恰当的分割线,
        // 使得 nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
        int left = 0;
        int right = n1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 -1]) {
                left = m1 + 1;
            } else {
                right = m1;
            }
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
        if ((n1 + n2) % 2 == 1) {
            return c1;
        }
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;
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

    /**
     * 448. 找到所有数组中消失的数字
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     *
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     *
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 示例:
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [5,6]
     *
     * @param nums nums
     * @return list
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        // 4,3,2,7,8,2,3,1
        // 4,3,2,7,8,5,6,1
        for (int i = 0; i < n; i++) {
            int x = (nums[i] - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    /**
     * 54.螺旋矩阵
     *
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *  
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     *
     *
     * @param matrix matrix
     * @return list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                for (int j = bottom; j > top; j--) {
                    ans.add(matrix[j][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return ans;
    }

    /**
     * 59. 螺旋矩阵 II
     * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     *
     * 提示：
     *
     * 1 <= n <= 20
     *
     * @param n n
     * @return matrix
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                ans[j][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    ans[bottom][i] = num++;
                }
                for (int j = bottom; j > top; j--) {
                    ans[j][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     *
     * @param matrix matrix
     * @param target target
     * @return true or false
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        // 0,0 0  1,1 0,1          x * n + y = mid  => x = mid / n
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 240. 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
     * 输出：false
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= n, m <= 300
     * -10^9 <= matix[i][j] <= 10^9
     * 每行的所有元素从左到右升序排列
     * 每列的所有元素从上到下升序排列
     * -10^9 <= target <= 10^9
     *
     * @param matrix matrix
     * @param target target
     * @return true or false
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target){
                col++;
            } else {
                return true;
            }
        }
        return false;
    }


}
