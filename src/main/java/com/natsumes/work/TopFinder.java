package com.natsumes.work;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 数据流中的分位数 -- top50，top90， top99
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
public class TopFinder {

    /**
     * 小顶堆
     * 里面所有数字都比 small 中的小
     */
    private final PriorityQueue<Integer> queue;

    private int k;

    private AtomicLong totalSize;



    public TopFinder() {
        queue = new PriorityQueue<>(Integer::compareTo);
        totalSize = new AtomicLong(0);
    }

    public int addNum(int num) {
        long old = totalSize.get();
        totalSize.compareAndSet(old, old + 1);

        if (queue.size() < totalSize.longValue() / 2 + 1) {
            queue.offer(num);
        } else if (Objects.requireNonNull(queue.peek()) < num){
            queue.poll();
            queue.offer(num);
        }
        return Objects.requireNonNull(queue.peek());
    }



    // todo: top50, top99, top999 应该怎么实现
}
