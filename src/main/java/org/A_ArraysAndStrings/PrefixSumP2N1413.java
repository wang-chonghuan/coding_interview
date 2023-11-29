package org.A_ArraysAndStrings;

/**
 * given an array of integers nums,
 * you start with an initial positive value startValue
 *
 * in each iteration, you calculate the step by step
 * sum of startValue plus elements in nums (from left to right)
 *
 * return the minimum positive value of startValue
 * such that the step by step sum is never less than 1
 *
 * 总结2：找到最小的startValue（默认是正整数），使得加得过程中，sum永远大于等于1
 */

public class PrefixSumP2N1413 {
    public int minStartValue(int[] nums) {
        // 先计算前N项和
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        // 从最小的startValue开始遍历，也就是1，然后针对每个会导致sum小于1的元素，都来检验一下
        // 检验的方法是取一个大的
        int minStarter = 1;
        for(int pre : prefixSums) {
            if(pre < 0) {
                minStarter = Math.max(-1 * pre + 1, minStarter);
            }
        }
        return minStarter;
    }
}
