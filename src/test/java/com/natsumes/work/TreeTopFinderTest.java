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

    private static RbTreeFinder finder = new RbTreeFinder();

    private static CountTopFinder ctf = new CountTopFinder();

    private static TreapFinder tf = new TreapFinder();

    private static AvlFinder atf = new AvlFinder();

    private final static long TEST_NUM = 1000000000;

    private final static long TEST_NUM_PART = 1000;

    /**
     * 当数据量变大且离散的时候，红黑树明显要比数组占用的空间小
     * 搜索算法待优化
     */
    @Test
    public void compare() throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            finder.addNum(i1);
        }
        for (int i = 0; i < TEST_NUM_PART; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            finder.addNum(i1);
        }

        System.out.println("Red-Black tree add time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        //finder.list();
        Integer[] topNumArr = finder.getTopNumArr();
        System.out.println("Red-Black tree search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Red-Black tree top number is: " + Arrays.toString(topNumArr));
        System.out.println("Red-Black tree heap size is: " + RamUsageEstimator.humanSizeOf(finder));
        System.out.println("==================================================================");

        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            ctf.addNum(i1);
        }
        for (int i = 0; i < TEST_NUM_PART; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            ctf.addNum(i1);
        }
        System.out.println("Count method add time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        int[] topNumArrCount = ctf.getTopNumArr();
        System.out.println("Count method search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Count method top number is: " + Arrays.toString(topNumArrCount));
        System.out.println("Count method heap size is: " + RamUsageEstimator.humanSizeOf(ctf));
        System.out.println("==================================================================");


        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            tf.addNum(i1);
        }
        for (int i = 0; i < TEST_NUM_PART; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            tf.addNum(i1);
        }
        System.out.println("Treap add time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        Integer[] topNumTreapCount = tf.getTopNumArr();
        System.out.println("Treap search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Treap top number is: " + Arrays.toString(topNumTreapCount));
        System.out.println("Treap heap size is: " + RamUsageEstimator.humanSizeOf(tf));
        System.out.println("==================================================================");


        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            atf.addNum(i1);
        }
        for (int i = 0; i < TEST_NUM_PART; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            atf.addNum(i1);
        }
        System.out.println("AVL tree add time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        Integer[] topNumAVLCount = atf.getTopNumArr();
        System.out.println("AVL tree search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("AVL tree top number is: " + Arrays.toString(topNumAVLCount));
        System.out.println("AVL tree heap size is: " + RamUsageEstimator.humanSizeOf(atf));
        System.out.println("==================================================================");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int in = sc.nextInt();
            atf.addNum(in);
            //tf.list();
            System.out.println("top number is: " + Arrays.toString(atf.getTopNumArr()));
        }

    }

}