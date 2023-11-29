package org.D_LinkedList;

/**
 * given the head of a sorted linked list
 * delete all duplicates
 * such that each element appears only once
 * return the linked list sorted as well
 *
 * 基本思路，关键是该链表是排序的
 * 用两个指针，快指针先走，如果和慢指针指向一样，
 * 就删除快指针的节点，快指针继续走
 * 如果指的不一样，那么慢指针走一格
 * 就是说慢指针停在重复的第一个位置，然后快指针把重复段删完
 */
public class FastSlowPtrP2N83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

}
