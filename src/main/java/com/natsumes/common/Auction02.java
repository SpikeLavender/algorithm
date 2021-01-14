package com.natsumes.common;


import org.apache.lucene.util.NamedThreadFactory;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hetengjiao
 */
public class Auction02 {

    private int totalCount;

    public Auction02(int totalCount) {
        this.totalCount = totalCount;
    }

    private int count = 0;

    private final int initPrice = 4000;

    private final Object lock = new Object();

    //private Condition curCondition = lock.newCondition();

    private Random random = new Random();

    private int price = initPrice;

    public void auction(String name) {
        while (count < totalCount) {
            synchronized (lock) {
                int i = random.nextInt(200);
                price = price + i;
                count++;
                System.out.println(Thread.currentThread().getName() + ": "
                        + name + " send " + price + " at " + count);
                lock.notifyAll();
                if (count == totalCount) {
                    System.out.println(Thread.currentThread().getName() + ": "
                            + "took by " + name + " at " + count + ", price is " + price + ", activity finished");
                    return;
                }
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + ": " + name + " activity has finished at " + price);
    }

    static class AuctionRunnable implements Runnable {

        private final String name;

        private final Auction02 auction;

        AuctionRunnable(String name, Auction02 auction) {
            this.name = name;
            this.auction = auction;
        }

        @Override
        public void run() {
            auction.auction(name);
        }
    }

    public static void main(String[] args) {
        Auction02 auction = new Auction02(1000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(150, 250,
                200L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(150),
                new NamedThreadFactory("thread-call-runner"));
        for (int i = 1; i <= 150; i++) {
            executor.execute(new AuctionRunnable("user-" + i, auction));
        }
        executor.shutdown();
    }
}
