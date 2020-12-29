package com.natsumes.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hetengjiao
 */
public class DailyPractice {
    /*=========================================2020-12-29======================================================*/
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

    /*=========================================2020-12-28======================================================*/
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

    /*=========================================2020-12-27======================================================*/

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


    /*=========================================2020-12-26======================================================*/
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


    /*=========================================2020-12-25======================================================*/

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
