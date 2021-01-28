package com.natsumes.string;

import java.util.Arrays;

/**
 * @author hetengjiao
 */
public class StrMatchUtils {

    /**
     * BF 算法
     *
     * 暴力匹配算法，也叫朴素匹配算法
     */
    public static int bruteForceMatch(String src, String pattern) {
        int index = -1;
        for (int i = 0; i <= src.length() - pattern.length(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (src.charAt(i + j) != pattern.charAt(j)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                return i;
            }
        }

        return index;
    }

    /**
     * RK 算法
     *
     * 适用于匹配串类型不多的情况，比如：字母、数字或字母加数字的组合 62 (大小写字母+数字)
     *
     * RK 算法的全称叫 Rabin-Karp 算法，是由它的两位发明者 Rabin 和 Karp 的名字来命名的
     * 每次检查主串与子串是否匹配，需要依次比对每个字符，所以 BF 算法的时间复杂度就比较高，是
     * O(n*m)。我们对朴素的字符串匹配算法稍加改造，引入哈希算法，时间复杂度立刻就会降低
     * RK 算法的思路是这样的：我们通过哈希算法对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式
     * 串的哈希值比较大小。如果某个子串的哈希值与模式串相等，那就说明对应的子串和模式串匹配了（这
     * 里先不考虑哈希冲突的问题）。因为哈希值是一个数字，数字之间比较是否相等是非常快速的，所以模
     * 式串和子串比较的效率就提高了
     */
    public static int rabinKarpMatch(String src, String pattern) {
        int index = -1;
        for (int i = 0; i <= src.length() - pattern.length(); i++) {
            String subStr = src.substring(i, i + pattern.length());
            if (strToHash(subStr) == strToHash(pattern)) {
                return i;
            }
        }
        return index;
    }

    /**
     * 支持 a-z 二十六进制
     * 获得字符串的hash值
     * @param src src
     */
    private static int strToHash(String src) {
        int hash = 0;
        for (int i = 0; i < src.length(); i++) {
            hash *= 26;
            hash += src.charAt(i) - 'a';
        }
        return hash;
    }

    /**
     * 全局变量或成员变量
     */
    private static final int SIZE = 256;

    /**
     * BM 算法
     *
     * 应用
     * BM算法比较高效，在实际开发中，特别是一些文本编辑器中，用于实现查找字符串功能。
     *
     * 非常高效的字符串匹配算法，滑动算法
     * BM算法包含两部分，分别是坏字符规则（bad character rule）和好后缀规则（good suffix shift）
     *
     * 如何选择坏字符和好后缀
     * 我们可以分别计算好后缀和坏字符往后滑动的位数，然后取两个数中最大的，作为模式串往后滑动的位数。
     *
     * 坏字符规则
     *
     * BM算法的时间复杂度是O(N/M)
     * n:主串长度
     * m:模式串长度
     *
     */
    public static int badBoyerMooreMatch(String src, String pattern) {
        char[] a = src.toCharArray();
        char[] b = pattern.toCharArray();
        // 主串长度
        int n = a.length;
        // 模式串长度
        int m = b.length;

        // 创建字典
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表，记录模式串中每个字符最后出现的位置
        badCharRule(b, m, bc);

        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        goodSuffixRule(b, m, suffix, prefix);

        // i表示主串与模式串对齐的第一个字符
        int i = 0;

        while (i <= n - m) {
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; j--) {
                // i+j ： 不匹配的位置
                // 坏字符对应模式串中的下标是j
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }

            // 这里等同于将模式串往后滑动j-bc[a[i+j]]位
            // si - xi
            // j：si bc[a[i+j]]:xi
            int moveWithBc = j - bc[a[i + j]];

            int moveWithGs = moveWithGs(m, j, suffix, prefix);

            i += Math.max(moveWithBc, moveWithGs);

        }
        return -1;
    }

    // hello
    // el

    /**
     * 处理好后缀
     * @param b     模式串
     * @param m     模式串长度
     * @param suffix    用子串长度为 k 存储主串的好后缀{u} 对应的子串中 {u*} 对应的起始位置
     * @param prefix    用子串长度为 k 存储 模式串中是否存在和好后缀相同的字符串
     */
    private static void goodSuffixRule(char[] b, int m, int[] suffix, boolean[] prefix) {
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);
        for (int i = 0; i < m - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && b[j] == b[m - k - 1]) {
                j--;
                k++;
                suffix[k] = j + 1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    /**
     * 滑动
     * @param n 模式串长度
     * @param j 坏字符的对应的模式串的下标
     * @param suffix    suffix
     * @param prefix    prefix
     * @return  int
     */
    private static int moveWithGs(int n, int j, int[] suffix, boolean[] prefix) {
        int k = n - j - 1;
        if (k <= 0) {
            return 0;
        }
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int i = k - 1; i >= 0; i--) {
            if (prefix[i]) {
                return n - i;
            }
        }
        return n;
    }

    private static void badCharRule(char[] b, int m, int[] dc) {
        // 初始化 bc 模式串中没有的字符值都是-1
        Arrays.fill(dc, -1);
        //将模式串中的字符希写入到字典中
        for (int i = 0; i < m; ++i) {
            // 计算 b[i] 的 ASCII 值
            dc[b[i]] = i;
        }
    }

    /**
     * Trie树
     */
    public static Trie buildTrie() {
        return new Trie();
    }

}
