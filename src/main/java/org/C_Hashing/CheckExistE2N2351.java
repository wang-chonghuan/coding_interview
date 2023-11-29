package org.C_Hashing;

import java.util.HashSet;

/**
 * example 2: 2351 first letter to appear twice
 * given a string s, return the first character to appear twice
 * it is guaranteed that the input will have a duplicate character
 */
public class CheckExistE2N2351 {
    public char findFirstTwice(String s) {
        var charSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(charSet.contains(s.charAt(i))) {
                return s.charAt(i);
            } else {
                charSet.add(s.charAt(i));
            }
        }
        return 0;
    }
}
