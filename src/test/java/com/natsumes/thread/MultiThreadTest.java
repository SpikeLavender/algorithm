package com.natsumes.thread;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MultiThreadTest {

    private final MultiThread multiThread = new MultiThread();

    @Test
    public void test() throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            System.out.println();
//        }
        multiThread.print();
    }
}