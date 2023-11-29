package org.Z;

import java.util.HashMap;

public class N238 {
    public int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var prefixArray = new int[n];
        var suffixArray = new int[n];
        var ans = new int[n];
        for(var i = 0; i < n; i++) {
            if(i == 0) {
                prefixArray[0] = 1;
            } else {
                var prefix = prefixArray[i - 1] * nums[i - 1];
                prefixArray[i] = prefix;
            }

            var j = n - i - 1;
            if(j == n - 1) {
                suffixArray[n - 1] = 1;
            } else {
                var suffix = suffixArray[j + 1] * nums[j + 1];
                suffixArray[j] = suffix;
            }
        }
        for(var k = 0; k < n; k++) {
            ans[k] = prefixArray[k] * suffixArray[k];
        }
        return ans;
    }
}
