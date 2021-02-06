package com.natsumes.sort;

/**
 * 排序工具类
 *
 * @author hetengjiao
 */
public class SortUtils {


    public static <E extends Comparable<E>> E[] quickSort(E[] arr) {
        QuickSort<E> qs = new QuickSort<>();
        return qs.doubleQuickSort(arr, 0, arr.length - 1);
    }
}
