package org.A_ArraysAndStrings;

/**
 * example 2: given a sorted array of unique integers and a target integer,
 * return true if there exists a pair of numbers that sum to target,
 * false otherwise. this problem is similar to two sum
 *
 * for example
 * given nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13
 * return true bcz 4+9=13
 */
public class TwoPointersE2 {
    public boolean existsPairSumToTar(int[] nums, int tar) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int curSum = nums[left] + nums[right];
            if(curSum == tar) {
                return true;
            }
            if(curSum > tar) { // 如果大，就减小，就移动右端
                right--;
                continue;
            }
            if(curSum < tar) { // 如果小，就变大，就移动左端
                left++;
                continue;
            }
        }
        return false;
    }
}
