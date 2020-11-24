package com.natsumes.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class CountSortTest {

    private CountSort cs = new CountSort();

    private int[] expectArr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testCountSort() {
        int[] arr = new int[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};
        int[] sort = cs.countSort(arr);

        System.out.println(Arrays.toString(sort));
        Assert.assertArrayEquals(expectArr, arr);
    }
}
