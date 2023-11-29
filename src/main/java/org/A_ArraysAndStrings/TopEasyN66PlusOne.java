package org.A_ArraysAndStrings;

public class TopEasyN66PlusOne {
    int[] plusOne(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            if(digits[i] == 9) {
                digits[i] = 0;
            }
        }
        if(digits[0] == 0) {
            int[] result = new int[len + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, len);
            return result;
        } else {
            return digits;
        }
    }
}
