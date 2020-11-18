package com.natsumes.linearlist;

/**
 * @author hetengjiao
 */
public interface Stack<E> {

    /**
     * 入栈操作
     * @param e
     * @return
     */
    boolean push(E e);

    /**
     * 出栈操作
     * @return
     */
    E pop();

    /**
     * 栈大小
     * @return
     */
    int size();
}
