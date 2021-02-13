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
 * <a href="https://leetcode-cn.com/problems/house-robber/">198.打家劫舍</a>
 * {@link DynamicProgram#rob1(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/">213.打家劫舍 II</a>
 * {@link DynamicProgram#rob(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-iii/">337.打家劫舍 III</a>
 * {@link DynamicProgram#rob(com.natsumes.leetcode.dp.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/maximal-square/">221.最大正方形</a>
 * {@link DynamicProgram#maximalSquare(char[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/word-search/">79.单词搜索</a>
 * {@link DynamicProgram#exist(char[][], java.lang.String)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309.最佳买卖股票时机含冷冻期</a>
 * {@link DynamicProgram#maxProfit(int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64.最小路径和</a>
 * {@link DynamicProgram#minPathSum(int[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-path-sum/">113.路径总和 II</a>
 * {@link DynamicProgram#pathSum(com.natsumes.leetcode.dp.TreeNode, int)}
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
 * <h4>BFS 广度优先搜索</h4>
 *
 * =====================================================================================================================
 * <h4>贪心算法</h4>
 *
 * TODO: <a href="https://leetcode-cn.com/problems/gas-station/">134.加油站</a>
 * {@link DynamicProgram#canCompleteCircuit(int[], int[])}
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
     * TODO: 221.最大正方形
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
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
     *
     * @param matrix matrix
     * @return int
     */
    public int maximalSquare(char[][] matrix) {
        return 0;
    }

    /**
     * TODO: 79.单词搜索
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
     * @param board board
     * @param word word
     * @return true or false
     */
    public boolean exist(char[][] board, String word) {
        return true;
    }

    /**
     * TODO: 309.最佳买卖股票时机含冷冻期
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
        return 0;
    }

    /**
     * TODO: 64.最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     *
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
        return 0;
    }

    /**
     * TODO: 113. 路径总和 II
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * @param root root
     * @param targetSum targetSum
     * @return list
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return null;
    }

    /**
     * TODO: 134.加油站
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
        return 0;
    }
}
