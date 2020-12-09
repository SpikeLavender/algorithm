package com.natsumes.leetcode;

import java.util.*;

/**
 *
 * LeetCode 全集
 *
 * @author hetengjiao
 */
public class LeetCode {

    /**
     * 398. 随机数索引
     * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。
     * 您可以假设给定的数字一定存在于数组中。
     *
     * 注意：
     * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
     *
     * 示例:
     *
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     *
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/random-pick-index
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
//    public int pick(int[]nums, int target) {
//        Random random = new Random();
//        int res = 1;
//        for (int i = 0; i < nums.length; i++) {
//            // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
//            if (random.nextInt(i) == 0) {
//                res = i;
//            }
//        }
//        return res;
//    }


    /**
     * 382. 链表随机节点
     *
     * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
     *
     * 进阶:
     * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
     *
     * 示例:
     *
     * // 初始化一个单链表 [1,2,3].
     * ListNode head = new ListNode(1);
     * head.next = new ListNode(2);
     * head.next.next = new ListNode(3);
     * Solution solution = new Solution(head);
     *
     * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
     * solution.getRandom();
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-random-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class RandomPick {

        private ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public RandomPick(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random random = new Random();
            int res = 0;
            int i = 0;
            ListNode p = head;
            while (p != null) {
                // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
                if (random.nextInt(++i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }

        public static void main(String[] args) {
            // 初始化一个单链表 [1,2,3].
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            RandomPick solution = new RandomPick(head);

            // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
            int random = solution.getRandom();
            System.out.println(random);
        }
    }

    /**
     * 实现一个生成器类，构造函数传入一个很长的数组，请你实现randomGet方法，每次调用随机返回数组中的一个元素，
     * 多次调用不能重复返回相同索引的元素。
     * 连续 m 次之内不能出现重复的元素
     * 要求不能对该数组进行任何形式的修改，且操作的时间复杂度是 O(1)。
     */
    static class RandomArrPick {

        private int[] nums;

        // 连续3次之内的数据不能重复
        private final static int MAX_SKIP_NUM = 3;

        // todo：定义一个类似于LRU的数据结构
        private Set<Integer> set = new HashSet<>(MAX_SKIP_NUM);

        /** @param nums The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public RandomArrPick(int[] nums) {
            this.nums = nums;
        }

        /** Returns a random node's value. */
        public int randomGet() {
            Random random = new Random();
            int res = 1, i = 0;
            for (i = 0; i < nums.length; i++) {
                // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
                if (!set.contains(i) && random.nextInt(i + 1) == 0) {
                    res = nums[i];
                    set.add(i);
                }
            }
            set.add(i);
            return res;
        }

        public static void main(String[] args) {
            // 初始化一个单链表 [1,2,3].
            RandomArrPick solution = new RandomArrPick(new int[]{1, 2, 3, 4, 5, 6});
            // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
            int random = solution.randomGet();
            System.out.println(random);
            System.out.println();
        }
    }


}
