package com.natsumes.leetcode;

import java.util.*;

/**
 *
 * LeetCode 全集
 *
 * @author hetengjiao
 */
public class LeetCode {

    /* ==================================== 随机算法专题 ======================================== */


    /* ------------------------------------ 水塘抽样算法 ---------------------------------------- */
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
    public int pick(int[]nums, int target) {
        Random random = new Random();
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
            if (random.nextInt(i) == 0) {
                res = i;
            }
        }
        return res;
    }

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
    class RandomPick {

        private ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        private RandomPick(ListNode head) {
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
    }

    public RandomPick randomPick(ListNode head) {
        return new RandomPick(head);
    }

    /**
     * 实现一个生成器类，构造函数传入一个很长的数组，请你实现randomGet方法，每次调用随机返回数组中的一个元素，
     * 多次调用不能重复返回相同索引的元素。
     * 连续 m 次之内不能出现重复的元素
     * 要求不能对该数组进行任何形式的修改，且操作的时间复杂度是 O(1)。
     */
    class RandomArrPick {

        private int[] nums;

        // 连续3次之内的数据不能重复
        private final static int MAX_SKIP_NUM = 3;

        // todo：定义一个类似于LRU的数据结构, 定长队列
        private Set<Integer> set = new HashSet<>(MAX_SKIP_NUM);

        /** @param nums The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public RandomArrPick(int[] nums) {
            this.nums = nums;
        }

        /** Returns a random node's value. */
        public int randomGet() {
            Random random = new Random();
            int res = 1, i;
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
    }

    public RandomArrPick randomArrPick(int[] nums) {
        return new RandomArrPick(nums);
    }
    /* ------------------------------------------------------------------------------------- */


    /* ==================================== 回溯算法相关专题 ======================================== */

    /**
     * 表示是否被访问过
     */
    private boolean[] vis;

    /**
     * 46. 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     *            O
     *         1     2
     *       O         O
     *     2   3     1   3
     *    O     O   O      O
     *    3     2   3      1
     *    O     O   O      O
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        vis = new boolean[nums.length];
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track, res, 0);
        return res;
    }

    /**
     * 回溯算法
     * @param nums      选择列表
     * @param track     记录路径
     * @param res       符合条件的结果
     */
    private void backTrack(int[] nums, List<Integer> track, List<List<Integer>> res, int idx) {
        // 结束条件：track.size = nums.length
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合理的选择
            if (vis[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            vis[i] = true;
            // 进入下一层决策树
            backTrack(nums, track, res, idx + 1);
            // 取消选择
            vis[i] = false;
            track.remove(idx);
        }
    }

    // todo: 1.交换元素达成目的的算法

    /**
     * 47. 全排列 II
     *
     * 给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backTrackUnique(nums, track, res, 0);
        return res;
    }

    /**
     * 回溯算法(按下标回溯)
     * @param nums          数据
     * @param trackIndex    记录路径下标
     * @param res           结果
     */
    private void backTrackUnique(int[] nums, List<Integer> trackIndex, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(trackIndex));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            } else if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                // 保证每次访问重复元素的时候，都是按照顺序访问第一个未被访问到的元素
                continue;
            }
            trackIndex.add(nums[i]);
            vis[i] = true;
            backTrackUnique(nums, trackIndex, res, idx + 1);
            vis[i] = false;
            trackIndex.remove(idx);
        }
    }

    /**
     * 784. 字母大小写全排列
     *
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     *
     * 示例：
     * 输入：S = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * 输入：S = "3z4"
     * 输出：["3z4", "3Z4"]
     *
     * 输入：S = "12345"
     * 输出：["12345"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> letterCasePermutation(String S) {
        return null;
    }

    /* ======================================================================================= */

    /**
     * 红包
     */

    /**
     * 三个线程打印 XYZ
     */
}
