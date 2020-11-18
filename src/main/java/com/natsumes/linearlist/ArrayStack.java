package com.natsumes.linearlist;


/**
 * 使用数组实现栈
 * @author hetengjiao
 */
public class ArrayStack<E> implements Stack<E>{

    private E[] nums;

    /**
     * 栈中元素个数
     */
    private int count;

    /**
     * 初始化数组，申请一个大小为n的数组空间
     */
    @SuppressWarnings("unchecked")
    public ArrayStack(int n) {
        this.nums = (E[]) new Object[n];
        this.count = 0;
    }

    /**
     * 入栈操作
     */
    @Override
    public boolean push(E n) {
        if (count >= nums.length) {
            return false;
        }
        nums[count] = n;
        count++;
        return true;
    }

    /**
     * 出栈操作
     */
    @Override
    public E pop() {
        if (count == 0) {
            return null;
        }
        E e = nums[count - 1];
        count--;
        return e;
    }

    @Override
    public int size() {
        return count;
    }
}
