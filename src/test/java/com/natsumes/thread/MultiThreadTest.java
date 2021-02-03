package com.natsumes.thread;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MultiThreadTest {

    private final MultiThread multiThread = new MultiThread();

    @Test
    public void print() throws InterruptedException {
        multiThread.print();
    }

    @Test
    public void printFooBar() throws InterruptedException {

        multiThread.printFooBar(5);
    }

    @Test
    public void printFooBar01() throws InterruptedException {

        multiThread.printFooBar01(5);
    }

    @Test
    public void printFooBar02() throws InterruptedException {

        FooBarSemaphore fooBar = new FooBarSemaphore(5);
        Thread t1 = new Thread(()-> {
            try {
                fooBar.foo(new MultiThread.PrintRunnable("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                fooBar.bar(new MultiThread.PrintRunnable("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    @Test
    public void printFooBar03() throws InterruptedException {

//        FooBarCyclicBarrier fooBar = new FooBarCyclicBarrier(5);
//        Thread t1 = new Thread(()-> {
//            try {
//                fooBar.foo(new MultiThread.PrintRunnable("foo"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        Thread t2 = new Thread(()-> {
//            try {
//                fooBar.bar(new MultiThread.PrintRunnable("bar"));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
    }
}