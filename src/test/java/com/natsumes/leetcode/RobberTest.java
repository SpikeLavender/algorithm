package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class RobberTest {

    private Robber robber = new Robber();

    @Test
    public void rob3() {
        TreeNode root = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1))
                );
        Assert.assertEquals(7, robber.rob(root));

        root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1))
        );
        Assert.assertEquals(9, robber.rob(root));
    }

    @Test
    public void rob() {
        Assert.assertEquals(1, robber.rob(new int[] {1}));
        Assert.assertEquals(3, robber.rob(new int[] {2, 3, 2}));
        Assert.assertEquals(4, robber.rob(new int[] {1, 2, 3, 1}));
        Assert.assertEquals(0, robber.rob(new int[] {0}));
        Assert.assertEquals(3, robber.rob(new int[] {2, 3}));
        Assert.assertEquals(3, robber.rob(new int[] {3, 2}));
        Assert.assertEquals(0, robber.rob(new int[] {}));
    }

    @Test
    public void rob1() {
        Assert.assertEquals(0, robber.rob1(new int[] {}));
        Assert.assertEquals(1, robber.rob1(new int[] {1}));
        Assert.assertEquals(2, robber.rob1(new int[] {1, 2}));
        Assert.assertEquals(4, robber.rob1(new int[] {1, 2, 3, 1}));
        Assert.assertEquals(12, robber.rob1(new int[] {2, 7, 9, 3, 1}));
    }
}