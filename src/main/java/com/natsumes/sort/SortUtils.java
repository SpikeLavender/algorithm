package com.natsumes.sort;

import java.util.Comparator;

/**
 * 排序工具类
 *
 * @author hetengjiao
 */
public class SortUtils {


    public static <E> E[] quickSort(E[] arr, Comparator<E> comparator) {
        QuickSort<E> qs = new QuickSort<>(comparator);
        return qs.doubleQuickSort(arr, 0, arr.length - 1);
    }
}
