package com.natsumes.leetcode.string;

import java.util.*;

/**
 * <h3>字符串处理专题</h3>
 *
 * =====================================================================================================================
 * <h4>栈</h4>
 *
 * <a href="https://leetcode-cn.com/problems/decode-string/">394.字符串解码</a>
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
 *
 * <a href="https://leetcode-cn.com/problems/integer-to-roman/">12.整数转罗马数字</a>
 * {@link StringHandler#intToRoman(int)}
 *
 * <a href="https://leetcode-cn.com/problems/roman-to-integer/">13.罗马数字转整数</a>
 * {@link StringHandler#romanToInt(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/">1178.猜字谜</a>
 * {@link StringHandler#findNumOfValidWords(String[], String[])}
 *
 * <a href="https://leetcode-cn.com/problems/longest-common-prefix/">14.最长公共前缀</a>
 * {@link StringHandler#longestCommonPrefix(String[])}
 *
 * <a href="https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/">1047.删除字符串中的所有相邻重复项</a>
 * {@link StringHandler#removeDuplicates(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/implement-strstr/">28.实现 strStr()</a>
 * {@link StringHandler#strStr(java.lang.String, java.lang.String)}
 * {@link StringHandler#bruteForceMatch(java.lang.String, java.lang.String)}
 * {@link StringHandler#rabinKarpMatch(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/repeated-string-match/">686.重复叠加字符串匹配</a>
 * {@link StringHandler#repeatedStringMatch(java.lang.String, java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/count-and-say/">38.外观数列</a>
 * {@link StringHandler#countAndSay(int)}
 *
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
     * 394. 字符串解码
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

    /**
     * 12. 整数转罗马数字
     * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     *
     * 示例 1:
     *
     * 输入: 3
     * 输出: "III"
     * 示例 2:
     *
     * 输入: 4
     * 输出: "IV"
     * 示例 3:
     *
     * 输入: 9
     * 输出: "IX"
     * 示例 4:
     *
     * 输入: 58
     * 输出: "LVIII"
     * 解释: L = 50, V = 5, III = 3.
     * 示例 5:
     *
     * 输入: 1994
     * 输出: "MCMXCIV"
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     * 提示：
     * 1 <= num <= 3999
     *
     * @param num num
     * @return String
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
     * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     *
     *
     *
     * 示例 1:
     *
     * 输入: "III"
     * 输出: 3
     * 示例 2:
     *
     * 输入: "IV"
     * 输出: 4
     * 示例 3:
     *
     * 输入: "IX"
     * 输出: 9
     * 示例 4:
     *
     * 输入: "LVIII"
     * 输出: 58
     * 解释: L = 50, V= 5, III = 3.
     * 示例 5:
     *
     * 输入: "MCMXCIV"
     * 输出: 1994
     * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 15
     * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
     * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
     * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
     * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
     *
     * @param s s
     * @return int
     */
    public int romanToInt(String s) {
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum  = sum + char2Int(s.charAt(i));
        }
        return sum;
    }

    private int char2Int(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }


    /**
     * 1178. 猜字谜
     * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
     *
     * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
     *
     * 单词 word 中包含谜面 puzzle 的第一个字母。
     * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
     * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；
     * 而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
     * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i]
     * 所对应的谜底的单词数目。
     *
     *
     *
     * 示例：
     *
     * 输入：
     * words = ["aaaa","asas","able","ability","actt","actor","access"],
     * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
     * 输出：[1,1,3,2,4,0]
     * 解释：
     * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
     * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
     * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
     * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
     * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
     * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
     *
     *
     * 提示：
     *
     * 1 <= words.length <= 10^5
     * 4 <= words[i].length <= 50
     * 1 <= puzzles.length <= 10^4
     * puzzles[i].length == 7
     * words[i][j], puzzles[i][j] 都是小写英文字母。
     * 每个 puzzles[i] 所包含的字符都不重复。
     *
     * @param words words
     * @param puzzles puzzles
     * @return ans
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>(puzzles.length);
        for (String puzzle : puzzles) {
            int total = 0;
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subnet = mask;
            do {
                int s= subnet | (1 << (puzzle.charAt(0) - 'a'));
                if (map.containsKey(s)) {
                    total += map.get(s);
                }
                subnet = (subnet - 1) & mask;
            } while (subnet != mask);
            ans.add(total);
        }
        return ans;
    }

    /**
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     *
     * 提示：
     *
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     *
     * @param strs strs
     * @return ans
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int n = strs[0].length();
        int m = strs.length;
        for (int i = 0; i < n; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < m; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     *
     * 1047. 删除字符串中的所有相邻重复项
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     *
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     *
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     *
     *
     * 示例：
     *
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
     * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *
     *
     * 提示：
     *
     * 1 <= S.length <= 20000
     * S 仅由小写英文字母组成。
     * @param s s
     * @return ans
     */
    public String removeDuplicates(String s) {
        int n = s.length();
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!stack.isEmpty() && stack.peekFirst() == s.charAt(i)) {
                stack.pollFirst();
            } else {
                stack.addFirst(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    /**
     * 28. 实现 strStr()
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     * @param haystack haystack
     * @param needle needle
     * @return index
     */
    public int strStr(String haystack, String needle) {
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        // 主串长度
        int n = a.length;
        // 模式串长度
        int m = b.length;

        // 创建字典
        int[] bc = new int[256];
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

    /**
     * 处理好后缀
     * @param b     模式串
     * @param m     模式串长度
     * @param suffix    用子串长度为 k 存储主串的好后缀{u} 对应的子串中 {u*} 对应的起始位置
     * @param prefix    用子串长度为 k 存储 模式串中是否存在和好后缀相同的字符串
     */
    private void goodSuffixRule(char[] b, int m, int[] suffix, boolean[] prefix) {
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
    private int moveWithGs(int n, int j, int[] suffix, boolean[] prefix) {
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

    private void badCharRule(char[] b, int m, int[] dc) {
        // 初始化 bc 模式串中没有的字符值都是-1
        Arrays.fill(dc, -1);
        //将模式串中的字符希写入到字典中
        for (int i = 0; i < m; ++i) {
            // 计算 b[i] 的 ASCII 值
            dc[b[i]] = i;
        }
    }

    /**
     * BF 算法
     *
     * 暴力匹配算法，也叫朴素匹配算法
     */
    public int bruteForceMatch(String src, String pattern) {
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
    public int rabinKarpMatch(String src, String pattern) {
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
    private int strToHash(String src) {
        int hash = 0;
        for (int i = 0; i < src.length(); i++) {
            hash *= 26;
            hash += src.charAt(i) - 'a';
        }
        return hash;
    }

    /**
     * 686.重复叠加字符串匹配
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
     * @param a a
     * @param b b
     * @return index
     */
    public int repeatedStringMatch(String a, String b) {
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

    private int badBoyerMooreMatch(char[] src, char[] pattern, int n) {
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

    private void ascii(char[] b, int m, int[] ac) {
        for (int i = 0; i < ac.length; i++) {
            ac[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            ac[b[i] - 'a'] = i;
        }
    }

    /**
     * 38. 外观数列
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 第一项是数字 1
     * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
     * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
     * 要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
     *
     * 例如，数字字符串 "3322251" 的描述如下图：
     *
     *
     *
     *
     * 示例 1：
     *
     * 输入：n = 1
     * 输出："1"
     * 解释：这是一个基本样例。
     * 示例 2：
     *
     * 输入：n = 4
     * 输出："1211"
     * 解释：
     * countAndSay(1) = "1"
     * countAndSay(2) = 读 "1" = 一 个 1 = "11"
     * countAndSay(3) = 读 "11" = 二 个 1 = "21"
     * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
     *
     *
     * 提示：
     *
     * 1 <= n <= 30
     *
     * @param n n
     * @return string
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            sb.append(i - start).append(s.charAt(start));
        }
        return sb.toString();
    }

}
