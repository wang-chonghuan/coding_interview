package org.C_Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
given a 2D array nums that contains n arrays of distinct integers,
return a sorted array containing all the numbers that appear in all n arrays

 * For example, given nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]],
 * return [3, 4].
 * 3 and 4 are the only numbers that are in all arrays.

 思路：全部放到map里， 找到频率等于数组个数的数字
 */
public class CountingE2N2248 {
    public List<Integer> intersection(int[][] nums) {
        var ret = new ArrayList<Integer>();
        var freq = new HashMap<Integer, Integer>();
        for(var i = 0; i < nums.length; i++) {
            for(var j = 0; j < nums.length; j++) {
                freq.put(nums[i][j], freq.getOrDefault(nums[i][j], 0) + 1);
            }
        }

        for(int num: freq.keySet()) {
            if(freq.get(num) == nums.length) {
                ret.add(num);
            }
        }

        Collections.sort(ret);
        return ret;
    }
}
