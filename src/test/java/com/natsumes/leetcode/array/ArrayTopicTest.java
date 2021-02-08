package com.natsumes.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class ArrayTopicTest {

    private final ArrayTopic at = new ArrayTopic();


    @Test
    public void findMedianSortedArrays() {
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0.0);
        Assert.assertEquals(2.5d, at.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0.0);
        Assert.assertEquals(0.0d, at.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}), 0.0);
        Assert.assertEquals(1.0d, at.findMedianSortedArrays(new int[] {}, new int[] {1}), 0.0);
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {2}, new int[] {}), 0.0);
    }

    @Test
    public void maxArea() {
        Assert.assertEquals(49, at.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, at.maxArea(new int[] {1, 1}));
        Assert.assertEquals(16, at.maxArea(new int[] {4, 3, 2, 1, 4}));
        Assert.assertEquals(2, at.maxArea(new int[] {1, 1, 1}));
    }

    @Test
    public void search() {
        Assert.assertEquals(4, at.search(new int[] {4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, at.search(new int[] {4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1, at.search(new int[] {1}, 0));
    }

    @Test
    public void findKthLargest() {
        Assert.assertEquals(5, at.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, at.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void quickSort() {
        int[] nums = new int[] {1, 3, 5, 7, 9, 4, 2, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3, 2, 3, 1, 2, 5, 2, 5, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void checkPossibility() {
        Assert.assertTrue(at.checkPossibility(new int[] {1, 4, 2, 5, 6, 7}));
        Assert.assertTrue(at.checkPossibility(new int[] {3, 4, 2, 5, 6, 7}));
        Assert.assertFalse(at.checkPossibility(new int[] {3, 4, 2, 3, 4, 5}));
        Assert.assertTrue(at.checkPossibility(new int[] {4, 2, 3}));
        Assert.assertTrue(at.checkPossibility(new int[] {4, 2}));
        Assert.assertTrue(at.checkPossibility(new int[] {4}));
        Assert.assertFalse(at.checkPossibility(new int[] {4, 2, 1}));
    }
}