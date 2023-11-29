package org.D_LinkedList;

/**
 * example 1: given the head of a linked list with
 * an odd number of nodes, head, return the value of
 * the node in the middle
 *
 * for example, given a linked list that represents
 * 1->2->3->4->5, return 3
 *
 * 思路，快慢同时走，快走到底时，慢刚好走了一半
 */
public class FastSlowPtrE1 {
    public int findMid(ListNode head) {
        var slow = head;
        var fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
}
