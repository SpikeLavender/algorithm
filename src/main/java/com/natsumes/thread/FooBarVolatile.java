package com.natsumes.thread;

/**
 * @author hetengjiao
 */
public class FooBarVolatile {

    private volatile int num;

    private int n;

    public FooBarVolatile(int n){
        this.n = n;
        num = 0;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (num != 0) {

            }
            printFoo.run();
            num = 1;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (num != 1) {

            }
            printBar.run();
            num = 0;
        }
    }

}
