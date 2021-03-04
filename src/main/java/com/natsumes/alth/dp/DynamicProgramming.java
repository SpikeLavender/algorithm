package com.natsumes.alth.dp;

/**
 * 动态规划问题大全
 *
 * @author hetengjiao
 */
public class DynamicProgramming {


    /**
     * 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有 n 阶台阶，小孩一次可以上 1 阶、2 阶或 3 阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。
     * 结果可能很大，你需要对结果模 1000000007。
     *
     * 示例
     * 输入：n = 3
     * 输出：4
     * 说明: 有四种走法
     *
     * 输入：n = 5
     * 输出：13
     *
     * n 范围在 [1, 1000000] 之间
     *
     * @param n     台阶数
     * @return 走法
     */
    public static int waysToStep(int n) {
        int mod = 1000000007;
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            if (i >= 2) {
                f[i] = (f[i] + f[i - 2]) % mod;
            }
            if (i >= 3) {
                f[i] = (f[i] + f[i - 3]) % mod;
            }
        }
        return f[n];
    }

    /**
     * 最小路径和
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * f[i][j] = [i][j] + min(f[i-1][j], f[i][j-1])
     *
     * @param grid     二维数组
     * @return sums
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int tp = Integer.MAX_VALUE;
                if (i > 0) {
                    tp = Math.min(tp, grid[i - 1][j]);
                }
                if (j > 0) {
                    tp = Math.min(tp, grid[i][j - 1]);
                }
                grid[i][j] += tp;
            }
        }
        return grid[m - 1][n - 1];
    }

    /**
     * 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 示例
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * nums[i] > 0:
     * f[i] = max(f[i-1] * nums[i], nums[i]);
     *
     * nums[i] <= 0:
     * f[i] = max([以i-1为右端点的连续区间的最小乘积] * nums[i], nums[i]);
     *
     * @param nums  整数数组
     * @return res
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int[] maxn = new int[n];
        int[] minn = new int[n];
        maxn[0] = minn[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                maxn[i] = Math.max(nums[i], nums[i] * maxn[i - 1]);
                minn[i] = Math.min(nums[i], nums[i] * minn[i - 1]);
            } else {
                maxn[i] = Math.max(nums[i], nums[i] * minn[i - 1]);
                minn[i] = Math.min(nums[i], nums[i] * maxn[i - 1]);
            }
            ans = Math.max(ans, maxn[i]);
        }
        return ans;
    }

    /**
     * 最长上升子序列（LIS）
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * f[i] = max(1, f[j] + 1), a[j] < a[i], j < i
     *
     * @param nums  nums
     * @return  length
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j =  i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    tmp = Math.max(tmp, f[j] + 1);
                }
            }
            f[i] = tmp;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    /**
     * 最长公共子序列（LCS）
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     * 一个字符串的「子序列」是指这样一个新的字符串：
     * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     * 示例
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     *
     * str1[i] == str2[j]:
     * f[i][j] = f[i-1][j-1] + 1
     *
     * str1[i] != str2[j]
     * f[i][j] = max(f[i-1][j], f[i][j-1])
     *
     * @param str1 str1
     * @param str2 str2
     * @return ans
     */
    public static int longestCommonSubSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }

        return f[len1][len2];
    }

    /**
     * 三角形最小路径和
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 相邻的结点在这里指的是「下标」与「上一层结点下标」相同或者等于「上一层结点下标 + 1 」的两个结点。
     *
     * 例如，给定三角形：
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     *
     * f[i][j] = min(f[i-1][j-1], f[i-1][j]) + t[i][j]
     *
     * @param triangle triangle
     * @return ans
     */
    public static int minimumTotal(int[][] triangle) {
        int len = triangle.length;
        int ans = Integer.MAX_VALUE;
        int[] f = new int[len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = triangle[i].length - 1; j >= 0; j--) {
                if (j == triangle[i].length - 1) {
                    f[j + 1] = triangle[i][j] + f[j];
                } else if (j == 0) {
                    f[j + 1] = triangle[i][j] + f[j + 1];
                } else {
                    f[j + 1] = triangle[i][j] + Math.min(f[j + 1], f[j]);
                }

                if (i == len - 1) {
                    ans = Math.min(ans, f[j + 1]);
                }
            }
        }

        return ans;
    }

    /**
     * 打家劫舍
     *
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你「不触动警报装置的情况下」，
     * 一夜之内能够偷窃到的最高金额。
     *
     * 示例 1
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * f[i] = max(f[i-2] + nums[i], f[i-1])
     *
     * @param nums nums
     * @return res
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] f = new int[len];

        for (int i = 0; i < len; i++) {
            f[i] = nums[i];
            if (i >= 2) {
                f[i] = Math.max(f[i], f[i - 2] + nums[i]);
            }
            if (i >= 1) {
                f[i] = Math.max(f[i], f[i - 1]);
            }
        }

        return f[len-1];
    }



    /**
     * 编辑距离
     *
     * 给你两个单词「word1」和「word2」，请你计算出将「word1」转换成「word2」所使用的最少操作数。
     * 你可以对一个单词进行如下三种操作：
     *      插入一个字符
     *      删除一个字符
     *      替换一个字符
     *
     * 示例 1
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     *
     * 示例 2
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     * word1[i] == word2[j]
     * f[i][j] = f[i-1][j-1]
     *
     * word1[i] != word2[j]
     * f[i][j] = min(f[i-1][j-1] + 1, min(f[i-1][j], f[i][j-1]) + 1)
     *
     * f[i][0] = i, f[0][j] = j, 1 <= i <= word1.length, 1 <= j <= word2.length
     *
     * @param word1 word 1
     * @param word2 word 2
     * @return res
     */
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            f[i][0] = i;
        }

        for (int j = 1; j <= m; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i-1][j-1];
                } else {
                    f[i][j] = Math.min(f[i-1][j-1] + 1, Math.min(f[i-1][j], f[i][j-1]) + 1);
                }
            }
        }
        return f[n][m];
    }

    /**
     * 0/1 背包问题
     * zero/one Knapsack problem
     *
     * 一共有 N 个物品，其中第 i 个物品的体积为 vi，价值为 wi。
     * 现要求选择一些物品放入一个容积为 M 的背包中，使得物品总体积不超过 M 的前提下，物品总价值最大。
     *
     * f[i][j] = max(f[i-1][j], f[i-1][j-vi] + wi)
     *
     * @param n num
     * @param m capacity
     * @param v volumes
     * @param w values
     * @return res
     */
    public static int zeroOneKnapsack(int n, int m, int[] v, int[] w) {
        int[][] f = new int[n + 1][m + 1];
        for (int j = 1; j <= m; j++) {
            f[0][j] = (int) Double.NEGATIVE_INFINITY;
        }
        f[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= v[i]) {
                    f[i][j] = Math.max(f[i-1][j], f[i-1][j-v[i]] + w[i]);
                } else {
                    f[i][j] = f[i-1][j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, f[n][i]);
        }
        return ans;
    }

    /**
     * 0/1 背包问题
     * zero/one Knapsack problem
     *
     * 一共有 N 个物品，其中第 i 个物品的体积为 vi，价值为 wi。
     * 现要求选择一些物品放入一个容积为 M 的背包中，使得物品总体积不超过 M 的前提下，物品总价值最大。
     *
     * f[i][j] = max(f[i-1][j], f[i-1][j-vi] + wi)
     *
     * @param n num
     * @param m capacity
     * @param v volumes
     * @param w values
     * @return res
     */
    public static int zeroOneKnapsackUpdate(int n, int m, int[] v, int[] w) {
        int[] f = new int[m + 1];
        for (int j = 1; j <= m; j++) {
            f[j] = (int) Double.NEGATIVE_INFINITY;
        }
        f[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j-v[i]] + w[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    /**
     * 分割等和子集
     *
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     *
     * 示例 1
     *
     * 输入: [1, 5, 11, 5]
     * 输出: true
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *
     * 示例 2
     *
     * 输入: [1, 2, 3, 5]
     * 输出: false
     * 解释: 数组不能分割成两个元素和相等的子集.
     *
     * 提示
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     *
     *「将数组分割成两个子集，使得两个子集的元素和相等」，假设数组元素个数为N，元素和为 M，
     * 则问题可以转化为「现有 N 个数字，是否可以选取若干个数字，使其和为 M/2」。
     *
     * f[i][j] = max(f[i-1][j], f[i-1][j-nums[i]])
     * f[0][0] = 1, f[0][i] = 0, 1 <= i =< M/2
     *
     * @param nums nums
     * @return res
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                if (f[j - nums[i - 1]]) {
                    f[j] = true;
                }
            }
        }
        return f[sum];
    }

    /**
     * 目标和
     *
     * 给定一个非负整数数组，a1,a2,a3,..,an和一个目标数S。现在你有两个符号 + 和 -。
     * 对于数组中的任意一个整数，你都可以从 + 或 - 中选择一个符号添加在前面。
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 示例
     *
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     *     -1+1+1+1+1 = 3
     *     +1-1+1+1+1 = 3
     *     +1+1-1+1+1 = 3
     *     +1+1+1-1+1 = 3
     *     +1+1+1+1-1 = 3
     *
     * 一共有5种方法让最终目标和为3。
     *
     * 提示
     *
     * 数组非空，且长度不会超过 20 。
     * 初始的数组的和不会超过 1000 。
     * 保证返回的最终结果能被 32 位整数存下。
     *
     * a - (sum - a) = s => 2a = sum + s => a = (sum + s)/2
     *
     * f[i][j] = f[i-1][j] + f[i-1][j-nums[i]]
     * f[0][0] = 1, f[0][i] = 0, 1 <= i =< (sum + s)/2
     *
     * @param nums nums
     * @param s    s
     * @return sums
     */
    public static int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (s < -sum || s > sum || (sum + s) % 2 != 0) {
            return 0;
        }

        int a = (sum + s) / 2;
        int[] f = new int[a + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = a; j >= nums[i] ; j--) {
                f[j] = f[j] + f[j - nums[i]];
            }
        }

        return f[a];
    }

    /**
     * 零钱兑换
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 - 1。
     *
     * 示例 1
     *
     * 输入: coins = [1, 2, 5], amount = 11
     * 输出: 3
     * 解释: 11 = 5 + 5 + 1
     *
     * 示例 2
     *
     * 输入: coins = [2], amount = 3
     * 输出: -1
     *
     * 提示
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * f[i][j]表示仅考虑前i类硬币，其总金额为j时最少所需硬币个数
     * f[i][j] = min(f[i-1][j], f[i][j-coins[i]] + 1), f[0][0] = 0, f[0][i]= inf, 1 =< i =< M
     *
     * @param coins     coins
     * @param amount    amount
     * @return int
     */
    public static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int inf = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= amount; i++) {
            f[i] = inf;   //防止后续整数溢出
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] = Math.min(f[j], f[j - coins[i]] + 1);
            }
        }

        return f[amount] == inf ? -1 : f[amount];
    }

    /**
     * 零钱兑换 II
     *
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     * 示例 1
     *
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * 示例 2
     *
     * 输入: amount = 3, coins = [2]
     * 输出: 0
     * 解释: 只用面额2的硬币不能凑成总金额3。
     *
     * 示例 3
     *
     * 输入: amount = 10, coins = [10]
     * 输出: 1
     *
     * f[i][j] = f[i-1][j] + f[i][j-coins[i]]
     * f[0][0] = 1, f[0][i] = 0, 1 =< i =< M
     *
     * @param coins     coins
     * @param amount    amount
     * @return int
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                f[j] = f[j] + f[j - coins[i]];
            }
        }
        
        return f[amount];
    }

    /**
     *  一和零
     *
     * 在计算机界中，我们总是追求用有限的资源获取最大的收益。
     * 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。
     * 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。
     * 示例 1
     *
     * 输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
     * 输出: 4
     *
     * 解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0"。
     *
     * 示例 2
     *
     * 输入: Array = {"10", "0", "1"}, m = 1, n = 1
     * 输出: 2
     *
     * 解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1"。
     *
     * 提示
     *
     * 给定 0 和 1 的数量都不会超过 100。
     * 给定字符串数组的长度不会超过 600。
     *
     * f[i][j][k]表示对于前 i 个字符串，一共有 j 个 0 和 k 个 1 时，能拼出的最大字符串个数。
     *
     * f[i][j][k] = max(f[i-1][j][k], f[i-1][j-ai][k-bi] + 1)
     * f[0][j][k] = 0, 0 =< j =< m, 0 =< k =< n
     *
     * @param str  str
     * @param m     m
     * @param n     n
     * @return  res
     */
    public static int findMaxForm(String[] str, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i < str.length; i++) {
            int a = 0, b = 0;
            char[] chars = str[i].toCharArray();
            for (char c : chars) {
                if (c == '0') {
                    a++;
                } else {
                    b++;
                }
            }
            for (int j = m; j >= a ; j--) {
                for (int k = n; k >= b; k--) {
                    f[j][k] = Math.max(f[j][k], f[j-a][k-b] + 1);
                }
            }
        }

        return f[m][n];
    }

    /**
     * 找出最少的硬币——组成所有的面值
     *
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成[1, amount]中所有面值所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。（你可以认为每种硬币的数量是无限的。
     *
     * @param coins coins
     * @param amount amount
     * @return res
     */
    public static int findMinCoins(int[] coins, int amount) {
        //todo:
        return 0;
    }
}
