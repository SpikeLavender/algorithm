package com.natsumes.leetcode;

import java.util.*;

/**
 * DFS + 二分查找问题
 *
 * ===========================================================================================
 * <h4>DFS + 子集</h4>
 *
 * <a href="https://leetcode-cn.com/problems/restore-ip-addresses/">93.复原IP地址</a>
 * {@link DfsAndBinarySearch#restoreIpAddresses(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/subsets/">78.子集</a>
 * {@link DfsAndBinarySearch#subsets(int[])}
 *
 * ===========================================================================================
 * <h4>DFS + 二分查找问题</h4>
 *
 * <a href="https://leetcode-cn.com/problems/longest-repeating-substring/">1062.最长重复子串</a>
 * {@link DfsAndBinarySearch#longestRepeatingSubstring(java.lang.String)}
 *
 * @author hetengjiao
 */
public class DfsAndBinarySearch {

    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     *
     * @param nums nums
     * @return {@link List<List<Integer>>}
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track, res);
        return res;
    }

    private void backtrack(int[] nums, int start, Deque<Integer> track, List<List<Integer>> res) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1, track, res);
            track.pollLast();
        }
    }

    /**
     * 93. 复原IP地址
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
     * 和 "192.168@1.1" 是 无效的 IP 地址。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     * 示例 2：
     *
     * 输入：s = "0000"
     * 输出：["0.0.0.0"]
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：["1.1.1.1"]
     * 示例 4：
     *
     * 输入：s = "010010"
     * 输出：["0.10.0.10","0.100.1.0"]
     * 示例 5：
     *
     * 输入：s = "101023"
     * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 3000
     * s 仅由数字组成
     * @param s s
     * @return List<String>
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int[] segments = new int[4];
        doRestore(s, 0, 0, segments, res);
        return res;
    }

    /**
     * 回溯函数
     * @param s 字符串
     * @param segId ip段
     * @param segStart 需要处理的字符位置
     * @param segments ip分段信息
     * @param res 结果集
     */
    private void doRestore(String s, int segId, int segStart, int[] segments, List<String> res) {
        // 回溯结束条件: segId = 4
        // ip 合理的条件 segStart 到了字符末尾
        if (segId == 4) {
            if (segStart == s.length()) {
                StringBuilder addrStr = new StringBuilder();
                for (int i = 0; i < segments.length; i++) {
                    addrStr.append(segments[i]);
                    if (i < segments.length - 1) {
                        addrStr.append(".");
                    }
                }
                res.add(addrStr.toString());
            }
            return;
        }
        // 如果已经到字符末尾，提前结束
        if (segStart == s.length()) {
            return;
        }
        // 如果为0，做判断, 提前回溯
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            doRestore(s, segId + 1, segStart + 1, segments, res);
        }

        int addr = 0;
        for (int i = segStart; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                doRestore(s, segId + 1, i + 1, segments, res);
            } else {
                return;
            }
        }
    }

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
