package com.natsumes.hashmap;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MyHashMapTest {

    @Test
    public void testMyHashMap() {
        MyHashMap<String, String> hashMap = new MyHashMap<>();
        hashMap.put("m3","cccccc");
        hashMap.put("c1","kkkkkk");
        hashMap.put("c1","mmmmmmm");
        System.out.println(hashMap.get("c1"));
        Assert.assertEquals(hashMap.get("c1"), "mmmmmmm");
    }
}

