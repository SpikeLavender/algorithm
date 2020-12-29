package com.natsumes.thread;

import java.util.concurrent.Semaphore;

/**
 * @author hetengjiao
 */
public class DiningPhilosophers {

    private final Semaphore eatLimit  = new Semaphore(2);

    private final Semaphore[] fork = new Semaphore[] {
            new Semaphore(2),
            new Semaphore(2),
            new Semaphore(2),
            new Semaphore(2),
            new Semaphore(2)
    };

    public DiningPhilosophers() {

    }

    /**
     * call the run() method of any runnable to execute its code
     */
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        eatLimit.acquire();

        fork[philosopher].acquire(2);
        int right = (philosopher + 1) % 5;
        int left = (philosopher - 1 + 5) % 5;
        fork[left].acquire();
        fork[right].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        fork[left].release();
        fork[right].release();
        fork[philosopher].release(2);
        eatLimit.release();
    }

}
