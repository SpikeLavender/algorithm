package com.natsumes.common;


/**
 * @author hetengjiao
 */
public class OrderPrinter {

    private volatile int num = 0;

    private volatile int flag = 0;

    private final int count;

    private final Object lock = new Object();

    /**
     * 1114. 按序打印
     * 我们提供了一个类：
     *
     *
     * 三个不同的线程将会共用一个 OrderPrinter 实例。
     *
     * 线程 A 将会调用 {@code first()} 方法
     * 线程 B 将会调用 second() 方法
     * 线程 C 将会调用 third() 方法
     * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
     *
     * 输出: "firstsecondthird"
     *
     * https://leetcode-cn.com/problems/print-in-order/
     */
    public OrderPrinter() {
        this.count = 10;
    }

    public OrderPrinter(int count) {
        this.count = count;
    }

    public void first(Runnable printFirst) {
        for (int i = 0; i < count; i++) {
            synchronized (lock) {
                if (flag == 0) {
                    printFirst.run();
                    flag = 1;
                    lock.notifyAll();
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void second(Runnable printSecond) {
        while (num <= count) {
            synchronized (lock) {
                if (flag != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else  {
                    printSecond.run();
                    flag = 2;
                }
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (num <= count) {
            synchronized (lock) {
                if (flag != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else  {
                    printThird.run();
                    flag = 0;
                }
            }
        }
    }
}
