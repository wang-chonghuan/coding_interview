package org.D_LinkedList;

/**
 * 反转一个单链表
 * 思路是把每个元素的next指针指向它的前一个元素
 */
public class ReserveE0 {
    ListNode reverseList(ListNode head) {
        var cur = head;
        ListNode left = null;
        while(cur != null) {
            // 关注左，中，右三个指针
            // 先保存右，再开始交换
            var right = cur.next;

            cur.next = left;
            left = cur;
            cur = right;
        }
        return left;
    }
}
