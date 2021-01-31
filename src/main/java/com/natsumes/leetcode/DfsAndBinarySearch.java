package com.natsumes.leetcode;

import java.util.HashSet;

/**
 * DFS + 二分查找问题
 *
 * 1062. 最长重复子串 https://leetcode-cn.com/problems/longest-repeating-substring/
 * @author hetengjiao
 */
public class DfsAndBinarySearch {

    /**
     * 1062. 最长重复子串
     * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
     *
     * 示例 1：
     *
     * 输入："abcd"
     * 输出：0
     * 解释：没有重复子串。
     * 示例 2：
     *
     * 输入："abbaba"
     * 输出：2
     * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
     * 示例 3：
     *
     * 输入："aabcaabdaab"
     * 输出：3
     * 解释：最长的重复子串为 "aab"，出现 3 次。
     * 示例 4：
     *
     * 输入："aaaaa"
     * 输出：4
     * 解释：最长的重复子串为 "aaaa"，出现 2 次。
     *
     *
     * 提示：
     *
     * 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
     * 1 <= S.length <= 1500
     */
    public int longestRepeatingSubstring(String S) {
        int n = S.length();

        // 将S转换成code
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = S.charAt(i) - 'a';
        }

        // 定义模数
        long modulus = (long) Math.pow(2, 24);
        // 二分处理子串
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, n, nums, modulus) != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private int search(int mid, int n, int[] nums, long modulus) {
        int a = 26;
        long al = 1;
        for (int i = 1; i <= mid; i++) {
            al = (al * a) % modulus;
        }

        // 计算mid个字符的hash值
        long h = 0;
        for (int i = 0; i < mid; i++) {
            h = (h * a + nums[i]) % modulus;
        }
        // 定义set存储hash值 [1, 2, 3, 4] => [1, 2, 3]
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        for (int start = 1; start < n - mid + 1; start++) {
            // 滑动窗口计算hash值 [1, 2, 3, 4] => [2, 3, 4] start = 1, mid = 3
            h = (h * a - nums[start - 1] * al % modulus + modulus) % modulus;
            h = (h + nums[start + mid - 1]) % modulus;
            if (seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }

}
