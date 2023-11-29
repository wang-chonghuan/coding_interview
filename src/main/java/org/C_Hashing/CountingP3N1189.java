package org.C_Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
given a string text, you want to use the characters of text form as many instances of the word balloon as possible
you can use each character in text at most once
return the max number of instances that can be formed

 */
public class CountingP3N1189 {
    public int maxNumOfBalloon(String s) {
        var balloon = new HashMap<Character, Integer>();
        balloon.put('b', 0);
        balloon.put('a', 0);
        balloon.put('l', 0);
        balloon.put('o', 0);
        balloon.put('n', 0);
        for(var c : s.toCharArray()) {
            if(balloon.containsKey(c)) {
                balloon.put(c, balloon.get(c) + 1);
            }
        }
        balloon.put('o', balloon.get('o') / 2);
        balloon.put('l', balloon.get('l') / 2);
        int minFreq = Integer.MAX_VALUE; // 将minFreq初始化为最大整数值
        for(var entry : balloon.entrySet()) {
            minFreq = Math.min(minFreq, entry.getValue());
        }
        return minFreq;
    }
}
