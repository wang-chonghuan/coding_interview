package org.C_Hashing;

import java.util.HashMap;

/*
1426 Counting Elements
given an integer array arr, count how many elements x there are,
such that x+1 is also in the array
if there are duplicates in arr, count them separately
 */
public class CheckExistP3N1426 {
    public int countElements(int[] arr) {
        int cnt = 0;
        var elemFreqMap = new HashMap<Integer, Integer>();
        for(var elem: arr) {
            elemFreqMap.put(elem, elemFreqMap.getOrDefault(elem, 0) + 1);
        }
        for(var e : arr) {
            if(elemFreqMap.containsKey(e) && elemFreqMap.containsKey(e + 1)) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
