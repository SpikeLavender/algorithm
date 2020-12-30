package com.natsumes.coder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class CoderExamTest {

    private final CoderExam coderExam = new CoderExam();

    @Test
    public void isUnique() {
        Assert.assertFalse(coderExam.isUnique("aa"));
        Assert.assertFalse(coderExam.isUnique("letetcode"));
        Assert.assertFalse(coderExam.isUnique("leetcode"));
        Assert.assertFalse(coderExam.isUnique("wdgoiws"));
        Assert.assertTrue(coderExam.isUnique("abc"));
        Assert.assertTrue(coderExam.isUnique(""));
        Assert.assertTrue(coderExam.isUnique(null));
        Assert.assertTrue(coderExam.isUnique(" "));
    }

    @Test
    public void isUniqueBit() {
        Assert.assertFalse(coderExam.isUniqueBit("aa"));
        Assert.assertFalse(coderExam.isUniqueBit("letetcode"));
        Assert.assertFalse(coderExam.isUniqueBit("leetcode"));
        Assert.assertFalse(coderExam.isUniqueBit("wdgoiws"));
        Assert.assertTrue(coderExam.isUniqueBit("abc"));
        Assert.assertTrue(coderExam.isUniqueBit(""));
        Assert.assertTrue(coderExam.isUniqueBit(null));
        Assert.assertTrue(coderExam.isUniqueBit(" "));
    }

    @Test
    public void checkPermutation() {
        Assert.assertTrue(coderExam.checkPermutation("abc", "bca"));
        Assert.assertFalse(coderExam.checkPermutation("abc", "bad"));
        Assert.assertFalse(coderExam.checkPermutation("null", null));
        Assert.assertFalse(coderExam.checkPermutation("null", ""));
        Assert.assertFalse(coderExam.checkPermutation("aa", "bb"));
        Assert.assertFalse(coderExam.checkPermutation("ac", "bb"));
    }

    @Test
    public void replaceSpaces() {
        Assert.assertEquals("Mr%20John%20Smith", coderExam.replaceSpaces("Mr John Smith    ", 13));
        Assert.assertEquals("%20%20%20%20%20", coderExam.replaceSpaces("               ", 5));
    }

    @Test
    public void replaceSpaces01() {
        Assert.assertEquals("Mr%20John%20Smith", coderExam.replaceSpaces01("Mr John Smith    ", 13));
        Assert.assertEquals("%20%20%20%20%20", coderExam.replaceSpaces01("               ", 5));
    }

    @Test
    public void replaceSpaces02() {
        Assert.assertEquals("Mr%20John%20Smith", coderExam.replaceSpaces02("Mr John Smith    ", 13));
        Assert.assertEquals("%20%20%20%20%20", coderExam.replaceSpaces02("               ", 5));
    }

    @Test
    public void canPermutePalindrome() {
        Assert.assertTrue(coderExam.canPermutePalindrome("tactcoa"));
        Assert.assertTrue(coderExam.canPermutePalindrome("tactca"));
        Assert.assertFalse(coderExam.canPermutePalindrome("abcabcabc"));
        Assert.assertTrue(coderExam.canPermutePalindrome(""));
        Assert.assertTrue(coderExam.canPermutePalindrome(null));
        Assert.assertFalse(coderExam.canPermutePalindrome("ab"));
        Assert.assertFalse(coderExam.canPermutePalindrome("abe"));
    }

    @Test
    public void oneEditAway() {
        Assert.assertTrue(coderExam.oneEditAway("a", "b"));
        Assert.assertTrue(coderExam.oneEditAway("pale", "ple"));
        Assert.assertTrue(coderExam.oneEditAway("pale", "pale"));
        Assert.assertFalse(coderExam.oneEditAway("pales", "ple"));
        Assert.assertFalse(coderExam.oneEditAway("pales", "pls"));
        Assert.assertFalse(coderExam.oneEditAway("ab", "bc"));
        Assert.assertFalse(coderExam.oneEditAway("teacher", "bleacher"));
    }

    @Test
    public void compressString() {
        Assert.assertEquals("a2b1c5a3", coderExam.compressString("aabcccccaaa"));
        Assert.assertEquals("abbccd", coderExam.compressString("abbccd"));
        Assert.assertEquals("a", coderExam.compressString("a"));
        Assert.assertEquals("a3", coderExam.compressString("aaa"));
        Assert.assertEquals("", coderExam.compressString(""));
    }
}