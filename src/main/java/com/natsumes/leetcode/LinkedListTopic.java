package com.natsumes.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hetengjiao
 */
public class LinkedListTopic {

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
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return head.next;
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
            if (cur.val == pre.val) {
                cur = cur.next;
            } else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
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
     * -105 <= Node.val <= 105
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
     * todo: 递归
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
     * 0 <= Node.val <= 100
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
        //todo
        return null;
    }
}
