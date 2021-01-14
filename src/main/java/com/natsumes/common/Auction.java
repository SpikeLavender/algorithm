package com.natsumes.common;


import org.apache.lucene.util.NamedThreadFactory;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hetengjiao
 */
public class Auction {

    private int totalCount;

    public Auction(int totalCount) {
        this.totalCount = totalCount;
    }

    private int count = 0;

    private final int initPrice = 4000;

    private Lock lock = new ReentrantLock();

    private Condition curCondition = lock.newCondition();

    private Random random = new Random();

    private int price = initPrice;

    private volatile int curId = 0;

    public void auction(int id) {
        while (count < totalCount) {
            lock.lock();
            //if (lock.tryLock()) {
                try {
                    if (curId == id) {
                        System.out.println("repeat");
                        curCondition.await();
                    }
                    if (count == totalCount) {
                        System.out.println(Thread.currentThread().getName() + " " + id + ": activity has finished");
                        return;
                    }
                    curId = id;
                    int i = random.nextInt(200);
                    price = price + i;
                    count++;
                    System.out.println(Thread.currentThread().getName() + ": "
                            + curId + " send " + price + " at " + count);
                    if (count == totalCount) {
                        System.out.println(Thread.currentThread().getName() + ": "
                                + "took by " + curId + " at " + count + ", price is " + price + ", activity finished");
                    }
                    curCondition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            //}
            System.out.println("test");
        }
        System.out.println(Thread.currentThread().getName() + ": " + id + " activity has finished");
    }

    static class AuctionRunnable implements Runnable {
        private final int id;

        private final Auction auction;

        AuctionRunnable(int id, Auction auction) {
            this.id = id;
            this.auction = auction;
        }

        @Override
        public void run() {
            auction.auction(id);
        }
    }

    public static void main(String[] args) {
        Auction auction = new Auction(10000);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(150, 250,
                200L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(150),
                new NamedThreadFactory("thread-call-runner"));
        for (int i = 1; i <= 150; i++) {
            executor.execute(new AuctionRunnable(i, auction));
        }
        executor.shutdown();
    }
}
