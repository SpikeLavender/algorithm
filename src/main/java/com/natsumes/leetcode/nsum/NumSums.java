package com.natsumes.leetcode.nsum;

import java.util.*;

/**
 * n sums 问题
 *
 * <a href="https://leetcode-cn.com/problems/two-sum/">1.两数之和</a>
 * @see NumSums#twoSum(int[], int)
 *
 * <a href="https://leetcode-cn.com/problems/3sum/">15.三数之和</a>
 * @see NumSums#threeSum(int[])
 *
 * <a href="https://leetcode-cn.com/problems/4sum/">18.四数之和</a>
 * @see NumSums#fourSum(int[], int)
 *
 * @author hetengjiao
 */
public class NumSums {
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     * @param nums nums
     * @param target target
     * @return int[]
     * @see NumSums
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 排序 + 双指针
     *
     * @param nums nums
     * @param target target
     * @return int[]
     * @see NumSums#nSumTarget(int[], int, int, int)
     */
    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            int left = nums[l];
            int right = nums[r];
            if (sum < target) {
                while (l < r && nums[l] == left) {
                    l++;
                }
            } else if (sum > target) {
                while (l < r && nums[r] == right) {
                    r--;
                }
            } else {
                res.add(Arrays.asList(left, right));
                while (l < r && nums[l] == left) {
                    l++;
                }
                while (l < r && nums[r] == right) {
                    r--;
                }
            }
        }
        return res;
    }

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * 示例 1：
     *
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     *
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：[]
     *
     * @param nums nums
     * @return list
     * @see NumSums#nSumTarget(int[], int, int, int)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSumTarget(nums, 3, 0, 0);
    }

    /**
     * 18. 四数之和
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     *
     * 注意：
     *
     * 答案中不可以包含重复的四元组。
     *
     * 示例：
     *
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     * @param nums nums
     * @param target target
     * @return <code>List<List<Integer>></code>
     * @see NumSums#nSumTarget(int[], int, int, int)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSumTarget(nums, 4, 0, target);
    }

    /**
     * n sum
     * @param nums nums
     * @param n n
     * @param start start
     * @param target target
     * @return <code>List<List<Integer>></code>
     */
    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || sz < n) {
            return res;
        }
        if (n == 2) {
            int lo = start;
            int hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo];
                int right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[lo]);
                    tmp.add(nums[hi]);
                    res.add(tmp);
                    while (lo < hi && nums[lo] == left) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == right) {
                        hi--;
                    }
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                List<List<Integer>> subs = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> sub : subs) {
                    sub.add(nums[i]);
                    res.add(sub);
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
