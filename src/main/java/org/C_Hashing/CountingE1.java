package org.C_Hashing;

import java.util.HashMap;

/*
example 1
you are given a string s and an integer k.
find the length of the longest substring that contains at most k distinct characters
这题的思路是滑动窗口，右侧扩张，违背条件了减少左侧
 */
public class CountingE1 {
    public int maxSubstring(String s, int k) {
        var freqMap = new HashMap<Character, Integer>();
        int left = 0, right = 0, ans = 0;
        for(right = 0; right < s.length(); right++) {
            var c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            while(freqMap.size() > k) {
                var cLeft = s.charAt(left);
                int freqLeft = freqMap.get(cLeft);
                if(freqLeft == 1) {
                    freqMap.remove(cLeft);
                } else {
                    freqMap.put(cLeft, freqLeft - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

}
