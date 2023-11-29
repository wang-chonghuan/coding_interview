package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * example 3: 1438
 * longest continuous subarray with absolute diff less than or equal to limit
 *
 * given an array of integers nums and an integer limit,
 * return the size of the longest subarray
 * such that the absolute difference between any two elements of this subarray
 * is less than or equal to limit
 */

public class MonotonicE3N1438 {
    public int longestSubarrayWithDiffLimit(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>(); // 单调递减，队首是最大元素
        Deque<Integer> mind = new ArrayDeque<>(); // 单调递增，队首是最小元素
        int i = 0, j;
        for(j = 0; j < A.length; ++j) {
            while(!maxd.isEmpty() && A[j] > maxd.peekLast()) {
                maxd.removeLast(); // 在最大队列中，如果遇到更大的（相对队尾），就把次大的全删了
            }
            maxd.addLast(A[j]); // 更大的追加进去
            while(!mind.isEmpty() && A[j] < mind.peekLast()) {
                mind.removeLast(); // 在最小队列中，如果遇到更小的（相对队尾），就把次小的全删了
            }
            mind.addLast(A[j]); // 更小的追加进去

            // 检查窗口中最大元素和最小元素的差值是否超过limit
            if(maxd.peekFirst() - mind.peekFirst() > limit) {
                i++; // 缩小窗口的左端
                // 缩小窗口的左端后，如果原左端刚好是队首，就要把它从队列中移除
                /**
                 * 若 A[i] 不是队首元素，这表示即便 A[i] 从窗口中移除，由于其不是当前窗口的最大值或最小值（因为它不在队首），它的移除不会影响当前窗口中的最大值或最小值。因此，我们不需要立即将其从队列中移除，队首元素仍旧保持当前窗口的最大值或最小值。
                 *
                 * 另外一方面，在将来的某个时刻当我们添加新的元素进入队列时，我们会确保队列的单调性。在添加新元素的同时，我们会从队尾移除所有比新添加元素小（对于 maxd）或大（对于 mind）的元素。这样，如果 A[i] 还在队列中但位于新添加元素的后面，它将在这一步被移除，以保持队列的单调性。在实际操作中，我们并不关心队列中除了队首之外的其他元素是否仍属于当前窗口，因为由于队列的单调性，它们不会影响我们的结果。
                 *
                 */
                if(maxd.peekFirst() == A[i])
                    maxd.removeFirst();
                if(maxd.peekFirst() == A[i])
                    maxd.removeFirst();
            }
        }
        return j - i; // 这就是窗口的最大值
    }
}
