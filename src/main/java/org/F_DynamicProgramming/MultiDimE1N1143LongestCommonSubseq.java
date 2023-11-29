package org.F_DynamicProgramming;

import java.util.Arrays;

/*

最长公共子序列（Longest Common Subsequence, LCS）问题的实现。这个问题的目标是找到两个字符串 text1 和 text2 的最长公共子序列的长度。一个字符串序列 S 的子序列是字符串 S 删除一些（或不删除）字符而不改变其余字符的顺序得到的字符串。

该算法通过动态规划技术解决两个字符串的最长公共子序列问题，首先定义一个二维数组memo来存储两个字符串从各自的某一位置开始到结尾的最长公共子序列的长度，避免重复计算以提高效率，然后通过一个递归函数dp，从两个字符串的起始位置开始比较，若当前位置字符相同，则长度加一并递归调用下一个位置；若不同，则分别递归调用text1的下一位置与text2的当前位置，以及text1的当前位置与text2的下一位置，选择两者中较大的一个，最终，memo数组中的第一个元素即存储了两个字符串的最长公共子序列的长度。
 */

public class MultiDimE1N1143LongestCommonSubseq {
    int m;
    int n;
    int[][] memo; // 用于存储中间结果的二维数组,从各自的某一位置开始到结尾的最长公共子序列的长度
    String text1;
    String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        // 获取输入字符串的长度
        this.m = text1.length();
        this.n = text2.length();
        this.text1 = text1;
        this.text2 = text2;

        // 初始化memo数组，并将所有位置填充为-1
        // memo数组用处存储已经计算过的子问题的解，以防止重复计算
        memo = new int[m][n];
        for(var i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        // 从两个字符串的第一个字符开始计算LCS
        return dp(0, 0);
    }

    // dp函数使用动态规划来计算LCS
    // 函数接收两个参数i和j，
    // 表示当前正在比较的字符在text1和text2中的位置
    public int dp(int i, int j) {
        // 如果i==m或j==n说明已经到了两个字符串的末尾
        // 此时的LCS的长度是0，因为从该位置开始的源字符串都是空的
        if(i == m || j == n) {
            return 0;
        }
        // 如果memo[i][j]不等于-1，说明之前已经计算过从i和j开始的LCS长度
        // 直接返回memo[i][j]防止重复计算
        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int ans = 0;

        // 如果text1[i]等于text2[j]说明找到了一个公共字符
        // 此时LCS的擦很多u等于从i+1和j+1开始的LCS长度加1（这个1就是刚找到的公共字符）
        if(text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + dp(i + 1, j + 1);
        } else {
            // 如果text1[i]不等于text2[j]说明当前位置的字符不能构成公共子序列的一部分
            // 此时LCS的长度从i+1和j或从i和j+1开始的LCS长度中取较大者
            ans = Math.max(dp(i + 1, j), dp(i, j+1));
        }

        // 将计算得到的LCS长度保存在memo[i][j]中，并返回这个值
        memo[i][j] = ans;
        return ans;
    }
}
