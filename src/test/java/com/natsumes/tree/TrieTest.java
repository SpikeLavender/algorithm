package com.natsumes.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author hetengjiao
 */
public class TrieTest {

    private Trie trie;

    @Before
    public void setUp() throws Exception {
        trie = new Trie();
        trie.add("test1");
        trie.add("teacher");
    }

    @Test
    public void add() {
        trie.add("hello");
        System.out.println(trie);
    }

    @Test
    public void contains() {
        Assert.assertFalse(trie.contains("tes"));
        Assert.assertTrue(trie.contains("test1"));
        Assert.assertTrue(trie.contains("teacher"));
        Assert.assertFalse(trie.contains("teacher1"));
        Assert.assertFalse(trie.contains("tea"));
    }

    @Test
    public void containsPrefix() {
        Assert.assertTrue(trie.containsPrefix("tes"));
        Assert.assertTrue(trie.containsPrefix("test1"));
        Assert.assertTrue(trie.containsPrefix("teacher"));
        Assert.assertFalse(trie.containsPrefix("teacher1"));
        Assert.assertTrue(trie.containsPrefix("tea"));
    }

    @Test
    public void remove() {
        Assert.assertFalse(trie.remove("hello"));
        Assert.assertFalse(trie.remove("te"));
        Assert.assertFalse(trie.remove("e"));
        Assert.assertTrue(trie.remove("test1"));
    }
}