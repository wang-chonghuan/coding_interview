package org.F_DynamicProgramming;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

这道题目是一个典型的动态规划问题，经常被称为“爬楼梯问题”。问题的大致内容是：给定一个整数`n`，代表一个楼梯的阶梯数，你一次可以选择爬1个阶梯或2个阶梯，问题是要求出到达楼梯顶部总共有多少种不同的方法。

给出的解决方案采用了动态规划的思想来解决这一问题。我们定义`dp[i]`为到达第`i`个阶梯的方法总数。那么，我们可以得出状态转移方程为：
\[ dp[i] = dp[i - 1] + dp[i - 2] \]
意思是到达第`i`个阶梯的方法总数等于到达第`i - 1`个阶梯的方法数加上到达第`i - 2`个阶梯的方法数，因为我们可以从第`i - 1`个阶梯走一步到达第`i`个阶梯，也可以从第`i - 2`个阶梯走两步到达第`i`个阶梯。

 */

import java.util.HashMap;
import java.util.Map;

public class OneDimP1N70ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
