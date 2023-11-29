package org.A_ArraysAndStrings;

import java.util.Arrays;

/**
 * example4: given an integer array nums and an integer k,
 * find the sum of the subarray with the largest sum whose length is k
 * 这一题的窗口是固定的，滑动窗口，每次加上新的数，减去老的数，就得到了当前窗口的和
 * 求出最大的就行了，要注意的是，该数组一共可以容纳几个窗口
 */
public class SlidingWindowE4 {
    public int maxSubarrSum(int[] nums, int k) {
        int n = nums.length;
        if(n <= k) { // 如果窗口比数组大，那么子数组最大和就是数组的和
            return Arrays.stream(nums).sum();
        }
        int maxSum = 0;
        for(int i = 0; i < k; i++) { // 计算初始的窗口的和
            maxSum += nums[i];
        }
        int left = 0;
        for(int right = k; right < n; right++) { // 向右滑动窗口
            int newMaxSum = maxSum + nums[right] - nums[left];
            maxSum = Math.max(maxSum, newMaxSum);
            left++;
        }
        return maxSum;
    }
}
