package com.natsumes.redis;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hetengjiao
 */
public class LRUCache<K, V> implements Serializable {

    private final Map<K, Node> cache;

    private final int capacity;

    private final Node head;

    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void put(K key, V value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            if (cache.size() >= capacity) {
                Node tail = removeTail();
                cache.remove(tail.key);
            }
            cache.put(key, node);
            addToHead(node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }

    private class Node {
        K key;

        V value;

        Node prev;

        Node next;

        Node() {
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
