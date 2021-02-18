package com.natsumes.leetcode.dp;

import java.util.*;

/**
 * 动态规划
 * =====================================================================================================================
 *
 * <a href="https://leetcode-cn.com/problems/coin-change/">322.零钱兑换</a>
 * {@link DynamicProgram#coinChange(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">32.最长有效括号</a>
 * {@link DynamicProgram#longestValidParentheses(java.lang.String)}
 * {@link DynamicProgram#longestValidParentheses2(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">300.最长递增子序列</a>
 * {@link DynamicProgram#lengthOfLis(int[])}
 * {@link DynamicProgram#patienceSorting(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a>
 * {@link DynamicProgram#maxSubArray(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">1143.最长公共子序列</a>
 * {@link DynamicProgram#longestCommonSubsequence(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/edit-distance/">72.编辑距离</a>
 * {@link DynamicProgram#minDistance(java.lang.String, java.lang.String)}
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * <a href="https://leetcode-cn.com/problems/house-robber/">198.打家劫舍</a>
 * {@link DynamicProgram#rob1(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/">213.打家劫舍 II</a>
 * {@link DynamicProgram#rob(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-iii/">337.打家劫舍 III</a>
 * {@link DynamicProgram#rob(com.natsumes.leetcode.dp.TreeNode)}
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * <a href="https://leetcode-cn.com/problems/maximal-square/">221.最大正方形</a>
 * {@link DynamicProgram#maximalSquare(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/">1277.统计全为 1 的正方形子矩阵</a>
 * {@link DynamicProgram#countSquares(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/word-search/">79.单词搜索</a>
 * {@link DynamicProgram#exist(char[][], java.lang.String)}
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">121.买卖股票的最佳时机</a>
 * {@link DynamicProgram#maxProfit01(int[])}
 * {@link DynamicProgram#maxProfitBySearch(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">122.买卖股票的最佳时机 II</a>
 * {@link DynamicProgram#maxProfit02(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">123.买卖股票的最佳时机 III</a>
 * {@link DynamicProgram#maxProfit03(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/">188.买卖股票的最佳时机 IV</a>
 * {@link DynamicProgram#maxProfit04(int, int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309.最佳买卖股票时机含冷冻期</a>
 * {@link DynamicProgram#maxProfit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714.买卖股票的最佳时机含手续费</a>
 * {@link DynamicProgram#maxProfit(int[], int)}
 *
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64.最小路径和</a>
 * {@link DynamicProgram#minPathSum(int[][])}
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
 * <a href="https://leetcode-cn.com/problems/max-area-of-island/">695.岛屿的最大面积</a>
 * {@link DynamicProgram#maxAreaOfIsland(int[][])}
 *
 * =====================================================================================================================
 * <h4>BFS 广度优先搜索</h4>
 *
 * =====================================================================================================================
 * <h4>贪心算法</h4>
 *
 * <a href="https://leetcode-cn.com/problems/gas-station/">134.加油站</a>
 * {@link DynamicProgram#canCompleteCircuit(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/palindrome-partitioning-iv/">1745.回文串分割 IV</a>
 * {@link DynamicProgram#checkPartitioning(String)}
 *
 * @author hetengjiao
 */
public class DynamicProgram {

    /**
     * 322.零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 示例 1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 示例 4：
     *
     * 输入：coins = [1], amount = 1
     * 输出：1
     * 示例 5：
     *
     * 输入：coins = [1], amount = 2
     * 输出：2
     *  
     *
     * 提示：
     *
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 2^31 - 1
     * 0 <= amount <= 10^4
     *
     *
     * @param coins coins
     * @param amount amount
     * @return int
     */
    public int coinChange(int[] coins, int amount) {
        // dp[i]: 当目标金额为i时，至少需要d[i]枚硬币凑出
        // dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]] + 1), dp[0][0] = 0, dp[0][i] = inf
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < amount + 1; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

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
    public int lengthOfLis(int[] nums) {
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
        for (int heap : nums) {
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

    /**
     * 337. 打家劫舍 III
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
     * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，
     * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * 要么偷两个子节点，要么偷根节点
     * dp[i] = dp[i - 1]
     */
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);

        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int noSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] {selected, noSelected};
    }

    /**
     * 213. 打家劫舍 II
     *
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
     * 系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     *
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     *
     * f[i][0] = max{f[i - 1], f[i - 2] + nums[i]}
     * f[i][1] = max{f[i - 1], f[i - 2] + nums[i]}
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int first = doRob(nums, 0, len - 2);
        int second = doRob(nums, 1, len - 1);

        return Math.max(first, second);
    }

    /**
     * 198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     *
     * 提示：
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return doRob(nums, 0, nums.length - 1);
    }

    private int doRob(int[] nums, int startIndex, int endIndex) {
        int len = endIndex - startIndex + 1;
        if (len == 0) {
            return 0;
        }

        int f0 = 0;
        int f1 = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            int cur = Math.max(f1, f0 + nums[i]);
            f0 = f1;
            f1 = cur;
        }
        return f1;
    }

    /**
     * 1277.统计全为 1 的正方形子矩阵
     * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * 输出：15
     * 解释：
     * 边长为 1 的正方形有 10 个。
     * 边长为 2 的正方形有 4 个。
     * 边长为 3 的正方形有 1 个。
     * 正方形的总数 = 10 + 4 + 1 = 15.
     * 示例 2：
     *
     * 输入：matrix =
     * [
     *   [1,0,1],
     *   [1,1,0],
     *   [1,1,0]
     * ]
     * 输出：7
     * 解释：
     * 边长为 1 的正方形有 6 个。
     * 边长为 2 的正方形有 1 个。
     * 正方形的总数 = 6 + 1 = 7.
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 300
     * 1 <= arr[0].length <= 300
     * 0 <= arr[i][j] <= 1
     *
     * @param matrix matrix
     * @return count
     */
    public int countSquares(int[][] matrix) {
        // dp[i][j]: 表示以 (i, j) 为右下角的正方形的最大边长
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * 221.最大正方形
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [
     *      ["1","0","1","0","0"],
     *      ["1","0","1","1","1"],
     *      ["1","1","1","1","1"],
     *      ["1","0","0","1","0"]
     * ]
     * 输出：4
     * 示例 2：
     *
     *
     * 输入：matrix = [["0","1"],["1","0"]]
     * 输出：1
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 300
     * matrix[i][j] 为 '0' 或 '1'
     *
     * 动态规划
     *
     * @param matrix matrix
     * @return int
     */
    public int maximalSquare(char[][] matrix) {
        // 动态规划
        // dp[i][j] 表示以(i, j) 为右下角的正方形的最大边长
        // matrix[i][j] = 0 :   dp[i][j] = 0, 当前位置不可能在正方形中
        // matrix[i][j] = 1:    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
        //                      i = 0 || j = 0 : dp[i][j] = 1
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                        dp[i][j] += 1;
                    }
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 暴力解法
     *
     * @param matrix matrix
     * @return int
     */
    public int maximalSquare01(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断新增的是否都是1
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int curMaxSide = Math.min(m - i, n - j);
                    for (int k = 1; k < curMaxSide; k++) {
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int x = 0; x < k; x++) {
                            if (matrix[i + x][j + k] == '0' || matrix[i + k][j + x] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return maxSide * maxSide;
    }

    /**
     * 79.单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     *
     *
     *
     * 示例:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     *
     *
     * 提示：
     *
     * board 和 word 中只包含大写和小写英文字母。
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * 1 <= word.length <= 10^3
     *
     * 深度优先搜索
     *
     * @param board board
     * @param word word
     * @return true or false
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * dfs 检查是否存在
     *
     * @param board 字符数组
     * @param visited 是否已使用
     * @param i 当前横坐标
     * @param j 当前纵坐标
     * @param s 字符串
     * @param k 当前字符位置
     * @return true or false
     */
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        // 回溯结束条件
        // 提前结束
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        // 查找到匹配项, 结束
        if (k == s.length() - 1) {
            return true;
        }

        // 回溯开始
        visited[i][j] = true;
        // 定义方向数组
        int[][] dks = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        boolean res = false;
        for (int[] dk : dks) {
            int x = i + dk[0];
            int y = j + dk[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!visited[x][y]) {
                    if (check(board, visited, x, y, s, k + 1)) {
                        res = true;
                        break;
                    }
                }
            }
        }
        // 结束
        visited[i][j] = false;
        return res;
    }

    /**
     * 121. 买卖股票的最佳时机 || 剑指 Offer 63. 股票的最大利润
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices prices
     * @return profit
     *
     */
    public int maxProfit01(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // dp[i][0] 表示当前持股状态下的最大收益
        // dp[i][1] 表示当前不持股状态下的最大收益
        // dp[i][0] = max(-prices[i], dp[i - 1][0])
        // dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])
        // ans = max(dp[n - 1][1])
        // dp[0][0] = -prices[0]
        // dp[0][1] = 0
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -1 * prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }

    /**
     * 121. 买卖股票的最佳时机 || 剑指 Offer 63. 股票的最大利润
     * 一次遍历
     *
     * @param prices prices
     * @return profit
     */
    public int maxProfitBySearch(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }


    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     *
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0
     *
     * @param prices prices
     * @return profit
     */
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /*
         * dp[i][0] 表示当前持股状态下的最大收益
         * dp[i][1] 表示当前不持股状态下的最大收益
         * dp[i][0] = max(dp[i - 1][1] - prices[i], dp[i - 1][0])
         * dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])
         * ans = max(dp[n - 1][1])
         * dp[0][0] = -prices[0]
         * dp[0][1] = 0
         */
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -1 * prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][1];
    }

    public int maxProfit0202(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        /*
         * dp[i][0] 表示当前持股状态下的最大收益
         * dp[i][1] 表示当前不持股状态下的最大收益
         * dp[i][0] = max(dp[i - 1][1] - prices[i], dp[i - 1][0])
         * dp[i][1] = max(dp[i - 1][0] + prices[i], dp[i - 1][1])
         * ans = max(dp[n - 1][1])
         * dp[0][0] = -prices[0]
         * dp[0][1] = 0
         */
        int n = prices.length;
        int dp00 = -prices[0], dp01;
        int dp10 = 0, dp11;
        for (int i = 1; i < n; i++) {
            dp01 = Math.max(dp10 - prices[i], dp00);
            dp11 = Math.max(dp00 + prices[i], dp10);
            dp00 = dp01;
            dp10 = dp11;
        }
        return dp10;
    }

    /**
     * 123. 买卖股票的最佳时机 III
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     *
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2：
     *
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3：
     *
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     * 示例 4：
     *
     * 输入：prices = [1]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 105
     * @param prices prices
     * @return profit
     */
    public int maxProfit03(int[] prices) {
        /*
         * 当天的状态:
         *      不进行任何交易
         *    buy01   已进行过一次买入
         *    sell01  已进行过一次交易, 即买入卖出一次
         *    buy02   已进行过一次交易, 又买入一次
         *    sell02  已进行过两次交易, 即买入卖出两次
         *
         * buy01  = max(buy01, -prices[i])
         * sell01 = max(sell01, buy01 + prices[i])
         * buy02  = max(buy02, sell01 - prices[i])
         * sell02 = max(sell02, buy02 + prices[i])
         *
         */
        int buy01 = -prices[0], sell01 = 0, buy02 = -prices[0], sell02 = 0;
        int buy11, sell11, buy12, sell12;
        for (int price : prices) {
            buy11 = Math.max(buy01, -price);
            sell11 = Math.max(sell01, buy01 + price);
            buy12 = Math.max(buy02, sell01 - price);
            sell12 = Math.max(sell02, buy02 + price);
            buy01 = buy11;
            sell01 = sell11;
            buy02 = buy12;
            sell02 = sell12;
        }

        return Math.max(sell01, sell02);
    }

    /**
     * 188. 买卖股票的最佳时机 IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2：
     *
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *
     *
     * 提示：
     *
     * 0 <= k <= 100
     * 0 <= prices.length <= 1000
     * 0 <= prices[i] <= 1000
     *
     * @param k k
     * @param prices prices
     * @return profit
     */
    public int maxProfit04(int k, int[] prices) {

        /*
         * 当天的状态:
         *      不进行任何交易
         *    buy01   已进行过一次买入
         *    sell01  已进行过一次交易, 即买入卖出一次
         *    buy02   已进行过一次交易, 又买入一次
         *    sell02  已进行过两次交易, 即买入卖出两次
         *
         * buy01  = max(buy01, -prices[i])
         * sell01 = max(sell01, buy01 + prices[i])
         * buy02  = max(buy02, sell01 - prices[i])
         * sell02 = max(sell02, buy02 + prices[i])
         *
         * buys[i][j] 进行恰好j笔交易, 手上还有一支股票
         * sells[i][j] 进行恰好j笔交易, 手上没有一支股票
         *
         */

        return 0;
    }

    /**
     * 309.最佳买卖股票时机含冷冻期
     *
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     * @param prices prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        // dp[i][0]: 表示当前持有股票, 对应的累计最大收益
        // dp[i][1]: 表示当前不持有股票且处于冷静期, 对应的累计最大收益
        // dp[i][2]: 表示当前不持有股票且不处于冷静期, 对应的累计最大收益

        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][2] - prices[i])
        // dp[i][1] = dp[i - 1][0] + prices[i]
        // dp[i][2] = max(dp[i - 1][1], dp[i - 1][2])
        // dp[0][0] = -prices[0]
        // dp[0][1] = 0
        // dp[0][2] = 0
        // ans = max(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2])
        // ans = max(dp[n - 1][1], dp[n - 1][2]) 最后一天持有股票没有意义
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][0] = -1 * prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     *
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     *
     * 返回获得利润的最大值。
     *
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *
     * 示例 1:
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     * 注意:
     *
     * 0 < prices.length <= 50000.
     * 0 < prices[i] < 50000.
     * 0 <= fee < 50000
     *
     * @param prices prices
     * @param fee fee
     * @return profit
     */
    public int maxProfit(int[] prices, int fee) {
        return 0;
    }

    /**
     * 64.最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例 1：
     *
     *
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     *
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     *
     * @param grid grid
     * @return int
     */
    public int minPathSum(int[][] grid) {
        //dp[m][n]: 从左上角到 (m, n) 位置的最小路径和
        // i > 0 && j = 0: dp[i][0] = dp[i - 1] + grid[i][0]
        // i = 0 && j > 0: dp[0][j] = dp[0][j - 1] + grid[0][j]
        // i > 0 && j > 0: dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[0][j]

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 134.加油站
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     *
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
     * 你从其中的一个加油站出发，开始时油箱为空。
     *
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     *
     * 说明:
     *
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     * 示例 1:
     *
     * 输入:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     *
     * 输出: 3
     *
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     * 示例 2:
     *
     * 输入:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     *
     * 输出: -1
     *
     * 解释:
     * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * 因此，无论怎样，你都不可能绕环路行驶一周。
     *
     * @param gas gas
     * @param cost cost
     * @return int
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 如果从 x 无法到达 y 的下一个加油站
        // 则从 [x, y]中间的任何一个加油站出发，都没法到达 y 的下一个加油站
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int gasSum = 0;
            int costSum = 0;
            int count = 0;
            while (count < n) {
                int j = (i + count) % n;
                gasSum += gas[j];
                costSum += cost[j];
                if (costSum > gasSum) {
                    break;
                }
                count++;
            }
            if (count == n) {
                return i;
            } else {
                // 从无法到达的第一个加油站开始继续检查
                i = i + count + 1;
            }
        }
        return -1;
    }

    /**
     * 1745. 回文串分割 IV
     *
     * 给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
     *
     * 当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。
     *
     * 示例 1：
     *
     * 输入：s = "abcbdd"
     * 输出：true
     * 解释："abcbdd" = "a" + "bcb" + "dd"，三个子字符串都是回文的。
     * 示例 2：
     *
     * 输入：s = "bcbddxy"
     * 输出：false
     * 解释：s 没办法被分割成 3 个回文子字符串。
     *  
     *
     * 提示：
     *
     * {@literal 3 <= s.length <= 2000}
     * s​​​​​​ 只包含小写英文字母。
     *
     * @param s s
     * @return b
     */
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int k = i;
            int j = i;
            while (k >= 0 && j < n && s.charAt(k) == s.charAt(j)) {
                dp[k][j] = true;
                k--;
                j++;
            }
            k = i;
            j = i + 1;
            while (k >= 0 && j < n && s.charAt(k) == s.charAt(j)) {
                dp[k][j] = true;
                k--;
                j++;
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 5. 最长回文子串
     *
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     *
     *
     * 提示：
     *
     * {@literal 1 <= s.length <= 1000}
     * s 仅由数字和英文字母（大写和/或小写）组成
     * @param s s
     * @return String
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 695.岛屿的最大面积
     *
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     *
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     *
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     *
     *  
     *
     * 示例 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     *
     * 示例 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * 对于上面这个给定的矩阵, 返回 0。
     *
     *  
     *
     * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
     *
     * @param grid grid
     * @return area
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] drs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(doMaxAreaOfIslandByDfs(grid, i, j, drs), max);
                }
            }
        }
        return max;
    }

    private int doMaxAreaOfIslandByDfs(int[][] grid, int i, int j, int[][] drs) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int ans = 1;
        for (int[] dr : drs) {
            int x = i + dr[0];
            int y = j + dr[1];
            ans += doMaxAreaOfIslandByDfs(grid, x, y, drs);
        }
        return ans;
    }

    /**
     * 1143. 最长公共子序列
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）
     * 后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     * 示例 1:
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 示例 2:
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     * 示例 3:
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     *
     *
     * 提示:
     *
     * 1 <= text1.length <= 1000
     * 1 <= text2.length <= 1000
     * 输入的字符串只含有小写英文字符。
     *
     * @param text1 text1
     * @param text2 text2
     * @return length
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        /*
         * dp[i][j] 表示 text1[0...i-1] 和 text2[0...j-1] 中最长的公共子串
         * text1[i - 1] == text2[j - 1]: dp[i][j] = dp[i - 1][j - 1] + 1
         * text1[i - 1] != text2[j - 1]: dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
         * ans = dp[m][n]
         */
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 72. 编辑距离
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     *
     * 示例 1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     *
     * 提示：
     *
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     *
     * @param word1 word1
     * @param word2 word2
     * @return length
     */
    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) {
            return word1.length();
        }
        /*
         * dp[i][j]: word1[0...i-1] 和 word2[0...j-1] 的最小编辑次数
         * word1[i - 1] == word2[j - 1]: dp[i][j] = dp[i - 1][j - 1]
         * word1[i - 1] != word2[j - 1]: dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
         *
         * dp[i][0] = i, dp[0][j] = j
         */
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
