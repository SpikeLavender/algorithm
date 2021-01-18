package com.natsumes.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hetengjiao
 */
public class MapAction {

    private final Map<Integer, Integer> map = new HashMap<>(1);

    private AtomicInteger total = new AtomicInteger(0);

    private int size = 0;

    public MapAction() {

    }

    public void put(int value) {
        synchronized (map) {
            if (size == 0) {
                map.put(0, value);
                size++;
                map.notify();
            }

            try {
                map.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int get() {
        synchronized (map) {
            if (size == 0) {
                try {
                    map.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            size--;
            total.addAndGet(map.get(0));
            map.notify();
        }

        return total.intValue();
    }


    static class A implements Runnable {
        private final MapAction mapAction;

        public A(MapAction mapAction) {
            this.mapAction = mapAction;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                mapAction.put(i);
            }
        }
    }

    static class B implements Runnable {
        private final MapAction mapAction;

        public B(MapAction mapAction) {
            this.mapAction = mapAction;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                System.out.println(mapAction.get());
            }
        }
    }

    public static void main(String[] args) {
        MapAction mapAction = new MapAction();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3,
                200L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(20));
        executor.execute(new A(mapAction));
        executor.execute(new B(mapAction));
        executor.shutdown();
    }
}