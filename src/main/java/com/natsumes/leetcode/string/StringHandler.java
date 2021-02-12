package com.natsumes.leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <h3>字符串处理专题</h3>
 *
 * =====================================================================================================================
 * <h4>栈</h4>
 *
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/">20.有效的括号</a>
 * {@link StringHandler#isValid(java.lang.String)}
 *
 * <a href="https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/">1003.检查替换后的词是否有效</a>
 * {@link StringHandler#isValidString(java.lang.String)}
 *
 * =====================================================================================================================
 *
 * @author hetengjiao
 */
public class StringHandler {

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
}
