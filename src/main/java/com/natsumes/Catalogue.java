package com.natsumes;

import com.natsumes.company.ByteDance;
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
 * {@link DynamicProgram#longestPalindrome(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6.Z 字形变换</a>
 * {@link StringHandler#convert(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">8.字符串转换整数 (atoi)</a>
 * {@link StringHandler#myAtoi(String)}
 *
 * <a href="https://leetcode-cn.com/problems/regular-expression-matching/">10.正则表达式匹配</a>
 * {@link DynamicProgram#isMatch(String, String)}
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
 * <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.在排序数组中查找元素的第一个和最后一个位置</a>
 * {@link ArrayTopic#searchRange(int[], int)}
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
 * <a href="https://leetcode-cn.com/problems/minimum-path-sum/">64.最小路径和</a>
 * {@link DynamicProgram#minPathSum(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/edit-distance/">72.编辑距离</a>
 * {@link DynamicProgram#minDistance(java.lang.String, java.lang.String)}
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
 * <a href="https://leetcode-cn.com/problems/word-search/">79.单词搜索</a>
 * {@link DynamicProgram#exist(char[][], java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/largest-rectangle-in-histogram/">84.柱状图中最大的矩形</a>
 * {@link ArrayTopic#largestRectangleArea(int[])}
 * {@link ArrayTopic#largestRectangleArea01(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/maximal-rectangle/">85.最大矩形</a>
 * {@link ArrayTopic#maximalRectangle(char[][]) TODO}
 * {@link ArrayTopic#maximalRectangleCommon(char[][])}
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
 * <a href="https://leetcode-cn.com/problems/path-sum/">112.路径总和</a>
 * {@link BinaryTreeTopic#hasPathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/path-sum-ii/">113.路径总和 II</a>
 * {@link BinaryTreeTopic#pathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/pascals-triangle-ii/">119.杨辉三角 II</a>
 * {@link ArrayTopic#getRow(int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock">121.买卖股票的最佳时机</a>
 * {@link DynamicProgram#maxProfit01(int[])}
 * {@link DynamicProgram#maxProfitBySearch(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">122.买卖股票的最佳时机 II</a>
 * {@link DynamicProgram#maxProfit02(int[])}
 * {@link DynamicProgram#maxProfit0202(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">123.买卖股票的最佳时机 III</a>
 * {@link DynamicProgram#maxProfit03(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">124.二叉树中的最大路径和</a>
 * {@link BinaryTreeTopic#maxPathSum(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">128.最长连续序列</a>
 * {@link UnionFinder#longestConsecutive(int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">129.求根到叶子节点数字之和</a>
 * {@link BinaryTreeTopic#sumNumbers(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/surrounded-regions/">130.被围绕的区域</a>
 * {@link UnionFinder#solve(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/gas-station/">134.加油站</a>
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
 * TODO: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/">188.买卖股票的最佳时机 IV</a>
 * {@link DynamicProgram#maxProfit04(int, int[])}
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
 * <a href="https://leetcode-cn.com/problems/maximal-square/">221.最大正方形</a>
 * {@link DynamicProgram#maximalSquare(char[][])}
 *
 * <a href="https://leetcode-cn.com/problems/search-a-2d-matrix-ii/">240.搜索二维矩阵 II</a>
 * {@link ArrayTopic#searchMatrix2(int[][], int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/count-univalue-subtrees/">250.统计同值子树</a>
 * {@link BinaryTreeTopic#countUnivalSubtrees(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">257.二叉树的所有路径</a>
 * {@link BinaryTreeTopic#binaryTreePaths(com.natsumes.leetcode.tree.TreeNode)}
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
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309.最佳买卖股票时机含冷冻期</a>
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
 * TODO: 复习
 * <a href="https://leetcode-cn.com/problems/decode-string/">394.字符串解码</a>
 * {@link StringHandler#decodeString(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">424.替换后的最长重复字符</a>
 * {@link SlidingWindow#characterReplacement(java.lang.String, int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/path-sum-iii/">437.路径总和 III</a>
 * {@link BinaryTreeTopic#pathSumIII(com.natsumes.leetcode.tree.TreeNode, int)}
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
 * <a href="https://leetcode-cn.com/problems/longest-palindromic-subsequence/">516.最长回文子序列</a>
 * {@link DynamicProgram#longestPalindromeSubseq(java.lang.String)}
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
 * <a href="https://leetcode-cn.com/problems/reshape-the-matrix/">566.重塑矩阵</a>
 * {@link ArrayTopic#matrixReshape(int[][], int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/permutation-in-string/">567.字符串的排列</a>
 * {@link SlidingWindow#checkInclusion(java.lang.String, java.lang.String)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/path-sum-iv/">666.路径总和 IV</a>
 * {@link BinaryTreeTopic#pathSum(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/trim-a-binary-search-tree/submissions/">669.修剪二叉搜索树</a>
 * {@link BinaryTreeTopic#trimBST(com.natsumes.leetcode.tree.TreeNode, int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/redundant-connection/">684.冗余连接</a>
 * {@link UnionFinder#findRedundantConnection(int[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/longest-univalue-path/">687.最长同值路径</a>
 * {@link BinaryTreeTopic#longestUnivaluePath(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/max-area-of-island/">695.岛屿的最大面积</a>
 * {@link UnionFinder#maxAreaOfIsland(int[][])}
 * {@link DynamicProgram#maxAreaOfIsland(int[][]) 深度优先搜索解法}
 *
 * <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">713.乘积小于K的子数组</a>
 * {@link SlidingWindow#numSubarrayProductLessThanK(int[], int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714.买卖股票的最佳时机含手续费</a>
 * {@link DynamicProgram#maxProfit(int[], int)}
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
 * <a href="https://leetcode-cn.com/problems/super-egg-drop/">887.鸡蛋掉落</a>
 * {@link DynamicProgram#superEggDrop(int, int) TODO: 各种方法}
 *
 * <a href="https://leetcode-cn.com/problems/fruit-into-baskets/">904.水果成篮</a>
 * {@link SlidingWindow#totalFruit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/minimize-malware-spread/">924.尽量减少恶意软件的传播</a>
 * {@link UnionFinder#minMalwareSpread(int[][], int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/">988.从叶结点开始的最小字符串</a>
 * {@link BinaryTreeTopic#smallestFromLeaf(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/satisfiability-of-equality-equations/">990.等式方程的可满足性</a>
 * {@link UnionFinder#equationsPossible(java.lang.String[])}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips/">995.K连续位的最小翻转次数</a>
 * {@link SlidingWindow#minKBitFlips(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/">1003.检查替换后的词是否有效</a>
 * {@link StringHandler#isValidString(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">1143.最长公共子序列</a>
 * {@link DynamicProgram#longestCommonSubsequence(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/">1277.统计全为1的正方形子矩阵</a>
 * {@link DynamicProgram#countSquares(int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">1312.让字符串成为回文串的最少插入次数</a>
 * {@link DynamicProgram#minInsertions(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box/">1742.盒子中小球的最大数量</a>
 * {@link ArrayTopic#countBalls(int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/">1743.从相邻元素对还原数组</a>
 * {@link ArrayTopic#restoreArray(int[][])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/">1744.你能在你最喜欢的那天吃到你最喜欢的糖果吗？</a>
 * {@link ByteDance#canEat(int[], int[][])}
 *
 * <a href="https://leetcode-cn.com/problems/palindrome-partitioning-iv/">1745.回文串分割 IV</a>
 * {@link DynamicProgram#checkPartitioning(String)}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string/">1758.生成交替二进制字符串的最少操作数</a>
 * {@link StringHandler#minOperations(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/contest/weekly-contest-228/problems/count-number-of-homogenous-substrings/">1759.统计同构子字符串的数目</a>
 * {@link StringHandler#countHomogenous(java.lang.String)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-limit-of-balls-in-a-bag/">1760.袋子里最少数目的球</a>
 * {@link ArrayTopic#minimumSize(int[], int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/">1761.一个图中连通三元组的最小度数</a>
 * {@link UnionFinder#minTrioDegree(int, int[][])}
 *
 */
public class Catalogue {
}
