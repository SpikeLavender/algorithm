package com.natsumes.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * @author hetengjiao
 */
public class FizzBuzzLock {

    private int n;

    private volatile int flag = 0;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition fzc = lock.newCondition();
    private final Condition bzc = lock.newCondition();
    private final Condition bfc = lock.newCondition();
    private final Condition nc = lock.newCondition();

    public FizzBuzzLock(int n) {
        this.n = n;
    }

    /**
     * printFizz.run() outputs "fizz".
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n && i % 5 != 0; i = i + 3) {
            lock.lock();
            try {
                while (flag != 1) {
                    fzc.await();
                }
                printFizz.run();
                flag = 0;
                nc.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * printBuzz.run() outputs "buzz".
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n && i % 3 != 0; i = i + 5) {
            lock.lock();
            try {
                while (flag != 2) {
                   bzc.await();
                }
                printBuzz.run();
                flag = 0;
                nc.signal();

            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * printFizzBuzz.run() outputs "fizzbuzz".
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i = i + 15) {
            lock.lock();
            try {
                while (flag != 3) {
                    bfc.await();
                }
                printFizzBuzz.run();
                flag = 0;
                nc.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            lock.lock();
            try {
                while (flag != 0) {
                    nc.await();
                }
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                } else if (i % 3 == 0 && i % 5 != 0) {
                    flag = 1;
                    fzc.signal();
                } else if (i % 3 != 0) {
                    flag = 2;
                    bzc.signal();
                } else {
                    flag = 3;
                    bfc.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
