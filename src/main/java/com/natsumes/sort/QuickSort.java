package com.natsumes.sort;

import java.util.Comparator;

/**
 * 快速排序
 * 同冒泡排序一样，快速排序也属于交换排序，通过元素之间的比较和交换位置来达到排序的目的。
 * 不同的是，冒泡排序在每一轮中只把1个元素冒泡到数列的一端，而快速排序则在每一轮挑选一个基准
 * 元素，并让其他比它大的元素移动到数列一边，比它小的元素移动到数列的另一边，从而把数列拆解成
 * 两个部分，这种思路就叫作分治法。
 *
 * 快速排序的时间复杂度是：O(nlogn)
 *
 * @author hetengjiao
 */
public class QuickSort<T> {

    private final Comparator<? super T> comparator;

    public QuickSort(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public T[] doubleQuickSort(T[] arr, int start, int end) {

        // 递归结束条件
        if (start >= end) {
            return arr;
        }

        // 得到基准元素位置
        int pivotIndex = partition(arr, start, end);
        // 根据基准元素，分成两部分进行递归排序
        doubleQuickSort(arr, start, pivotIndex - 1);
        doubleQuickSort(arr, pivotIndex + 1, end);
        return arr;
    }

    /**
     * 分治（双边循环法）
     * @param arr       待交换的数组
     * @param start     起始下标
     * @param end       结束下标
     * @return
     */
    private int partition(T[] arr, int start, int end) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        T pivot = arr[start];
        int left = start;
        int right = end;

        while (left != right) {
            //控制right 指针比较并左移
            while (left < right && comparator.compare(arr[right], pivot) > 0) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && comparator.compare(arr[left], pivot) <= 0) {
                left++;
            }

            //交换left和right 指针所指向的元素
            if (left < right) {
                T tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }

        //pivot 和指针重合点交换
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    public T[] signalQuickSort(T[] arr, int start, int end) {

        // 递归结束条件
        if (start >= end) {
            return arr;
        }

        // 得到基准元素位置
        int pivotIndex = signalPartition(arr, start, end);
        // 根据基准元素，分成两部分进行递归排序
        signalQuickSort(arr, start, pivotIndex - 1);
        signalQuickSort(arr, pivotIndex + 1, end);
        return arr;
    }

    /**
     * 分治（单边循环法）
     * @param arr       待交换的数组
     * @param start     起始下标
     * @param end       结束下标
     * @return
     */
    private int signalPartition(T[] arr, int start, int end) {
        // 取第1个位置（也可以选择随机位置）的元素作为基准元素
        T pivot = arr[start];
        int mark = start;
        for (int i = start + 1; i <= end ; i++) {
            if (comparator.compare(arr[i], pivot) < 0) {
                mark++;
                T tmp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = tmp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
