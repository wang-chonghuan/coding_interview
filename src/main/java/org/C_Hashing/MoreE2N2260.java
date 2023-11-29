package org.C_Hashing;

import java.util.HashMap;

/*
you are given an integer array cards, where cards[i] represents the value of the i-th card.
a pair of card are matching if the cards have the same value.
return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards .
if it is impossible to have matching cards, return -1.

这个Java类定义了一个名为`Solution`的解决方案，其中包含一个名为`minimumCardPickup`的公共方法，它接受一个整数数组`cards`作为输入，这个数组代表一系列的卡片，其中每个卡片上有一个整数值。该方法的目标是找出选取的连续卡片序列中能够获得一对相匹配卡片的最小长度。在这里，“匹配”是指两张卡片具有相同的值。我们初始化一个名为`map`的哈希映射，并使用一个名为`min`的变量保存当前找到的最小距离（初始化为`Integer.MAX_VALUE`）。我们通过一个循环遍历输入数组`cards`的每一个元素。在循环内部，我们首先检查`map`是否包含当前卡片的值。如果包含，则说明我们在之前已经看到过一张这样的卡片，我们计算两张相同卡片之间的索引差（也就是它们之间的距离，`i - map.get(cards[i])`），并加上1来得到包含这两张卡片的序列的长度。我们用`min`和新计算的长度取最小值，以便保存到目前为止找到的最短的包含一对匹配卡片的序列的长度。接着，我们使用当前的卡片值和其在数组中的索引更新`map`，以便我们可以在之后找到该值的最新位置。最后，在循环结束后，我们检查`min`是否仍然等于`Integer.MAX_VALUE`。如果是，这意味着我们没有找到任何一对匹配的卡片，因此我们返回-1。否则，我们返回`min`的值，这是包含至少一对匹配卡片的最短序列的长度。

一个数组，最短的两个相同数的距离
 */
public class MoreE2N2260 {
    public int minimumCardPickup(int[] cards) {
        // 创建一个映射来存储卡片值及其在数组中的位置
        var map = new HashMap<Integer, Integer>();
        // 初始化最小长度为整数的最大值
        int min = Integer.MAX_VALUE;
        // 遍历数组中的每个卡片
        for(int i = 0; i < cards.length; i++) {
            // 如果已经见过当前卡片（映射中存在）
            // 则计算并更新最小长度
            if(map.containsKey(cards[i])) {
                var distance = i - map.get(cards[i]) + 1;
                min = Math.min(distance, min);
                // 将当前卡片和其索引放入映射中，以便于后续查找
                map.put(cards[i], i);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}




