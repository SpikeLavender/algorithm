package com.natsumes.work;

import com.natsumes.tree.Treap;

/**
 * @author hetengjiao
 */
public class TreapFinder {

    private final Treap<Integer> treap;

    public TreapFinder() {
        this.treap = new Treap<>();
    }

    public void addNum(int data) {
        treap.insert(data);
    }

    public Integer[] getTopNumArr() {
        Integer[] topNumArr = new Integer[5];
        int size = treap.getTotalSize();
        int top50Index = (int)(size * 0.5 + 0.5);
        int top90Index = (int)(size * 0.9 + 0.5);
        int top99Index = (int)(size * 0.99 + 0.5);
        topNumArr[0] = treap.getTopN(top50Index);
        topNumArr[1] = treap.getTopN(top90Index);
        topNumArr[2] = treap.getTopN(top99Index);
        topNumArr[3] = treap.getMinData();
        topNumArr[4] = treap.getMaxData();
        return topNumArr;
    }
}
