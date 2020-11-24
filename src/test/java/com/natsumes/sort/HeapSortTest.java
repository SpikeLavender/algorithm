package com.natsumes.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class HeapSortTest {

    private HeapSort<Integer> hs = new HeapSort<>(Integer::compareTo);

    private Integer[] expectArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void testHeapSort() {
        Integer[] arr = new Integer[] {4, 7, 1, 3, 2, 6, 9, 5, 8, 10};
        Integer[] heapSort = hs.heapSort(arr);

        System.out.println(Arrays.toString(heapSort));
        Assert.assertArrayEquals(expectArr, heapSort);
    }
}
