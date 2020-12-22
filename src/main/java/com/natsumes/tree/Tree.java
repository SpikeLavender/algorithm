package com.natsumes.tree;

/**
 * @author hetengjiao
 */
public interface Tree<T> {

    /**
     * 插入元素
     * @param data 值
     */
    void add(T data);

    /**
     * 删除元素
     * @param data 值
     * @return old data
     */
    boolean remove(T data);

}
