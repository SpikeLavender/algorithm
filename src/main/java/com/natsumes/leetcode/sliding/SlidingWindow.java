package com.natsumes.leetcode.sliding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 滑动窗口
 *
 * <a href="https://leetcode-cn.com/problems/permutation-in-string/">567.字符串的排列</a>
 * {@link SlidingWindow#checkInclusion(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum/">795.区间子数组个数</a>
 * {@link SlidingWindow#numSubarrayBoundedMax(int[], int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/fruit-into-baskets/">904.水果成篮</a>
 * {@link SlidingWindow#totalFruit(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/subarray-product-less-than-k/">713.乘积小于K的子数组</a>
 * {@link SlidingWindow#numSubarrayProductLessThanK(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/">3.无重复字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstring(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-repeating-character-replacement/">424.替换后的最长重复字符</a>
 * {@link SlidingWindow#characterReplacement(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/">159.至多包含两个不同字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstringTwoDistinct(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters/">340.至多包含 K 个不同字符的最长子串</a>
 * {@link SlidingWindow#lengthOfLongestSubstringKDistinct(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">209.长度最小的子数组</a>
 * {@link SlidingWindow#minSubArrayLen(int, int[])}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-window-substring/">76.最小覆盖子串</a>
 * {@link SlidingWindow#minWindow(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/subarrays-with-k-different-integers/">992.K个不同整数的子数组</a>
 * {@link SlidingWindow#subarraysWithKDistinct(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/longest-turbulent-subarray/">978.最长湍流子数组</a>
 * {@link SlidingWindow#maxTurbulenceSize(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/sliding-window-median/">480.滑动窗口中位数</a>
 * {@link SlidingWindow#medianSlidingWindow(int[], int)}
 *
 * @author hetengjiao
 */
public class SlidingWindow {

    /**
     * 567. 字符串的排列
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     *
     * 注意：
     *
     * 输入的字符串只包含小写字母
     * 两个字符串的长度都在 [1, 10,000] 之间
     *
     * @param s1 s1
     * @param s2 s2
     * @return true or false
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] nums = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i) - 'a']--;
        }

        int left = 0;
        int window = s1.length();
        int right = 0;

        while (right < s2.length()) {
            int index = s2.charAt(right) - 'a';
            nums[index]++;
            // eidboaoo
            while (nums[index] > 0) {
                nums[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == window){
                return true;
            }
            right++;
        }
        return false;
    }

    /**
     * 795. 区间子数组个数
     * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
     *
     * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
     *
     * 例如 :
     * 输入:
     * A = [2, 1, 4, 3]
     * L = 2
     * R = 3
     * 输出: 3
     * 解释: 满足条件的子数组: [2], [2, 1], [3].
     * 注意:
     *
     * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
     * 数组 A 的长度范围在[1, 50000]。
     *
     * @param A A
     * @param L L
     * @param R R
     * @return int
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return doMumSubarrayBoundedMax(A, R) - doMumSubarrayBoundedMax(A, L - 1);
    }

    private int doMumSubarrayBoundedMax(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > k) {
                left = i + 1;
            }
            ans += i - left + 1;
        }
        return ans;
    }

    /**
     * 904. 水果成篮
     * 在一排树中，第 i 棵树产生 tree[i] 型的水果。
     * 你可以从你选择的任何树开始，然后重复执行以下步骤：
     *
     *   1. 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
     *   2. 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
     *
     * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
     *
     * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
     *
     * 用这个程序你能收集的水果树的最大总量是多少？
     *
     * 示例 1：
     *
     * 输入：[1,2,1]
     * 输出：3
     * 解释：我们可以收集 [1,2,1]。
     * 示例 2：
     *
     * 输入：[0,1,2,2]
     * 输出：3
     * 解释：我们可以收集 [1,2,2]
     * 如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
     * 示例 3：
     *
     * 输入：[1,2,3,2,2]
     * 输出：4
     * 解释：我们可以收集 [2,3,2,2]
     * 如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
     * 示例 4：
     *
     * 输入：[3,3,3,1,2,1,1,2,3,3,4]
     * 输出：5
     * 解释：我们可以收集 [1,2,1,1,2]
     * 如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
     *
     *
     * 提示：
     *
     * 1 <= tree.length <= 40000
     * 0 <= tree[i] < tree.length
     *
     * @param tree tree
     * @return int
     */
    public int totalFruit(int[] tree) {
        int n = tree.length;
        int left = 0;
        int right = 0;
        int max = 0;
        int k = 0;
        int[] nums = new int[n];

        while (right < n) {
            if (nums[tree[right]] == 0) {
                k++;
            }
            nums[tree[right]]++;
            while (k > 2) {
                nums[tree[left]]--;
                if (nums[tree[left]] == 0) {
                    k--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * 713. 乘积小于K的子数组
     * 给定一个正整数数组 nums。
     *
     * 找出该数组内乘积小于 k 的连续的子数组的个数。
     *
     * 示例 1:
     *
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     * 说明:
     *
     * 0 < nums.length <= 50000
     * 0 < nums[i] < 1000
     * 0 <= k < 10^6
     *
     * @param nums nums
     * @param k k
     * @return int
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        int prod = 1;

        while (right < n) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     *
     *
     * @param s s
     * @return int
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] arr = new int[128];

        int max = 0;
        int left = 0;
        int right = 0;
        // acbcabcbb
        while (right < n) {
            if (arr[s.charAt(right)] == 0) {
                arr[s.charAt(right)] = 1;
                right++;
                max = Math.max(max, right - left);
            } else {
                arr[s.charAt(left)] = 0;
                left++;
            }
        }
        return max;
    }

    /**
     * 424. 替换后的最长重复字符
     * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
     * 在执行上述操作后，找到包含重复字母的最长子串的长度。
     *
     * 注意：字符串长度 和 k 不会超过 104。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     *
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *
     * @param s s
     * @param k k
     * @return int
     */
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] nums = new int[26];
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            nums[index]++;
            max = Math.max(max, nums[index]);
            if (right - left + 1 - max > k) {
                nums[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    /**
     * 159. 至多包含两个不同字符的最长子串
     * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
     *
     * 示例 1:
     *
     * 输入: "eceba"
     * 输出: 3
     * 解释: t 是 "ece"，长度为3。
     * 示例 2:
     *
     * 输入: "ccaabbb"
     * 输出: 5
     * 解释: t 是 "aabbb"，长度为5。
     *
     * @param s s
     * @return int
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        if (n < 3) {
            return n;
        }
        int left = 0;
        int right = 0;
        int k = 0;
        int max = 0;
        int[] nums = new int[128];

        while (right < n) {
            if (nums[s.charAt(right)] == 0) {
                k++;
            }
            nums[s.charAt(right)]++;

            while (k > 2) {
                nums[s.charAt(left)]--;
                if (nums[s.charAt(left)] == 0) {
                    k--;
                }
                left++;
                //right++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * 340. 至多包含 K 个不同字符的最长子串
     * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
     *
     * 示例 1:
     *
     * 输入: s = "eceba", k = 2
     * 输出: 3
     * 解释: 则 T 为 "ece"，所以长度为 3。
     * 示例 2:
     *
     * 输入: s = "aa", k = 1
     * 输出: 2
     * 解释: 则 T 为 "aa"，所以长度为 2。
     *
     * @param s s
     * @param k k
     * @return int
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n <= k) {
            return n;
        }

        int[] nums = new int[128];
        int count = 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            if (nums[s.charAt(right)] == 0) {
                count++;
            }
            nums[s.charAt(right)]++;
            while (count > k) {
                nums[s.charAt(left)]--;
                if (nums[s.charAt(left)] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。
     * 如果不存在符合条件的子数组，返回 0 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     *
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     *
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     *
     * @param target target
     * @param nums nums
     * @return int
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int min = n + 1;
        int sum = 0;

        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                min = Math.min(min, right - left + 1);
                left++;
            }
            right++;
        }

        return min == n + 1 ? 0 : min;
    }

    /**
     * 76. 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * 示例 1：
     *
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     *
     * 输入：s = "a", t = "a"
     * 输出："a"
     *
     *
     * 提示：
     *
     * 1 <= s.length, t.length <= 10^5
     * s 和 t 由英文字母组成
     *
     * @param s s
     * @param t t
     * @return string
     */
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int[] trr = new int[128];
        for (int i = 0; i < t.length(); i++) {
            trr[t.charAt(i)]++;
        }
        int m = t.length();

        int min = 0;
        int max = s.length();
        int window = 0;
        int left = 0;
        int right = 0;

        // ADOBECODEBANC
        // TODO: try use array
        while (right < s.length()) {

            if (trr[s.charAt(right)] > 0) {
                Integer value = map.getOrDefault(s.charAt(right), 0);
                if (value < trr[s.charAt(right)]) {
                    window++;
                }
                map.put(s.charAt(right), value + 1);
            }

            while (window == m && left <= right) {
                // 搜索，缩小左边
                if (right - left < max - min) {
                    min = left;
                    max = right;
                }
                if (map.containsKey(s.charAt(left))) {
                    if (map.get(s.charAt(left)) == trr[s.charAt(left)]) {
                        window--;
                    }
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }

        return max == s.length() ? "" : s.substring(min, max + 1);
    }

    /*
    Map<Character, Integer> map = new HashMap<>();

        int[] trr = new int[128];
        boolean[] arr = new boolean[];
        for (int i = 0; i < t.length(); i++) {
            trr[t.charAt(i)]--;
            arr[t.charAt(i)] = true;
        }
        int m = t.length();

        int min = 0;
        int max = s.length();
        int window = 0;
        int left = 0;
        int right = 0;

        // ADOBECODEBANC
        while (right < s.length()) {
            int index = s.charAt(right);
            if (arr[index]) {
                trr[index]++;
                  Integer value = map.getOrDefault(s.charAt(right), 0);
                  if (value < trr[s.charAt(right)]) {
                      window++;
                  }
                  map.put(s.charAt(right), value + 1);
            }

            while (trr[index] > 0) {
                if (arr[s.charAt(left)]) {
                    trr[s.charAt(left)]--;
                }
                left++;
            }
            right++;

              while (window == m && left <= right) {
                  // 搜索，缩小左边
                  if (right - left < max - min) {
                      min = left;
                      max = right;
                  }
                  if (map.containsKey(s.charAt(left))) {
                      if (map.get(s.charAt(left)) == trr[s.charAt(left)]) {
                          window--;
                      }
                      map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                  }
                  left++;
              }
              right++;
        }
     */

    /**
     * 992. K 个不同整数的子数组
     * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
     *
     * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
     *
     * 返回 A 中好子数组的数目。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = [1,2,1,2,3], K = 2
     * 输出：7
     * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
     * 示例 2：
     *
     * 输入：A = [1,2,1,3,4], K = 3
     * 输出：3
     * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 20000
     * 1 <= A[i] <= A.length
     * 1 <= K <= A.length
     * @param A A
     * @param K K
     * @return A 中好子数组的数目
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        return kMostDistinct(A, K) - kMostDistinct(A, K - 1);
    }

    /**
     * 最多有K个不同整数的子串数目
     * 1 <= A.length <= 20000
     * 1 <= A[i] <= A.length
     * 1 <= K <= A.length
     *
     * @param arr A
     * @param k K
     * @return 恰好有K个不同整数的子串数目
     */
    private int kMostDistinct(int[] arr, int k) {
        int n = arr.length;

        // 1 <= A[i] <= A.length
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int window = 0;
        int res = 0;
        while (right < n) {
            if (freq[arr[right]] == 0) {
                window++;
            }
            freq[arr[right]]++;
            right++;
            // [left, right)
            while (window > k) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    window--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

    /**
     * 978. 最长湍流子数组
     * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
     *
     * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
     * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
     * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
     *
     * 返回 A 的最大湍流子数组的长度。
     *
     * 示例 1：
     *
     * 输入：[9,4,2,10,7,8,8,1,9]
     * 输出：5
     * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
     * 示例 2：
     *
     * 输入：[4,8,12,16]
     * 输出：2
     * 示例 3：
     *
     * 输入：[100]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 40000
     * 0 <= A[i] <= 10^9
     *
     * @param arr arr
     * @return int
     */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 1;

        int left = 0;
        int right = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[right + 1]) {
                    left++;
                }
                right++;
            } else {
                if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    /**
     * 480. 滑动窗口中位数
     * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
     *
     * 例如：
     *
     * [2,3,4]，中位数是 3
     * [2,3]，中位数是 (2 + 3) / 2 = 2.5
     * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
     * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     *
     * 示例：
     *
     * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
     *
     * 窗口位置                      中位数
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     *  1 [3  -1  -3] 5  3  6  7      -1
     *  1  3 [-1  -3  5] 3  6  7      -1
     *  1  3  -1 [-3  5  3] 6  7       3
     *  1  3  -1  -3 [5  3  6] 7       5
     *  1  3  -1  -3  5 [3  6  7]      6
     *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
     *
     * 提示：
     *
     * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
     * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
     *
     * @param nums nums
     * @param k sliding size
     * @return double[]
     * @see DualHeap
     * @see SlidingWindow
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }
        double[] res = new double[nums.length - k + 1];
        res[0] = dh.getMedian();
        for (int i = k; i < nums.length; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i - k]);
            res[i - k + 1] = dh.getMedian();
        }
        return res;
    }

    static class DualHeap {
        // 大根堆
        private PriorityQueue<Integer> small;
        // 小根堆
        private PriorityQueue<Integer> large;

        private Map<Integer, Integer> delayed;

        private int k;

        private int smallSize, largeSize;

        public DualHeap(int k) {
            this.small = new PriorityQueue<>(((o1, o2) -> o2 - o1));
            this.large = new PriorityQueue<>();
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }

        public double getMedian() {
            return (k & 1) == 1 ? small.peek() : ((double)small.peek() + large.peek())/ 2.0;
        }

        public void insert(int num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                ++smallSize;
            } else {
                large.offer(num);
                ++largeSize;
            }
            makeBalance();
        }

        public void erase(int num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);
            if (num <= small.peek()) {
                --smallSize;
                if (num == small.peek()) {
                    prune(small);
                }
            } else {
                --largeSize;
                if (num == large.peek()) {
                    prune(large);
                }
            }
            makeBalance();
        }

        private void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int num = heap.peek();
                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);
                    if (delayed.get(num) == 0) {
                        delayed.remove(num);
                    }
                    heap.poll();
                } else {
                   break;
                }
            }
        }

        private void makeBalance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                prune(large);
            }
        }
    }
}
