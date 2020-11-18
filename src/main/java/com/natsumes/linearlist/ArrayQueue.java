package com.natsumes.linearlist;

/**
 * 使用数组实现队列
 *
 * @author hetengjiao
 */
public class ArrayQueue<E> implements Queue<E> {

    private E[] nums;

    private int head = 0;

    private int tail = 0;

    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        this.nums = (E[]) new Object[size];
    }

    @Override
    public boolean enqueue(E e) {
        if (tail == nums.length) {
            return false;
        }
        nums[tail] = e;
        tail++;
        size++;
        return true;
    }

    @Override
    public E dequeue() {
        if (tail == head) {
            return null;
        }
        E oldValue = nums[head];
        head++;
        size--;
        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }
}
