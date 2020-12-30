package com.natsumes.thread;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MonkeyTakeTest {

    @Test
    public void print() throws InterruptedException {

        MonkeyTake monkeyTake = new MonkeyTake(19);
        monkeyTake.print();
    }
}