package com.natsumes.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * @author hetengjiao
 */
public class FizzBuzz {

    private int n;

    private final AtomicInteger count = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    /**
     * printFizz.run() outputs "fizz".
     */
    public void fizz(Runnable printFizz) throws InterruptedException {
        int num;
        while ((num = count.get()) <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                printFizz.run();
                count.incrementAndGet();
            }
        }
    }

    /**
     * printBuzz.run() outputs "buzz".
     */
    public void buzz(Runnable printBuzz) throws InterruptedException {
        int num;
        while ((num = count.get()) <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                printBuzz.run();
                count.incrementAndGet();
            }
        }
    }

    /**
     * printFizzBuzz.run() outputs "fizzbuzz".
     */
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int num;
        while ((num = count.get()) <= n) {
            if (num % 3 == 0 && num % 5 == 0) {
                printFizzBuzz.run();
                count.incrementAndGet();
            }
        }
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     */
    public void number(IntConsumer printNumber) throws InterruptedException {
        int num;
        while ((num = count.get()) <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                printNumber.accept(num);
                count.incrementAndGet();
            }
        }
    }
}
