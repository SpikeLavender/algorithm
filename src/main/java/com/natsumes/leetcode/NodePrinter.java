package com.natsumes.leetcode;

/**
 * @author hetengjiao
 */
public class NodePrinter {

    public static String toString(ListNode node) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        while (node.next != null) {
            str.append(node.val).append(" -> ");
            node = node.next;
        }
        str.append(node.val).append("]");
        return str.toString();
    }
}
