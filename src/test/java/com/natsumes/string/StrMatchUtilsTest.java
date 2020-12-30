package com.natsumes.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class StrMatchUtilsTest {

    @Test
    public void testBruteForce() {
        int index = StrMatchUtils.bruteForceMatch("abcdsef", "ab");
        System.out.println(index);
        Assert.assertEquals(0, index);

        index = StrMatchUtils.bruteForceMatch("abcdsef", "cd");
        System.out.println(index);
        Assert.assertEquals(2, index);

        index = StrMatchUtils.bruteForceMatch("abcdsef", "ef");
        System.out.println(index);
        Assert.assertEquals(5, index);

        index = StrMatchUtils.bruteForceMatch("abcdsef", "cs");
        System.out.println(index);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testRabinKarp() {
        int index = StrMatchUtils.rabinKarpMatch("abcdsef", "ab");
        System.out.println(index);
        Assert.assertEquals(0, index);

        index = StrMatchUtils.rabinKarpMatch("abcdsef", "cd");
        System.out.println(index);
        Assert.assertEquals(2, index);

        index = StrMatchUtils.rabinKarpMatch("abcdsef", "ef");
        System.out.println(index);
        Assert.assertEquals(5, index);

        index = StrMatchUtils.rabinKarpMatch("abcdsef", "cs");
        System.out.println(index);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testBoyerMoore() {
        int index = StrMatchUtils.badBoyerMooreMatch("abcdsef", "ab");
        System.out.println(index);
        Assert.assertEquals(0, index);

        index = StrMatchUtils.badBoyerMooreMatch("abcdsef", "cd");
        System.out.println(index);
        Assert.assertEquals(2, index);

        index = StrMatchUtils.badBoyerMooreMatch("abcdsef", "ef");
        System.out.println(index);
        Assert.assertEquals(5, index);

        index = StrMatchUtils.badBoyerMooreMatch("abcdsef", "cs");
        System.out.println(index);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testTire() {
        Trie trie = StrMatchUtils.buildTrie().insert("hello")
                .insert("her").insert("hi").insert("how").insert("see").insert("so");
        boolean how = trie.find("how");
        System.out.println(how);
        Assert.assertTrue(how);

        how = trie.find("hs");
        System.out.println(how);
        Assert.assertFalse(how);
    }
}
