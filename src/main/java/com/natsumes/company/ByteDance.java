package com.natsumes.company;


import com.natsumes.leetcode.array.ArrayTopic;
import com.natsumes.leetcode.dp.DynamicProgram;
import com.natsumes.leetcode.graph.Graph;
import com.natsumes.leetcode.permute.Permute;
import com.natsumes.leetcode.string.StringHandler;
import com.natsumes.leetcode.tree.BinarySearchTreeTopic;
import com.natsumes.leetcode.tree.BinaryTreeTopic;
import com.natsumes.leetcode.unionfind.UnionFinder;

/**
 *
 * <h3>字节跳动题库</h3>
 *
 * =====================================================================================================================
 * <h4>DFS 问题</h4>
 * <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">93.复原IP地址</a>
 * {@link com.natsumes.leetcode.DfsAndBinarySearch#restoreIpAddresses(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/subsets/">78.子集</a>
 * {@link com.natsumes.leetcode.DfsAndBinarySearch#subsets(int[])}
 *
 * =====================================================================================================================
 * <h4>1.dp 问题</h4>
 * {@link com.natsumes.leetcode.dp.DynamicProgram}
 *
 * <a href="https://leetcode-cn.com/problems/maximal-square/">221.最大正方形</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#maximalSquare(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/coin-change/">322.零钱兑换</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#coinChange(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/word-search/">79.单词搜索</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#exist(char[][], java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">121.买卖股票的最佳时机</a>
 * {@link DynamicProgram#maxProfit01(int[])}
 * {@link DynamicProgram#maxProfitBySearch(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309.最佳买卖股票时机含冷冻期</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#maxProfit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64.最小路径和</a>
 * {@link DynamicProgram#minPathSum(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">257.二叉树的所有路径</a>
 * {@link BinaryTreeTopic#binaryTreePaths(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/path-sum/">112.路径总和</a>
 * {@link BinaryTreeTopic#hasPathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/path-sum-ii/">113.路径总和 II</a>
 * {@link BinaryTreeTopic#pathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/path-sum-iii/">437.路径总和 III</a>
 * {@link BinaryTreeTopic#pathSumIII(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">124.二叉树中的最大路径和</a>
 * {@link BinaryTreeTopic#maxPathSum(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">129.求根到叶子节点数字之和</a>
 * {@link BinaryTreeTopic#sumNumbers(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/">988.从叶结点开始的最小字符串</a>
 * {@link BinaryTreeTopic#smallestFromLeaf(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/gas-station/">134.加油站</a>
 * {@link DynamicProgram#canCompleteCircuit(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/generate-parentheses/">22.括号生成</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#generateParenthesis(int)}
 *
 * <a href="https://leetcode-cn.com/problems/remove-invalid-parentheses/">301.删除无效的括号</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#removeInvalidParentheses(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">32.最长有效括号</a>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#longestValidParentheses(java.lang.String)}
 * {@link com.natsumes.leetcode.dp.DynamicProgram#longestValidParentheses2(java.lang.String)}
 *
 * <p><a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a></p>
 * {@link com.natsumes.leetcode.dp.DynamicProgram#maxSubArray(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">1143.最长公共子序列</a>
 * {@link DynamicProgram#longestCommonSubsequence(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/edit-distance/">72.编辑距离</a>
 * {@link DynamicProgram#minDistance(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-subsequence/">516.最长回文子序列</a>
 * {@link DynamicProgram#longestPalindromeSubseq(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/regular-expression-matching/">10.正则表达式匹配</a>
 * {@link DynamicProgram#isMatch(String, String)}
 *
 * <a href="https://leetcode-cn.com/problems/super-egg-drop/">887.鸡蛋掉落</a>
 * {@link DynamicProgram#superEggDrop(int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/burst-balloons/">312.戳气球</a>
 * {@link DynamicProgram#maxCoins(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/jump-game-ii/">45.跳跃游戏 II</a>
 * {@link DynamicProgram#jump(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/jump-game/">55.跳跃游戏</a>
 * {@link DynamicProgram#canJump(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/unique-paths/">62.不同路径</a>
 * {@link DynamicProgram#uniquePaths(int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/climbing-stairs/">70.爬楼梯</a>
 * {@link DynamicProgram#climbStairs(int)}
 *
 * <a href="https://leetcode-cn.com/problems/candy/">135.分发糖果</a>
 * {@link DynamicProgram#candy(int[])}
 * {@link DynamicProgram#candy01(int[])}
 *
 * =====================================================================================================================
 * <h4>2.n sum 问题</h4>
 * {@link com.natsumes.leetcode.nsum.NumSums}
 *
 * <a href="https://leetcode-cn.com/problems/two-sum/">1.两数之和</a>
 * {@link com.natsumes.leetcode.nsum.NumSums#twoSum(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/3sum/">15.三数之和</a>
 * {@link com.natsumes.leetcode.nsum.NumSums#threeSum(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/4sum/">18.四数之和</a>
 * {@link com.natsumes.leetcode.nsum.NumSums#fourSum(int[], int)}
 *
 * =====================================================================================================================
 * <h4>3.排列问题</h4>
 * {@link com.natsumes.leetcode.permute.Permute 排列问题}
 *
 * <a href="https://leetcode-cn.com/problems/next-permutation/">31.下一个排列</a>
 * {@link com.natsumes.leetcode.permute.Permute#nextPermutation(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/combination-sum/">39.组合总和</a>
 * {@link Permute#combinationSum(int[], int)}
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.寻找两个正序数组的中位数</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#findMedianSortedArrays(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5.最长回文子串</a>
 * {@link DynamicProgram#longestPalindrome(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/largest-number/">179.最大数</a>
 * {@link ArrayTopic#largestNumber(int[])}
 *
 * =====================================================================================================================
 * <h4>4.链表问题</h4>
 * {@link com.natsumes.leetcode.list.LinkedListTopic}
 *
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list/">206.反转链表</a>
 * {@link com.natsumes.leetcode.list.LinkedListTopic#reverseList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/reorder-list/">143.重排链表</a>
 * {@link com.natsumes.leetcode.list.LinkedListTopic#reorderList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
 * {@link com.natsumes.leetcode.list.LinkedListTopic#sortList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/insertion-sort-list/">147.对链表进行插入排序</a>
 * {@link com.natsumes.leetcode.list.LinkedListTopic#insertionSortList(com.natsumes.leetcode.list.ListNode)}
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">42.接雨水</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#trap(int[])}
 * {@link com.natsumes.leetcode.array.ArrayTopic#trap02(int[])}
 * {@link com.natsumes.leetcode.array.ArrayTopic#trap01(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/">
 *     5667.你能在你最喜欢的那天吃到你最喜欢的糖果吗？</a>
 * {@link com.natsumes.company.ByteDance#canEat(int[], int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103.二叉树的锯齿形层序遍历</a>
 * {@link com.natsumes.leetcode.tree.BinaryTreeTopic#zigzagLevelOrder(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">199.二叉树的右视图</a>
 * {@link com.natsumes.leetcode.tree.BinaryTreeTopic#rightSideView(com.natsumes.leetcode.tree.TreeNode)
 * {@link com.natsumes.leetcode.tree.BinaryTreeTopic#rightSideView01(com.natsumes.leetcode.tree.TreeNode)
 *
 * <a>查找完全二叉树的最后一层最右边的节点</a>
 * {@link BinaryTreeTopic#findLastRightNode(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/merge-intervals/">56.合并区间</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#merge(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">215.数组中的第K个最大元素</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#findKthLargest(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix/">54.螺旋矩阵</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#spiralOrder(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">59.螺旋矩阵 II</a>
 * {@link ArrayTopic#generateMatrix(int)}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">74.搜索二维矩阵</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#searchMatrix(int[][], int)}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">240.搜索二维矩阵 II</a>
 * {@link com.natsumes.leetcode.array.ArrayTopic#searchMatrix2(int[][], int)}
 *
 * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">8.字符串转换整数 (atoi)</a>
 * {@link StringHandler#myAtoi(String)}
 *
 * <a href="https://leetcode-cn.com/problems/decode-string/">394.字符串解码</a>
 * {@link StringHandler#decodeString(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6.Z 字形变换</a>
 * {@link StringHandler#convert(java.lang.String, int)}
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
 * <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.在排序数组中查找元素的第一个和最后一个位置</a>
 * {@link ArrayTopic#searchRange(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">84.柱状图中最大的矩形</a>
 * {@link ArrayTopic#largestRectangleArea(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/first-missing-positive/submissions/">41.缺失的第一个正数</a>
 * {@link ArrayTopic#firstMissingPositive(int[])}
 *
 * =====================================================================================================================
 * <h4>并查集</h4>
 *
 * <a href="https://leetcode-cn.com/problems/max-area-of-island/">695.岛屿的最大面积</a>
 * {@link UnionFinder#maxAreaOfIsland(int[][])}
 * {@link DynamicProgram#maxAreaOfIsland(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">96.不同的二叉搜索树</a>
 * {@link BinarySearchTreeTopic#numTrees(int)}
 * {@link BinarySearchTreeTopic#numTrees01(int)}
 *
 * =====================================================================================================================
 * <h4>图</h4>
 *
 * <a href="https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/">440.字典序的第K小数字</a>
 * {@link Graph#findKthNumber(int, int)}
 *
 *
 * @author hetengjiao
 */
public class ByteDance {

    /**
     * https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
     *
     * 1744.你能在你最喜欢的那天吃到你最喜欢的糖果吗？
     *
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

}
