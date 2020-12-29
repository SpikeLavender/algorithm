package com.natsumes.thread;

import java.util.concurrent.Semaphore;

/**
 * @author hetengjiao
 */
public class H2OSemaphore {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(1);

    public H2OSemaphore() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        releaseHydrogen.run();
        o.release();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

}
