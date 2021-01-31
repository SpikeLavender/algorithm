package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class DfsAndBinarySearchTest {

    private DfsAndBinarySearch dbs = new DfsAndBinarySearch();

    @Test
    public void longestRepeatingSubstring() {
        Assert.assertEquals(0, dbs.longestRepeatingSubstring("abcd"));
        Assert.assertEquals(2, dbs.longestRepeatingSubstring("abbaba"));
        Assert.assertEquals(3, dbs.longestRepeatingSubstring("aabcaabdaab"));
        Assert.assertEquals(4, dbs.longestRepeatingSubstring("aaaaa"));
    }
}