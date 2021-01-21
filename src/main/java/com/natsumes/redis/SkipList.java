package com.natsumes.redis;

import java.util.Random;

/**
 * 跳跃表
 * 快速查询、插入、删除
 * 与红黑树功能和性能相似，但实现更简单
 *
 * 因为需要多层节点，所以需要2n空间，空间换时间
 *
 * @author hetengjiao
 */
public class SkipList<E extends Comparable<E>> {

    private static final double PROMOTE_RATE = 0.5d;

    private Node head;

    private Node tail;

    private int maxLevel;

    public SkipList() {
        this.head = new Node(null);
        this.tail = new Node(null);
        head.right = tail;
        tail.left = head;
    }

    public void add(E e) {
        if (e == null) {
            throw new IllegalArgumentException("param can not be null");
        }
        Node preNode = findNode(e);
        if (preNode.data != null && e.compareTo(preNode.data) == 0) {
            return;
        }

        Node node = new Node(e);
        appendNode(preNode, node);
        int curLevel = 0;
        Random random = new Random();
        while (random.nextDouble() < PROMOTE_RATE) {
            if (curLevel == maxLevel) {
                addLevel();
            }
            while (preNode.up == null) {
                preNode = preNode.left;
            }
            preNode = preNode.up;
            Node upperNode = new Node(e);
            appendNode(preNode, upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            curLevel++;
        }
    }

    private void appendNode(Node preNode, Node newNode) {
        newNode.left = preNode;
        newNode.right = preNode.right;
        preNode.right.left = newNode;
        preNode.right = newNode;
    }

    private void addLevel() {
        maxLevel++;
        Node p1 = new Node(null);
        Node p2 = new Node(null);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        head.up = p1;
        p2.down = tail;
        tail.up = p2;
        head = p1;
        tail = p2;
    }

    public Node search(E e) {
        Node node = findNode(e);
        if (node.data.compareTo(e) == 0) {
            return node;
        }
        return null;
    }

    /**
     * search pre node
     */
    private Node findNode(E e) {
        Node node = head;
        while (true) {
            while (node.right.data != null && node.right.data.compareTo(e) <= 0) {
                node = node.right;
            }
            if (node.down == null) {
                break;
            }
            node = node.down;
        }
        return node;
    }

    public boolean remove(E e) {
        Node removeNode = search(e);
        if (removeNode == null) {
            return false;
        }
        int curLevel = 0;
        while (removeNode != null) {
            removeNode.right.left = removeNode.left;
            removeNode.left.right = removeNode.right;
            if (curLevel != 0 && removeNode.left.data == null && removeNode.right.data == null) {
                removeLevel(removeNode.left);
            } else {
                curLevel++;
            }
            removeNode = removeNode.up;
        }
        return true;
    }

    private void removeLevel(Node node) {
        Node rightNode = node.right;
        if (node.up == null) {
            node.down.up = null;
            rightNode.down.up = null;
        } else {
            node.up.down = node.down;
            node.down.up = node.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }
        maxLevel--;
    }

    public void print() {
        Node node = head;
        while (node.down != null) {
            node = node.down;
        }
        while (node.right.data != null) {
            System.out.print(node.right.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    class Node {

        E data;

        Node left;

        Node right;

        Node up;

        Node down;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data = " + data;
        }
    }

}
