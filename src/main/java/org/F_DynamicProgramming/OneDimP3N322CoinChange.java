package org.F_DynamicProgramming;

/*
322
给定一个整数数组 coins，代表不同面额的硬币，和一个整数 amount，代表一总金额。

返回组成该金额所需的最少硬币数。如果不能用硬币的任意组合组成那个金额，则返回 -1。

你可以假设每种硬币你拥有无限个。

在这个用于找出凑齐特定金额所需的最小硬币数量的算法中，我们采用了一种自顶向下的递归策略，并辅之以记忆化技术以避免重复计算，核心的思路在于，对于每个目标金额，我们遍历每一种硬币面额，并递归地尝试减去当前硬币面额后剩下的金额所需的最小硬币数量，此后，我们保留所需硬币数量最少的那一个，并在返回之前，将这个最小值存储在一个数组中，以便后续的函数调用直接利用，最终当函数递归到基本情况，即目标金额为0或负数时，我们返回适当的值来终结递归，并将逐层回溯中得到的最小硬币数量返回给最初的函数调用者。

关键递归关系：
该递归等式表示，凑齐金额 \(x\) 所需的最小硬币数量 \(F(x)\) 等于凑齐金额 \(x - c_i\) 所需的最小硬币数量 \(F(x - c_i)\) 加上当前这枚硬币，对所有可能的硬币 \(c_i\) 计算这个值并选择一个最小的。即，选择一枚硬币，并找剩下金额所需的最少硬币数量，整个过程确保总的硬币数量最少。
最核心！！！

            原始面额X，一共有ABC三种面额。
            取面额A，算剩下金额（X-A）的最小硬币数
            取面额B，算剩下金额（X-B）的最小硬币数
            取面额C，算剩下金额（X-C）的最小硬币数
            从以上ABC中取一个最小的，加上1（相当于ABC其中之一的硬币）就是面额X的最小硬币数。


            原始面额X，一共有ABC三种面额。
            取面额A，算剩下金额（X-A）的最小硬币数
            取面额B，算剩下金额（X-B）的最小硬币数
            取面额C，算剩下金额（X-C）的最小硬币数
            从以上ABC中取一个最小的，加上1（相当于ABC其中之一的硬币）就是面额X的最小硬币数。

            原始面额X，一共有ABC三种面额。
            取面额A，算剩下金额（X-A）的最小硬币数
            取面额B，算剩下金额（X-B）的最小硬币数
            取面额C，算剩下金额（X-C）的最小硬币数
            从以上ABC中取一个最小的，加上1（相当于ABC其中之一的硬币）就是面额X的最小硬币数。

 */
public class OneDimP3N322CoinChange {

    public int coinChange(int[] coinDenominations, int targetAmount) {
        if (targetAmount < 1) return 0;
        return findMinCoins(coinDenominations, targetAmount, new int[targetAmount]);
    }

    private int findMinCoins(int[] coinDenominations, int remainingAmount, int[] minCoinsNeeded) {
        // Case 1: No solution exists
        if (remainingAmount < 0) return -1;
        // Case 2: Exact amount matched
        if (remainingAmount == 0) return 0;
        // Case 3: Return previously calculated result
        if (minCoinsNeeded[remainingAmount - 1] != 0) return minCoinsNeeded[remainingAmount - 1];

        // Initially set minimum coins needed to the maximum possible value
        int minCoins = Integer.MAX_VALUE;
        // Try each coin denomination
        for (int coin : coinDenominations) {
            // Recursively find the minimum number of coins needed for the remaining amount after using the current coin
            /*
            原始面额X，一共有ABC三种面额。
            取面额A，算剩下金额（X-A）的最小硬币数
            取面额B，算剩下金额（X-B）的最小硬币数
            取面额C，算剩下金额（X-C）的最小硬币数
            从以上ABC中取一个最小的，加上1（相当于ABC其中之一的硬币）就是面额X的最小硬币数。
             */
            int res = findMinCoins(coinDenominations, remainingAmount - coin, minCoinsNeeded);
            // If a solution exists and is smaller than the current minimum, update the minimum
            if (res >= 0 && res < minCoins)
                minCoins = 1 + res; // Include the current coin in the count
        }
        // Save the result in the memoization array: no solution => -1, otherwise the minimum number of coins found
        minCoinsNeeded[remainingAmount - 1] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        // Return the minimum number of coins needed for the current remaining amount
        return minCoinsNeeded[remainingAmount - 1];
    }
}

