package com.natsumes.leetcode.dp;

import java.util.*;

/**
 * 动态规划
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">32.最长有效括号</a>
 * {@link DynamicProgram#longestValidParentheses(java.lang.String)}
 * {@link DynamicProgram#longestValidParentheses2(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">300.最长递增子序列</a>
 * {@link DynamicProgram#lengthOfLIS(int[])}
 * {@link DynamicProgram#patienceSorting(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a>
 * {@link DynamicProgram#maxSubArray(int[])}
 *
 * =====================================================================================================================
 * <h4>DFS 深度优先搜索（回溯算法）</h4>
 *
 * <a href="https://leetcode-cn.com/problems/generate-parentheses/">22.括号生成</a>
 * {@link DynamicProgram#generateParenthesis(int)}
 *
 * <a href="https://leetcode-cn.com/problems/remove-invalid-parentheses/">301.删除无效的括号</a>
 * {@link DynamicProgram#removeInvalidParentheses(java.lang.String)}
 *
 * =====================================================================================================================
 * <h4>BFS 广度优先搜索（回溯算法）</h4>
 *
 * =====================================================================================================================
 * @author hetengjiao
 */
public class DynamicProgram {

    /**
     * 301. 删除无效的括号
     * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
     *
     * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
     *
     * 示例 1:
     *
     * 输入: "()())()"
     * 输出: ["()()()", "(())()"]
     * 示例 2:
     *
     * 输入: "(a)())()"
     * 输出: ["(a)()()", "(a())()"]
     * 示例 3:
     *
     * 输入: ")("
     * 输出: [""]
     *
     * @param s s
     * @return list
     */
    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        Set<String> ans = new HashSet<>();

        int open = 0;
        int close = 0;
        for (char c : ss) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        doRemoveInvalidParentheses(ss, new StringBuilder(), ans, 0, 0, 0, open, close);
        return new ArrayList<>(ans);
    }

    /**
     * 回溯函数
     * 分别对字符串中的每一位置的字符进行处理，最终获得符合要求的字符串加入集合中
     * @param ss 字符串对应的字符数组
     * @param sb 储存当前处理过且未去除字符的字符串
     * @param ans 存储所有正确的字符串，去重复
     * @param index 当前处理的字符位置
     * @param open 当前sb中存储的左括号数
     * @param close 当前sb中存储的右括号数
     * @param openRem 当前需要去除的左括号数
     * @param closeRem 当前需要去除的右括号数
     */
    private void doRemoveInvalidParentheses(char[] ss, StringBuilder sb, Set<String> ans, int index,
                                            int open, int close, int openRem, int closeRem) {
        if (index == ss.length) {
            if (openRem == 0 && closeRem == 0) {
                ans.add(sb.toString());
            }
            return;
        }

        if (ss[index] == '(' && openRem > 0) {
            doRemoveInvalidParentheses(ss, sb, ans, index + 1, open, close, openRem - 1, closeRem);
        } else if (ss[index] == ')' && closeRem > 0) {
            doRemoveInvalidParentheses(ss, sb, ans, index + 1, open, close, openRem, closeRem - 1);
        }
        sb.append(ss[index]);
        if (ss[index] != '(' && ss[index] != ')') {
            doRemoveInvalidParentheses(ss, sb, ans, index + 1, open, close, openRem, closeRem);
        } else if (ss[index] == '(') {
            doRemoveInvalidParentheses(ss, sb, ans, index + 1, open + 1, close, openRem, closeRem);
        } else if (open > close) {
            doRemoveInvalidParentheses(ss, sb, ans, index + 1, open, close + 1, openRem, closeRem);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     *
     * 提示：
     *
     * 1 <= n <= 8
     *
     * @param n n
     * @return list
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        doGenerateParenthesis(str, ans, 0, 0, n);
        return ans;
    }

    private void doGenerateParenthesis(StringBuilder str, List<String> ans, int open, int close, int max) {
        if (str.length() == max * 2) {
            ans.add(str.toString());
            return;
        }
        if (open < max) {
            str.append("(");
            doGenerateParenthesis(str, ans, open + 1, close, max);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(")");
            doGenerateParenthesis(str, ans, open, close + 1, max);
            str.deleteCharAt(str.length() - 1);
        }
    }

    /**
     * 32. 最长有效括号
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     *
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     *
     * 输入：s = ""
     * 输出：0
     *
     * 示例 4：
     * 输入：s = ")(()())"
     * 输出：6
     * 解释：最长有效括号子串是 "(()())"
     *
     * 提示：
     *
     * 0 <= s.length <= 3 * 10^4
     * s[i] 为 '(' 或 ')'
     *
     * dp[i]表示以s[i]结尾的最长有效子字符串长度
     *
     * s[i] = ')' && s[i - 1] = '('
     *      dp[i] = dp[i - 2] + 2
     * s[i] = ')' && s[i - 1] = ')'
     *      s[i - dp[i - 1] - 1] = '('
     *      dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2]
     *
     * @param s s
     * @return length
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // ())
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    /**
     * 双指针法
     * 空间复杂度为 O(1)的方法
     * @param s s
     * @return length
     */
    public int longestValidParentheses2(String s) {
        int left = 0;
        int right = 0;
        int max = 0;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = Math.max(max, right * 2);
            } else if (right < left) {
                left = right = 0;
            }
        }
        return max;
    }

    /**
     * 300. 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     * @param nums nums
     * @return int
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // dp[i] = max(dp[i], dp[j] + 1)
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * 耐心排序
     *
     * @param nums nums
     * @return int
     */
    public int patienceSorting(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int heap = nums[i];
            int left = 0;
            int right = count;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= heap) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == count) {
                count++;
            }
            top[left] = heap;
        }
        return count;
    }

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     *
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     *
     * 输入：nums = [-100000]
     * 输出：-100000
     *
     * dp[i] = max(nums[i] + dp[i - 1]), dp[0] = nums[0]
     *
     * @param nums nums
     * @return int
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp0 = nums[0];
        int dp1;
        int res = dp0;

        for (int i = 1; i < n; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            res = Math.max(res, dp0);
        }
        return res;
    }
}
