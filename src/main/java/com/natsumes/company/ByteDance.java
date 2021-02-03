package com.natsumes.company;

import java.util.*;

/**
 *
 * 字节跳动题库
 *
 * @author hetengjiao
 *
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.寻找两个正序数组的中位数</a>
 * @see com.natsumes.company.ByteDance#findMedianSortedArrays(int[], int[])
 *
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5.最长回文子串</a>
 * @see com.natsumes.company.ByteDance#longestPalindrome(String)
 *
 * <a href="https://leetcode-cn.com/problems/reorder-list/">143.重排链表</a>
 * @see com.natsumes.leetcode.LinkedListTopic#reorderList(com.natsumes.leetcode.ListNode)
 *
 * <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
 * @see com.natsumes.leetcode.LinkedListTopic#sortList(com.natsumes.leetcode.ListNode)
 *
 * <a href="https://leetcode-cn.com/problems/insertion-sort-list/">147.对链表进行插入排序</a>
 * @see com.natsumes.leetcode.LinkedListTopic#insertionSortList(com.natsumes.leetcode.ListNode)
 *
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">42.接雨水</a>
 * @see com.natsumes.company.ByteDance#trap(int[])
 *
 * <a href="https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/">5665.从相邻元素对还原数组</a>
 * @see com.natsumes.company.ByteDance#restoreArray(int[][])
 *
 * <a href="https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/">
 *     5667.你能在你最喜欢的那天吃到你最喜欢的糖果吗？</a>
 * @see com.natsumes.company.ByteDance#canEat(int[], int[][])
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">199.二叉树的右视图</a>
 * @see com.natsumes.company.ByteDance#rightSideView(com.natsumes.company.TreeNode)
 *
 * <a href="">查找完全二叉树的最后一层最右边的节点</a>
 * @see com.natsumes.company.ByteDance#findLastRightNode(TreeNode)
 *
 * <a href="https://leetcode-cn.com/problems/palindrome-partitioning-iv/">1745.回文串分割 IV</a>
 * @see com.natsumes.company.ByteDance#checkPartitioning(String)
 *
 * <a href="https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box/">1742.盒子中小球的最大数量</a>
 * @see com.natsumes.company.ByteDance#countBalls(int, int)
 *
 */
public class ByteDance {

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
     * @see ByteDance
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
     *
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     *
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *
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
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     * @param s s
     * @return String
     * @see ByteDance
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
     * 查找完全二叉树的最后一层最右边的节点
     *
     * 对每个子树的根节点，先从它的右子树开始，沿着左分支一直走到最后一层，如果深度等于树的深度
     * 且该最后节点右边没有节点，则为所求；
     * 否则，右侧右节点，则遍历右子树，深度小于树的深度，则遍历左子树
     *
     *            1
     *          /  \
     *         2    2
     *        / \  / \
     *       3  4 4   3
     *
     * @param treeNode treeNode
     * @return treeNode
     * @see ByteDance
     */
    public TreeNode findLastRightNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode;
        }

        TreeNode curTreeNode = treeNode;
        int depth = 0;
        while (curTreeNode != null) {
            curTreeNode = curTreeNode.left;
            depth++;
        }
        int level = 0;
        int tempDepth;
        while (treeNode != null) {
            level++;
            if (level == depth) {
                break;
            }
            if (treeNode.right != null) {
                curTreeNode = treeNode.right;
                TreeNode preTreeNode = curTreeNode;
                tempDepth = level + 1;
                while (curTreeNode.left != null) {
                    tempDepth++;
                    preTreeNode = curTreeNode;
                    curTreeNode = curTreeNode.left;
                }
                if (tempDepth < depth) {
                    treeNode = treeNode.left;
                } else if (preTreeNode.right == null || preTreeNode.right == curTreeNode) {
                    return curTreeNode;
                } else {
                    treeNode = treeNode.right;
                }
            } else {
                treeNode = treeNode.left;
            }
        }

        return treeNode;
    }

    /**
     * 1742. 盒子中小球的最大数量
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
     * 1 <= lowLimit <= highLimit <= 105
     *
     * @param lowLimit lowLimit
     * @param highLimit highLimit
     * @return int
     * @see ByteDance
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
     * 3 <= s.length <= 2000
     * s​​​​​​ 只包含小写英文字母。
     *
     * @param s s
     * @return b
     * @see ByteDance
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
     * https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
     *
     * 5665.从相邻元素对还原数组
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
     * 2 <= n <= 105
     * -105 <= nums[i], ui, vi <= 105
     * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
     *
     * @param adjacentPairs adj
     * @return int[]
     * @see ByteDance
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        //用list保存前后两个数
        HashMap<Integer, List<Integer>> map = new HashMap<>();
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
     * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
     *
     * 5667. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
     * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。
     * 同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
     *
     * 你按照如下规则进行一场游戏：
     *
     * 你从第 0 天开始吃糖果。
     * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
     * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
     * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：
     * 在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；
     * 否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
     *
     * 请你返回得到的数组 answer 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
     * 输出：[true,false,true]
     * 提示：
     * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
     * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），
     * 你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
     * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
     * 示例 2：
     *
     * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
     * 输出：[false,true,true,false,false]
     *
     * @param candiesCount candiesCount
     * @param queries queries
     * @return boolean
     *
     * @see ByteDance
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        return null;
    }

    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/
     *
     * 42.接雨水
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     *
     *
     * 示例 1：
     *
     *
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
     * @see ByteDance
     * @see ByteDance#trap(int[]) 双指针法
     * @see ByteDance#trap02(int[]) 备忘录解法
     * @see ByteDance#trap01(int[]) 暴力解法
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
     * 199. 二叉树的右视图
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     * @param root root  @Nullable
     * @return List
     * @see ByteDance
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelValue = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValue = Objects.requireNonNull(node).val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(levelValue);
        }
        return res;
    }

}
