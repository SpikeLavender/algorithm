package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author hetengjiao
 */
public class LinkedListTopicTest {

    private final LinkedListTopic llt = new LinkedListTopic();

    @Test
    public void mergeTwoLists() {

        ListNode node1 = ListNode.build(new int[]{1, 2, 4});

        ListNode node2 = ListNode.build(new int[]{1, 3, 4});

        ListNode node = llt.mergeTwoLists(node1, node2);
        System.out.println(node);
    }

    @Test
    public void deleteDuplicates() {
        ListNode node1 = ListNode.build(new int[]{1, 1, 2});
        System.out.println(llt.deleteDuplicates(node1));

        ListNode node2 = ListNode.build(new int[]{1, 1, 2, 3, 3});
        System.out.println(llt.deleteDuplicates(node2));

        node2 = ListNode.build(new int[]{1, 1, 2, 3, 3, 4});
        System.out.println(llt.deleteDuplicates(node2));

        node2 = ListNode.build(new int[]{1, 1, 2, 3, 3, 4, 5});
        System.out.println(llt.deleteDuplicates(node2));

        node2 = ListNode.build(new int[]{});
        System.out.println(llt.deleteDuplicates(node2));
    }

    @Test
    public void hasCycle() {
        ListNode node = ListNode.build(new int[]{1});
        ListNode.setCycle(node, 0);
        Assert.assertTrue(llt.hasCycle(node));

        node = ListNode.build(new int[] {3, 2, 0, -4});
        ListNode.setCycle(node, 1);
        Assert.assertTrue(llt.hasCycle(node));

        node = ListNode.build(new int[] {1, 2});
        ListNode.setCycle(node, 0);
        Assert.assertTrue(llt.hasCycle(node));

        node = ListNode.build(new int[] {1, 2});
        ListNode.setCycle(node, -1);
        Assert.assertFalse(llt.hasCycle(node));

        node = ListNode.build(new int[] {1});
        ListNode.setCycle(node, -1);
        Assert.assertFalse(llt.hasCycle(node));
    }


    @Test
    public void getIntersectionNode() {
        ListNode node1 = ListNode.build(new int[]{4, 1});
        ListNode node2 = ListNode.build(new int[]{5, 0, 1});
        ListNode node3 = ListNode.build(new int[]{8, 4, 5});
        ListNode cur = node1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node3;

        cur = node2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node3;

        System.out.println(llt.getIntersectionNode(node1, node2));

        node1 = ListNode.build(new int[]{2, 4, 6});
        node2 = ListNode.build(new int[]{1, 5});
        System.out.println(llt.getIntersectionNode(node1, node2));
    }

    @Test
    public void removeElements() {
        ListNode node = ListNode.build(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(llt.removeElements(node, 6));

        node = ListNode.build(new int[]{});
        System.out.println(llt.removeElements(node, 6));

        node = ListNode.build(new int[]{6});
        System.out.println(llt.removeElements(node, 6));

        node = ListNode.build(new int[]{1, 1});
        System.out.println(llt.removeElements(node, 1));
    }

    @Test
    public void reverseList() {
        ListNode node = ListNode.build(new int[]{1, 2, 6, 3, 4, 5});
        System.out.println(llt.reverseList(node));
    }

    @Test
    public void isPalindrome() {
        Assert.assertFalse(llt.isPalindrome(ListNode.build(new int[] {1, 2})));
        Assert.assertTrue(llt.isPalindrome(ListNode.build(new int[] {1, 2, 2, 1})));
    }

    @Test
    public void deleteNode() {
        ListNode node = ListNode.build(new int[]{5, 4, 1, 9});
        llt.deleteNode(node.next);
        System.out.println(node);

        node = ListNode.build(new int[]{5, 4, 1, 9});
        llt.deleteNode(node.next.next);
        System.out.println(node);
    }

    @Test
    public void middleNode() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.middleNode(node));

        node = ListNode.build(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(llt.middleNode(node));
    }

    @Test
    public void getDecimalValue() {
        ListNode node = ListNode.build(new int[]{1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0});
        Assert.assertEquals(18880, llt.getDecimalValue(node));

        Assert.assertEquals(5, llt.getDecimalValue(ListNode.build(new int[] {1, 0, 1})));
        Assert.assertEquals(0, llt.getDecimalValue(ListNode.build(new int[] {0, 0})));
        Assert.assertEquals(0, llt.getDecimalValue(ListNode.build(new int[] {0})));
        Assert.assertEquals(1, llt.getDecimalValue(ListNode.build(new int[] {1})));
    }
}