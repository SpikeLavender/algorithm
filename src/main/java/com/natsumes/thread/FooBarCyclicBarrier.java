package com.natsumes.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 不适合
 * @author hetengjiao
 */
public class FooBarCyclicBarrier {

    private int n;

    CyclicBarrier cb = new CyclicBarrier(2);

    volatile int num = 0;

    public FooBarCyclicBarrier(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (num != 0) {

            }
            printFoo.run();
            num = 1;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        printBar.run();
        num = 0;
    }

}
