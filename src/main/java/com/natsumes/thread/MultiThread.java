package com.natsumes.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hetengjiao
 */
public class MultiThread {

    private OrderPrinter orderPrinter = new OrderPrinter();

    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");
    }

    class PrintRunnable implements Runnable {

        private String name;

        public PrintRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name);
        }
    }

    public void print() throws InterruptedException {
        orderPrinter.third(new PrintRunnable("third"));
        orderPrinter.first(new PrintRunnable("first"));
        orderPrinter.second(new PrintRunnable("second"));
    }
}
