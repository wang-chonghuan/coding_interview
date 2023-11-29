package org.A_ArraysAndStrings;

/**
 * given an integer array nums sorted in non-decreasing order
 * return an array of the squares of each number sorted in non-decreasing order
 * 注意该数组的左边是负数部分，右边是正数部分，其平方是两头大中间小，可以用两指针
 */
public class TwoPointersP2N977 {
    public int[] sortedSquareArr(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int sqrLeft = nums[left] * nums[left];
            int sqrRight = nums[right] * nums[right];
            if(sqrLeft >= sqrRight) {
                res[i] = sqrLeft;
                left++;
            } else {
                res[i] = sqrRight;
                right--;
            }
        }
        return res;
    }
}
