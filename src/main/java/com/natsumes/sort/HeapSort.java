package com.natsumes.sort;

/**
 * 堆排序
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。
 * 将其与末尾元素进行交换，此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得
 * 到n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 *
 * 堆排序的时间复杂度是： O(nlogn)
 *
 * @author hetengjiao
 */
public class HeapSort<T extends Comparable<T>> {

    public T[] heapSort(T[] arr) {
        // 1. 把无序数组构建成最大堆
        for (int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
            //heapify(arr, i, arr.length);
        }
        // 2. 调整堆结构+交换堆顶元素与末尾元素，调整堆产生新的堆顶
        for (int i = arr.length - 1; i > 0; i--){
            swap(arr, 0, i);
            // “下沉”调整最大堆
            //adjustHeap(arr, 0, i);
            heapify(arr, 0, i);
        }
        return arr;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void adjustHeap(T[] arr, int parentIndex, int length) {
        // temp 保存父节点值，用于最后的赋值
        T tmp = arr[parentIndex];
        int childIndex = 2 * parentIndex + 1;

        while (childIndex < length) {
            // 如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && arr[childIndex].compareTo(arr[childIndex + 1]) < 0) {
                childIndex++;
            }
            // 如果父节点大于任何一个孩子的值，则直接跳出
            if (tmp.compareTo(arr[childIndex]) >= 0) {
                break;
            }
            //无须真正交换，单向赋值即可
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            //下一个左孩子
            childIndex = 2 * childIndex + 1;
        }
        arr[parentIndex] = tmp;
    }

    /**
     * 自调整
     *
     * @param arr arr
     * @param parentIndex 父节点
     * @param size 堆大小
     */
    private void heapify(T[] arr, int parentIndex, int size) {
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;
        int large = parentIndex;
        if (leftIndex < size && arr[leftIndex].compareTo(arr[large]) > 0) {
            large = leftIndex;
        }
        if (rightIndex < size && arr[rightIndex].compareTo(arr[large]) > 0) {
            large = rightIndex;
        }
        if (large != parentIndex) {
            swap(arr, parentIndex, large);
            heapify(arr, large, size);
        }
    }
}
