package com.natsumes.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class BucketSortTest {

    private BucketSort bs = new BucketSort();

    @Test
    public void testBucketSort() {
        double[] array = {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] doubles = bs.bucketSort(array);
        System.out.println(Arrays.toString(doubles));
    }
}
