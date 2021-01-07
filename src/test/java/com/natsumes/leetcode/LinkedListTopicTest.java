package com.natsumes.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


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
    public void reverseList4R() {
        ListNode node = ListNode.build(new int[]{1, 2, 6, 3, 4, 5});
        System.out.println(llt.reverseList4R(node));
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

    @Test
    public void getKthFromEnd() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.getKthFromEnd(node, 2));
    }

    @Test
    public void reversePrint() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(llt.reversePrint(node)));
    }

    @Test
    public void removeDuplicateNodes() {
        ListNode node = ListNode.build(new int[] {1, 2, 3, 3, 2, 1});
        System.out.println(llt.removeDuplicateNodes(node));

        node = ListNode.build(new int[] {1, 1, 1, 1, 2});
        System.out.println(llt.removeDuplicateNodes(node));
    }

    @Test
    public void removeNthFromEnd() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.removeNthFromEnd(node, 2));

        node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.removeNthFromEnd(node, 1));

        node = ListNode.build(new int[]{1});
        System.out.println(llt.removeNthFromEnd(node, 1));

        node = ListNode.build(new int[]{1});
        System.out.println(llt.removeNthFromEnd(node, 0));

        node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.removeNthFromEnd(node, 5));
    }

    @Test
    public void swapPairs() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4});
        System.out.println(llt.swapPairs(node));

        node = ListNode.build(new int[]{});
        System.out.println(llt.swapPairs(node));

        node = ListNode.build(new int[]{1});
        System.out.println(llt.swapPairs(node));
    }

    @Test
    public void reverseKGroup() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4});
        System.out.println(llt.reverseKGroup(node, 2));

        node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.reverseKGroup(node, 2));

        node = ListNode.build(new int[]{});
        System.out.println(llt.reverseKGroup(node, 2));

        node = ListNode.build(new int[]{1});
        System.out.println(llt.reverseKGroup(node, 2));
    }

    @Test
    public void rotateRight() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.rotateRight(node, 2));

        node = ListNode.build(new int[]{0, 1, 2});
        System.out.println(llt.rotateRight(node, 4));

    }

    @Test
    public void testDeleteDuplicatesNode() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println(llt.deleteDuplicatesNode(node));

        node = ListNode.build(new int[]{1, 1, 1, 2, 3});
        System.out.println(llt.deleteDuplicatesNode(node));
    }

    @Test
    public void testReverseBetween() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.reverseBetween(node, 2, 4));

        node = ListNode.build(new int[]{3, 5});
        System.out.println(llt.reverseBetween(node, 1, 2));

        node = ListNode.build(new int[]{3, 5, 6});
        System.out.println(llt.reverseBetween(node, 1, 2));
    }

    @Test
    public void testReverseBetween4R() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.reverseBetween4R(node, 2, 4));

        node = ListNode.build(new int[]{3, 5});
        System.out.println(llt.reverseBetween4R(node, 1, 2));

        node = ListNode.build(new int[]{3, 5, 6});
        System.out.println(llt.reverseBetween4R(node, 1, 2));
    }

    @Test
    public void testReverseN() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        System.out.println(llt.reverseN(node, 2));

        node = ListNode.build(new int[]{3, 5});
        System.out.println(llt.reverseN(node, 1));

        node = ListNode.build(new int[]{3, 5, 6});
        System.out.println(llt.reverseN(node, 1));
    }

    @Test
    public void testDetectCycle() {
        ListNode node = ListNode.build(new int[]{1}, true);
        ListNode.setCycle(node, 0);
        ListNode listNode = llt.detectCycle(node);
        System.out.println(listNode);

        node = ListNode.build(new int[] {3, 2, 0, -4}, true);
        ListNode.setCycle(node, 1);
        listNode = llt.detectCycle(node);
        System.out.println(listNode);
        //Assert.assertTrue();

        node = ListNode.build(new int[] {1, 2}, true);
        ListNode.setCycle(node, 0);
        listNode = llt.detectCycle(node);
        System.out.println(listNode);

        node = ListNode.build(new int[] {1, 2}, false);
        ListNode.setCycle(node, -1);
        listNode = llt.detectCycle(node);
        System.out.println(listNode);

        node = ListNode.build(new int[] {1}, false);
        ListNode.setCycle(node, -1);
        listNode = llt.detectCycle(node);
        System.out.println(listNode);
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode node1 = ListNode.build(new int[]{7, 1, 6});
        ListNode node2 = ListNode.build(new int[]{5, 9, 2});
        ListNode listNode = llt.addTwoNumbers(node1, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{1, 8});
        node2 = ListNode.build(new int[]{0});
        listNode = llt.addTwoNumbers(node1, node2);
        System.out.println(listNode);
    }

    @Test
    public void testAddTwoNumbers01() {
        ListNode node1 = ListNode.build(new int[]{7, 1, 6});
        ListNode node2 = ListNode.build(new int[]{5, 9, 2});
        ListNode listNode = llt.addTwoNumbers01(node1, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{1, 8});
        node2 = ListNode.build(new int[]{0});
        listNode = llt.addTwoNumbers01(node1, node2);
        System.out.println(listNode);
    }

    @Test
    public void testAddTwoNumbers02() {
        ListNode node1 = ListNode.build(new int[]{7, 2, 4, 3});
        ListNode node2 = ListNode.build(new int[]{5, 6, 4});
        ListNode listNode = llt.addTwoNumbers02(node1, node2);
        System.out.println(listNode);
    }

    @Test
    public void testMergeInBetween() {
        ListNode node1 = ListNode.build(new int[]{0, 1, 2, 3, 4, 5});
        ListNode node2 = ListNode.build(new int[]{10000, 100001, 10002});
        ListNode listNode = llt.mergeInBetween(node1, 3, 4, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{0, 1, 2, 3, 4, 5});
        node2 = ListNode.build(new int[]{10000, 100001, 10002});
        listNode = llt.mergeInBetween(node1, 4, 5, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{0, 1, 2, 3, 4, 5});
        node2 = ListNode.build(new int[]{10000, 100001, 10002});
        listNode = llt.mergeInBetween(node1, 5, 5, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{0, 1, 2, 3, 4, 5});
        node2 = ListNode.build(new int[]{10000, 100001, 10002});
        listNode = llt.mergeInBetween(node1, 4, 4, node2);
        System.out.println(listNode);

        node1 = ListNode.build(new int[]{0, 1, 2, 3, 4, 5});
        node2 = ListNode.build(new int[]{10000, 100001, 10002});
        listNode = llt.mergeInBetween(node1, 1, 4, node2);
        System.out.println(listNode);
    }

    @Test
    public void partition() {
        ListNode node = ListNode.build(new int[]{3, 5, 8, 5, 10, 2, 1});
        System.out.println(llt.partition(node, 5));

        node = ListNode.build(new int[]{3, 5, 8, 5, 10, 2, 1});
        System.out.println(llt.partition(node, 3));

        node = ListNode.build(new int[]{3, 5, 8, 5, 10, 2, 1});
        System.out.println(llt.partition(node, 1));

        node = ListNode.build(new int[]{3, 5, 8, 5, 10, 2, 1});
        System.out.println(llt.partition(node, 8));

        node = ListNode.build(new int[]{});
        System.out.println(llt.partition(node, 8));

        node = ListNode.build(new int[]{1});
        System.out.println(llt.partition(node, 8));

        node = ListNode.build(new int[]{9});
        System.out.println(llt.partition(node, 8));
    }

    @Test
    public void nextLargerNodes() {
        ListNode node = ListNode.build(new int[]{2, 1, 5});
        System.out.println(Arrays.toString(llt.nextLargerNodes(node)));

        node = ListNode.build(new int[]{2, 7, 4, 3, 5});
        System.out.println(Arrays.toString(llt.nextLargerNodes(node)));

        node = ListNode.build(new int[]{1, 7, 5, 1, 9, 2, 5, 1});
        System.out.println(Arrays.toString(llt.nextLargerNodes(node)));
    }

    @Test
    public void removeZeroSumSublists() {
        ListNode node = ListNode.build(new int[]{1, 2, -3, 3, 1});
        System.out.println(llt.removeZeroSumSublists(node));

        node = ListNode.build(new int[]{1, 2, -3, 3, 4});
        System.out.println(llt.removeZeroSumSublists(node));

        node = ListNode.build(new int[]{1, 2, 3, -3, -2});
        System.out.println(llt.removeZeroSumSublists(node));
    }

    @Test
    public void reorderList() {
        ListNode node = ListNode.build(new int[]{1, 2, 3, 4});
        llt.reorderList(node);
        System.out.println(node);

        node = ListNode.build(new int[]{1, 2, 3, 4, 5});
        llt.reorderList(node);
        System.out.println(node);
    }
}