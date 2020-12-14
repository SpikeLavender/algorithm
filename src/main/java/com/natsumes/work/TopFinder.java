package com.natsumes.work;

import com.natsumes.tree.RedBlackTree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 数据流中的分位数 -- top50，top90， top99
 * todo: 改造成线程安全的
 * @author hetengjiao
 */
public class TopFinder {

    private final RedBlackTree<Integer> tree;

    private AtomicLong totalSize;

    public TopFinder() {
        tree = new RedBlackTree<>(Integer::compareTo);
        totalSize = new AtomicLong(0);
    }

    public void addNum(int num) {
        tree.insert(num);
        totalSize.addAndGet(1);
    }

    // todo: top50, top99, top999 应该怎么实现

    public int getTop(double per) {
        long len = totalSize.get();
        long size = (long) (len * per + 0.5);
        return tree.getNstValue(size);
    }

    public void list() {
        tree.list();
    }
}
