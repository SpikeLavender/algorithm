package com.natsumes.work;

import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 *
 * 计算一个数据流的分位数
 * 一个数据集可按以下表示
 *    - - - - - - -
 *     -         -
 *      -       -           大顶堆          小顶堆
 *       -     -           -  -  -         -  -  -
 *        -   -             -   -         -       -
 *         - -               - -         -         -
 *          -                 -         - - - - - - -
 *                          small           large
 * @author hetengjiao
 */
public class MedianFinder {

    /**
     * 小顶堆
     * 里面所有数字都比 small 中的小
     */
    private PriorityQueue<Integer> large;

    /**
     * 大顶堆
     * 里面所有数字都比 large 中的小
     */
    private PriorityQueue<Integer> small;

    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    /**
     * 查找中位数
     * @return -1: 队列为空，中位数不存在
     */
    public double findMedian() {

        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        if (large.size() == 0) {
            return -1;
        }
        return (large.peek() + small.peek()) / 2.0;
    }

    /**
     * 添加并维护堆的顺序
     *
     * 技巧：
     * 如果large数目多于small，逻辑上新添加的元素应该放到small中，
     * 此时可以先将其放入large中，然后将large的堆顶元素放入small中
     *
     * @param num 数字
     */
    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(Objects.requireNonNull(small.poll()));
        } else {
            large.offer(num);
            small.offer(Objects.requireNonNull(large.poll()));
        }
    }

    // todo: top50, top99, top999 应该怎么实现
}
