package org.A_ArraysAndStrings;

public class TopEasyN136SingleNumber {
    public int findSingleNumber(int[] arr) {
        var xorResult = 0;
        for(var e : arr) {
            xorResult = xorResult ^ e;
        }
        return xorResult;
    }
}
