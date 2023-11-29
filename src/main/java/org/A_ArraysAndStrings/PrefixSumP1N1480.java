package org.A_ArraysAndStrings;

/**
 * given an array of nums, we define a running sum of an array
 * as runningSum[i] = sum(nums[0]...nums[i])
 * return the running sum of nums
 * 总结2：某一项的前缀和，是它前一项的前缀和加上当前元素得到的。
 */
public class PrefixSumP1N1480 {
    public int[] runningSum(int[] nums) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        return prefixSums;
    }
}
