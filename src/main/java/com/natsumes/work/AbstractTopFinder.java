package com.natsumes.work;

import com.natsumes.tree.AbstractTree;
import com.natsumes.tree.Tree;

/**
 * @author hetengjiao
 */
public class AbstractTopFinder implements TopFinder {

    protected AbstractTree<Integer> tree;

    @Override
    public void addNum(int data) {
        tree.add(data);
    }

    @Override
    public Integer[] getTopNumArr() {
        int size = tree.getTotalSize();
        Integer[] topNumArr = new Integer[5];
        int top50Index = (int)(size * 0.5 + 0.5);
        int top90Index = (int)(size * 0.9 + 0.5);
        int top99Index = (int)(size * 0.99 + 0.5);
        topNumArr[0] = tree.getTopN(top50Index);
        topNumArr[1] = tree.getTopN(top90Index);
        topNumArr[2] = tree.getTopN(top99Index);
        topNumArr[3] = tree.getMinData();
        topNumArr[4] = tree.getMaxData();
        return topNumArr;
    }
}
