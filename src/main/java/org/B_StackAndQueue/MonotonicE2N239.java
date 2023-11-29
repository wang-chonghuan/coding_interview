package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239 sliding window maximum
 *
 * given an integer array nums and an integer k, there is a sliding window of size k
 * that moves from the very left to the very right.
 * for each window, find the maximum element in the window
 *
 * For example, given nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3, return [3, 3, 5, 5, 6, 7 ]
 * The first window is [1, 3, -1]
 * and the last window is [3, 6, 7]
 *
 * 在"Sliding Window Maximum"问题的解决方案中，我们使用一个双端队列来在给定数组的每个长度为\( k \)的滑动窗口中找到最大值。我们遍历输入数组的每一个元素，为了保持队列的单调递减性，我们总是在添加新元素到队列之前，从队列尾部移除所有小于新元素的元素。这样，队列的头部总是保持着当前滑动窗口中的最大值。当处理到数组的第\( k \)个元素及其后的元素时，我们开始将每个窗口的最大值（即队列的头部元素）保存到一个结果数组中。同时，我们还要检查队列头部的元素是否仍在新的滑动窗口范围内，如果不在，我们就将其从队列中移除。最后，返回包含所有滑动窗口最大值的结果数组。整个算法只需要进行一次线性遍历，所以时间复杂度为O(n)。
 *
 *
 *
 */

public class MonotonicE2N239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1]; // 队列的数量
        // 存储数组 nums 的元素的下标。它的特性是队列中的元素总是单调递减的，
        // 这样 queue 队首就总是当前滑动窗口的最大值的下标。
        Deque<Integer> queue = new ArrayDeque<>(); // 空的双端队列（头部最大，尾部最小）

        for(int i = 0; i < nums.length; i++) {
            // step 1 保持队列的单调性
            // 当队列非空，且新遍历到的元素 nums[i] 大于队列尾部元素 nums[queue.getLast()] 时，
            // 我们从队列尾部移除元素。这个步骤保证了队列中的元素始终保持单调递减。
            //将新元素 i 的下标添加到队列尾部。

            /**
             * 把大元素插入队尾，把比它小的都删除。为什么不把大元素插入队的中间呢，不用删除比它小的元素。
             * 因为新插入的这个大元素，自动淘汰了比它小的那些元素，那些元素随着窗口的滑动，一定会比该大元素先过期，因此没必要保留。
             * 滑动窗口在未来的移动中，这些较小的元素不可能成为最大元素，它们会在当前的大元素之前离开窗口（过期）。简单来说，一旦一个更大的元素进入队列，那些较小的元素就不再有可能成为窗口中的最大值了。因此，我们没有理由保留它们
             *
             */

            while(!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);

            // step 2 移除过期元素
            // 如果队首元素（即当前滑动窗口最大值的下标）加上 k 等于 i，
            // 那么它就不在下一个窗口内，我们需要将其从队列中移除。
            if(queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            // step 3 收集结果
            // 当窗口达到k时，添加一次结果，仅一次
            if(i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
