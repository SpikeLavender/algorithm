package com.natsumes.tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * 字典树
 *
 * @author hetengjiao
 */
public class Trie {

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入操作
     *
     * @param word 单词
     */
    public void add(String word) {
        Node current = root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            Node next = current.next.get(c);
            if (next == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        //如果当前的node已经是一个word，则不需要添加
        if (!current.isWord) {
            size++;
            current.isWord = true;
        }
    }

    /**
     * 是否包含某个单词
     *
     * @param word 单词
     * @return 存在返回true，反之false
     */
    public boolean contains(String word) {
        //如果只存在 panda这个词，查询 pan，虽然有这3个字母，但是并不存在该单词
        Node node = doContains(word);
        return node != null && node.isWord;
    }

    /**
     * Trie是否包含某个前缀
     *
     * @param prefix 前缀
     * @return true or false
     */
    public boolean containsPrefix(String prefix) {
        return doContains(prefix) != null;
    }

    private Node doContains(String pattern) {
        Node current = root;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            Node node = current.next.get(c);
            if (node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    /**
     * 删除操作
     *
     * 1，如果单词是另一个单词的前缀，只需要把该word的最后一个节点的isWord的改成false
     * 2，如果单词的所有字母的都没有多个分支，删除整个单词
     * 3，如果单词的除了最后一个字母，其他的字母有多个分支，
     *
     *
     * @param word word
     * @return true or false
     */
    public boolean remove(String word) {
        Node multiChildNode = null;
        int multiChildNodeIndex = -1;
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Node child = current.next.get(word.charAt(i));
            //如果Trie中没有这个单词
            if (child == null) {
                return false;
            }
            //当前节点的子节点大于1个
            if (child.next.size() > 1) {
                multiChildNodeIndex = i;
                multiChildNode = child;
            }
            current = child;
        }
        //如果单词后面还有子节点
        if (current.next.size() > 0) {
            if (current.isWord) {
                current.isWord = false;
                size--;
                return true;
            }
            //不存在该单词，该单词只是前缀
            return false;
        }
        //如果单词的所有字母的都没有多个分支，删除整个单词
        if (multiChildNodeIndex == -1) {
            root.next.remove(word.charAt(0));
            size--;
            return true;
        }
        //如果单词的除了最后一个字母，其他的字母有分支
        if (multiChildNodeIndex != word.length() - 1) {
            multiChildNode.next.remove(word.charAt(multiChildNodeIndex + 1));
            size--;
            return true;
        }
        return false;
    }

    private static class Node {

        boolean isWord;

        Map<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }

        public Node(boolean isWord) {
            this();
            this.isWord = isWord;
        }
    }
}
