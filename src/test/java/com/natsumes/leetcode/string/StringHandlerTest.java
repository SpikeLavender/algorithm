package com.natsumes.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class StringHandlerTest {

    private final StringHandler sh = new StringHandler();

    @Test
    public void isValid() {
        Assert.assertTrue(sh.isValid("()"));
        Assert.assertTrue(sh.isValid("()[]{}"));
        Assert.assertFalse(sh.isValid("(]"));
        Assert.assertFalse(sh.isValid("([)]"));
        Assert.assertTrue(sh.isValid("{[]}"));
        Assert.assertTrue(sh.isValid("([])"));
    }

    @Test
    public void isValidString() {
        Assert.assertTrue(sh.isValidString(""));
        Assert.assertTrue(sh.isValidString("aabcbc"));
        Assert.assertTrue(sh.isValidString("abcabcababcc"));
        Assert.assertFalse(sh.isValidString("abccba"));
        Assert.assertFalse(sh.isValidString("cababc"));
        Assert.assertFalse(sh.isValidString("ab"));
        Assert.assertFalse(sh.isValidString("bac"));
        Assert.assertFalse(sh.isValidString("c"));
    }
}