package com.natsumes.daily;

import java.util.*;

/**
 * @author hetengjiao
 */
public class DailyPractice {

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

    /*========================================= 2021-01-04 ======================================================*/
    /**
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     *
     *
     * 提示：
     *
     * 0 <= n <= 30
     *
     * https://leetcode-cn.com/problems/fibonacci-number/
     */
    public int fib(int n) {
        int f0 = 0;
        int f1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }
        return n <= 1 ? n : res;
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
        // f[i] = max(f[j] + 1, 1) a[j] < a[i] j < i
        int length = intervals.length;
        int count = 0;
        int[] f = new int[length];
        for (int i = 0; i < length; i++) {
            int temp = 1;
            for (int j = length - 1; j >= 0; j--) {
                if (intervals[i][1] > intervals[j][1]) {
                    temp = Math.max(f[j] + 1, temp);
                }
            }
            f[i] = temp;
            count = Math.max(count, f[i]);
        }
        return length - count;
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
    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     *  
     *
     * 示例 1：
     *      1   0   1   0   0
     *      1   0   1   1   1
     *      1   1   1   1   1
     *      1   0   0   1   0
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     *
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     *
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     *
     * 输入：matrix = [["0","0"]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * rows == matrix.length
     * cols == matrix[0].length
     * 0 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximalRectangle(char[][] matrix) {
        return doMaximalRectangle(matrix);
    }

    /**
     * 解法二： 单调队列 todo
     */
    public int doMaximalRectangle(char[][] matrix) {
        return 0;
    }

    /**
     * 暴力破解法
     */
    public int doMaximalRectangleCommon(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[][] width = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        // 递归思想，数学归纳法
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                  width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                for (int up = row; up >= 0; up--) {
                    int height = row - up + 1;
                    minWidth = Math.min(minWidth, width[up][col]);
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }


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
