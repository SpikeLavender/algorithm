package com.natsumes.leetcode.design;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MyQueueTest {

    @Test
    public void push() {
        MyQueue myQueue = new MyQueue();
        // queue is: [1]
        myQueue.push(1);
        // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(2);
        // return 1
        Assert.assertEquals(1, myQueue.peek());
        // return 1, queue is [2]
        Assert.assertEquals(1, myQueue.pop());
        // return false
        Assert.assertFalse(myQueue.empty());
    }
}