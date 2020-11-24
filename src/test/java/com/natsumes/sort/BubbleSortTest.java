package com.natsumes.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class BubbleSortTest {

    private BubbleSort bs = new BubbleSort();

    private int[] expectArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testBubbleSort() {
        int[] arr = new int[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};
        bs.bubbleSort(arr);
        display(arr);
        Assert.assertArrayEquals(expectArr, arr);
    }

    @Test
    public void testBubbleSort1() {
        int[] arr = new int[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};
        bs.bubbleSort1(arr);
        display(arr);
        Assert.assertArrayEquals(expectArr, arr);
    }

    @Test
    public void testBubbleSort2() {
        int[] arr = new int[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};
        bs.bubbleSort2(arr);
        display(arr);
        Assert.assertArrayEquals(expectArr, arr);
    }

    private static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
