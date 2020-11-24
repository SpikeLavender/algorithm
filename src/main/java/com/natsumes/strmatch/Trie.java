package com.natsumes.strmatch;


/**
 * 如果要在一组字符串中，频繁地查询某些字符串，用 Trie 树会非常高效。构建 Trie 树的过程，需要扫
 * 描所有的字符串，时间复杂度是 O(n)（n 表示所有字符串的长度和）。但是一旦构建成功之后，后续的
 * 查询操作会非常高效。每次查询时，如果要查询的字符串长度是 k，那我们只需要比对大约 k 个节点，
 * 就能完成查询操作。跟原本那组字符串的长度和个数没有任何关系。所以说，构建好 Trie 树后，在其中
 * 查找字符串的时间复杂度是 O(k)，k 表示要查找的字符串的长度。
 * 典型应用
 * 利用 Trie 树，实现搜索关键词的提示功能
 *
 *  @author hetengjiao
 */
public class Trie {
    /**
     * 存储无意义字符
     */
    private TrieNode root = new TrieNode('/');

    Trie() {
    }

    /**
     * 往Trie树中插入一个字符串
     */
    public Trie insert(String src) {
        char[] text = src.toCharArray();
        Trie.TrieNode p = root;
        for (char c : text) {
            int index = c - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(c);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;

        return this;
    }

    /**
     * 在Trie树中查找一个字符串
     */
    public boolean find(String pattern) {
        TrieNode p = root;
        char[] array = pattern.toCharArray();
        for (char c : array) {
            int index = c - 'a';
            if (p.children[index] == null) {
                // 不存在pattern
                return false;
            }
            p = p.children[index];
        }

        // 不能完全匹配，只是前缀
        // 找到pattern
        return p.isEndingChar;

    }

    class TrieNode {
        char data;

        TrieNode[] children = new TrieNode[26];

        boolean isEndingChar = false;

        TrieNode(char data) {
            this.data = data;
        }
    }
}
