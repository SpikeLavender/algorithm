package com.natsumes.thread;

import junit.framework.TestCase;
import org.junit.Test;


public class FizzBuzzLockTest extends TestCase {

    private FizzBuzzLock fizzBuzz;

    static class PrintRunnable implements Runnable {

        private final String name;

        public PrintRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.print(name + " ");
            System.out.flush();
        }
    }

    @Test
    public void test() throws InterruptedException {
        fizzBuzz = new FizzBuzzLock(15);

        Thread t1 = new Thread(()-> {
            try {
                fizzBuzz.buzz(new PrintRunnable("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                fizzBuzz.fizz(new PrintRunnable("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()-> {
            try {
                fizzBuzz.fizzbuzz(new PrintRunnable("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(()-> {
            try {
                fizzBuzz.number((v) -> {
                    System.out.print(v + " ");
                    System.out.flush();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }

}