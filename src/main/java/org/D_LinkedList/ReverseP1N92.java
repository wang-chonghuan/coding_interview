package org.D_LinkedList;

/**
 * given the head of a singly linked list
 * and two integers left and right, where left <= right
 * reverse the nodes of the list from position left
 * to position right, and return the reversed list
 */
public class ReverseP1N92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode leftSentry = dummy, rightSentry = null;
        ListNode leftNode = null, rightNode = null;
        int curPos = 1;
        ListNode preNode = dummy;
        ListNode curNode = head;
        // 先遍历这个链表定位到区间的两端
        while(curNode != null) {
            if(curPos == left) {
                leftNode = curNode;
                leftSentry = preNode;
            }
            if(curPos == right) {
                rightNode = curNode;
                rightSentry = rightNode.next;
                break;
            }
            curPos++;
            preNode = curNode;
            curNode = curNode.next;
        }

        // 反转中间这一段
        if(rightNode == null) {
            return head;
        }
        var prev = leftSentry;
        var cur = leftNode;
        while(cur != rightSentry) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // 最后按照合理顺序把反转的一段插回去
        leftSentry.next = rightNode;
        leftNode.next = rightSentry;
        return dummy.next;
    }
}




