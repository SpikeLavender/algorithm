package com.natsumes.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 桶排序
 * 桶排序同样是一种线性时间的排序算法
 *
 * 桶排序的时间复杂度是O(n)
 * @author hetengjiao
 */
public class BucketSort {

    public double[] bucketSort(double[] arr) {
        double max = 0;
        double min = Double.MAX_VALUE;
        for (double v : arr) {
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }

        double d = max - min;

        //桶初始化
        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }
        //将每个元素放入桶中
        for (double v : arr) {
            int num = (int) ((v - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(v);
        }

        //对每个桶内部进行排序
        for (LinkedList<Double> doubleLinkedList : bucketList) {
            Collections.sort(doubleLinkedList);
        }

        //输出全部元素
        int index = 0;
        for (LinkedList<Double> doubles : bucketList) {
            for (Double e : doubles) {
                arr[index] = e;
                index++;
            }
        }
        return arr;
    }
}
