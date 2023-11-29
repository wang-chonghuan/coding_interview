package org.B_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * example 1: 739 daily temperatures
 *
 * given an array of integers temperatures that represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait
 * after the i day to get a warmer temperature
 * if there is no future that is answer, have answer[i] = 0 instead
 *
 * 题意解析：
 * 给一个数组temperatures代表每日温度
 * 返回一个数组answer,其每个元素a[i]代表第i天之后你要等几天才能遇到比a[i]更高的温度
 * 如果遇不到，a[i] = 0
 *
 * 分析2：
 * 例子：23， 24， 25， 20， 19
 * 答案：1， 1， 0， 0， 0
 * 方法：
 * 遍历每一个温度，下标i
 * 如果栈为空，则把i入栈
 * 如果i的温度小于等于栈顶t(也是一个下标)的温度，则把i入栈
 * 如果i的温度大于栈顶t的温度，则代表：t后面的第一个高温就是i，所以ret[t]=i-t
 * 弹出t，t下面的元素的温度一定比t高，再同样处理t下面的元素（新栈顶）
 * 这个栈是单调递减栈，最大的温度在最下面
 * 遍历完所有温度，栈里面剩下的下标，都是没有最高温的
 */
public class MonotonicE1N739 {
    int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length]; // 初始化结果数组，全0
        Deque<Integer> maxStack = new LinkedList<>(); // 单调栈，顶最小，底最大
        for(int iCur = 0; iCur < temperatures.length; iCur++) {
            int curTmp = temperatures[iCur];
            while(maxStack.size() > 0 && curTmp > temperatures[maxStack.getFirst()]) {
                int iTop = maxStack.removeFirst();
                ret[iTop] = iCur - iTop;
            }
            maxStack.addFirst(iCur);
        }
        return ret;
    }
}
