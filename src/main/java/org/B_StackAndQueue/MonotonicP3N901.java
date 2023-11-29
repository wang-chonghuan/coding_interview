package org.B_StackAndQueue;

import java.util.Stack;

/*
这道题目要求设计一个算法，该算法可以收集某支股票的每日价格报价，并针对当前这一天，返回该股票价格的跨度（span）。这里的"跨度"定义为从当前天数开始逆序回望，股票价格保持低于或等于当天价格的最大连续天数。

举例说明：

如果在过去四天的股票价格分别为 [7,2,1,2]，今天的股票价格是 2，那么今天的跨度就是 4，因为从今天开始往回看，股票价格在连续 4 天里都是小于或等于 2 的。
如果在过去四天的股票价格分别为 [7,34,1,2]，今天的股票价格是 8，那么今天的跨度就是 3，因为从今天开始往回看，股票价格在连续 3 天里都是小于或等于 8 的。
要实现一个StockSpanner类，这个类需要包含下列方法：

StockSpanner()：初始化类的对象。
int next(int price)：返回给定当天价格price下，股票价格的跨度。
你需要构建一个数据结构或算法，使其能够满足上述要求，并高效地返回每一天的股票价格跨度。

在实现这个类的过程中，你可能会需要存储之前的股票价格和相应的跨度，以便在计算当前天的跨度时能够高效地利用已有信息，避免不必要的重复计算。这个算法问题可能需要利用到栈（stack）这种数据结构，来实现时间复杂度较低的解决方案。

interface:

StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 */
public class MonotonicP3N901 {
    private class StockSpanner {
        Stack<int[]> stack = new Stack<>();

        /**
         * @param price
         * @return
         * 这个stack的元素是一个二元素数组，第一个元素是价格，第二个元素是span
         */
        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                // 如果新来的价格更高，就把上一个的span加上
                ans += stack.pop()[1];
            }

            stack.push(new int[] {price, ans});
            return ans;
        }
    }
}
