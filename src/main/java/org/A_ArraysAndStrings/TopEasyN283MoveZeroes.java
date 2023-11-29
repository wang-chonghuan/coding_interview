package org.A_ArraysAndStrings;

public class TopEasyN283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int beginZeroSection = len;
        while(cur < beginZeroSection) {
            if(nums[cur] == 0) {
                beginZeroSection -= 1;
                for(int i = cur; i < beginZeroSection; i++) {
                    nums[i] = nums[i + 1];
                }
                nums[beginZeroSection] = 0;
            } else { // 在这个修正版中，当 nums[cur] 为零时，不增加 cur，因此如果移动到 cur 位置的新元素也是零，那么在下一次循环迭代中会继续处理这个新的零元素。如果 nums[cur] 不是零，那么我们就安全地增加 cur 的值，继续检查下一个元素。
                cur++;
            }
        }
    }
}
