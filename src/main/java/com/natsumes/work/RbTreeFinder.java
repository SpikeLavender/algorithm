package com.natsumes.work;


import com.natsumes.tree.RedBlackTree;

/**
 * 数据流中的分位数 -- top50，top90， top99
 * todo: 改造成线程安全的
 * @author hetengjiao
 */
public class RbTreeFinder extends AbstractTopFinder {

    public RbTreeFinder() {
        this.tree = new RedBlackTree<>();
    }
}
