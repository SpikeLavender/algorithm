package com.natsumes.hashmap;


/**
 * @author hetengjiao
 */
public class MyHashMap<K,V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;


    private transient ListNode<K,V>[] map;

    private int size;

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap() {
        map = (ListNode<K,V>[])new ListNode[DEFAULT_INITIAL_CAPACITY];
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public MyHashMap(int initialCapacity) {
        map = (ListNode<K,V>[])new ListNode[initialCapacity + initialCapacity / 16 * 2];
    }

    public void put(K key, V value) {
        if (size >= map.length * DEFAULT_LOAD_FACTOR) {
            System.out.println("need resize");
            return;
        }

        int index = Math.abs(key.hashCode()) % map.length;

        ListNode<K,V> ln = map[index];
        if (ln == null) {
            ListNode<K,V> lnNew = new ListNode<>();
            lnNew.head = new Node<>(key, value, null);
            map[index] = lnNew;
            size++;
        } else {
            ln.addNode(key, value);
        }
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % map.length;
        ListNode<K,V> ln = map[index];
        if (ln == null) {
            return null;
        }
        return ln.getVal(key);
    }

    public int size() {
        return size;
    }

}
