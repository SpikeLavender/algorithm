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

        Assert.assertEquals(1.0d, at.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}), 0.001);
    }
}