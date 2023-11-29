package org.A_ArraysAndStrings;

import java.util.*;

public class TopEasyN350IntersectionOfTwoArraysII {
    int[] intersection(int[] nums1, int[] nums2) {
        var map1 = new HashMap<Integer, Integer>();
        for(var e1 : nums1) {
            map1.put(e1, map1.getOrDefault(e1, 0) + 1);
        }
        var map2 = new HashMap<Integer, Integer>();
        for(var e2 : nums2) {
            map2.put(e2, map2.getOrDefault(e2, 0) + 1);
        }
        var resultList = new ArrayList<Integer>();
        for(var key : map1.keySet()) {
            var count1 = map1.get(key);
            var count2 = map2.getOrDefault(key, 0);
            var count = Math.min(count1, count2);
            for(int i = 0; i != count; i++) {
                resultList.add(key);
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
