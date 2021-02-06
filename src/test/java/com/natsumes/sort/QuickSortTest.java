package com.natsumes.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class QuickSortTest {

    private QuickSort<Integer> qs = new QuickSort<>();

    private Integer[] expectArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testDoubleQuickSort() {

        Integer[] arr = new Integer[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};

        Integer[] quickSort = qs.doubleQuickSort(arr, 0, arr.length - 1);
        display(quickSort);
        Assert.assertArrayEquals(expectArr, quickSort);
    }

    @Test
    public void testSignalQuickSort() {

        Integer[] arr = new Integer[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};

        Integer[] quickSort = qs.signalQuickSort(arr, 0, arr.length - 1);
        display(quickSort);
        Assert.assertArrayEquals(expectArr, quickSort);
    }

    private static <T> void display(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
