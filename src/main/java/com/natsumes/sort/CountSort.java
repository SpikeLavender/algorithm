package com.natsumes.sort;

/**
 * 计数排序
 * 利用数组下标来确定元素的正确位置的
 *
 * 时间复杂度是O(n+m)
 *
 * @author hetengjiao
 */
public class CountSort {

    public int[] countSort(int[] arr) {

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }

        int len = max - min + 1;

        int[] nums = new int[len];

        for (int value : arr) {
            int n = value - min;
            // 数字自增
            nums[n]++;
        }

        // i是计数数组下标，k是新数组下标
        for (int i = 0, k = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                arr[k++] = i + min;
            }
        }

        return arr;
    }
}
