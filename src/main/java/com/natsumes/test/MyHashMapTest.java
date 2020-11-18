package com.natsumes.test;

import com.natsumes.hashmap.MyHashMap;

/**
 * @author hetengjiao
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMap=new MyHashMap<>();
        hashMap.put("m3","cccccc");
        hashMap.put("c1","kkkkkk");
        hashMap.put("c1","mmmmmmm");
        System.out.println(hashMap.get("c1"));
    }
}
