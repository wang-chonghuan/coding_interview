package org.A_ArraysAndStrings;

import java.util.Arrays;

public class TopEasyN189RotateArray {
    public void rotateArray(int[] arr, int k) {
        var len = arr.length;
        if(k <= 0 || len <= 1) {
            return;
        }
        var rightLen = k % len;
        var leftLen = len - k;
        var rightIndex = leftLen;
        int[] rightTemp = new int[rightLen];
        rightTemp = Arrays.copyOfRange(arr, rightIndex, len - 1);

    }
}
