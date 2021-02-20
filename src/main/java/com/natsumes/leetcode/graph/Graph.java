package com.natsumes.leetcode.graph;

/**
 * <h3>图<h3/>
 *
 * <a href="https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/">440.字典序的第K小数字</a>
 * {@link Graph#findKthNumber(int, int)}
 *
 * @author hetengjiao
 */
public class Graph {

    /**
     * 440. 字典序的第K小数字
     * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
     *
     * 注意：1 ≤ k ≤ n ≤ 109。
     *
     * 示例 :
     *
     * 输入:
     * n: 13   k: 2
     *
     * 输出:
     * 10
     *
     * 解释:
     * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
     *
     * @param n n
     * @param k k
     * @return num
     */
    public int findKthNumber(int n, int k) {
        /*
         *                           1
         *                     /   /   \  \
         *                    0   1     8   9
         *                 //  \\
         *                0 1  8 9 ...
         * 层序遍历, 二分查找
         */
        int cur = 1;
        // 扣除掉第一个0节点
        k = k - 1;
        while (k > 0) {
            int num = getNode(n, cur, cur + 1);
            if (num <= k) {
                // 第k个数不在以cur为根节点的树上
                cur++;
                k -= num;
            } else {
                // 在子树中
                // cur在字典序数组中从上往下移动
                cur *= 10;
                //去掉根节点
                k -= 1;
            }
        }
        return cur;
    }

    private int getNode(int n, long first, long last) {
        int num = 0;
        while (first <= n) {
            num += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return num;
    }

}
