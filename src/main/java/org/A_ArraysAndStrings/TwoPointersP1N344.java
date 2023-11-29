package org.A_ArraysAndStrings;

/**
 * write a function that reverses a string
 * the input string is given as an array of characters s
 * you must do this by modifying the input array in-place with o1 extra memory
 *
 * while的判断用小于，不要用!=，否则会越界
 * 不用考虑奇数个还是偶数个，头尾两个指针，交换，向中间趋近
 */
public class TwoPointersP1N344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
