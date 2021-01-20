package com.natsumes.redis;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class BloomFilterTest {

    @Test
    public void add() {
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add("he");
    }

    @Test
    public void contain() {
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add("he");
        bloomFilter.add("het");
        Assert.assertFalse(bloomFilter.contain("h"));
        Assert.assertTrue(bloomFilter.contain("he"));
        Assert.assertTrue(bloomFilter.contain("het"));
    }
}