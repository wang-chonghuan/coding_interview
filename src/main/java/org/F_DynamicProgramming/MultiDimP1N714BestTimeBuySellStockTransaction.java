package org.F_DynamicProgramming;

/*
you are given an array prices where prices[i] is the price of a given stock on the i-th day, and an integer fee representing a transaction fee
find the max profit you can achieve. you may complete as many trascations as you like, but you need to pay the transaction fee for each transaction

You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.

这个算法通过动态规划解决一个股票交易问题，其中允许多次买卖但每次卖出会收取固定的手续费用`fee`；定义两个一维数组`hold`和`free`分别代表在第`i`天结束时持有或不持有股票所能获得的最大累计收益，其中`hold[i]`为持有股票的最大收益的两种可能情况（保持前一天的持有状态或者在第`i`天买入）中的较大值，通过比较`hold[i-1]`和`free[i-1] - prices[i]`得出；`free[i]`则为不持有股票的两种可能情况（保持前一天的空闲状态或者在第`i`天卖出）中的较大值，通过比较`free[i-1]`和`hold[i-1] + prices[i] - fee`得出；算法最终返回`free[n-1]`，即在最后一天不持有股票所能获得的最大累计收益。

 */
public class MultiDimP1N714BestTimeBuySellStockTransaction {
    public int maxProfit(int[] prices, int fee) {
        //n是给定价格数组的长度,就是交易天数
        int n = prices.length;
        // free表示第i天不持有股票时的最大利润
        // hold表示第i填持有股票时的最大利润
        int[] free = new int[n], hold = new int[n];
        // 如果第0天持有股票,那么利润就是负的股票价格
        hold[0] = -prices[0];
        // 从第1填开始遍历到第n天
        for(int i = 1; i < n; i++) {
            // 对于hold数组,第i天持有股票的最大利润可以从两者中的较大者得出
            // 前一天也持有股票,那么今天肯定是不做任何事,否则今天不会也持有hold[i-1]
            // 前一天不持有股票,今天买入股票free[i-1]-prices[i]
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            // 对于free数组,第i填不持有股票的最大利润可以由两者中的较大者得出
            // 前一天不持有股票,今天不做任何事,利润不变free[i-1]
            // 前一天持有股票,因为今天不持有了,说明今天卖出hold[i-1]+prices[i]-fee
            free[i]=Math.max(free[i-1],hold[i-1]+prices[i]-fee);
        }
        // 返回第n填不持有股票的最大利润,因为不持有股票的利润始终大于持有股票的利润
        return free[n-1];
    }
}
