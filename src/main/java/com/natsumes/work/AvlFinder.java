package com.natsumes.work;

import com.natsumes.tree.AVLTree;

/**
 * @author hetengjiao
 */
public class AvlFinder {

    private final AVLTree<Integer> avlTree;

    public AvlFinder() {
        this.avlTree = new AVLTree<>();
    }

    public void addNum(int data) {
        avlTree.add(data);
    }

    public Integer[] getTopNumArr() {
        Integer[] topNumArr = new Integer[5];
        int size = avlTree.getTotalSize();
        int top90Index = (int)(size * 0.9 + 0.5);
        int top99Index = (int)(size * 0.99 + 0.5);
        int top50Index = (int)(size * 0.5 + 0.5);
        topNumArr[1] = avlTree.getTopN(top90Index);
        topNumArr[0] = avlTree.getTopN(top50Index);
        topNumArr[2] = avlTree.getTopN(top99Index);
        topNumArr[4] = avlTree.getMaxData();
        topNumArr[3] = avlTree.getMinData();
        return topNumArr;
    }
}
