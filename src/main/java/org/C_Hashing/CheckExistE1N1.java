package org.C_Hashing;

import java.util.HashMap;

/*
1 two sum
given an array of integers nums and an integer target
return indices of two numbers such that they add up to target
you cannot use the same index twice

 */
public class CheckExistE1N1 {
    public int[] twoSum(int[] nums, int target) {
        // 遍历过的数字和它对应的下标
        var numIndexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int complete = target - nums[i];
            // 如果找到了它的补数，说明满足了
            // 如果没找到，就把原数放进map
            if(numIndexMap.containsKey(complete)) {
                int completeIndex = numIndexMap.get(complete);
                return new int[]{i, completeIndex};
            } else {
                numIndexMap.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
