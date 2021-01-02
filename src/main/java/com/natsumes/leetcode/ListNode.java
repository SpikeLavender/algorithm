package com.natsumes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hetengjiao
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] nums) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }

    public static void setCycle(ListNode cur, int pos) {
        if (pos < 0) {
            return;
        }
        int count = 0;
        ListNode cy = cur;
        while (cur.next != null) {
            if (count == pos) {
                cy = cur;
            }
            cur = cur.next;
            count++;
        }
        cur.next = cy;
    }

    public static Integer[] toArray(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.toArray(new Integer[0]);
    }

    @Override
    public String toString() {
        return NodePrinter.toString(this);
    }
}
