package org.D_LinkedList;

/**
 * example 3: given the head of a linked list
 * and an integer k,
 * return the kth nod from the end
 *
 * for example given the linked list that represents
 * 1-2-3-4-5 and k=2
 * return the node with value 4, as it is the 2nd node
 * from the end
 *
 * 思路：用两个相同速度的指针，但是f指针比s指针靠前了k个位置
 * 这样f指针到底时，s指针就指向了desired position
 */
public class FastSlowPtrE3 {
    public ListNode kFromEnd(ListNode head, int k) {
        var fast = head;
        var slow = head;
        // 先让fast比slow领先k个位置
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
