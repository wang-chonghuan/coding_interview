package org.D_LinkedList;

/**
 * example 2: 141 linked list cycle
 * given the head of a linked list,
 * determine if the linked list has a cycle
 *
 * there is a cycle in a linked list
 * if there is some node in the list
 * that can be reached again by
 * continuously following the next pointer
 *
 * 基本思想：
 * 使用两个指针，一个运动速度是另一个的2倍。
 * 如果链表中不存在环，快指针（fast）将首先达到链表的尾部。
 * 如果链表中存在环，快指针（fast）最终会追上慢指针（slow），因为它们每一轮都会离慢指针更近一步。
 */
public class FastSlowPtrE2 {
    public boolean findCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果有环,慢指针会跑到快指针前面去
            // 快指针又会追上慢指针
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
