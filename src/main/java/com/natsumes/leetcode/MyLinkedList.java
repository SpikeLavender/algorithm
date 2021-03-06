package com.natsumes.leetcode;

/**
 * 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，
 * 则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 *
 * 示例：
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * @author hetengjiao
 */
public class MyLinkedList {

    transient Node node;

    transient int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.item;
    }

    private Node getNode(int index) {
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        Node cur = node;
        int i = 0;
        while (cur != null) {
            if (i == index) {
                return cur;
            }
            i++;
            cur = cur.next;
        }
        return null;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (size == 0) {
            this.node = new Node(val, null, this.node);
            this.size++;
            return;
        }
        Node node = new Node(val, null, this.node);
        this.node.pre = node;
        this.node = node;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            this.node = new Node(val, null, this.node);
            this.size++;
            return;
        }
        Node cur = node;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(val, cur, null);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node node = getNode(index);
        if (node == null) {
            return;
        }
        Node newNode = new Node(val, node.pre, node);
        node.pre.next = newNode;
        node.pre = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (node != null) {
            if (node.pre == null) {
                if (node.next != null) {
                    node.next.pre = null;
                }
                this.node = node.next;
                size--;
                return;
            }
            node.pre.next = node.next;
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            size--;
        }
    }

    private static class Node {
        int item;

        Node pre;

        Node next;

        public Node(int item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

}
