package com.natsumes.coder;

/**
 * @author hetengjiao
 */
public class CoderExam {

    /**
     * 面试题 01.01. 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     * 限制：
     *
     * 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。
     *
     * https://leetcode-cn.com/problems/is-unique-lcci/
     */
    public boolean isUnique(String astr) {
        if (astr == null || astr.isEmpty()) {
            return true;
        }
        char l = astr.charAt(0);
        char r = astr.charAt(astr.length() - 1);

        if (astr.length() > 1 && l == r) {
            return false;
        }

        int index = 1;
        while (index < astr.length() - 1) {
            if (l == astr.charAt(index) || r == astr.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    public boolean isUniqueBit(String astr) {
        if (astr == null || astr.isEmpty()) {
            return true;
        }
        int aa = 0;
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            int offset = c - 'a';

            int bb = 1 << offset;
            if ((aa & bb) != 0) {
                return false;
            }
            aa |= bb;
        }
        return true;
    }

    /**
     * 面试题 01.02. 判定是否互为字符重排
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     *
     * 示例 1：
     *
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * 示例 2：
     *
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     * 说明：
     *
     * 0 <= len(s1) <= 100
     * 0 <= len(s2) <= 100
     *
     * https://leetcode-cn.com/problems/check-permutation-lcci/
     */
    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 面试题 01.03. URL化
     *
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     * 示例 1：
     *
     * 输入："Mr John Smith    ", 13
     * 输出："Mr%20John%20Smith"
     * 示例 2：
     *
     * 输入："               ", 5
     * 输出："%20%20%20%20%20"
     *
     *
     * 提示：
     *
     * 字符串长度在 [0, 500000] 范围内。
     *
     * https://leetcode-cn.com/problems/string-to-url-lcci/
     */
    public String replaceSpaces(String S, int length) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                str.append("%20");
            } else {
                str.append(S.charAt(i));
            }
        }
        return str.toString();
    }

    public String replaceSpaces01(String S, int length) {
        return S.substring(0, length).replace(" ", "%20");
    }

    public String replaceSpaces02(String S, int length) {
        char[] res = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            } else {
                res[index++] = S.charAt(i);
            }
        }
        return new String(res, 0, index);
    }

    /**
     * 面试题 01.04. 回文排列
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     *
     * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
     *
     * 回文串不一定是字典当中的单词。
     *
     *
     *
     * 示例1：
     *
     * 输入："tactcoa"
     * 输出：true（排列有"tacocat"、"atcocta"，等等）
     *
     * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
     *
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        int[] count = new int[128];
        while (left < right) {
            count[s.charAt(left)]++;
            count[s.charAt(right)]++;
            left++;
            right--;
        }
        if (right == left) {
            count[s.charAt(left)]++;
        }
        int res = 0;
        for (int value : count) {
            if(value % 2 != 0) {
                res++;
            }

            if (res > 1 && left != right) {
                return false;
            }
        }

        return (res == 0 && left != right) || (res == 1 && left == right);
    }

    /**
     * 面试题 01.05. 一次编辑
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *
     *
     * 示例 2:
     *
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * https://leetcode-cn.com/problems/one-away-lcci/
     */
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            int len1 = first == null ? 0 : first.length();
            int len2 = second == null ? 0 : second.length();
            return len1 - len2 > 1 || len1 - len2 < -1;
        }

        int len1 = first.length();
        int len2 = second.length();

        if (len1 - len2 > 1 || len1 - len2 < -1) {
            return false;
        }

        int count = 0;
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) != second.charAt(j)) {
                if (first.length() > second.length()) {
                    i++;
                } else if (first.length() < second.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                count++;
            } else {
                i++;
                j++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * 面试题 01.06. 字符串压缩
     * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
     * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     *
     * 示例1:
     *
     *  输入："aabcccccaaa"
     *  输出："a2b1c5a3"
     * 示例2:
     *
     *  输入："abbccd"
     *  输出："abbccd"
     *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
     * 提示：
     *
     * 字符串长度在[0, 50000]范围内。
     *
     * https://leetcode-cn.com/problems/compress-string-lcci/
     */
    public String compressString(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        int i = 0, j = 1;
        res.append(S.charAt(0));
        int count = 1;
        while (i + j < S.length()) {
            if (S.charAt(i) == S.charAt(i + j)) {
                j++;
            } else {
                res.append(j);
                i = i + j;
                j = 1;
                res.append(S.charAt(i));
                count = count + 2;
            }
            if (count >= S.length() - 1) {
                return S;
            }
        }
        res.append(j);
        return res.toString();
    }

}
