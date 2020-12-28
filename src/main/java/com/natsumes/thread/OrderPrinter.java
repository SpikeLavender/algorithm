package com.natsumes.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hetengjiao
 */
public class OrderPrinter {

    private volatile AtomicInteger num = new AtomicInteger(0);

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
     */
    public OrderPrinter() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while (num.get() != 0) {
            //
        }
        printFirst.run();
        num.compareAndSet(0, 1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (num.get() != 1) {
            //
        }
        printSecond.run();
        num.compareAndSet(1, 2);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (num.get() != 2) {
            //
        }
        printThird.run();
        num.compareAndSet(2, 0);
    }
}
