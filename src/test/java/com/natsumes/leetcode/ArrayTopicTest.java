package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class ArrayTopicTest {

    private final ArrayTopic at = new ArrayTopic();

    @Test
    public void findMedianSortedArrays() {
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0.0);
        Assert.assertEquals(2.5d, at.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0.0);
        Assert.assertEquals(0.0d, at.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}), 0.0);
        Assert.assertEquals(1.0d, at.findMedianSortedArrays(new int[] {}, new int[] {1}), 0.0);
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {2}, new int[] {}), 0.0);
    }

    @Test
    public void maxArea() {
        Assert.assertEquals(49, at.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, at.maxArea(new int[] {1, 1}));
        Assert.assertEquals(16, at.maxArea(new int[] {4, 3, 2, 1, 4}));
        Assert.assertEquals(2, at.maxArea(new int[] {1, 1, 1}));
    }
}