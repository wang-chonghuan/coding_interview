package org.C_Hashing;

import java.util.HashMap;

/*
given an integer array nums, return the largest integer that only once. if no integer occurs once, return -1
 */
public class CountingP2N1133 {
    public int largestUniqueNumber(int[] nums) {

        // 先算出每个的频率，再找到频率为1的最大值
        var freqMap = new HashMap<Integer, Integer>();
        for(var e : nums) {
            freqMap.put(e, freqMap.getOrDefault(e, 0) + 1);
        }

        int result = -1;
        for(var entry: freqMap.entrySet()) {
            if(entry.getValue() == 1) {
                result = Math.max(result, entry.getKey());
            }
        }

        return result;
    }
}
