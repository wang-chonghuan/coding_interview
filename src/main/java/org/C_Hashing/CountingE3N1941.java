package org.C_Hashing;

import java.util.HashMap;

/*
example 3: 1941
check if all characters have equal number of occurrences

given a string s, determine if all characters have the same freq

判断一组数是否相等,可以把他们放入一个集合里,如果集合元素是1,就相等
 */
public class CountingE3N1941 {
    public boolean areOccurrencesEqual(String s) {
        var freqMap = new HashMap<Character, Integer>();
        for(var c: s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        var commonFreq = freqMap.values().stream().findAny().get();
        for(var freq : freqMap.values()) {
            if(freq != commonFreq) {
                return false;
            }
        }
        return true;

    }
}
