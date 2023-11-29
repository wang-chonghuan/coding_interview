package org.C_Hashing;

import java.util.HashMap;

/*
3 longest substring without repeating characters

given a string s, find the length of the longest substring without repeating character.
 */
public class MoreP3N3 {
    public int lengthOfLongestSubstring(String s) {
        var charMap = new HashMap<Character, Integer>();
        int maxLength = 0;
        for(int left = 0, right = 0; right < s.length(); right++) {
            var charRight = s.charAt(right);
            charMap.put(charRight, charMap.getOrDefault(charRight, 0) + 1);
            /*
            可能的NullPointerException来源于这一行的charMap.get(charRight)，在你使用remove代替put来减少计数的原始版本中。如果您调用remove方法，那么这个字符的计数就完全从charMap中移除了。那么当这行代码尝试获取该字符的计数时，它将返回null而非0，导致尝试访问null对象的int值时抛出NullPointerException。
            while(charMap.get(charRight) > 1) {
             */
            while(charMap.get(charRight) > 1) {
                var charLeft = s.charAt(left);
                //! 不要remove charMap.remove(charLeft);
                charMap.put(charLeft, charMap.get(charLeft) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
