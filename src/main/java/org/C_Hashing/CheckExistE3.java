package org.C_Hashing;

import java.util.*;

/*
example 3: given an integer array nums
find all the numbers x that satisfy the following
x + 1 is not in nums and x - 1 is not in nums
 */
public class CheckExistE3 {
    public List<Integer> findXs(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>(Arrays.stream(nums).boxed().toList());
        for(var num: nums) {
            if(!numSet.contains(num - 1) && !numSet.contains(num + 1)) {
                res.add(num);
            }
        }
        return res;
    }
}
