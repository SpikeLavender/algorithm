package com.natsumes.leetcode.list;

import com.natsumes.leetcode.tree.TreeNode;

import java.util.*;

/**
 * <h3>链表专题</h3>
 *
 * <a href="https://leetcode-cn.com/problems/add-two-numbers/">2.两数相加</a>
 * {@link LinkedListTopic#addTwoNumbers(com.natsumes.leetcode.list.ListNode, com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">21.合并两个有序链表</a>
 * {@link LinkedListTopic#mergeTwoLists(com.natsumes.leetcode.list.ListNode, com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/reorder-list/">143.重排链表</a>
 * {@link LinkedListTopic#reorderList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/sort-list/">148.排序链表</a>
 * {@link LinkedListTopic#sortList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/insertion-sort-list/">147.对链表进行插入排序</a>
 * {@link LinkedListTopic#insertionSortList(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">25.K 个一组翻转链表</a>
 * {@link LinkedListTopic#reverseKGroup(com.natsumes.leetcode.list.ListNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/swap-nodes-in-pairs/">24.两两交换链表中的节点</a>
 * {@link LinkedListTopic#swapPairs(com.natsumes.leetcode.list.ListNode)}
 *
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23.合并K个升序链表</a>
 * {@link LinkedListTopic#mergeKLists(com.natsumes.leetcode.list.ListNode[])}
 *
 * <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">19.删除链表的倒数第N个节点</a>
 * {@link LinkedListTopic#removeNthFromEnd(com.natsumes.leetcode.list.ListNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/remove-element/">27.移除元素</a>
 * {@link LinkedListTopic#removeElement(int[], int)}
 *
 * <a href="https://leetcode-cn.com/problems/permutations-ii/">47.全排列 II</a>
 * {@link LinkedListTopic#permuteUnique(int[])}
 *
 * <a href="https://leetcode-cn.com/problems/reverse-linked-list-ii/">92.反转链表 II</a>
 * {@link LinkedListTopic#reverseBetween(com.natsumes.leetcode.list.ListNode, int, int)}
 *
 * @author hetengjiao
 */
public class LinkedListTopic {

    /**
     * 23. 合并K个升序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *
     * @param lists lists
     * @return listNode
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return doMergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode doMergeKLists(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        return mergeTwoLists(doMergeKLists(lists, l, mid), doMergeKLists(lists, mid + 1, r));
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     *
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    /**
     * 83. 删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     *
     * 示例 1:
     *
     * 输入: 1->1->2
     * 输出: 1->2
     * 示例 2:
     *
     * 输入: 1->1->2->3->3
     * 输出: 1->2->3
     *
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = head;

        while (cur != null) {
            if (cur.val != pre.val) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        pre.next = null;

        return head;
    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     * 如果链表中存在环，则返回 true 。 否则，返回 false 。
     *
     *
     *
     * 进阶：
     *
     * 你能用 O(1)（即，常量）内存解决此问题吗？
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     *
     *
     *
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     *
     *
     * 提示：
     *
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= TreeNode.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     *
     * https://leetcode-cn.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            if (slow.val == fast.next.val) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 160. 相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * 如下面的两个链表：
     *
     *
     *
     * 在节点 c1 开始相交。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Reference of the node with value = 8
     * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，
     * 链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     *
     *
     * 示例 2：
     *
     *
     *
     * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * 输出：Reference of the node with value = 2
     * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，
     * 链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
     *
     *
     * 示例 3：
     *
     *
     *
     * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * 输出：null
     * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
     * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
     * 解释：这两个链表不相交，因此返回 null。
     *
     *
     * 注意：
     *
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     * 可假定整个链表结构中没有循环。
     * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
     *
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    /**
     * 203. 移除链表元素
     * 删除链表中等于给定值 val 的所有节点。
     *
     * 示例:
     *
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     *
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        ListNode pre = preHead;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return preHead.next;
    }

    /**
     * 206. 反转链表
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL   2 3 4 5 1  3 4 5
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     * https://leetcode-cn.com/problems/reverse-linked-list/
     *
     */
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    /**
     * 递归实现
     */
    public ListNode reverseList4R(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList4R(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 234. 回文链表
     * 请判断一个链表是否为回文链表。
     *
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * https://leetcode-cn.com/problems/palindrome-linked-list/
     * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode node = endOfFirstHalf(head);
        ListNode node2 = reverseList(node.next);

        ListNode p1 = head;
        ListNode p2 = node2;
        boolean result = true;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        node.next = reverseList(node2);

        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 237. 删除链表中的节点 || 面试题 02.03. 删除中间节点
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *
     * 示例 1：
     *
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2：
     *
     * 输入：head = [4,5,1,9], node = 1
     * 输出：[4,5,9]
     * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     *
     * 提示：
     *
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
     * https://leetcode-cn.com/problems/delete-middle-node-lcci/submissions/
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 876. 链表的中间结点
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     *
     * 如果有两个中间结点，则返回第二个中间结点。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例 2：
     *
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     *
     *
     * 提示：
     *
     * 给定链表的结点数介于 1 和 100 之间。
     *
     * https://leetcode-cn.com/problems/middle-of-the-linked-list/
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 1290. 二进制链表转整数
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
     *
     * 请你返回该链表所表示数字的 十进制值 。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [1,0,1]
     * 输出：5
     * 解释：二进制数 (101) 转化为十进制数 (5)
     * 示例 2：
     *
     * 输入：head = [0]
     * 输出：0
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：1
     * 示例 4：
     *
     * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
     * 输出：18880
     * 示例 5：
     *
     * 输入：head = [0,0]
     * 输出：0
     *
     *
     * 提示：
     *
     * 链表不为空。
     * 链表的结点总数不超过 30。
     * 每个结点的值不是 0 就是 1
     *
     * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
     */
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }

        return res;
    }

    /**
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     *
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            k--;
            if (k < 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 剑指 Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     *
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        reversePrint(head, nums);
        return nums.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void reversePrint(ListNode head, List<Integer> nums) {
        if (head == null) {
            return;
        }
        reversePrint(head.next, nums);
        nums.add(head.val);
    }

    /**
     * 面试题 02.01. 移除重复节点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     *
     * 示例1:
     *
     *  输入：[1, 2, 3, 3, 2, 1]
     *  输出：[1, 2, 3]
     * 示例2:
     *
     *  输入：[1, 1, 1, 1, 2]
     *  输出：[1, 2]
     * 提示：
     *
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     * 进阶：
     *
     * 如果不得使用临时缓冲区，该怎么解决？
     *
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     *
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode node = head;
        while (node != null) {
            ListNode newNode = node;
            while (newNode.next != null) {
                if (node.val == newNode.next.val) {
                    newNode.next = newNode.next.next;
                } else {
                    newNode = newNode.next;
                }
            }
            node = node.next;
        }
        return head;
    }

    /*============================================中等===============================================*/
    /**
     * 19. 删除链表的倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode slow = preHead;
        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return preHead.next;
    }

    /**
     * 24. 两两交换链表中的节点
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1：
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     *
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= TreeNode.val <= 100
     *
     * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = dummyHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode pre = tmp.next;
            ListNode cur = tmp.next.next;
            pre.next = cur.next;
            cur.next = pre;
            tmp.next = cur;
            tmp = pre;
        }
        return dummyHead.next;
    }

    /**
     * 61. 旋转链表
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->4->5->NULL, k = 2
     * 输出: 4->5->1->2->3->NULL
     * 解释:
     * 向右旋转 1 步: 5->1->2->3->4->NULL
     * 向右旋转 2 步: 4->5->1->2->3->NULL
     * 示例 2:
     *
     * 输入: 0->1->2->NULL, k = 4
     * 输出: 2->0->1->NULL
     * 解释:
     * 向右旋转 1 步: 2->0->1->NULL
     * 向右旋转 2 步: 1->2->0->NULL
     * 向右旋转 3 步: 0->1->2->NULL
     * 向右旋转 4 步: 2->0->1->NULL
     *
     * https://leetcode-cn.com/problems/rotate-list/
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        ListNode newTail = head;
        for (int i = 1; i < n - k % n; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     *
     * 示例 1:
     *
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 示例 2:
     *
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     */
    public ListNode deleteDuplicatesNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesNode(head.next);
        } else {
            head.next = deleteDuplicatesNode(head.next);
            return head;
        }
    }

    /**
     * 92. 反转链表 II
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     *
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     *
     * https://leetcode-cn.com/problems/reverse-linked-list-ii/
     *
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode preHead = null;
        int j = 0;

        for (int i = 1; i < m; i++) {
            j++;
            preHead = cur;
            cur = cur.next;
        }
        ListNode pre = null;
        ListNode supHead = cur;
        while (j < n) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            j++;
        }
        if (supHead != null) {
            supHead.next = cur;
        }
        if (preHead == null) {
            head = pre;
        } else {
            preHead.next = pre;
        }
        return head;
    }

    /**
     * 递归实现
     */
    public ListNode reverseBetween4R(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween4R(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null;

    /**
     * 反转前N个节点
     */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }


    /**
     * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
     *
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
     *
     * 示例:
     *
     * 给定的有序链表： [-10, -3, 0, 5, 9],
     *
     * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode sortedListToBST(ListNode head) {
        // 中序遍历
        return null;
    }

    /**
     * 142. 环形链表 II || 面试题 02.08. 环路检测
     * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
     *
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：tail connects to node index 1
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2], pos = 0
     * 输出：tail connects to node index 0
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     *
     *
     *
     * 输入：head = [1], pos = -1
     * 输出：no cycle
     * 解释：链表中没有环。
     *
     *
     * 进阶：
     *
     * 你是否可以不用额外空间解决此题？
     *
     * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (fast == slow) {
                ListNode cur = head;
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }

    /**
     * 面试题 02.05. 链表求和
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     *
     *
     *
     * 示例：
     *
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
     *
     * 示例：
     *
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     *
     * https://leetcode-cn.com/problems/sum-lists-lcci/
     *
     * 2. 两数相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        addTwoNumbers(res, l1, l2, 0);
        return res.next;
    }

    private void addTwoNumbers(ListNode res, ListNode l1, ListNode l2, int flag) {
        if (l1 == null && l2 == null && flag == 0) {
            return;
        }
        int sum1 = l1 == null ? 0 : l1.val;
        int sum2 = l2 == null ? 0 : l2.val;
        int sum = sum1 + sum2 + flag;
        res.next = new ListNode(sum % 10);
        flag = sum / 10;
        addTwoNumbers(res.next, l1 == null ? null : l1.next, l2 == null ? null : l2.next, flag);
    }

    public ListNode addTwoNumbers01(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummyHead = res;
        int flag = 0;
        while (l1 != null || l2 != null || flag != 0) {
            int sum1 = l1 == null ? 0 : l1.val;
            int sum2 = l2 == null ? 0 : l2.val;
            int sum = sum1 + sum2 + flag;
            flag = sum / 10;
            res.next = new ListNode(sum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            res = res.next;
        }
        return dummyHead.next;
    }

    /**
     * 445. 两数相加 II
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。
     * 将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 进阶：
     *
     * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     *
     * 示例：
     *
     * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 8 -> 0 -> 7
     *
     * https://leetcode-cn.com/problems/add-two-numbers-ii/
     */
    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int flag = 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int sum1 = stack1.isEmpty() ? 0 : stack1.pop();
            int sum2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = sum1 + sum2 + flag;
            flag = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            cur.next = res;
            res = cur;
        }

        return res;
    }

    /**
     * 1669. 合并两个链表
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     *
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
     *
     * 下图中蓝色边和节点展示了操作后的结果：
     *
     *
     * 请你返回结果链表的头指针。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
     * 输出：[0,1,2,1000000,1000001,1000002,5]
     * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
     * 示例 2：
     *
     *
     * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
     * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
     * 解释：上图中蓝色的边和节点为答案链表。
     *
     *
     * 提示：
     *
     * 3 <= list1.length <= 104
     * 1 <= a <= b < list1.length - 1
     * 1 <= list2.length <= 10
     *
     * https://leetcode-cn.com/problems/merge-in-between-linked-lists/
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        while (cur != null) {
            if (a == 1) {
                ListNode cur2 = cur.next;
                cur.next = list2;
                while (list2.next != null) {
                    list2 = list2.next;
                }
                while (cur2 != null && b > 0) {
                    b--;
                    cur2 = cur2.next;
                }
                list2.next = cur2;
                break;
            }
            a--;
            b--;
            cur = cur.next;
        }
        return list1;
    }

    /**
     * 面试题 02.04. 分割链表
     * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
     * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。
     * 分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
     *
     * 示例:
     *
     * 输入: head = 3->5->8->5->10->2->1, x = 5
     * 输出: 3->1->2->10->5->5->8
     * https://leetcode-cn.com/problems/partition-list-lcci/
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < x) {
                pre.next = cur.next;
                cur.next = head;
                head = cur;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 1019. 链表中的下一个更大节点
     * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
     *
     * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
     * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
     *
     * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
     *
     * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，
     * 其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[2,1,5]
     * 输出：[5,5,0]
     * 示例 2：
     *
     * 输入：[2,7,4,3,5]
     * 输出：[7,0,5,5,0]
     * 示例 3：
     *
     * 输入：[1,7,5,1,9,2,5,1]
     * 输出：[7,9,9,9,0,5,0,0]
     *
     *
     * 提示：
     *
     * 对于链表中的每个节点，1 <= node.val <= 10^9
     * 给定列表的长度在 [0, 10000] 范围内
     *
     * https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
     *
     * ANS: 单调栈, 后序遍历
     */
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        nextLargerNodes(head, stack, res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void nextLargerNodes(ListNode node, Deque<Integer> stack, LinkedList<Integer> res) {
        if (node == null) {
            return;
        }
        nextLargerNodes(node.next, stack, res);
        while (!stack.isEmpty() && stack.peek() <= node.val) {
            stack.pop();
        }
        res.addFirst(stack.isEmpty() ? 0 : stack.peek());
        stack.push(node.val);
    }

    /**
     * 1171. 从链表中删去总和值为零的连续节点
     * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
     *
     * 删除完毕后，请你返回最终结果链表的头节点。
     *
     *
     *
     * 你可以返回任何满足题目要求的答案。
     *
     * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
     *
     * 示例 1：
     *
     * 输入：head = [1,2,-3,3,1]
     * 输出：[3,1]
     * 提示：答案 [1,2,1] 也是正确的。
     * 示例 2：
     *
     * 输入：head = [1,2,3,-3,4]
     * 输出：[1,2,4]
     * 示例 3：
     *
     * 输入：head = [1,2,3,-3,-2]
     * 输出：[1]
     *
     *
     * 提示：
     *
     * 给你的链表中可能有 1 到 1000 个节点。
     * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
     *
     * https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode d = dummyHead; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        sum = 0;
        for (ListNode d = dummyHead; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummyHead.next;
    }

    /**
     * 143. 重排链表
     * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
     * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * 示例 1:
     *
     * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
     * 示例 2:
     *
     * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
     * https://leetcode-cn.com/problems/reorder-list/
     *
     * @param head head
     * @see LinkedListTopic
     * @see LinkedListTopic#reverseList(ListNode)
     * @see LinkedListTopic#middleNode(ListNode)
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反转后半部分链表 1 -> 2  3 -> 4 -> 5
        ListNode right = slow.next;
        slow.next = null;
        ListNode pre = null;

        while (right != null) {
            ListNode tmp = right.next;
            right.next = pre;
            pre = right;
            right = tmp;
        }
        ListNode node = head;
        // 合并 1 -> 2  3 -> 4 -> 5
        // 1 -> 3 -> 2 -> 4
        while (node != null && pre != null) {
            ListNode nextL = node.next;
            ListNode nextR = pre.next;

            node.next = pre;
            node = nextL;
            pre.next = node;
            pre = nextR;
        }
    }

    /**
     * 148. 排序链表 -- 归并排序
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * 进阶：
     *
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * 归并排序
     *
     * 示例 1：
     *
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     *
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     *
     *
     * 提示：
     *
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= TreeNode.val <= 105
     *
     * @param head head
     * @return  {@link ListNode}
     * @see LinkedListTopic
     * @see LinkedListTopic#mergeTwoLists(ListNode, ListNode)
     *
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyNode = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode pre = dummyNode;
            ListNode cur = dummyNode.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                pre.next = mergeTwoLists(head1, head2);
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 147. 对链表进行插入排序
     * 对链表进行插入排序。
     *
     *
     * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
     * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
     *
     *
     *
     * 插入排序算法：
     *
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     *
     *
     * 示例 1：
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     * 示例 2：
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     *
     * @param head head
     * @return {@link ListNode}
     *
     * @see LinkedListTopic
     *
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode last = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (last.val <= cur.val) {
                last = last.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val) {
                    prev = prev.next;
                }
                last.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = last.next;
        }
        return dummyHead.next;
    }

    /**
     * 25. K 个一组翻转链表
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * @param head head
     * @param k k
     * @return ListNode
     * @see LinkedListTopic
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转 a 到 b 之间的链表 [a, b)
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * 1 -> 2 -> 4 -> 3 -> 5 -> 6
     *
     * @param a a
     * @param b b
     * @return node
     */
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = b;
        ListNode cur = a;
        while (cur != b) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }

    /**
     * 27.移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     *
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     *
     * 注意这五个元素可为任意顺序。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *  
     *
     * 说明:
     *
     * 为什么返回数值是整数，但输出的答案是数组呢?
     *
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     *
     * 你可以想象内部操作如下:
     *
     * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
     * int len = removeElement(nums, val);
     *
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9p1iv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                i++;
                j--;
                continue;
            }
            if (nums[i] != val) {
                i++;
            }
            if (nums[j] == val) {
                j--;
            }
        }
        return i;
    }

    /**
     * 47. 全排列 II
     *
     * 给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backTrackUnique(nums, track, res, 0, vis);
        return res;
    }

    /**
     * 回溯算法(按下标回溯)
     * @param nums          数据
     * @param trackIndex    记录路径下标
     * @param res           结果
     */
    private void backTrackUnique(int[] nums, List<Integer> trackIndex,
                                 List<List<Integer>> res, int idx, boolean[] vis) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(trackIndex));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            } else if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                // 保证每次访问重复元素的时候，都是按照顺序访问第一个未被访问到的元素
                continue;
            }
            trackIndex.add(nums[i]);
            vis[i] = true;
            backTrackUnique(nums, trackIndex, res, idx + 1, vis);
            vis[i] = false;
            trackIndex.remove(idx);
        }
    }
}
