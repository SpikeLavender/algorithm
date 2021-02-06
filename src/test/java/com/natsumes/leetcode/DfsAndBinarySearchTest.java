package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void subsets() {
        List<List<Integer>> subsets = dbs.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

    @Test
    public void restoreIpAddresses() {
        List<String> addresses = dbs.restoreIpAddresses("25525511135");
        System.out.println(addresses);

        addresses = dbs.restoreIpAddresses("0000");
        System.out.println(addresses);

        addresses = dbs.restoreIpAddresses("1111");
        System.out.println(addresses);

        addresses = dbs.restoreIpAddresses("010010");
        System.out.println(addresses);

        addresses = dbs.restoreIpAddresses("101023");
        System.out.println(addresses);
    }
}