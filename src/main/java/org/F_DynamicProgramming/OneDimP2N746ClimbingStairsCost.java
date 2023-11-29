package org.F_DynamicProgramming;

import java.util.HashMap;

/*
746 Min Cost Climbing Stairs
给定一个整数数组`cost`，其中`cost[i]`代表爬楼梯的第i步的成本。支付成本后，你可以选择爬一步或两步。你可以选择从索引为0或索引为1的台阶开始爬。需要返回到达楼顶的最小成本。

动态规划原理：问题的最优解可以由其子问题的最优解构成。具体在这个问题中，到达第i阶的最优解（最小成本）是基于你之前是从第i-1阶或i-2阶达到第i阶的最小成本来构建的。
 */
public class OneDimP2N746ClimbingStairsCost {
    // 使用HashMap作为记忆化存储，避免重复计算。键是台阶的索引，值是从当前步到楼顶的最小成本。
    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        // 主函数调用递归函数并传递数组长度和数组本身
        return minimumCost(cost.length, cost);
    }

    private int minimumCost(int i, int[] cost) {
        // 基本情况：如果我们在台阶0或台阶1上，那么没有成本，因为我们可以直接开始
        if(i == 0 || i == 1) {
            return 0;
        }

        // 如果我们之前计算过从i到楼顶的最小成本，我们就直接返回它，避免重复计算
        if(memo.containsKey(i)) {
            return memo.get(i);
        }

        // 如果没有计算过，我们将从i-1和i-2两个台阶中选择一个成本较小的
        // downOne是从i-1台阶开始的成本，downTwo是从i-2台阶开始的成本
        // 对于downOne，我们支付cost[i-1]的成本，并递归计算minimumCost(i-1, cost)
        // 对于downTwo，我们支付cost[i-2]的成本，并递归计算minimumCost(i-2, cost)
        int downOne = cost[i - 1] + minimumCost(i - 1, cost);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost);

        // 我们取downOne和downTwo的较小值，并将其存储在memo中，便于将来查找
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }
}
