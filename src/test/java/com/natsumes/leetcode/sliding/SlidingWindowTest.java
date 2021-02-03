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
}