package com.natsumes.leetcode.unionfind;

import org.junit.Assert;
import org.junit.Test;

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
}