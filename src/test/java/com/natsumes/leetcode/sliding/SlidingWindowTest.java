package com.natsumes.leetcode.sliding;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class SlidingWindowTest {

    private SlidingWindow sw = new SlidingWindow();

    @Test
    public void medianSlidingWindow() {
        double[] doubles = sw.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        double[] exps = new double[] {1, -1, -1, 3, 5, 6};
        for (int i = 0; i < doubles.length; i++) {
            Assert.assertEquals(exps[i], doubles[i], 0.000d);
        }
    }

    @Test
    public void maxTurbulenceSize() {
        Assert.assertEquals(5, sw.maxTurbulenceSize(new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9}));
        Assert.assertEquals(2, sw.maxTurbulenceSize(new int[] {4, 8, 12, 16}));
        Assert.assertEquals(1, sw.maxTurbulenceSize(new int[] {100}));
    }
}