package org.D_LinkedList;

/*
in a linked list of size n, where n is even
the ith node (0 indexed) of the linked list
is known as the win of the (n-1-i)th node
if 0<=i<=n/2-1
for example if n=4 then node 0 is the twin of node 3
and node 1 is the twin of node 2.
these are the only nodes with twins for n = 4
the twin sum is defined as the sum of a node and its twin

given the head of a linked list with even length
return the max twin sum of the linked list

整体思路就是翻转原链表的后面部分，
然后两个指针分别从两个链表的头开始加
 */
public class ReverseE2N2130 {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // get middle of the linked list
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse the second half of the linked list
        // 其实这样把后半个链表破坏了，prev最后变成头
        // 其实就是原链表的尾
        ListNode nextNode, prev = null;
        while(slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maximumSum = 0;
        while(prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }
        return maximumSum;
    }
}
