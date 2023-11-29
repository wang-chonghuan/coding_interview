package org.A_ArraysAndStrings;

/**
 * given an array of positive integers nums, and an integer k
 * find the length of the longest subarray whose sum is less than or equal to k
 *
 * 这一题是从一个数组中，找到长度最大的子串，但是其和要小于k
 * 方法是，不断向右扩大窗口，如果和大于k，就不断在左侧缩小窗口，记下此时窗口的大小
 */
public class SlidingWindowE1 {
    public int maxLenUnderK(int[] nums, int k) {
        int left = 0;
        int curSum = 0;
        int maxLen = 0;
        for(int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum > k) {
                curSum -= nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
