package com.natsumes.linearlist;

/**
 * 使用链表实现栈
 * @author hetengjiao
 */
public class LinkedStack<E> implements Stack<E> {

    private int size;

    private Node<E> head;

    /**
     * 初始化
     */
    public LinkedStack() {
        this.size = 0;
        this.head = null;
    }

    /**
     * 入栈操作
     */
    @Override
    public boolean push(E e) {
        Node<E> node = new Node<>(e);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    /**
     * 出栈操作
     */
    @Override
    public E pop() {
        if (size > 0) {
           Node<E> oldHead = head;
           head = head.next;
           size--;
           return oldHead.value;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
