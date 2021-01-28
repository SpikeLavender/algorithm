package com.natsumes.thread;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hetengjiao
 */
public class Printer {
    private final int num;

    private volatile int flag = 0;

    private final ReentrantLock lock = new ReentrantLock();

    //private final Object lock = new Object();

    private Condition ca = lock.newCondition();

    private Condition cb = lock.newCondition();

    private Condition cc = lock.newCondition();

    Printer(int num) {
        this.num = num;
    }

    public void printA() {
        for(int i = 0; i < num; i++) {
            lock.lock();
            try {
                if (flag != 0) {
                    ca.await();
                }
                System.out.print("A");
                flag = 1;
                cb.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public void printB() {
        for(int i = 0; i < num; i++) {
            lock.lock();
            try {
                if (flag != 1) {
                    cb.await();
                }
                System.out.print("B");
                flag = 2;
                cc.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC() {
        for(int i = 0; i < num; i++) {
            lock.lock();
            try {
                if (flag != 2) {
                    cc.await();
                }
                System.out.print("C");
                flag = 0;
                ca.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        Printer print = new Printer(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3,
                200L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        executor.execute(new A(print));
        executor.execute(new B(print));
        executor.execute(new C(print));
        executor.shutdown();
        while (!executor.isTerminated()) {
            //
        }

        System.out.println("end");
    }

    static class A implements Runnable {
        private Printer printer;

        A(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            //for(int i = 0; i < num; i++) {
                printer.printA();
            //}
        }
    }

    static class B implements Runnable {
        private Printer printer;

        B(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            //for(int i = 0; i < num; i++) {
                printer.printB();
            //}
        }
    }

    static class C implements Runnable {
        private Printer printer;

        C(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            //for(int i = 0; i < num; i++) {
                printer.printC();
            //}
        }
    }
}
