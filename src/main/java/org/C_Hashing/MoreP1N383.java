package org.C_Hashing;

import java.util.HashMap;

/*
given two strings ransomNote and magazine
return true if ransomNote can be constructed
by using letters from magazine and false otherwise
each letter in magazine can only be used once in ransomNote

 */
public class MoreP1N383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        var freqMap = new HashMap<Character, Integer>();
        for(var c : magazine.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for(var cTar : ransomNote.toCharArray()) {
            var cSrc = freqMap.getOrDefault(cTar, 0);
            if(cSrc == 0) {
                return false;
            } else {
                freqMap.put(cTar, cSrc - 1);
            }
        }
        return true;
    }
}
