package com.natsumes;

import com.natsumes.leetcode.DfsAndBinarySearch;
import com.natsumes.leetcode.array.ArrayTopic;
import com.natsumes.leetcode.dp.DynamicProgram;
import com.natsumes.leetcode.list.LinkedListTopic;
import com.natsumes.leetcode.nsum.NumSums;
import com.natsumes.leetcode.permute.Permute;
import com.natsumes.leetcode.sliding.SlidingWindow;
import com.natsumes.leetcode.string.StringHandler;
import com.natsumes.leetcode.tree.BinarySearchTreeTopic;
import com.natsumes.leetcode.tree.BinaryTreeTopic;
import com.natsumes.leetcode.unionfind.UnionFinder;

/**
 * @author hetengjiao
 *
 * <a href="https://leetcode-cn.com/problems/two-sum/">1.两数之和</a>
 * {@link NumSums#twoSum(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">2.两数相加</a>
 * {@link LinkedListTopic#addTwoNumbers(com.natsumes.leetcode.list.ListNode, com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">3.无重复字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstring(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">4.寻找两个正序数组的中位数</a>
 * {@link ArrayTopic#findMedianSortedArrays(int[], int[])}
 * {@link ArrayTopic#findMedianSortedArrays02(int[], int[])}}
 *
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-substring/">5.最长回文子串</a>
 * {@link com.natsumes.company.ByteDance#longestPalindrome(String)}
 *
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6.Z 字形变换</a>
 * {@link StringHandler#convert(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">8.字符串转换整数 (atoi)</a>
 * {@link StringHandler#myAtoi(String)}
 *
 * <a href="https://leetcode-cn.com/problems/container-with-most-water/">11.盛最多水的容器</a>
 * {@link ArrayTopic#maxArea(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/3sum/">15.三数之和</a>
 * {@link NumSums#threeSum(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/4sum/">18.四数之和</a>
 * {@link NumSums#fourSum(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/">20.有效的括号</a>
 * {@link StringHandler#isValid(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21.合并两个有序链表</a>
 * {@link LinkedListTopic#mergeTwoLists(com.natsumes.leetcode.list.ListNode, com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/generate-parentheses/">22.括号生成</a>
 * {@link DynamicProgram#generateParenthesis(int)}
 *
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23.合并K个升序链表</a>
 * {@link LinkedListTopic#mergeKLists(com.natsumes.leetcode.list.ListNode[])}
 *
 * <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">25.K个一组翻转链表</a>
 * {@link LinkedListTopic#reverseKGroup(com.natsumes.leetcode.list.ListNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/next-permutation/">31.下一个排列</a>
 * {@link Permute#nextPermutation(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">32.最长有效括号</a>
 * {@link DynamicProgram#longestValidParentheses(java.lang.String)}
 * {@link DynamicProgram#longestValidParentheses2(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">33.搜索旋转排序数组</a>
 * {@link ArrayTopic#search(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/combination-sum/">39.组合总和</a>
 * {@link Permute#combinationSum(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/trapping-rain-water/">42.接雨水</a>
 * {@link ArrayTopic#trap(int[])}
 * {@link ArrayTopic#trap02(int[])}
 * {@link ArrayTopic#trap01(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/permutations/">46.全排列</a>
 * {@link Permute#permute(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">53.最大子序和</a>
 * {@link DynamicProgram#maxSubArray(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix/">54.螺旋矩阵</a>
 * {@link ArrayTopic#spiralOrder(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/merge-intervals/">56.合并区间</a>
 * {@link ArrayTopic#merge(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">59.螺旋矩阵 II</a>
 * {@link ArrayTopic#generateMatrix(int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64.最小路径和</a>
 * {@link DynamicProgram#minPathSum(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix/">74.搜索二维矩阵</a>
 * {@link ArrayTopic#searchMatrix(int[][], int)}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-window-substring/">76.最小覆盖子串</a>
 * {@link SlidingWindow#minWindow(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/subsets/">78.子集</a>
 * {@link DfsAndBinarySearch#subsets(int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/word-search/">79.单词搜索</a>
 * {@link DynamicProgram#exist(char[][], java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">93.复原IP地址</a>
 * {@link DfsAndBinarySearch#restoreIpAddresses(java.lang.String)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/unique-binary-search-trees/">96.不同的二叉搜索树</a>
 * {@link BinarySearchTreeTopic#numTrees(int)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103.二叉树的锯齿形层序遍历</a>
 * {@link BinaryTreeTopic#zigzagLevelOrder(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-path-sum/">113.路径总和 II</a>
 * {@link DynamicProgram#pathSum(com.natsumes.leetcode.dp.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">119.杨辉三角 II</a>
 * {@link ArrayTopic#getRow(int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">128.最长连续序列</a>
 * {@link UnionFinder#longestConsecutive(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/surrounded-regions/">130.被围绕的区域</a>
 * {@link UnionFinder#solve(char[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/gas-station/">134.加油站</a>
 * {@link DynamicProgram#canCompleteCircuit(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/">159.至多包含两个不同字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstringTwoDistinct(java.lang.String)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/rank-scores/">178.分数排名</a>
 *
 * <a href="https://leetcode-cn.com/problems/largest-number/">179.最大数</a>
 * {@link ArrayTopic#largestNumber(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber/">198.打家劫舍</a>
 * {@link DynamicProgram#rob1(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">199.二叉树的右视图</a>
 * {@link BinaryTreeTopic#rightSideView(com.natsumes.leetcode.tree.TreeNode)
 * {@link BinaryTreeTopic#rightSideView01(com.natsumes.leetcode.tree.TreeNode)
 *
 * <a href="https://leetcode-cn.com/problems/number-of-islands/">200.岛屿数量 </a>
 * {@link UnionFinder#numIslands(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">209.长度最小的子数组</a>
 * {@link SlidingWindow#minSubArrayLen(int, int[])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-ii/">213.打家劫舍 II</a>
 * {@link DynamicProgram#rob(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">215.数组中的第K个最大元素</a>
 * {@link ArrayTopic#findKthLargest(int[], int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/maximal-square/">221.最大正方形</a>
 * {@link DynamicProgram#maximalSquare(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">240.搜索二维矩阵 II</a>
 * {@link ArrayTopic#searchMatrix2(int[][], int)}
 *
 * <a href="https://leetcode-cn.com/problems/graph-valid-tree/">261.以图判树</a>
 * {@link UnionFinder#validTree(int, int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">300.最长递增子序列</a>
 * {@link DynamicProgram#lengthOfLis(int[]) }
 * {@link DynamicProgram#patienceSorting(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/remove-invalid-parentheses/">301.删除无效的括号</a>
 * {@link DynamicProgram#removeInvalidParentheses(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-islands-ii/">305.岛屿数量 II</a>
 * {@link UnionFinder#numIslands2(int, int, int[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309.最佳买卖股票时机含冷冻期</a>
 * {@link DynamicProgram#maxProfit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/coin-change/">322.零钱兑换</a>
 * {@link DynamicProgram#coinChange(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/">323.无向图中连通分量的数目</a>
 * {@link UnionFinder#countComponents(int, int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/house-robber-iii/">337.打家劫舍 III</a>
 * {@link DynamicProgram#rob(com.natsumes.leetcode.dp.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/">340.至多包含K个不同字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstringKDistinct(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">347.前 K 个高频元素</a>
 * {@link ArrayTopic#topKsFrequent(int[], int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/decode-string/">394.字符串解码</a>
 * {@link StringHandler#decodeString(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">424.替换后的最长重复字符</a>
 * {@link SlidingWindow#characterReplacement(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/">448.找到所有数组中消失的数字</a>
 * {@link ArrayTopic#findDisappearedNumbers(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/sliding-window-median/">480.滑动窗口中位数</a>
 * {@link SlidingWindow#medianSlidingWindow(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/max-consecutive-ones/">485.最大连续1的个数</a>
 * {@link SlidingWindow#findMaxConsecutiveOnes(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/next-greater-element-i/">496.下一个更大元素 I</a>
 * {@link ArrayTopic#nextGreaterElement(int[], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/next-greater-element-ii/">503.下一个更大元素 II</a>
 * {@link ArrayTopic#nextGreaterElements(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-provinces/">547.省份数量</a>
 * {@link UnionFinder#findCircleNum(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/next-greater-element-iii/">556.下一个更大元素 III</a>
 * {@link ArrayTopic#nextGreaterElement(int)}
 *
 * <a href="https://leetcode-cn.com/problems/array-partition-i/">561.数组拆分 I</a>
 * {@link ArrayTopic#arrayPairSum(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/permutation-in-string/">567.字符串的排列</a>
 * {@link SlidingWindow#checkInclusion(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/redundant-connection/">684.冗余连接</a>
 * {@link UnionFinder#findRedundantConnection(int[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/max-area-of-island/">695.岛屿的最大面积</a>
 * {@link UnionFinder#maxAreaOfIsland(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">713.乘积小于K的子数组</a>
 * {@link SlidingWindow#numSubarrayProductLessThanK(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/accounts-merge/">721.账户合并</a>
 * {@link UnionFinder#accountsMerge(java.util.List)}
 *
 * <a href="https://leetcode-cn.com/problems/daily-temperatures/">739.每日温度</a>
 * {@link ArrayTopic#dailyTemperatures(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/couples-holding-hands/">765.情侣牵手</a>
 * {@link UnionFinder#minSwapsCouples(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/swim-in-rising-water/">778.水位上升的泳池中游泳</a>
 * {@link UnionFinder#swimInWater(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/">795.区间子数组个数</a>
 * {@link SlidingWindow#numSubarrayBoundedMax(int[], int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/bricks-falling-when-hit/">803.打砖块</a>
 * {@link UnionFinder#hitBricks(int[][], int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/similar-string-groups/">839.相似字符串组</a>
 * {@link UnionFinder#numSimilarGroups(java.lang.String[])}
 *
 * <a href="https://leetcode-cn.com/problems/fruit-into-baskets/">904.水果成篮</a>
 * {@link SlidingWindow#totalFruit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/minimize-malware-spread/">924.尽量减少恶意软件的传播</a>
 * {@link UnionFinder#minMalwareSpread(int[][], int[])}
 *
 * <a href="https://leetcode-cn.com/problems/satisfiability-of-equality-equations/">990.等式方程的可满足性</a>
 * {@link UnionFinder#equationsPossible(java.lang.String[])}
 *
 * <a href="https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/">1003.检查替换后的词是否有效</a>
 * {@link StringHandler#isValidString(java.lang.String)}
 *
 */
public class Catalogue {
}
