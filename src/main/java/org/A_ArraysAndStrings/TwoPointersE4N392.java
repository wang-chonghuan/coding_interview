package org.A_ArraysAndStrings;

/**
 * example 4: 392 Is Subsequence
 *
 * given two strings s and t, return true if s is a subsequence of t,
 * or false otherwise
 *
 * a subsequence of a string is a new string that is formed
 * from the original string by deleting some(can be none)
 * of the characters without disturbing the relative positions
 * of the remaining characters
 * the fact that they are not consecutive doesn't matter
 *
 * 双指针，同时遍历两个字符串，如果s的指针对应的字符，等于t的指针对应的字符，那么去匹配下一个s
 * 此时两个指针都移动
 * 如果不匹配，那么移动s指针，不动t指针。如果s指针移动到末尾还没匹配到当前的t指针，那么匹配失败。
 * 如果t指针全部遍历完，说明全部匹配了，那么就匹配成功了。
 */
public class TwoPointersE4N392 {
    public boolean isSubseq(String s, String t) {
        int iSubseq = 0;
        int iOriseq = 0;
        while(iOriseq < t.length() && iSubseq < s.length()) {
            if(s.charAt(iSubseq) == t.charAt(iOriseq)) {
                iSubseq++;
                iOriseq++;
            } else {
                iOriseq++;
            }
        }
        return iSubseq == s.length();
    }
}
