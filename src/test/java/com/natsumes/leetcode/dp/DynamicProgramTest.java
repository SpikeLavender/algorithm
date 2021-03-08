package com.natsumes.leetcode.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class DynamicProgramTest {

    private final DynamicProgram dp = new DynamicProgram();

    @Test
    public void maxSubArray() {
        Assert.assertEquals(6, dp.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        Assert.assertEquals(1, dp.maxSubArray(new int[] {1}));
        Assert.assertEquals(0, dp.maxSubArray(new int[] {0}));
        Assert.assertEquals(-1, dp.maxSubArray(new int[] {-1}));
        Assert.assertEquals(-100000, dp.maxSubArray(new int[] {-100000}));
    }

    @Test
    public void lengthOfLIS() {
        Assert.assertEquals(4, dp.lengthOfLis(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, dp.lengthOfLis(new int[] {0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, dp.lengthOfLis(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void patienceSorting() {
        Assert.assertEquals(4, dp.patienceSorting(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(4, dp.patienceSorting(new int[] {0, 1, 0, 3, 2, 3}));
        Assert.assertEquals(1, dp.patienceSorting(new int[] {7, 7, 7, 7, 7, 7, 7}));
    }

    @Test
    public void longestValidParentheses() {
        Assert.assertEquals(2, dp.longestValidParentheses("(()"));
        Assert.assertEquals(2, dp.longestValidParentheses("())"));
        Assert.assertEquals(4, dp.longestValidParentheses(")()())"));
        Assert.assertEquals(6, dp.longestValidParentheses(")(()())"));
        Assert.assertEquals(0, dp.longestValidParentheses(""));
    }

    @Test
    public void longestValidParentheses2() {
        Assert.assertEquals(2, dp.longestValidParentheses2("(()"));
        Assert.assertEquals(2, dp.longestValidParentheses2("())"));
        Assert.assertEquals(4, dp.longestValidParentheses2(")()())"));
        Assert.assertEquals(6, dp.longestValidParentheses2(")(()())"));
        Assert.assertEquals(0, dp.longestValidParentheses2(""));
    }

    @Test
    public void generateParenthesis() {
        List<String> strings = dp.generateParenthesis(3);
        System.out.println(strings);
    }

    @Test
    public void removeInvalidParentheses() {
        List<String> strings = dp.removeInvalidParentheses("()())()");
        System.out.println(strings);

        strings = dp.removeInvalidParentheses("(a)())()");
        System.out.println(strings);

        strings = dp.removeInvalidParentheses(")(");
        System.out.println(strings);
    }

    @Test
    public void rob3() {
        TreeNode root = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1))
        );
        Assert.assertEquals(7, dp.rob(root));

        root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1))
        );
        Assert.assertEquals(9, dp.rob(root));
    }

    @Test
    public void rob() {
        Assert.assertEquals(1, dp.rob(new int[] {1}));
        Assert.assertEquals(3, dp.rob(new int[] {2, 3, 2}));
        Assert.assertEquals(4, dp.rob(new int[] {1, 2, 3, 1}));
        Assert.assertEquals(0, dp.rob(new int[] {0}));
        Assert.assertEquals(3, dp.rob(new int[] {2, 3}));
        Assert.assertEquals(3, dp.rob(new int[] {3, 2}));
        Assert.assertEquals(0, dp.rob(new int[] {}));
    }

    @Test
    public void rob1() {
        Assert.assertEquals(0, dp.rob1(new int[] {}));
        Assert.assertEquals(1, dp.rob1(new int[] {1}));
        Assert.assertEquals(2, dp.rob1(new int[] {1, 2}));
        Assert.assertEquals(4, dp.rob1(new int[] {1, 2, 3, 1}));
        Assert.assertEquals(12, dp.rob1(new int[] {2, 7, 9, 3, 1}));
    }

    @Test
    public void coinChange() {
        Assert.assertEquals(3, dp.coinChange(new int[]{1, 2, 5}, 11));
        Assert.assertEquals(-1, dp.coinChange(new int[]{2}, 3));
        Assert.assertEquals(0, dp.coinChange(new int[]{1}, 0));
        Assert.assertEquals(1, dp.coinChange(new int[]{1}, 1));
        Assert.assertEquals(2, dp.coinChange(new int[]{1}, 2));
    }

    /**
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：4
     *
     *
     *
     * 输入：matrix = [["0","1"],["1","0"]]
     * 输出：1
     *
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     *  
     */
    @Test
    public void maximalSquare() {
        Assert.assertEquals(4, dp.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        Assert.assertEquals(1, dp.maximalSquare(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }));

        Assert.assertEquals(0, dp.maximalSquare(new char[][]{{'0'}}));
    }

    @Test
    public void maximalSquare01() {
        Assert.assertEquals(4, dp.maximalSquare01(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));

        Assert.assertEquals(1, dp.maximalSquare01(new char[][]{
                {'0', '1'},
                {'1', '0'}
        }));

        Assert.assertEquals(0, dp.maximalSquare01(new char[][]{{'0'}}));
    }

    /**
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
     */
    @Test
    public void exist() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Assert.assertTrue(dp.exist(board, "ABCCED"));
        Assert.assertTrue(dp.exist(board, "SEE"));
        Assert.assertFalse(dp.exist(board, "ABCB"));
    }

    @Test
    public void maxProfit01() {
        Assert.assertEquals(5, dp.maxProfit01(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, dp.maxProfit01(new int[] {7,6,4,3,1}));
    }

    @Test
    public void maxProfitBySearch() {
        Assert.assertEquals(5, dp.maxProfitBySearch(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, dp.maxProfitBySearch(new int[] {7,6,4,3,1}));
    }

    @Test
    public void maxProfit02() {
        Assert.assertEquals(7, dp.maxProfit02(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, dp.maxProfit02(new int[] {7,6,4,3,1}));
        Assert.assertEquals(4, dp.maxProfit02(new int[] {1,2,3,4,5}));
    }

    @Test
    public void maxProfit0202() {
        Assert.assertEquals(7, dp.maxProfit0202(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, dp.maxProfit0202(new int[] {7,6,4,3,1}));
        Assert.assertEquals(4, dp.maxProfit0202(new int[] {1,2,3,4,5}));
    }

    @Test
    public void maxProfit03() {
        Assert.assertEquals(6, dp.maxProfit03(new int[] {3, 3, 5, 0, 0, 3, 1, 4}));
        Assert.assertEquals(4, dp.maxProfit03(new int[] {1, 2, 3, 4, 5}));
        Assert.assertEquals(0, dp.maxProfit03(new int[] {7, 6, 4, 3, 1}));
        Assert.assertEquals(0, dp.maxProfit03(new int[] {1}));
    }

    @Test
    public void maxProfit() {
        Assert.assertEquals(3, dp.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    @Test
    public void minPathSum() {
        Assert.assertEquals(7, dp.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));

        Assert.assertEquals(12, dp.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }));
    }

    @Test
    public void checkPartitioning() {
        Assert.assertTrue(dp.checkPartitioning("juchzcedhfesefhdeczhcujzzvbmoeombv"));
        Assert.assertTrue(dp.checkPartitioning("aaa"));
        Assert.assertTrue(dp.checkPartitioning("aac"));
        Assert.assertTrue(dp.checkPartitioning("abcbdd"));
        Assert.assertFalse(dp.checkPartitioning("aa"));
        Assert.assertFalse(dp.checkPartitioning("bcbddxy"));
    }

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("aba", dp.longestPalindrome("babad"));
        Assert.assertEquals("bb", dp.longestPalindrome("cbbd"));
        Assert.assertEquals("a", dp.longestPalindrome("a"));
        Assert.assertEquals("c", dp.longestPalindrome("ac"));
    }

    @Test
    public void canCompleteCircuit() {
        Assert.assertEquals(3, dp.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assert.assertEquals(-1, dp.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    @Test
    public void maxAreaOfIsland() {
        Assert.assertEquals(6, dp.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));

        Assert.assertEquals(0, dp.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}}));
    }

    @Test
    public void countSquares() {
        Assert.assertEquals(15, dp.countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));

        Assert.assertEquals(7, dp.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }

    @Test
    public void longestCommonSubsequence() {
        Assert.assertEquals(3, dp.longestCommonSubsequence("abcde", "ace"));
        Assert.assertEquals(3, dp.longestCommonSubsequence("abc", "abc"));
        Assert.assertEquals(0, dp.longestCommonSubsequence("abc", "def"));
    }

    @Test
    public void minDistance() {
        Assert.assertEquals(1, dp.minDistance("", "a"));
        Assert.assertEquals(3, dp.minDistance("horse", "ros"));
        Assert.assertEquals(5, dp.minDistance("intention", "execution"));
    }

    @Test
    public void longestPalindromeSubseq() {
        Assert.assertEquals(4, dp.longestPalindromeSubseq("bbbab"));
        Assert.assertEquals(2, dp.longestPalindromeSubseq("cbbd"));
    }

    @Test
    public void minInsertions() {
        Assert.assertEquals(0, dp.minInsertions("zzazz"));
        Assert.assertEquals(2, dp.minInsertions("mbadm"));
        Assert.assertEquals(5, dp.minInsertions("leetcode"));
        Assert.assertEquals(0, dp.minInsertions("g"));
        Assert.assertEquals(1, dp.minInsertions("no"));
    }

    @Test
    public void isMatch() {
        Assert.assertFalse(dp.isMatch("aa", "a"));
        Assert.assertTrue(dp.isMatch("aa", "a*"));
        Assert.assertTrue(dp.isMatch("ab", ".*"));
        Assert.assertTrue(dp.isMatch("aab", "c*a*b"));
        Assert.assertFalse(dp.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void superEggDrop() {
        Assert.assertEquals(2, dp.superEggDrop(1, 2));
        Assert.assertEquals(3, dp.superEggDrop(2, 6));
        Assert.assertEquals(4, dp.superEggDrop(3, 14));
    }

    @Test
    public void maxCoins() {
        Assert.assertEquals(167, dp.maxCoins(new int[]{3, 1, 5, 8}));
        Assert.assertEquals(10, dp.maxCoins(new int[]{1, 5}));
    }

    @Test
    public void canJump() {
        Assert.assertTrue(dp.canJump(new int[]{2, 3, 1, 1, 4}));
        Assert.assertFalse(dp.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void jump() {
        Assert.assertEquals(2, dp.jump(new int[]{2, 3, 1, 1, 4}));
    }

    @Test
    public void uniquePaths() {
        Assert.assertEquals(28, dp.uniquePaths(7, 3));
        Assert.assertEquals(28, dp.uniquePaths(3, 7));
        Assert.assertEquals(3, dp.uniquePaths(3, 2));
        Assert.assertEquals(6, dp.uniquePaths(3, 3));
    }

    @Test
    public void climbStairs() {
        Assert.assertEquals(1, dp.climbStairs(1));
        Assert.assertEquals(2, dp.climbStairs(2));
        Assert.assertEquals(3, dp.climbStairs(3));
        Assert.assertEquals(8, dp.climbStairs(5));
    }

    @Test
    public void minCostClimbingStairs() {
        Assert.assertEquals(15, dp.minCostClimbingStairs(new int[]{10, 15, 20}));
        Assert.assertEquals(6, dp.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    @Test
    public void fib() {
        Assert.assertEquals(1, dp.fib(2));
        Assert.assertEquals(2, dp.fib(3));
        Assert.assertEquals(3, dp.fib(4));
    }

    @Test
    public void fib01() {
        Assert.assertEquals(1, dp.fib01(2));
        Assert.assertEquals(2, dp.fib01(3));
        Assert.assertEquals(3, dp.fib01(4));
    }

    @Test
    public void fib02() {
        Assert.assertEquals(1, dp.fib02(2));
        Assert.assertEquals(2, dp.fib02(3));
        Assert.assertEquals(3, dp.fib02(4));
    }

    @Test
    public void fib03() {
        Assert.assertEquals(1, dp.fib03(2));
        Assert.assertEquals(2, dp.fib03(3));
        Assert.assertEquals(3, dp.fib03(4));
    }

    @Test
    public void tribonacci() {
        Assert.assertEquals(4, dp.tribonacci(4));
        Assert.assertEquals(1389537, dp.tribonacci(25));
    }

    @Test
    public void candy() {
        Assert.assertEquals(5, dp.candy(new int[]{1, 0, 2}));
        Assert.assertEquals(4, dp.candy(new int[]{1, 2, 2}));
    }

    @Test
    public void candy01() {
        Assert.assertEquals(5, dp.candy01(new int[]{1, 0, 2}));
        Assert.assertEquals(4, dp.candy01(new int[]{1, 2, 2}));
    }

    @Test
    public void longestIncreasingPath() {

        Assert.assertEquals(1, dp.longestIncreasingPath(new int[][]{{1}}));

        Assert.assertEquals(4, dp.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));

        Assert.assertEquals(4, dp.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        }));

    }

    @Test
    public void solveNQueens() {
        List<List<String>> lists = dp.solveNsQueens(4);
        System.out.println(lists);

        lists = dp.solveNsQueens(1);
        System.out.println(lists);
    }

    @Test
    public void countBits() {
        Assert.assertArrayEquals(new int[]{0, 1, 1}, dp.countBits(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, dp.countBits(5));
    }


    @Test
    public void maxEnvelopes() {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Assert.assertEquals(3, dp.maxEnvelopes(envelopes));
    }

    @Test
    public void partition() {
        List<List<String>> aab = dp.partition("aab");
        System.out.println(aab);
    }

    @Test
    public void minCut() {
        Assert.assertEquals(1, dp.minCut("aab"));
        Assert.assertEquals(0, dp.minCut("a"));
        Assert.assertEquals(1, dp.minCut("ab"));
    }
}