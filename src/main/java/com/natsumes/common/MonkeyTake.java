package com.natsumes.common;

import org.apache.lucene.util.NamedThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hetengjiao
 */
public class MonkeyTake {

    private int curNum = 0;

    private final int total;

    private final Object lock = new Object();

    public MonkeyTake(int total) {
        this.total = total;
    }

    public void take(String name, int num) {
        while (curNum + num <= total) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": " + name + " take " + num);
                curNum = curNum + num;
                lock.notifyAll();
                if (total - curNum < num) {
                    System.out.println(name + " not enough to take!!!");
                    return;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(name + " not enough to take!!!");
    }

    static class MonkeyRunnable implements Runnable {
        private final String name;

        private final int num;

        private final MonkeyTake monkeyTake;

        public MonkeyRunnable(String name, int num, MonkeyTake monkeyTake) {
            this.name = name;
            this.num = num;
            this.monkeyTake = monkeyTake;
        }

        @Override
        public void run() {
            monkeyTake.take(name, num);
        }
    }

    public static void main(String[] args) {
        MonkeyTake monkeyTake = new MonkeyTake(39);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3,
                200L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), new NamedThreadFactory("Monkey-taker"));
        executor.execute(new MonkeyRunnable("monkey-01", 2, monkeyTake));
        executor.execute(new MonkeyRunnable("monkey-02", 3, monkeyTake));
        executor.execute(new MonkeyRunnable("monkey-03", 4, monkeyTake));
        executor.shutdown();
    }

}
