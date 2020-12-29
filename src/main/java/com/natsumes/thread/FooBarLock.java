package com.natsumes.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hetengjiao
 */
public class FooBarLock {

    private final int n;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition foo = lock.newCondition();

    private final Condition bar = lock.newCondition();

    volatile int num = 0;

    public FooBarLock(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (num != 0) {
                    foo.await();
                }
                printFoo.run();
                num = 1;
                bar.signal();
            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                if (num != 1){
                    bar.await();
                }
                printBar.run();
                num = 0;
                foo.signal();

            } finally {
                lock.unlock();
            }
        }
    }

}
