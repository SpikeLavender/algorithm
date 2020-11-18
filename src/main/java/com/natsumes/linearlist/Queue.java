package com.natsumes.linearlist;

/**
 * @author hetengjiao
 */
public interface Queue<E> {

    /**
     * 入队操作
     * @param e
     * @return
     */
    boolean enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 队列大小
     * @return
     */
    int size();
}
