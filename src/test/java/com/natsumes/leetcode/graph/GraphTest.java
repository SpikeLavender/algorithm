package com.natsumes.leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class GraphTest {

    private final Graph graph = new Graph();

    @Test
    public void findKthNumber() {
        Assert.assertEquals(10, graph.findKthNumber(13, 2));
    }
}