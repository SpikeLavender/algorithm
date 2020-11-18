package com.natsumes.hashmap;

/**
 * @author hetengjiao
 */
public class ListNode<K,V> {

    Node<K,V> head;

    public void addNode(K key, V value) {
        if (head == null) {
            return;
        }
        Node<K,V> node = new Node<>(key, value, null);
        Node tmp = head;
        while (true) {
            if (key.equals(tmp.key)) {
                tmp.value = value;
            }
            if (tmp.next == null){
                break;
            }
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    public V getVal(K key) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head.value;
        } else {
            Node<K,V> tmp = head;
            while (tmp != null) {
                if (key.equals(tmp.key)) {
                    return tmp.value;
                }
                tmp = tmp.next;
            }
            return null;
        }
    }

}
