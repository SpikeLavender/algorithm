package com.natsumes.work;

/**
 * 数据流中的分位数 -- top50，top90， top99
 * todo: 改造成线程安全的
 * @author hetengjiao
 */
public class TreeTopFinder {

    private final IntRedBlackTree tree;

    private int delta;

    public TreeTopFinder() {
        tree = new IntRedBlackTree();
        delta = 1000;
    }

    public void addNum(int num) {
        tree.insert(num);
        // 1s更新一次
        if (System.currentTimeMillis() % delta == 0) {
            updateTopValue();
        }
    }

    // todo: top50, top99, top999 应该怎么实现

    private void updateTopValue() {
        tree.updateNstValue();
    }

    public int[] getTopNumArr() {
        return tree.getTopNumArr();
    }

    public void list() {
        tree.list();
    }
}
