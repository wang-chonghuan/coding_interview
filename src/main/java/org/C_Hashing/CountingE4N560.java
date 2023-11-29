package org.C_Hashing;

import java.util.HashMap;

/*
example 4: 560 subarray sum equals k
given an integer array nums and an integer k
find the number of subarrays whoe sum is equal to k

 * 和等于k的子数组的个数
 * 如果两个前序的差等于k,那么这两个序数之间的子数组的和就等于k
 * 问题转化为,有哪些前序和的差等于k
 * 问题再转化为,对于一个前序和s,看看s-k是否存在

 */
public class CountingE4N560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0; // 用于计数和为 k 的子数组的数量
        int sum = 0; // 存储到当前位置的数组和。
        var map = new HashMap<Integer, Integer>(); // 用于存储某个和（sum）在数组中出现的次数。
        map.put(0, 1); // 和为0的子数组数量应该被计为1个（我们可以认为这个子数组是空的）
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 对于一个前序和s,看看s-k是否存在
            if(map.containsKey(sum - k)) {
                // 如果s-k也存在，就说明该子数组存在
                // 增加的数量应该是 sum - k 这个值出现的次数，因为这些位置的子数组和都是 k。
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
