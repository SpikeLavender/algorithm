package com.natsumes.thread;

import java.util.concurrent.Semaphore;

/**
 * @author hetengjiao
 */
public class FooBarSemaphore {

    private int n;

    /**
     * permits 信号量
     */
    Semaphore foo = new Semaphore(1);

    Semaphore bar = new Semaphore(0);

    public FooBarSemaphore(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }

}
