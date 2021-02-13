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
}