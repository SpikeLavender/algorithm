package com.natsumes.leetcode.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void intToRoman() {
        Assert.assertEquals("III", sh.intToRoman(3));
        Assert.assertEquals("IV", sh.intToRoman(4));
        Assert.assertEquals("IX", sh.intToRoman(9));
        Assert.assertEquals("LVIII", sh.intToRoman(58));
        Assert.assertEquals("MCMXCIV", sh.intToRoman(1994));
    }

    @Test
    public void romanToInt() {
        Assert.assertEquals(3, sh.romanToInt("III"));
        Assert.assertEquals(4, sh.romanToInt("IV"));
        Assert.assertEquals(9, sh.romanToInt("IX"));
        Assert.assertEquals(58, sh.romanToInt("LVIII"));
        Assert.assertEquals(1994, sh.romanToInt("MCMXCIV"));
    }

    @Test
    public void findNumOfValidWords() {
        List<Integer> words = sh.findNumOfValidWords(
                new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"});
        Integer[] res = new Integer[words.size()];
        Assert.assertArrayEquals(new Integer[]{1, 1, 3, 2, 4, 0}, words.toArray(res));
    }

    @Test
    public void longestCommonPrefix() {
        Assert.assertEquals("fl", sh.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        Assert.assertEquals("", sh.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    @Test
    public void removeDuplicates() {
        Assert.assertEquals("ca", sh.removeDuplicates("abbaca"));
    }

    @Test
    public void strStr() {
        Assert.assertEquals(2, sh.strStr("hello", "ll"));
        Assert.assertEquals(-1, sh.strStr("aaaaa", "bba"));
        Assert.assertEquals(0, sh.strStr("aaaaa", ""));
    }

    @Test
    public void repeatedStringMatch() {
        Assert.assertEquals(1, sh.repeatedStringMatch("aa", "a"));
        Assert.assertEquals(2, sh.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
        Assert.assertEquals(1, sh.repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ab"));
        Assert.assertEquals(4, sh.repeatedStringMatch("abc", "cabcabca"));
        Assert.assertEquals(1, sh.repeatedStringMatch("abab", "aba"));
        Assert.assertEquals(2, sh.repeatedStringMatch("abcd", "cda"));
        Assert.assertEquals(3, sh.repeatedStringMatch("abcd", "cdabcdabc"));
        Assert.assertEquals(2, sh.repeatedStringMatch("abcd", "cdabc"));
        Assert.assertEquals(2, sh.repeatedStringMatch("a", "aa"));
        Assert.assertEquals(1, sh.repeatedStringMatch("a", "a"));
        Assert.assertEquals(-1, sh.repeatedStringMatch("abc", "wxyz"));
        Assert.assertEquals(0, sh.repeatedStringMatch("abc", ""));
    }
}