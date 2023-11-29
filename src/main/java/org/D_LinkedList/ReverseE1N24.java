package org.D_LinkedList;

/**
 * 24. Swap Nodes in Pairs
 * Given the head of a linked list,
 * swap every pair of nodes.
 * For example, given a linked list
 * 1 -> 2 -> 3 -> 4 -> 5 -> 6,
 * return a linked list 2 -> 1 -> 4 -> 3 -> 6 -> 5.
 * 思路,一个链表有很多对,奇数链表最后多一个,不用管
 *
 */
public class ReverseE1N24 {
    public ListNode swapPairs(ListNode head) {
        // dummy nodes acts as
        // the prevNode for the head node
        // of the list and hence stores pointer
        // to the haed node
        ListNode dummy = new ListNode(-1, head);
        ListNode prevNode = dummy;
        while((head != null) && (head.next != null)) {
            // nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            // swapping
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prevNode.next = secondNode;
            // 迭代
            prevNode = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
