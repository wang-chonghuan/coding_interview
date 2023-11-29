package org.C_Hashing;

import java.util.HashSet;

public class MoreP2N771 {
    public int numJewelsInStones(String jewels, String stones) {
        var count = 0;
        var jewelSet = new HashSet<Character>();
        for(var c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        for(var cStone : stones.toCharArray()) {
            if(jewelSet.contains(cStone)) {
                count ++;
            }
        }
        return count;
    }
}
