package org.D_LinkedList;

/**
 * 876 middle of the linked list
 * given the head of a singly linked list,
 * return the middle node of the linked list
 *
 * if there are two middle nodes,
 * return the second one
 *
 */
public class FastSlowPtrP1N876 {
    // 标准答案里fast一定能到最后一个位置,
    // 这就保证了slow能到偶数的第二个中间数!
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        var fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
