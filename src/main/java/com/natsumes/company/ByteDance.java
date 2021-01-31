package com.natsumes.company;

/**
 *
 * 字节跳动题库
 *
 * @author hetengjiao
 */
public class ByteDance {

    /**
     *
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     *
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        // 双指针
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    /**
     * 查找完全二叉树的最后一层最右边的节点
     *
     * 对每个子树的根节点，先从它的右子树开始，沿着左分支一直走到最后一层，如果深度等于树的深度
     * 且该最后节点右边没有节点，则为所求；
     * 否则，右侧右节点，则遍历右子树，深度小于树的深度，则遍历左子树
     *
     *            1
     *          /  \
     *         2    2
     *        / \  / \
     *       3  4 4   3
     */
    public Node findLastRightNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return node;
        }

        // 计算高度
        int depth = 0;
        Node curNode = node;
        while (curNode != null) {
            depth++;
            curNode = curNode.left;
        }

        int level = 0;
        int tmpDepth;
        while (node != null) {
            level++;
            if (level == depth) {
                break;
            }
            curNode = node;
            if (curNode.right != null) {
                tmpDepth = level + 1;
                Node preNode = curNode;
                curNode = curNode.right;
                while (curNode.left != null) {
                    tmpDepth++;
                    preNode = curNode;
                    curNode = curNode.left;
                }
                if (tmpDepth < depth) {
                    node = node.left;
                } else if (preNode.right == null || preNode.right == curNode) {
                    return curNode;
                } else {
                    node = node.right;
                }
            } else {
                node = node.left;
            }
        }
        return node;
    }
}
