package com.natsumes.sort;

/**
 * 冒泡排序
 *
 * 时间复杂度是：O(n^2)
 *
 * @author hetengjiao
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arr arr
     */
    public void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序 -- 优化 1: 内循环不用全部
     * @param arr arr
     */
    public void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序 -- 优化 2: 外层循环优化
     * @param arr arr
     */
    public void bubbleSort2(int[] arr) {
        boolean isSort = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }
}
