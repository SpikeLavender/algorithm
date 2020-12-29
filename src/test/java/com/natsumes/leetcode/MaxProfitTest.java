package com.natsumes.leetcode;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MaxProfitTest extends TestCase {

    private static final MaxProfit mp = new MaxProfit();

    public void testMaxProfit() {
        Assert.assertEquals(5, mp.maxProfit(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, mp.maxProfit(new int[] {7,6,4,3,1}));
    }

    public void testMaxProfit2() {
        Assert.assertEquals(7, mp.maxProfit2(new int[] {7,1,5,3,6,4}));
        Assert.assertEquals(0, mp.maxProfit2(new int[] {7,6,4,3,1}));
        Assert.assertEquals(4, mp.maxProfit2(new int[] {1,2,3,4,5}));
    }
}