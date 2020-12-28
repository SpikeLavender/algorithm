package com.natsumes.thread;


/**
 * @author hetengjiao
 */
public class OrderPrinter {

    private volatile int num = 0;

    private final int count;

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

    public void first(Runnable printFirst) throws InterruptedException {
        int count = this.count;
        while (count-- >= 0) {

            while (num != 0) {
                //
            }

            printFirst.run();
            num = 1;
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        int count = this.count;
        while (count-- >= 0) {
            while (num != 1) {
                //
            }

            printSecond.run();
            num = 2;
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        int count = this.count;
        while (count-- >= 0) {
            while (num != 2) {
                //
            }

            printThird.run();
            System.out.println();
            num = 0;
        }
    }
}
