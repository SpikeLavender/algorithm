package com.natsumes.work;

import com.natsumes.tree.RedBlackTree;

/**
 * 数据流中的分位数 -- top50，top90， top99
 * todo: 改造成线程安全的
 * @author hetengjiao
 */
public class RbTreeFinder {

    private final RedBlackTree<Integer> tree;

    public RbTreeFinder() {
        tree = new RedBlackTree<>();
    }

    public void addNum(int num) {
        tree.add(num);
    }

    public Integer[] getTopNumArr() {
        Integer[] topNumArr = new Integer[5];
        int size = tree.getTotalSize();
        int top50Index = (int)(size * 0.5 + 0.5);
        int top99Index = (int)(size * 0.99 + 0.5);
        int top90Index = (int)(size * 0.9 + 0.5);
        topNumArr[4] = tree.getMaxData();
        topNumArr[3] = tree.getMinData();
        topNumArr[0] = tree.getTopN(top50Index);
        topNumArr[1] = tree.getTopN(top90Index);
        topNumArr[2] = tree.getTopN(top99Index);
        return topNumArr;
    }

    public void list() {
        tree.list();
    }
}
