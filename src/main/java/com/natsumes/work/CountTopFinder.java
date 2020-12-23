package com.natsumes.work;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hetengjiao
 */
public class CountTopFinder {

    private int[] nums;

    private AtomicLong size;

    private volatile int[] topNumArr;

    public CountTopFinder() {
        nums = new int[200000];
        size = new AtomicLong(0);
        topNumArr = new int[]{-1, -1, -1};
    }

    public void addNum(int num) {
        if (num < 0 || num >= nums.length) {
            throw new IllegalArgumentException();
        }
        nums[num] = nums[num] + 1;
        size.addAndGet(1);
    }

    private void updateTopValue() {
        int top50Index = (int)(size.intValue() * 0.5 + 0.5);
        int top90Index = (int)(size.intValue() * 0.1 + 0.5);
        int top99Index = (int)(size.intValue() * 0.01 + 0.5);
        for (int i = 0; i < topNumArr.length; i++) {
            topNumArr[i] = -1;
        }

        int k = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            k += nums[i];
            if (k >= top99Index && topNumArr[2] == -1) {
                topNumArr[2] = i;
                continue;
            }
            if (k >= top90Index && topNumArr[1] == -1) {
                topNumArr[1] = i;
                continue;
            }
            if (k >= top50Index) {
                topNumArr[0] = i;
                break;
            }
        }
    }

    public int[] getTopNumArr() {
        updateTopValue();
        return topNumArr;
    }
}
