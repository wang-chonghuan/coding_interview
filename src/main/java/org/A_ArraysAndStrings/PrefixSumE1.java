package org.A_ArraysAndStrings;

/**
 * example1: given an integer array nums,
 * an array queries where queries[i] = [x, y]
 * and an integer limit,
 * return a boolean array that represents the answer to each query
 * a query is true if the sum of the subarray from x to y is less than limit,
 * or false otherwise
 *
 * for example, given nums = [1, 6, 3, 2, 7, 2]
 * and queries = [[0, 3], [2, 5], [2, 4]] and limit = 13,
 * the answer is [true, false, true]
 * for each query, the subarray sums are [12, 14, 12]
 *
 * 总结1：这题的难点在于，算sum的时候，只算差值还不行，还要把左端加回去，因为算差值时被减掉了
 * 一定要对例子中的数值手算一遍，这个是前缀算区间的正确方法
 *
 * 总结2：先计算前缀和，再利用前缀和计算区间和，计算区间和注意把首项加回去
 */
public class PrefixSumE1 {
    public boolean[] queryByPrefixSum(int[] nums, int[][] queries, int limit) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        boolean[] res = new boolean[queries.length];
        for(int q = 0; q < queries.length; q++) {
            int delta = prefixSums[queries[q][1]] - prefixSums[queries[q][0]];
            int sum = delta + nums[queries[q][0]];
            res[q] = sum < limit ? true : false;
        }
        return res;
    }
}

