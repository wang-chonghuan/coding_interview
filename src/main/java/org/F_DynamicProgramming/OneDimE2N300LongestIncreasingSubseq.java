package org.F_DynamicProgramming;

import java.util.Arrays;

/*
300 longest increasing subsequence
given an integer array nums, return the length of the longest strictly increasing subsequence
找出一个无序整数数组中最长的严格递增的子序列的长度


不，子序列（subsequence）在原数组中的元素不需要是连续的。只需要保持相对的顺序不变。例如，\[3, 5\] 和 \[3, 4, 7\] 都是数组 \[3, 4, 5, 7\] 的子序列。

与此相对的概念是子数组（subarray）或子串（substring），这两个术语通常用于描述原数组或字符串中的一段连续的部分。例如，在数组 \[3, 4, 5, 7\] 中，\[4, 5\] 是一个子数组和子序列，而 \[3, 7\] 只是一个子序列。


 */
public class OneDimE2N300LongestIncreasingSubseq {
    // 记忆化数组，用于存储子问题的结果
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        // 初始化记忆化数组，值设置为-1表示该位置的值还未计算过
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        int maxLength = 0;
        // 从每一个位置开始寻找最长递增子序列
        for(int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, findLIS(nums, i));
        }
        return maxLength;
    }

    // 递归函数，用于查找从index位置开始的最长递增子序列的长度
    private int findLIS(int[] nums, int index) {
        // 如果这个值计算过，直接从memo数组中返回
        if(memo[index] != -1) {
            return memo[index];
        }

        int maxLength = 1; // 至少包含自己

        // 递归查找所有可以跟在nums[index]后面的递增子序列
        for(int nextIndex = index + 1; nextIndex < nums.length; nextIndex++) {
            if(nums[nextIndex] > nums[index]) {
                maxLength = Math.max(maxLength, findLIS(nums, nextIndex) + 1);
            }
        }

        memo[index] = maxLength;
        return maxLength;
    }
}




