package org.C_Hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
268 missing number
given an array nums containing n distinct numbers
in the range [0,n](n+1 numbers)
return the only number in the range that is missing from the array

 */
public class CheckExistP2N268 {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<>(Arrays.stream(nums).boxed().toList());
        for(int i = 0; i <= nums.length; i++) {
            if(!numSet.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
