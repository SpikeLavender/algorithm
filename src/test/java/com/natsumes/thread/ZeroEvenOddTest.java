package com.natsumes.thread;

import org.junit.Test;

public class ZeroEvenOddTest {

    private ZeroEvenOdd zeroEvenOdd;

    @Test
    public void test() throws InterruptedException {
        zeroEvenOdd = new ZeroEvenOdd(15);

        Thread t1 = new Thread(()-> {
            try {
                zeroEvenOdd.zero(value -> {
                    System.out.print(value);
                    System.out.flush();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                zeroEvenOdd.even(value -> {
                    System.out.print(value);
                    System.out.flush();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()-> {
            try {
                zeroEvenOdd.odd(value -> {
                    System.out.print(value);
                    System.out.flush();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}