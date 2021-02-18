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

    @Test
    public void myAtoi() {
        Assert.assertEquals(-1, sh.myAtoi("-000000000000001"));
        Assert.assertEquals(42, sh.myAtoi("42"));
        Assert.assertEquals(-42, sh.myAtoi("   -42"));
        Assert.assertEquals(4193, sh.myAtoi("4193 with words"));
        Assert.assertEquals(0, sh.myAtoi("words and 987"));
        Assert.assertEquals(-2147483648, sh.myAtoi("-91283472332"));
        Assert.assertEquals(2147483647, sh.myAtoi("91283472332"));
        Assert.assertEquals(-2147483648, sh.myAtoi("-2147483648"));
        Assert.assertEquals(2147483647, sh.myAtoi("2147483647"));
        Assert.assertEquals(2147483646, sh.myAtoi("2147483646"));
        Assert.assertEquals(-2147483647, sh.myAtoi("-2147483647"));
        Assert.assertEquals(2147483647, sh.myAtoi("2147483648"));
        Assert.assertEquals(-2147483648, sh.myAtoi("-2147483649"));
        Assert.assertEquals(0, sh.myAtoi(""));
        Assert.assertEquals(0, sh.myAtoi("+"));
    }

    @Test
    public void decodeString() {
        Assert.assertEquals("aaabcbc", sh.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", sh.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", sh.decodeString("2[abc]3[cd]ef"));
        Assert.assertEquals("abccdcdcdxyz", sh.decodeString("abc3[cd]xyz"));
    }

    @Test
    public void convert() {
        Assert.assertEquals("PAHNAPLSIIGYIR", sh.convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", sh.convert("PAYPALISHIRING", 4));
        Assert.assertEquals("A", sh.convert("A", 1));
    }

    @Test
    public void minOperations() {
        Assert.assertEquals(1, sh.minOperations("0100"));
        Assert.assertEquals(0, sh.minOperations("10"));
        Assert.assertEquals(2, sh.minOperations("1111"));
    }

    @Test
    public void countHomogenous() {
        Assert.assertEquals(13, sh.countHomogenous("abbcccaa"));
        Assert.assertEquals(2, sh.countHomogenous("xy"));
        Assert.assertEquals(15, sh.countHomogenous("zzzzz"));
    }
}