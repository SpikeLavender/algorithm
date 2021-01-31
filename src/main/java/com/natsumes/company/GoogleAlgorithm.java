package com.natsumes.company;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class GoogleAlgorithm {
    /**
     * 重复叠加字符串匹配
     * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
     *
     * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：a = "abcd", b = "cdabcdab"
     * 输出：3
     * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
     * 示例 2：
     *
     * 输入：a = "a", b = "aa"
     * 输出：2
     * 示例 3：
     *
     * 输入：a = "a", b = "a"
     * 输出：1
     * 示例 4：
     *
     * 输入：a = "abc", b = "wxyz"
     * 输出：-1
     *  
     *
     * 提示：
     *
     * 1 <= a.length <= 104
     * 1 <= b.length <= 104
     * a 和 b 由小写英文字母组成
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/google-interview/1hdle/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        int k = lenB / lenA;
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();
        int max = k + 2;
        char[] cc = new char[lenA * max];
        for (int i = 0; i < max; i++) {
            System.arraycopy(aa, 0, cc, i * lenA, lenA);
        }

        while (k <= max) {
            int i = badBoyerMooreMatch(cc, bb, k * lenA);
            if (i < 0) {
                k++;
            } else {
                return k;
            }
        }
        return -1;
    }

    private static void goodSuffixRule(char[] b, int m, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);
        for (int i = 0; i < m; i++) {
            int j;
            int k = 0;
            for (j = m - 1; j >= 0; j--) {
                if (b[j] != b[m - k - 1]) {
                    break;
                }
                k++;
                suffix[k - 1] = j;
            }
            if (j == -1) {
                prefix[k - 1] = true;
            }
        }
    }

    private static int moveWithGs(int n, int j, int[] suffix, boolean[] prefix) {
        int k = n - j - 1;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int i = k - 1; i >=0; i--) {
            if (prefix[i]) {
                return n - i;
            }
        }
        return n;
    }

    private static int badBoyerMooreMatch(char[] src, char[] pattern, int n) {
        //int n = src.length;
        int m = pattern.length;
        int[] ac = new int[26];
        ascii(pattern, m, ac);

        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        goodSuffixRule(pattern, m, suffix, prefix);

        int i = 0;
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (src[i + j] != pattern[j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }

            int moveWithBc = j - ac[src[i + j] - 'a'];
            int moveWithGs = Integer.MIN_VALUE;
            if (j < m - 1) {
                moveWithGs = moveWithGs(m, j, suffix, prefix);
            }

            i += Math.max(moveWithBc, moveWithGs);
        }
        return -1;
    }

    private static void ascii(char[] b, int m, int[] ac) {
        for (int i = 0; i < ac.length; i++) {
            ac[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            ac[b[i] - 'a'] = i;
        }
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aa", "a"));
        System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ba"));
        System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab", "ab"));
        System.out.println(repeatedStringMatch("abc", "cabcabca"));
        System.out.println(repeatedStringMatch("abab", "aba"));
        System.out.println(repeatedStringMatch("abcd", "cda"));
        System.out.println(repeatedStringMatch("abcd", "cdabcdabc"));
        System.out.println(repeatedStringMatch("abcd", "cdabc"));
        System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch("a", "a"));
        System.out.println(repeatedStringMatch("abc", "wxyz"));
        System.out.println(repeatedStringMatch("abc", ""));
    }


}
