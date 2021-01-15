package com.natsumes.common;

/**
 * @author hetengjiao
 */
public class Tire {

    private Node root;

    public Tire() {
        this.root = new Node('/');
    }

    public void add(String str) {
        char[] array = str.toCharArray();
        Node p = root;
        for (char c : array) {
            int index = c - 'a';
            Node child = p.children[index];
            if (child == null) {
                p.children[index] = new Node(c);
            }
            p = p.children[index];
        }
        p.isEndChar = true;
    }

    /**
     * 查找
     * @param pattern 模式串
     * @param isPrefix true: prex
     * @return
     */
    public boolean find(String pattern, boolean isPrefix) {
        char[] chars = pattern.toCharArray();
        Node p = root;
        for (char c : chars) {
            int index = c - 'a';
            Node child = p.children[index];
            if (child == null) {
                return false;
            }
            p = p.children[index];
        }
        return isPrefix || p.isEndChar;
    }

    private static class Node {

        char data;

        Node[] children = new Node[26];

        boolean isEndChar = false;

        Node(char data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {
        Tire tire = new Tire();
        tire.add("hello");
        System.out.println(tire.find("hel", true));
        System.out.println(tire.find("hello", false));
        System.out.println(tire.find("hello", true));
        System.out.println(tire.find("hei", true));
        System.out.println(tire.find("hei", false));
    }
}
