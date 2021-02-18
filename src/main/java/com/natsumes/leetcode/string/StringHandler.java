package com.natsumes.leetcode.string;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <h3>字符串处理专题</h3>
 *
 * =====================================================================================================================
 * <h4>栈</h4>
 *
 * TODO: <a href="https://leetcode-cn.com/problems/decode-string/">394.字符串解码</a>
 * {@link StringHandler#decodeString(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/">20.有效的括号</a>
 * {@link StringHandler#isValid(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/">1003.检查替换后的词是否有效</a>
 * {@link StringHandler#isValidString(java.lang.String)}
 *
 * =====================================================================================================================
 * <a href="https://leetcode-cn.com/problems/string-to-integer-atoi/">8.字符串转换整数 (atoi)</a>
 * {@link StringHandler#myAtoi(String)}
 *
 * <a href="https://leetcode-cn.com/problems/zigzag-conversion/">6.Z 字形变换</a>
 * {@link StringHandler#convert(java.lang.String, int)}
 *
 * <a href="https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string/">1758. 生成交替二进制字符串的最少操作数</a>
 * {@link StringHandler#minOperations(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/contest/weekly-contest-228/problems/count-number-of-homogenous-substrings/">1759.统计同构子字符串的数目</a>
 * {@link StringHandler#countHomogenous(java.lang.String)}
 * @author hetengjiao
 */
public class StringHandler {

    /**
     * 6.Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     *
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     * @param s s
     * @param numRows numRows
     * @return s
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int delta = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += delta) {
                sb.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + delta - i < n) {
                    sb.append(s.charAt(j + delta - i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * TODO: 394. 字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * @param s s
     * @return s
     */
    public String decodeString(String s) {
        int n = s.length();
        int ptr = 0;
        LinkedList<String> stack = new LinkedList<>();

        while (ptr < n) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(ptr))) {
                    sb.append(s.charAt(ptr++));
                }
                stack.addLast(sb.toString());
            } else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                stack.removeLast();
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder t = new StringBuilder();
                String o = getString(sub);
                while (repTime-- > 0) {
                    t.append(o);
                }
                stack.addLast(t.toString());
            }
        }

        return getString(stack);
    }

    private String getString(LinkedList<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     *
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例 2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     * 示例 3：
     *
     * 输入：s = "(]"
     * 输出：false
     * 示例 4：
     *
     * 输入：s = "([)]"
     * 输出：false
     * 示例 5：
     *
     * 输入：s = "{[]}"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     * @param s s
     * @return true or false
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && leftOf(c) == stack.peek()) {
                    stack.poll();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char leftOf(char a) {
        if (a == '}') {
            return '{';
        }
        if (a == ']') {
            return '[';
        }
        return '(';
    }

    /**
     * 1003. 检查替换后的词是否有效
     * 给你一个字符串 s ，请你判断它是否 有效 。
     * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
     *
     * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。
     * 注意，tleft 和 tright 可能为 空 。
     * 如果字符串 s 有效，则返回 true；否则，返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "aabcbc"
     * 输出：true
     * 解释：
     * "" -> "abc" -> "aabcbc"
     * 因此，"aabcbc" 有效。
     * 示例 2：
     *
     * 输入：s = "abcabcababcc"
     * 输出：true
     * 解释：
     * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
     * 因此，"abcabcababcc" 有效。
     * 示例 3：
     *
     * 输入：s = "abccba"
     * 输出：false
     * 解释：执行操作无法得到 "abccba" 。
     * 示例 4：
     *
     * 输入：s = "cababc"
     * 输出：false
     * 解释：执行操作无法得到 "cababc" 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 2 * 10^4
     * s 由字母 'a'、'b' 和 'c' 组成
     *
     *
     * @param s s
     * @return true or false
     */
    public boolean isValidString(String s) {
        char[] ss = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char c : ss) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.poll() != 'b') {
                    return false;
                }
                if (stack.isEmpty() || stack.poll() != 'a') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 8.字符串转换整数 (atoi)
     * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * 函数 myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查第一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。
     * 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。
     * 必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。
     * 具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1 。
     * 返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *
     *
     * 示例 1：
     *
     * 输入：s = "42"
     * 输出：42
     * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
     * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："42"（读入 "42"）
     *            ^
     * 解析得到整数 42 。
     * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
     * 示例 2：
     *
     * 输入：s = "   -42"
     * 输出：-42
     * 解释：
     * 第 1 步："   -42"（读入前导空格，但忽视掉）
     *             ^
     * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
     *              ^
     * 第 3 步："   -42"（读入 "42"）
     *                ^
     * 解析得到整数 -42 。
     * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
     * 示例 3：
     *
     * 输入：s = "4193 with words"
     * 输出：4193
     * 解释：
     * 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
     *              ^
     * 解析得到整数 4193 。
     * 由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
     * 示例 4：
     *
     * 输入：s = "words and 987"
     * 输出：0
     * 解释：
     * 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
     *          ^
     * 第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
     *          ^
     * 解析得到整数 0 ，因为没有读入任何数字。
     * 由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
     * 示例 5：
     *
     * 输入：s = "-91283472332"
     * 输出：-2147483648
     * 解释：
     * 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
     *          ^
     * 第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
     *           ^
     * 第 3 步："-91283472332"（读入 "91283472332"）
     *                      ^
     * 解析得到整数 -91283472332 。
     * 由于 -91283472332 小于范围 [-2^31, 2^31 - 1] 的下界，最终结果被截断为 -2^31 = -2147483648 。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 200
     * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
     *
     * @param s s
     * @return code
     */
    public int myAtoi(String s) {
        int ans = 0;
        int sign = 1;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= s.length()) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        if (i >= s.length() || s.charAt(i) < '0' || s.charAt(i) > '9') {
            return 0;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int value = s.charAt(i) - '0';
            if (sign == 1 && ans > (2147483647 - value) / 10) {
                return 2147483647;
            } else if (sign == -1 && ans > (-2147483648 + value) / 10 * (-1)) {
                return -2147483648;
            }
            ans = ans * 10 + (s.charAt(i) - '0');
            i++;
        }

        return ans * sign;
    }

    /**
     * 1758. 生成交替二进制字符串的最少操作数
     * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
     *
     * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。
     * 例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
     *
     * 返回使 s 变成 交替字符串 所需的 最少 操作数。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "0100"
     * 输出：1
     * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
     * 示例 2：
     *
     * 输入：s = "10"
     * 输出：0
     * 解释：s 已经是交替字符串。
     * 示例 3：
     *
     * 输入：s = "1111"
     * 输出：2
     * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s[i] 是 '0' 或 '1'
     *
     * @param s s
     * @return int
     */
    public int minOperations(String s) {
        char[] array = s.toCharArray();
        int count1 = 0;
        int count2 = 0;
        // 第一个字符为 0，第一个字符为1
        char[] ans1 = new char[s.length()];
        char[] ans2 = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                ans1[i] = '0';
                ans2[i] = '1';
            } else {
                ans1[i] = '1';
                ans2[i] = '0';
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != ans1[i]) {
                count1++;
            }
            if (array[i] != ans2[i]) {
                count2++;
            }
        }
        return count1 < count2 ? count1 : count2;
    }



    /**
     * 1759. 统计同构子字符串的数目
     * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
     *
     * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
     *
     * 子字符串 是字符串中的一个连续字符序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "abbcccaa"
     * 输出：13
     * 解释：同构子字符串如下所列：
     * "a"   出现 3 次。
     * "aa"  出现 1 次。
     * "b"   出现 2 次。
     * "bb"  出现 1 次。
     * "c"   出现 3 次。
     * "cc"  出现 2 次。
     * "ccc" 出现 1 次。
     * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
     * 示例 2：
     *
     * 输入：s = "xy"
     * 输出：2
     * 解释：同构子字符串是 "x" 和 "y" 。
     * 示例 3：
     *
     * 输入：s = "zzzzz"
     * 输出：15
     *
     * @param s s
     * @return int
     */
    public int countHomogenous(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            while (right < s.length() && s.charAt(left) == s.charAt(right)) {
                right++;
                count = count % ((int) Math.pow(10, 9) + 7);
                count += right - left;
            }
            left = right;
        }

        return count % ((int) Math.pow(10, 9) + 7);
    }
}
