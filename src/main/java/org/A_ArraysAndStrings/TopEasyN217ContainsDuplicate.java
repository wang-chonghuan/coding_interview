package org.A_ArraysAndStrings;

import java.util.HashSet;

public class TopEasyN217ContainsDuplicate {
    public boolean containsDuplicate(int[] arr) {
        var set = new HashSet<Integer>();
        for(var e : arr) {
            if(set.contains(e)) {
                return false;
            } else {
                set.add(e);
            }
        }
        return true;
    }
}
