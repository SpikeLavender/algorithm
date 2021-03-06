package com.natsumes.leetcode.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * =====================================================================================================================
 * <h3>排列组合问题</h3>
 *
 * <a href="https://leetcode-cn.com/problems/combination-sum/">39.组合总和</a>
 * {@link Permute#combinationSum(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/next-permutation/">31.下一个排列</a>
 * {@link Permute#nextPermutation(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/permutations/">46.全排列</a>
 * {@link Permute#permute(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">17.电话号码的字母组合</a>
 * {@link Permute#letterCombinations(java.lang.String)}
 *
 * =====================================================================================================================
 * @author hetengjiao
 */
public class Permute {

    /**
     * 39. 组合总和
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     *
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     *
     *
     * 提示：
     *
     * 1 <= candidates.length <= 30
     * 1 <= candidates[i] <= 200
     * candidate 中的每个元素都是独一无二的。
     * 1 <= target <= 500
     *
     * @param candidates candidates
     * @param target target
     * @return list
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 零钱 dp[n + 1][target + 1]
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        doCombinationSum(ans, path, candidates, target, 0, 0);
        return ans;
    }

    private void doCombinationSum(List<List<Integer>> ans, List<Integer> path, int[] candidates,
                                  int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int rs = sum + candidates[i];
            if (rs <= target) {
                path.add(candidates[i]);
                doCombinationSum(ans, path, candidates, target, rs, i);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }

    /**
     * 46. 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *            O
     *         1     2
     *       O         O
     *     2   3     1   3
     *    O     O   O      O
     *    3     2   3      1
     *    O     O   O      O
     *
     * @param nums nums
     * @return list
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        return res;
    }

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
     * 17. 电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     *
     * 提示：
     *
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字
     *
     * @param digits digits
     * @return ans
     */
    public List<String> letterCombinations(String digits) {
       //new HashMap<Character, >()
        return null;
    }
}
