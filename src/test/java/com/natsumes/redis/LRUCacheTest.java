package com.natsumes.redis;

/**
 * @author hetengjiao
 */
public class LRUCacheTest {

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        System.out.println(lruCache.get(2));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

}