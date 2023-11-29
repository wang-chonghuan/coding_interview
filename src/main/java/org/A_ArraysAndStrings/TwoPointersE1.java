package org.A_ArraysAndStrings;

/**
 * example1 return true if a given string is a palindrome, false otherwise
 * 两个指针，左指针指头，右指针指尾，比较其字符是否相等，不想等马上返回错
 * 相当的话，让两个指针靠近，继续比较，直到两指针相遇
 * 注意，不用管元素数量是奇数个还是偶数个
 */
public class TwoPointersE1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
