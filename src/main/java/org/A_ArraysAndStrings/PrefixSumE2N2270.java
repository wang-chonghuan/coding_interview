package org.A_ArraysAndStrings;

/**
 * Example 2: 2270, Number of Ways to Split Array
 * given an integer array nums,
 * find the number of ways to split the array into two parts
 * so that the first section has a sum greater than or equal to the sum of the second section
 * the second section should at least have one number
 * 这题的重点，在于算int的加总时，可能会溢出，所以一定要用long做前项和数组，而不能只用int
 * 总结2：用前缀和快速计算每一半的元素之和，后半部的前缀和可以用减法计算出来
 */
public class PrefixSumE2N2270 {
    public int numWaysSplit(int[] nums) {
        int numWays = 0;
        long[] prefixSums = new long[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        // pivot是左数组的右端点，因为右半部分必须至少一个元素，所以边界用nums.length - 1
        for(int pivot = 0; pivot < nums.length - 1; pivot++) {
            long sumLeft = prefixSums[pivot];
            long sumRight = prefixSums[nums.length - 1] - prefixSums[pivot];
            if(sumLeft >= sumRight) {
                numWays++;
            }
        }
        return numWays;
    }
}
