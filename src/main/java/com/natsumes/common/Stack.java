package com.natsumes.common;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hetengjiao
 */
public class Stack {

    private final LinkedList list = new LinkedList();

    public void push(Object x) {
        System.out.println(Thread.currentThread().getName() + " test1");
        synchronized(list) {
            list.addLast(x);
            list.notify();
            System.out.println(Thread.currentThread().getName() + ": push " + list.size());
        }

    }

    public Object pop() throws Exception {
        System.out.println(Thread.currentThread().getName() + " pop");
        synchronized(list) {
            if (list.size() <= 0) {
                System.out.println(Thread.currentThread().getName() + ": wait=================== " + list.size());
                list.wait();
            }
            return list.removeLast();
        }

    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(30, 300,
                200L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new NamedThreadFactory("Monkey-taker"));

        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            executor.execute(() -> {
                stack.push(finalI);
            });
            executor.execute(() -> {
                try {
                    stack.pop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}
