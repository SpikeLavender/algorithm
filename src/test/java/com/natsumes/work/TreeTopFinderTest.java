package com.natsumes.work;

import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author hetengjiao
 */
public class TreeTopFinderTest {
    private static TreeTopFinder finder = new TreeTopFinder();

    private static CountTopFinder ctf = new CountTopFinder();

    private static TreapFinder tf = new TreapFinder();

    @Test
    public void addNum() {
    }

    /**
     * 当数据量变大且离散的时候，红黑树明显要比数组占用的空间小
     * 搜索算法待优化
     */
    @Test
    public void compare() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            finder.addNum(i1);
        }
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            finder.addNum(i1);
        }

        System.out.println("insert time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        //finder.list();
        int[] topNumArr = finder.getTopNumArr();
        System.out.println("search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("top number is: " + Arrays.toString(topNumArr));
        System.out.println("Heap size is: " + RamUsageEstimator.humanSizeOf(finder));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            ctf.addNum(i1);
        }
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            ctf.addNum(i1);
        }
        System.out.println("insert time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        int[] topNumArrCount = ctf.getTopNumArr();
        System.out.println("search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("top number is: " + Arrays.toString(topNumArrCount));
        System.out.println("Heap size is: " + RamUsageEstimator.humanSizeOf(ctf));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            tf.addNum(i1);
        }
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            tf.addNum(i1);
        }
        System.out.println("insert time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        Integer[] topNumTreapCount = tf.getTopNumArr();
        System.out.println("search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("top number is: " + Arrays.toString(topNumTreapCount));
        System.out.println("Heap size is: " + RamUsageEstimator.humanSizeOf(tf));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int in = sc.nextInt();
            finder.addNum(in);
            finder.list();
            System.out.println("top number is: " + Arrays.toString(finder.getTopNumArr()));
        }

    }

}