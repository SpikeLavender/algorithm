package com.natsumes.daily;

import java.util.*;

/**
 * @author hetengjiao
 *
 * <a href="https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/">1423.可获得的最大点数</a>
 * {@link DailyPractice#maxScore(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/maximum-average-subarray-i/">643.子数组最大平均数 I</a>
 * {@link DailyPractice#findMaxAverage(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">424.替换后的最长重复字符</a>
 * {@link com.natsumes.leetcode.sliding.SlidingWindow#characterReplacement(java.lang.String, int)}
 *
 */
public class DailyPractice {

    /**
     * 1423. 可获得的最大点数
     * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
     *
     * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
     *
     * 你的点数就是你拿到手中的所有卡牌的点数之和。
     *
     * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
     * 输出：12
     * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。
     * 最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
     * 示例 2：
     *
     * 输入：cardPoints = [2,2,2], k = 2
     * 输出：4
     * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
     * 示例 3：
     *
     * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
     * 输出：55
     * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
     * 示例 4：
     *
     * 输入：cardPoints = [1,1000,1], k = 1
     * 输出：1
     * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
     * 示例 5：
     *
     * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
     * 输出：202
     *
     *
     * @param cardPoints 卡牌
     * @param k 拿 k 张卡牌
     * @return 可以获得的最大点数
     */
    public int maxScore(int[] cardPoints, int k) {
        // 滑动窗口，拿走k张之后，剩下的必然为连续的 n - k 张，
        // 找到剩下和最小的，用总数减掉，得到可以拿走的最大点数
        int n = cardPoints.length;
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += cardPoints[i];
        }
        int min = sum;
        int totalSum = sum;
        for (int i = n - k; i < n; i++) {
            sum = sum + cardPoints[i] - cardPoints[i - n + k];
            totalSum += cardPoints[i];
            min = Math.min(min, sum);
        }
        return totalSum - min;
    }

    /**
     * 643. 子数组最大平均数 I
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 示例：
     *
     * 输入：[1,12,-5,-6,50,3], k = 4
     * 输出：12.75
     * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * 提示：
     * 1 <= k <= n <= 30,000。
     * 所给数据范围 [-10,000，10,000]。
     *
     * @param nums nums
     * @param k k
     * @return double
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double ans = (double) sum / k;
        for (int i = 0; i < n - k; i++) {
            sum = sum + nums[i + k] -nums[i];
            ans = Math.max(ans, (double) sum / k);
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/fair-candy-swap/
     *
     * 888. 公平的糖果棒交换
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
     *
     * 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。
     * （一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     *
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     *
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = [1,1], B = [2,2]
     * 输出：[1,2]
     * 示例 2：
     *
     * 输入：A = [1,2], B = [2,3]
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：A = [2], B = [1,3]
     * 输出：[2,3]
     * 示例 4：
     *
     * 输入：A = [1,2,5], B = [2,4]
     * 输出：[5,4]
     *
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int value : A) {
            sumA += value;
            set.add(value);
        }

        int sumB = 0;
        for (int value : B) {
            sumB += value;
        }

        int[] ans = new int[2];
        int delta = (sumA - sumB) / 2;
        for (int b : B) {
            int a = delta + b;
            if (set.contains(a)) {
                ans[0] = a;
                ans[1] = b;
                break;
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/path-with-minimum-effort/
     * 1631. 最小体力消耗路径
     * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，
     * 其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，
     * 且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
     * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
     *
     * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
     *
     * 请你返回从左上角走到右下角的最小 体力消耗值 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
     * 输出：2
     * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
     * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
     * 示例 2：
     *
     *
     *
     * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
     * 输出：1
     * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
     * 示例 3：
     *
     *
     * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
     * 输出：0
     * 解释：上图所示路径不需要消耗任何体力。
     *
     *
     * 提示：
     *
     * rows == heights.length
     * columns == heights[i].length
     * 1 <= rows, columns <= 100
     * 1 <= heights[i][j] <= 106
     */
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;

        return 0;
    }

    /*========================================= 2021-01-13 ======================================================*/
    /**
     * 684. 冗余连接
     * 在本问题中, 树指的是一个连通且无环的无向图。
     *
     * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     *
     * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
     *
     * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     *
     * 示例 1：
     *
     * 输入: [[1,2], [1,3], [2,3]]
     * 输出: [2,3]
     * 解释: 给定的无向图为:
     *   1
     *  / \
     * 2 - 3
     * 示例 2：
     *
     * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
     * 输出: [1,4]
     * 解释: 给定的无向图为:
     * 5 - 1 - 2
     *     |   |
     *     4 - 3
     * 注意:
     *
     * 输入的二维数组大小在 3 到 1000。
     * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
     * 更新(2017-09-26):
     * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
     * https://leetcode-cn.com/problems/redundant-connection/
     */
    public int[] findRedundantConnection(int[][] edges) {
        return new int[0];
    }

    /*========================================= 2021-01-08 ======================================================*/
    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     *
     * https://leetcode-cn.com/problems/rotate-array/
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int cur = start;
            int prev = nums[start];
            do {
                int next = (cur + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
            } while (start != cur);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    /*========================================= 2021-01-07 ======================================================*/
    /**
     * 547. 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，
     * 且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     *
     *
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] 为 1 或 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     */
    public int findCircleNum(int[][] isConnected) {
        return 0;
    }

    /*========================================= 2021-01-06 ======================================================*/
    /**
     * 399. 除法求值
     * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
     *
     *
     *
     * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0],
     * queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 示例 2：
     *
     * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
     * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * 输出：[3.75000,0.40000,5.00000,0.20000]
     * 示例 3：
     *
     * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * 输出：[0.50000,2.00000,-1.00000,-1.00000]
     *
     *
     * 提示：
     *
     * 1 <= equations.length <= 20
     * equations[i].length == 2
     * 1 <= Ai.length, Bi.length <= 5
     * values.length == equations.length
     * 0.0 < values[i] <= 20.0
     * 1 <= queries.length <= 20
     * queries[i].length == 2
     * 1 <= Cj.length, Dj.length <= 5
     * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
     *
     * https://leetcode-cn.com/problems/evaluate-division/
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[0];
        return res;
    }

    /*========================================= 2021-01-05 ======================================================*/
    /**
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
     * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abbxxxxzzy"
     * 输出：[[3,6]]
     * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * 示例 2：
     *
     * 输入：s = "abc"
     * 输出：[]
     * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
     * 示例 3：
     *
     * 输入：s = "abcdddeeeeaabbbcd"
     * 输出：[[3,5],[6,9],[12,14]]
     * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
     * 示例 4：
     *
     * 输入：s = "aba"
     * 输出：[]
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅含小写英文字母
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < s.length() - 2) {
            int count = 0;
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                count++;
                j++;
            }
            if (count >= 3) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                cur.add(j - 1);
                res.add(cur);
            }
            i = j;
        }
        return res;
    }

    /*========================================= 2021-01-03 ======================================================*/
    /**
     * 86. 分隔链表
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 示例：
     *
     * 输入：head = 1->4->3->2->5->2, x = 3
     *   1 2 4 3 5 2
     * 输出：1->2->2->4->3->5
     *
     * https://leetcode-cn.com/problems/partition-list/
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode smallHead = small;
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append("[");
            ListNode node = this;
            while (node.next != null) {
                str.append(node.val).append(" -> ");
                node = node.next;
            }
            str.append(node.val).append("]");
            return str.toString();
        }
    }

    /*========================================= 2021-01-02 ======================================================*/
    /**
     * 239. 滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
     * 滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     *
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     *
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     *
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 单调队列
        MonotonicQueue mq = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                mq.push(nums[i]);
            } else {
                mq.push(nums[i]);
                res[i - k + 1] = mq.max();
                mq.pop(nums[i - k + 1]);
            }
        }
        return res;
    }

    class MonotonicQueue {

        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int value) {
            while (!queue.isEmpty() && queue.getLast() < value) {
                queue.pollLast();
            }
            queue.addLast(value);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int value) {
            if (value == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }

    /*========================================= 2021-01-01 ======================================================*/
    /**
     * 605. 种花问题
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
     *
     * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *
     * 示例 1:
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * 示例 2:
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     * 注意:
     *
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     *
     * f[i] = f[i-1] + 1    p[i] = 0
     * f[i] = f[i-1] - 1    p[i] = 1
     *
     * 自己为空
     * 左右为空（最左和最右）
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = (i == 0 || flowerbed[i - 1] == 0);
            boolean right = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);
            if (flowerbed[i] == 0 && left && right) {
                n--;
                flowerbed[i] = 1;
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }

    /*========================================= 2020-12-31 ======================================================*/
    /**
     * 435. 无重叠区间
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     *
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     *
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     *
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        // f[i] = max(f[j] + 1, f[i]) a[j] < a[i] j < i
        int length = intervals.length;
        int[] f = new int[length];
        Arrays.fill(f, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
        }
        return length - Arrays.stream(f).max().getAsInt();
    }

    /*========================================= 2020-12-30 ======================================================*/
    /**
     * 1046. 最后一块石头的重量
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     *
     * 示例：
     *
     * 输入：[2,7,4,1,8,1]
     * 输出：1
     * 解释：
     * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
     * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
     * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
     * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
     *
     *                8                i
     *              7   4              2 * i + 1   2 * i + 2
     *             2 1 1 1
     *
     * 提示：
     *
     * 1 <= stones.length <= 30
     * 1 <= stones[i] <= 1000
     *
     * https://leetcode-cn.com/problems/last-stone-weight/
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int top = queue.poll();
            int second = Objects.requireNonNullElse(queue.poll(), 0);
            if (top > second) {
                queue.offer(top - second);
            }
        }
        return queue.size() == 0 ? 0 : queue.peek();
    }

    /*========================================= 2020-12-29 ======================================================*/
    /**
     * 330. 按要求补齐数组
     * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
     *
     * 示例 1:
     *
     * 输入: nums = [1,3], n = 6
     * 输出: 1
     * 解释:
     * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
     * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
     * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
     * 所以我们最少需要添加一个数字。
     * 示例 2:
     *
     * 输入: nums = [1,5,10], n = 20
     * 输出: 2
     * 解释: 我们需要添加 [2, 4]。
     * 示例 3:
     *
     * 输入: nums = [1,2,2], n = 5
     * 输出: 0
     */
    public int minPatches(int[] nums, int n) {
        return 0;
    }

    /*========================================= 2020-12-28 ======================================================*/
    /**
     * 188. 买卖股票的最佳时机 IV
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     *
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     *
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * 示例 2：
     *
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     *
     *
     * 提示：
     *
     * 0 <= k <= 109
     * 0 <= prices.length <= 1000
     * 0 <= prices[i] <= 1000
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     *
     * f[i] = max(p[i] - p[i-1] + f[i-2], )
     *
     */
    public int maxProfit(int k, int[] prices) {
        return 0;
    }

    /*========================================= 2020-12-27 ======================================================*/

    /**
     * 205. 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "paper", t = "title"
     * 输出: true
     * 说明:
     * 你可以假设 s 和 t 具有相同的长度。
     *
     * https://leetcode-cn.com/problems/isomorphic-strings/
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.containsKey(key) && map.get(key) != value) {
                return false;
            }
            if (!map.containsKey(key) && map.containsValue(value)) {
                return false;
            }
            map.put(key, value);
        }
        return true;
    }


    /*========================================= 2020-12-26 ======================================================*/

    /*========================================= 2020-12-25 ======================================================*/

    /**
     * 455. 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
     * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，
     * 并输出这个最大数值。
     *
     * 示例 1:
     *
     * 输入: g = [1,2,3], s = [1,1]
     * 输出: 1
     * 解释:
     * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
     * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
     * 所以你应该输出1。
     * 示例 2:
     *
     * 输入: g = [1,2], s = [1,2,3]
     * 输出: 2
     * 解释:
     * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
     * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
     * 所以你应该输出2.
     *
     *
     * 提示：
     *
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/assign-cookies/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
