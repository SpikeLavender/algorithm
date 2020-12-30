package com.natsumes.thread;

/**
 * @author hetengjiao
 */
public class MonkeyTake {
    private volatile int num = 0;
    //private Pick pick = new Pick();

    public void take(String name, int num) {
        System.out.println(name + "take " + num);
    }

    private int total;

    public MonkeyTake(int total) {
        this.total = total;
    }

    private Thread t1 = new Thread(()->{
        while(num + 2 <= total) {
            take("Monkey 1 ", 2);
            num = num + 2;
        }
    });
    private Thread t2 = new Thread(()->{
        while(num + 3 <= total) {
            take("Monkey 2 ", 3);
            num = num + 3;
        }
    });

    public void print() throws InterruptedException {
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
