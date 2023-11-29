package org.B_StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

 You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

 For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

 Return an array ans of length nums1.length such that ans[i] is the next greater element as described above

 Subarray子数组要求元素连续。
 Subsequence子序列不要求元素连续，但要求保持原始顺序。
 Subset子集不要求元素连续，也不要求保持原始顺序。
-------------------------------------------------------
 题目的要求是：

 给定两个数组nums1和nums2。
 nums1是nums2的子集。
 对于nums1中的每个元素，我们需要找到它在nums2中的对应位置j。
 接着，我们需要找到数组nums2在位置j处元素的下一个更大元素。
 如果存在这样的一个更大元素，则将它加入到结果数组ans中。如果不存在（即该元素右侧没有比它更大的元素），则将-1加入到结果数组ans中。
 目标是返回这个结果数组ans。

 示例：

 plaintext
 Copy code
 nums1 = [4,1,2], nums2 = [1,3,4,2].
 返回的结果应为 [-1,3,-1]，因为：

 对于nums1中的4，它在nums2中没有下一个更大的元素，所以ans[0] = -1。
 对于nums1中的1，它在nums2中的下一个更大的元素是3，所以ans[1] = 3。
 对于nums1中的2，它在nums2中没有下一个更大的元素，所以ans[2] = -1。

 */
public class MonotonicP1N496 {
    public int[] nextGreaterElement(int[] subset, int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>(); // 这是一个栈顶最小栈，栈底最大
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            // 当前元素如果比栈顶大，就把栈顶弹出，一直弹出，维持栈的单调性，栈底最大
            // 弹出的时候，说明该元素遇到了NextGreater，因此要记录到map中
            while(!stack.isEmpty() && nums[i] > stack.peekLast()) {
                map.put(stack.removeLast(), nums[i]);
            }
            stack.addLast(nums[i]);
        }

        int[] res = new int[subset.length];
        for(int i = 0; i < subset.length; i++) {
            // 遍历完，没遇到最大的元素就记-1
            res[i] = map.getOrDefault(subset[i], -1);
        }
        return res;
    }
}
