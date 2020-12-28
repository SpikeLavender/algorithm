package com.natsumes.thread;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MultiThreadTest {

    private MultiThread multiThread = new MultiThread();

    @Test
    public void test1() throws InterruptedException {
        //multiThread.print(new int[]{1, 2, 3});
        //multiThread.print(new int[]{1, 3, 2});
        multiThread.print();
    }
}