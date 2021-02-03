package com.natsumes.thread;

import org.junit.Test;

import java.util.Arrays;

public class DiningPhilosophersTest {

    private DiningPhilosophers dp;

    class EatRunnable implements Runnable {

        private final int[] output = new int[] {-1,-1, -1};

        private final int num;

        public EatRunnable(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            output[0] = num;
            try {
                dp.wantsToEat(num, () -> {
                    output[1] = 1;
                    output[2] = 1;
                    System.out.println(Arrays.toString(output));
                }, () -> {
                    output[1] = 2;
                    output[2] = 1;
                    System.out.println(Arrays.toString(output));
                }, () -> {
                    output[1] = 0;
                    output[2] = 3;
                    System.out.println(Arrays.toString(output));
                }, () -> {
                    output[1] = 1;
                    output[2] = 2;
                    System.out.println(Arrays.toString(output));
                }, () -> {
                    output[1] = 2;
                    output[2] = 2;
                    System.out.println(Arrays.toString(output));
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testWantsToEat() {
        dp = new DiningPhilosophers();
        for (int i = 0; i < 5; i++) {
            new Thread(new EatRunnable(i)).start();
        }
        //while (true);
    }
}