package com.natsumes.leetcode.sliding;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class SlidingWindowTest {

    private SlidingWindow sw = new SlidingWindow();

    @Test
    public void characterReplacement() {
        Assert.assertEquals(4, sw.characterReplacement("ABBB", 2));
        Assert.assertEquals(2, sw.characterReplacement("ABAA", 0));
        Assert.assertEquals(4, sw.characterReplacement("ABAB", 2));
        Assert.assertEquals(4, sw.characterReplacement("AABABBA", 1));
        Assert.assertEquals(1, sw.characterReplacement("A", 1));
        Assert.assertEquals(4, sw.characterReplacement("AACABBA", 1));
        Assert.assertEquals(4, sw.characterReplacement("AABABCBB", 1));
        Assert.assertEquals(6, sw.characterReplacement("AABBBABB", 1));
    }

    @Test
    public void medianSlidingWindow() {
        double[] doubles = sw.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        double[] exps = new double[] {1, -1, -1, 3, 5, 6};
        for (int i = 0; i < doubles.length; i++) {
            Assert.assertEquals(exps[i], doubles[i], 0.000d);
        }
    }

    @Test
    public void maxTurbulenceSize() {
        Assert.assertEquals(5, sw.maxTurbulenceSize(new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9}));
        Assert.assertEquals(2, sw.maxTurbulenceSize(new int[] {4, 8, 12, 16}));
        Assert.assertEquals(1, sw.maxTurbulenceSize(new int[] {100}));
    }

    @Test
    public void subarraysWithKDistinct() {
        Assert.assertEquals(7, sw.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2));
        Assert.assertEquals(3, sw.subarraysWithKDistinct(new int[] {1,2,1,3,4}, 3));
    }

    @Test
    public void lengthOfLongestSubstringTwoDistinct() {
        Assert.assertEquals(5, sw.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        Assert.assertEquals(1, sw.lengthOfLongestSubstringTwoDistinct("a"));
        Assert.assertEquals(3, sw.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    @Test
    public void minSubArrayLen() {
        Assert.assertEquals(3, sw.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
        Assert.assertEquals(1, sw.minSubArrayLen(1, new int[] {1}));
        Assert.assertEquals(2, sw.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        Assert.assertEquals(1, sw.minSubArrayLen(4, new int[] {1, 4, 4}));
        Assert.assertEquals(0, sw.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(0, sw.minSubArrayLen(1, new int[] {}));
    }

    @Test
    public void minWindow() {
        Assert.assertEquals("BANC", sw.minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("ba", sw.minWindow("bba", "ab"));
        Assert.assertEquals("a", sw.minWindow("a", "a"));
        Assert.assertEquals("", sw.minWindow("a", "ab"));
        Assert.assertEquals("BECODEBA", sw.minWindow("ADOBECODEBANC", "ABBC"));
    }

    @Test
    public void lengthOfLongestSubstring() {
        Assert.assertEquals(3, sw.lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, sw.lengthOfLongestSubstring("bbbbb"));
        Assert.assertEquals(3, sw.lengthOfLongestSubstring("pwwkew"));
        Assert.assertEquals(0, sw.lengthOfLongestSubstring(""));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct() {
        Assert.assertEquals(3, sw.lengthOfLongestSubstringKDistinct("eceba", 2));
        Assert.assertEquals(2, sw.lengthOfLongestSubstringKDistinct("aa", 1));
    }

    @Test
    public void numSubarrayProductLessThanK() {
        Assert.assertEquals(8, sw.numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
    }

    @Test
    public void totalFruit() {
        Assert.assertEquals(3, sw.totalFruit(new int[] {1, 2, 1}));
        Assert.assertEquals(3, sw.totalFruit(new int[] {0, 1, 2, 2}));
        Assert.assertEquals(4, sw.totalFruit(new int[] {1, 2, 3, 2, 2}));
        Assert.assertEquals(5, sw.totalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    public void checkInclusion() {
        Assert.assertFalse(sw.checkInclusion("hello", "ooolleoooleh"));
        Assert.assertTrue(sw.checkInclusion("abc", "bbbca"));
        Assert.assertTrue(sw.checkInclusion("ab", "ab"));
        Assert.assertTrue(sw.checkInclusion("ab", "eidbaooo"));
        Assert.assertFalse(sw.checkInclusion("ab", "eidboaoo"));
    }

    @Test
    public void numSubarrayBoundedMax() {
        Assert.assertEquals(3, sw.numSubarrayBoundedMax(new int[] {2, 1, 4, 3}, 2, 3));
        Assert.assertEquals(7, sw.numSubarrayBoundedMax(new int[] {2, 1, 4, 3, 2, 1}, 2, 3));
    }

    @Test
    public void findMaxConsecutiveOnes() {
        Assert.assertEquals(3, sw.findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
    }
}