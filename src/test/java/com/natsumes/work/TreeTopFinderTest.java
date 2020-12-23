package com.natsumes.work;

import org.apache.lucene.util.RamUsageEstimator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 不同场景使用不同的方法
 *     - 数据离散 -> 使用计数排序
 *     - 数据集中在某个小区间内，使用平衡树  O(log n)
 *
 * 由于AVL树种类较少所以比红黑树实际上更容易实现.而且ALV树在旋转插入所需要的复杂度为0(1),而红
 * 黑树则需要的复杂度为0(lgn).
 *
 * 实际上插入AVL树和红黑树的速度取决于你所插入的数据.如果你的数据分布较好,则比较宜于采用AVL树(例如随机产生系列数),
 * 但是如果你想处理比较杂乱的情况,则红黑树是比较快的,因为红黑树对已经处理好的数据重新平衡减少了不心要的操作.
 *
 * 另外一方面,如果是一种非寻常的插入系列比较常见(比如,插入密钥系列),则AVL树比较快,因为它的严格的平衡规则将会减少树的高度.
 * Splay树可能比红黑树和AVL树还要快这也取决于你所访问的数据分布,如果你用哈希表来代替一棵树,则
 * 将所以的树还要快.
 *
 * @author hetengjiao
 */
public class TreeTopFinderTest {

    private static TopFinder finder = new RbTreeFinder();

    private static CountTopFinder ctf = new CountTopFinder();

    private static TopFinder tf = new TreapFinder();

    private static TopFinder atf = new AvlFinder();

    private static TopFinder stf = new SizeBalanceFinder();

    private final static long TEST_NUM = 10000000;

    private final static long TEST_NUM_PART = 10000;

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

        start = System.currentTimeMillis();
        for (int i = 0; i < TEST_NUM; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100) + 100;
            stf.addNum(i1);
        }
        for (int i = 0; i < TEST_NUM_PART; i++) {
            Random random = new Random();
            int i1 = random.nextInt(200000);
            stf.addNum(i1);
        }
        System.out.println("Size Balanced Tree add time is: " + (System.currentTimeMillis() - start) + "ms");
        //
        Thread.sleep(1000);
        start = System.currentTimeMillis();
        Integer[] topSbtAVLCount = stf.getTopNumArr();
        System.out.println("Size Balanced Tree search time is: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println("Size Balanced Tree top number is: " + Arrays.toString(topSbtAVLCount));
        System.out.println("Size Balanced Tree heap size is: " + RamUsageEstimator.humanSizeOf(stf));
        System.out.println("==================================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int in = sc.nextInt();
            stf.addNum(in);
            //tf.list();
            System.out.println("top number is: " + Arrays.toString(stf.getTopNumArr()));
        }

    }

}