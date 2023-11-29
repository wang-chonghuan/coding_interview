package org.B_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 这道题的要求是实现一个RecentCounter类，该类主要用于计算在一个特定的时间范围内发生的请求数量。

 RecentCounter()：这是类的构造函数，需要将计数器初始化为零。

 int ping(int t)：这个方法是在时间t加入一个新的请求，并返回过去3000毫秒（包括新的请求在内）内发生的请求数量。具体来说，返回在时间区间[t - 3000, t]内发生的请求的数量。题目保证每次调用ping方法时，t的值都会严格大于前一次的值。

 简单举个例子：如果我们依次调用ping(1000)、ping(2000)、ping(3000)、ping(4000)，我们将分别返回1、2、3、4，因为在每个时间点t，我们都会计算在[t - 3000, t]时间区间内发生了多少次ping请求。

 */
public class QueueE1N933 {
    final Deque<Integer> dq = new LinkedList<>();
    private class RecentCounter {
    }
    public int ping(int t) {
        while(dq.size() > 0 && dq.getFirst() < t - 3000) {
            dq.removeFirst(); // 如果队列第一个元素超出了区间，就删除队列第一个元素
        }
        dq.addLast(t);
        return dq.size();
    }
}
