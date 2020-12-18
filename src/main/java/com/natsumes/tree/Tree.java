package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public interface Tree<V> {

    /**
     * 插入元素
     * @param value 值
     */
    void insert(V value);

    /**
     * 删除元素
     * @param value 值
     * @return old value
     */
    boolean remove(V value);

}
