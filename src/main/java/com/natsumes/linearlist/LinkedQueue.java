package com.natsumes.linearlist;

/**
 * @author hetengjiao
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size;

    @Override
    public boolean enqueue(E e) {
        Node<E> node = new Node<>(e);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return false;
    }

    @Override
    public E dequeue() {
        if (head == null) {
            return null;
        }
        Node<E> h = head;
        head = head.next;
        h.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return h.value;
    }

    @Override
    public int size() {
        return size;
    }
}
