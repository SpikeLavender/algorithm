package com.natsumes.thread;

/**
 * @author hetengjiao
 */
public class MultiThread {

    private final OrderPrinter orderPrinter = new OrderPrinter();

    private FooBarVolatile fooBarVolatile;

    static class PrintRunnable implements Runnable {

        private final String name;

        public PrintRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.print(name);
            System.out.flush();
        }
    }

    public void print() throws InterruptedException {
        Thread t1 = new Thread(()-> {
            try {
                orderPrinter.third(new PrintRunnable("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                orderPrinter.first(new PrintRunnable("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()-> {
            try {
                orderPrinter.second(new PrintRunnable("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join();

    }

    public void printFooBar(int n) throws InterruptedException {
        fooBarVolatile = new FooBarVolatile(n);
        Thread t1 = new Thread(()-> {
            try {
                fooBarVolatile.foo(new PrintRunnable("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                fooBarVolatile.bar(new PrintRunnable("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void printFooBar01(int n) throws InterruptedException {
        FooBarLock fooBarLock = new FooBarLock(n);
        Thread t1 = new Thread(()-> {
            try {
                fooBarLock.foo(new PrintRunnable("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()-> {
            try {
                fooBarLock.bar(new PrintRunnable("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
