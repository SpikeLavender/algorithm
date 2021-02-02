package com.natsumes.leetcode.unionfind;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hetengjiao
 */
public class UnionFinderTest {

    private UnionFinder uf = new UnionFinder();


    @Test
    public void countComponents() {
        Assert.assertEquals(2, uf.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
        Assert.assertEquals(1, uf.countComponents(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}}));
    }

    @Test
    public void validTree() {
        Assert.assertTrue(uf.validTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        Assert.assertFalse(uf.validTree(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        Assert.assertFalse(uf.validTree(4, new int[][] {{0, 1}, {2, 3}}));
    }

    @Test
    public void numIslands2() {
        List<Integer> list = uf.numIslands2(3, 3, new int[][] {{0, 0}, {0, 1}, {1, 2}, {1, 2}});
        Integer[] res = new Integer[list.size()];
        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 2}, list.toArray(res));

        list = uf.numIslands2(3, 3, new int[][] {{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        res = new Integer[list.size()];
        Assert.assertArrayEquals(new Integer[] {1, 1, 2, 3}, list.toArray(res));
    }

    @Test
    public void numSimilarGroups() {
        Assert.assertEquals(2, uf.numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        Assert.assertEquals(1, uf.numSimilarGroups(new String[]{"omv", "ovm"}));
        Assert.assertEquals(1, uf.numSimilarGroups(new String[]{"blw", "bwl", "wlb"}));
    }

    @Test
    public void numIslands() {
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals(1, uf.numIslands(grid));

        grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(3, uf.numIslands(grid));
    }

    @Test
    public void equationsPossible() {
        Assert.assertFalse(uf.equationsPossible(new String[]{"a==b", "b!=a"}));
        Assert.assertTrue(uf.equationsPossible(new String[]{"b==a", "a==b"}));
        Assert.assertTrue(uf.equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        Assert.assertFalse(uf.equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        Assert.assertTrue(uf.equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }

    @Test
    public void solve() {
        char[][] chars = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] exps = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        uf.solve(chars);
        Assert.assertArrayEquals(exps, chars);
    }

    @Test
    public void solveByDfs() {
        char[][] chars = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] exps = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        uf.solveByDfs(chars);
        Assert.assertArrayEquals(exps, chars);
    }

    @Test
    public void longestConsecutive() {
        Assert.assertEquals(4, uf.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
        Assert.assertEquals(9, uf.longestConsecutive(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    @Test
    public void findCircleNum() {
        Assert.assertEquals(2, uf.findCircleNum(new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assert.assertEquals(3, uf.findCircleNum(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    @Test
    public void findRedundantConnection() {
        Assert.assertArrayEquals(new int[] {2, 3}, uf.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Assert.assertArrayEquals(new int[] {1, 4},
                uf.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }

    @Test
    public void accountsMerge() {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> res = uf.accountsMerge(accounts);
        System.out.println(res);
    }

    @Test
    public void hitBricks() {
        int[][] grid = new int[][] {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = new int[][] {{1, 0}};
        int[] exp = new int[] {2};
        Assert.assertArrayEquals(exp, uf.hitBricks(grid, hits));

        grid = new int[][] {{1, 0, 0, 0}, {1, 1, 0, 0}};
        hits = new int[][] {{1, 1}, {1, 0}};
        exp = new int[] {0, 0};
        Assert.assertArrayEquals(exp, uf.hitBricks(grid, hits));
    }

    @Test
    public void minSwapsCouples() {
        Assert.assertEquals(1, uf.minSwapsCouples(new int[] {0, 2, 1, 3}));
        Assert.assertEquals(0, uf.minSwapsCouples(new int[] {3, 2, 0, 1}));
    }

    @Test
    public void swimInWater() {
        Assert.assertEquals(17, uf.swimInWater(new int[][]{
                {1, 2, 3, 4, 5},
                {24, 23, 22, 21, 17},
                {12, 13, 14, 15, 16},
                {11, 0, 18, 19, 20},
                {10, 9, 8, 7, 6}
        }));
        Assert.assertEquals(3, uf.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        Assert.assertEquals(16, uf.swimInWater(new int[][]{
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        }));
    }

    /**
     * 示例 1：
     *
     * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
     * 输出：0
     * 示例 2：
     *
     * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
     * 输出：0
     * 示例 3：
     *
     * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
     * 输出：1
     *
     * [
     * [1,0,0,0,1,0,0,0,0,0,1],
     * [0,1,0,1,0,0,0,0,0,0,0],
     * [0,0,1,0,0,0,0,1,0,0,0],
     * [0,1,0,1,0,1,0,0,0,0,0],
     * [1,0,0,0,1,0,0,0,0,0,0],
     * [0,0,0,1,0,1,0,0,1,1,0],
     * [0,0,0,0,0,0,1,1,0,0,0],
     * [0,0,1,0,0,0,1,1,0,0,0],
     * [0,0,0,0,0,1,0,0,1,0,0],
     * [0,0,0,0,0,1,0,0,0,1,0],
     * [1,0,0,0,0,0,0,0,0,0,1]
     * ]
     * [7,8,6,2,3]
     */
    @Test
    public void minMalwareSpread() {
        Assert.assertEquals(2,
                uf.minMalwareSpread(new int[][] {
                                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
                                {0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0},
                                {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                                {0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                                {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}
                        },
                        new int[] {7,8,6,2,3}));
        Assert.assertEquals(1,
                uf.minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[] {1, 2}));
        Assert.assertEquals(2,
                uf.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[] {0, 1, 2}));
        Assert.assertEquals(0,
                uf.minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[] {0, 1}));
        Assert.assertEquals(0,
                uf.minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[] {0, 2}));
    }
}