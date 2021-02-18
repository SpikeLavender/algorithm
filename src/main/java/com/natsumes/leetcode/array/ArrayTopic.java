package com.natsumes.leetcode.array;

import java.util.*;

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
 * <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.在排序数组中查找元素的第一个和最后一个位置</a>
 * {@link ArrayTopic#searchRange(int[], int)}
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
 * <a href="https://leetcode-cn.com/problems/array-partition-i/">561.数组拆分 I</a>
 * {@link ArrayTopic#arrayPairSum(int[])}
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
 * <a href="https://leetcode-cn.com/problems/next-greater-element-i/">496.下一个更大元素 I</a>
 * {@link ArrayTopic#nextGreaterElement(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/next-greater-element-ii/">503.下一个更大元素 II</a>
 * {@link ArrayTopic#nextGreaterElements(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/next-greater-element-iii/">556.下一个更大元素 III</a>
 * {@link ArrayTopic#nextGreaterElement(int)}
 *
 * <a href="https://leetcode-cn.com/problems/daily-temperatures/">739.每日温度</a>
 * {@link ArrayTopic#dailyTemperatures(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">347.前 K 个高频元素</a>
 * {@link ArrayTopic#topKsFrequent(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-limit-of-balls-in-a-bag/">1760.袋子里最少数目的球</a>
 * {@link ArrayTopic#minimumSize(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box/">1742.盒子中小球的最大数量</a>
 * {@link ArrayTopic#countBalls(int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/">1743.从相邻元素对还原数组</a>
 * {@link ArrayTopic#restoreArray(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/reshape-the-matrix/">566.重塑矩阵</a>
 * {@link ArrayTopic#matrixReshape(int[][], int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">84.柱状图中最大的矩形</a>
 * {@link ArrayTopic#largestRectangleArea(int[])}
 * {@link ArrayTopic#largestRectangleArea01(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/maximal-rectangle/">85.最大矩形</a>
 * {@link ArrayTopic#maximalRectangle(char[][])}
 * {@link ArrayTopic#maximalRectangleCommon(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/first-missing-positive/submissions/">41.缺失的第一个正数</a>
 * {@link ArrayTopic#firstMissingPositive(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/reverse-integer/">7.整数反转</a>
 * {@link ArrayTopic#reverse(int)}
 *
 * @author hetengjiao
 */
public class ArrayTopic {

    /**
     * 7. 整数反转
     * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     *
     *
     * 提示：
     *
     * -2^31 <= x <= 2^31 - 1
     *
     * @param x x
     * @return x
     */
    public int reverse(int x) {
        int ans = 0;
        int tmp;
        while (x / 10 != 0) {
            tmp = x % 10;
            x = x / 10;
            if (checkOutRange(tmp, ans)) {
                return 0;
            }
            ans = ans * 10 + tmp;
        }
        if (checkOutRange(x, ans)) {
            return 0;
        }
        ans = ans * 10 + x;
        return ans;
    }

    private boolean checkOutRange(int tmp, int ans) {
        if (tmp < 0) {
            return (Integer.MIN_VALUE - tmp) / 10 > ans;
        } else {
            return (Integer.MAX_VALUE - tmp) / 10 < ans;
        }
    }

    /**
     * 561. 数组拆分 I
     * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从 1 到 n 的 min(ai, bi) 总和最大。
     *
     * 返回该 最大总和 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,4,3,2]
     * 输出：4
     * 解释：所有可能的分法（忽略元素顺序）为：
     * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
     * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
     * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
     * 所以最大总和为 4
     * 示例 2：
     *
     * 输入：nums = [6,2,6,5,1,2]
     * 输出：9
     * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
     *
     *
     * 提示：
     *
     * 1 <= n <= 104
     * nums.length == 2 * n
     * -104 <= nums[i] <= 10^4
     *
     * @param nums nums
     * @return max
     */
    public int arrayPairSum(int[] nums) {
        doArrayPairSum(nums, 0, nums.length -  1);
        int max = 0;
        for (int i = 0; i < nums.length; i += 2) {
            max += nums[i];
        }
        return max;
    }


    private void doArrayPairSum(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition4ArrayPairSum(nums, start, end);
        doArrayPairSum(nums, start, p - 1);
        doArrayPairSum(nums, p + 1, end);
    }

    private int partition4ArrayPairSum(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left != right) {
            while (left < right && pivot <= nums[right]) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && pivot >= nums[left]) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

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
     * 347. 前 K 个高频元素
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
    public int[] topKsFrequent(int[] nums, int k) {
        // k小顶堆

        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (queue.size() == k) {
                if (Objects.requireNonNull(queue.peek())[1] < value) {
                    queue.poll();
                    queue.offer(new int[]{key, value});
                }
            } else {
                queue.offer(new int[]{key, value});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = Objects.requireNonNull(queue.poll())[0];
        }
        return ans;
    }



    /**
     * 496. 下一个更大元素 I
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
        // 单调栈
        Map<Integer, Integer> greaterElement = nextGreaterElement(nums2);

        int[] ans = new int[nums1.length];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = greaterElement.getOrDefault(nums1[i], -1);
        }

        return ans;
    }

    private Map<Integer, Integer> nextGreaterElement(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>(16);
        //int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans.put(nums[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }
        return ans;
    }

    /**
     * 503. 下一个更大元素 II
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
     * 如果不存在，则输出 -1。
     *
     * 示例 1:
     *
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * @param nums nums
     * @return ans
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        //单调栈
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }
            ans[i % n] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i % n]);
        }

        return ans;
    }

    /**
     * 556. 下一个更大元素 III
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。
     * 如果不存在这样的正整数，则返回 -1 。
     *
     * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 12
     * 输出：21
     * 示例 2：
     *
     * 输入：n = 21
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= n <= 2^31 - 1
     *
     * @param n n
     * @return max
     */
    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        int m = str.length();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = str.charAt(i) - '0';
        }
        // 134876923431586532
        int i;
        for (i = m - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        int j = m - 1;
        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }
        int tmp = nums[j];
        nums[j] = nums[i - 1];
        nums[i - 1] = tmp;
        // 逆序输出
        int max = Integer.MAX_VALUE;
        int ans = 0;
        for (int k = 0; k < i; k++) {
            if ((max - nums[k]) / 10 < ans) {
                return -1;
            }
            ans = ans * 10 + nums[k];
        }

        for (int k = m - 1; k >= i; k--) {
            if ((max - nums[k]) / 10 < ans) {
                return -1;
            }
            ans = ans * 10 + nums[k];
        }
        return ans;
    }

    /**
     * 739. 每日温度
     *
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * @param t t
     * @return day
     *
     * {@link #nextGreaterElements(int[])}
     */
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
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
        //for (int i = 0; i < intervals.length; i++) {
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(r, res.get(res.size() - 1)[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 33.搜索旋转排序数组
     *
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
     *
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
     * 双指针法
     *
     * {@link ArrayTopic#trap02(int[]) 备忘录解法}
     * {@link ArrayTopic#trap01(int[]) 暴力解法}
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

        for (int i = 0; i < len; i++) {
            int lMax = 0;
            int rMax = 0;
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

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 进阶：
     *
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
     *
     * @param nums nums
     * @param target target
     * @return index
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int s = mid;
                int f = mid;
                while (s >= 0 && nums[s] == target) {
                    s--;
                }
                while (f < n && nums[f] == target) {
                    f++;
                }
                return new int[]{s + 1, f - 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 1760. 袋子里最少数目的球
     *
     * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
     *
     * 你可以进行如下操作至多 maxOperations 次：
     *
     * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
     * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
     * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
     *
     * 请你返回进行上述操作后的最小开销。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [9], maxOperations = 2
     * 输出：3
     * 解释：
     * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
     * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
     * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
     * 示例 2：
     *
     * 输入：nums = [2,4,8,2], maxOperations = 4
     * 输出：2
     * 解释：
     * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
     * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
     * 示例 3：
     *
     * 输入：nums = [7,17], maxOperations = 2
     * 输出：7
     *
     * @param nums nums
     * @param maxOperations maxOperations
     * @return int
     *
     */
    public int minimumSize(int[] nums, int maxOperations) {
        return nums[0] + maxOperations;
    }

    /**
     * 1742. 盒子中小球的最大数量
     *
     * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，
     * 即 n == highLimit - lowLimit + 1）。另有无限数量的盒子，编号从 1 到 infinity 。
     *
     * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。
     * 例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
     *
     * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，
     * 只需返回其中任一盒子的小球数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：lowLimit = 1, highLimit = 10
     * 输出：2
     * 解释：
     * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
     * 小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
     * 编号 1 的盒子放有最多小球，小球数量为 2 。
     * 示例 2：
     *
     * 输入：lowLimit = 5, highLimit = 15
     * 输出：2
     * 解释：
     * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
     * 小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
     * 编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
     * 示例 3：
     *
     * 输入：lowLimit = 19, highLimit = 28
     * 输出：2
     * 解释：
     * 盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
     * 小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
     * 编号 10 的盒子放有最多小球，小球数量为 2 。
     *
     *
     * 提示：
     *
     * {@literal 1 <= lowLimit <= highLimit <= 105}
     *
     * @param lowLimit lowLimit
     * @param highLimit highLimit
     * @return int
     */
    public int countBalls(int lowLimit, int highLimit) {
        int[] res = new int[55];

        for (int i = lowLimit; i <= highLimit; i++) {
            int cur = i;
            int sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur = cur / 10;
            }
            res[sum] = res[sum] + 1;
        }
        int max = 0;
        for (int re : res) {
            if (re > max) {
                max = re;
            }
        }
        return max;
    }

    /**
     * https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
     *
     * 1743.从相邻元素对还原数组
     * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
     *
     * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，
     * 其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
     *
     * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，
     * 存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
     *
     * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
     *
     *
     *
     * 示例 1：
     *
     * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
     * 输出：[1,2,3,4]
     * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
     * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
     * 示例 2：
     *
     * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
     * 输出：[-2,4,1,-3]
     * 解释：数组中可能存在负数。
     * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
     * 示例 3：
     *
     * 输入：adjacentPairs = [[100000,-100000]]
     * 输出：[100000,-100000]
     *
     *
     * 提示：
     *
     * nums.length == n
     * adjacentPairs.length == n - 1
     * adjacentPairs[i].length == 2
     * {@literal 2 <= n <= 105}
     * {@literal -105 <= nums[i], ui, vi <= 105}
     * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
     *
     * @param adjacentPairs adj
     * @return int[]
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        //用list保存前后两个数
        HashMap<Integer, List<Integer>> map = new HashMap<>(16);
        for (int[] adjacentPair : adjacentPairs) {
            int first = adjacentPair[0];
            int second = adjacentPair[1];
            List<Integer> list = map.getOrDefault(first, new ArrayList<>());
            list.add(second);
            map.put(first, list);
            list = map.getOrDefault(second, new ArrayList<>());
            list.add(first);
            map.put(second, list);
        }
        int i = 0;
        int pre = 0;
        int[] res = new int[adjacentPairs.length + 1];
        for (int k : map.keySet()) {
            if (map.get(k).size() == 1) {
                res[i++] = k;
                pre = k;
                break;
            }
        }
        // 1 -> 2 -> 1, 3
        while (i <= adjacentPairs.length) {
            List<Integer> list = map.get(pre);
            pre = list.get(0);
            if (list.size() > 1 && res[i - 2] == pre) {
                pre = list.get(1);
            }
            res[i++] = pre;
        }
        return res;
    }

    /**
     * 566. 重塑矩阵
     * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     *
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     *
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * 示例 1:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     * 解释:
     * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
     * 示例 2:
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 2, c = 4
     * 输出:
     * [[1,2],
     *  [3,4]]
     * 解释:
     * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
     * 注意：
     *
     * 给定矩阵的宽和高范围在 [1, 100]。
     * 给定的 r 和 c 都是正数。
     *
     * @param nums nums
     * @param r r
     * @param c c
     * @return int[][]
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] ans = new int[r][c];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[(i * n + j) / c][(i * n + j) % c] = nums[i][j];
            }
        }
        return ans;
    }

    /**
     * 84. 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     *
     * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
     *
     * 示例:
     *
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     *
     * @param heights heights
     * @return area
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        Arrays.fill(right, n);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                right[stack.removeLast()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }
        return ans;
    }

    public int largestRectangleArea01(int[] heights) {
        int n = heights.length;
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peekLast()] >= height) {
                int cur = stack.removeLast();
                int l = stack.isEmpty() ? -1 : stack.peekLast();
                ans = Math.max((i - l - 1) * heights[cur], ans);
            }
            stack.addLast(i);
        }
        return ans;
    }

    /**
     *
     * 85.最大矩形
     *
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     *  
     *
     * 示例 1：
     *      1   0   1   0   0
     *      1   0   1   1   1
     *      1   1   1   1   1
     *      1   0   0   1   0
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     *
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     *
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     *
     * 输入：matrix = [["0","0"]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * rows == matrix.length
     * cols == matrix[0].length
     * 0 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximalRectangle(char[][] matrix) {
        /*
         * 解法二： 单调队列 todo
         */
        return 0;
    }


    /**
     * 暴力破解法
     */
    public int maximalRectangleCommon(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[][] width = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        // 递归思想，数学归纳法
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                    width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                for (int up = row; up >= 0; up--) {
                    int height = row - up + 1;
                    minWidth = Math.min(minWidth, width[up][col]);
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }

    /**
     * 41. 缺失的第一个正数
     *
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,0]
     * 输出：3
     *
     * 示例 2：
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     *
     * 示例 3：
     *
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 300
     * -2^31 <= nums[i] <= 2^31 - 1
     *
     * @param nums nums
     * @return ans
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
