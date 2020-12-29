package com.natsumes.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @author hetengjiao
 */
public class H2O {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(1);

    private final CyclicBarrier cb = new CyclicBarrier(3, () -> {
        // 可以做一些事情
        System.out.println("H2O complete");
        h.release(2);
        o.release(1);
    });

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
