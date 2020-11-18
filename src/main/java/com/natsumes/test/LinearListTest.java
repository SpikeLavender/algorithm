package com.natsumes.test;

import com.natsumes.linearlist.*;

/**
 * @author hetengjiao
 */
public class LinearListTest {
    public static void main(String[] args) {
        System.out.println("===============testLinkedStack===================");
        testLinkedStack();

        System.out.println("==================testArrayStack================");
        testArrayStack();

        System.out.println("===============testLinkedQueue===================");
        testLinkedQueue();

        System.out.println("==================testArrayQueue================");
        testArrayQueue();
    }

    private static void testLinkedStack() {
        Stack<Integer> ls = new LinkedStack<>();
        ls.push(3);
        ls.push(1);
        ls.push(5);
        ls.push(4);
        System.out.println(ls.size());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
    }

    private static void testArrayStack() {
        Stack<Integer> as = new ArrayStack<>(8);
        as.push(3);
        as.push(5);
        as.push(1);
        as.push(4);
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
    }

    private static void testLinkedQueue() {
        Queue<Integer> ls = new LinkedQueue<>();
        ls.enqueue(3);
        ls.enqueue(1);
        ls.enqueue(5);
        ls.enqueue(4);
        System.out.println(ls.size());
        System.out.println(ls.dequeue());
        System.out.println(ls.dequeue());
        System.out.println(ls.dequeue());
        System.out.println(ls.dequeue());
    }

    private static void testArrayQueue() {
        Queue<Integer> as = new ArrayQueue<>(8);
        as.enqueue(3);
        as.enqueue(5);
        as.enqueue(1);
        as.enqueue(4);
        System.out.println(as.dequeue());
        System.out.println(as.dequeue());
        System.out.println(as.dequeue());
        System.out.println(as.dequeue());
    }
}
