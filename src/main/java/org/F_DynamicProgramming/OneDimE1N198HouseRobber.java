package org.F_DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
198 House Robber
你是一名专业的小偷，计划在一条街上的房屋中盗窃。每个房子里藏有一定数量的钱，但由于相邻的房子有连接的安全系统，如果在同一夜晚连续闯入两个相邻的房子，警报就会触发。给定一个整数数组`nums`，表示每个房子中藏有的钱的数量，返回你今晚能在不触发警报的情况下抢劫的最大金额。

 */
public class OneDimE1N198HouseRobber {
    private int[] memo; // 用于存储从每个房屋开始的最大收益

    public int rob(int[] nums) {
        this.memo = new int[100]; // 初始化记忆数组
        // 用-1填充memo数组，代表这些值还未被计算过
        Arrays.fill(this.memo, -1);
        // 从第一个房屋开始考虑
        return this.robFrom(0, nums);
    }

    private int robFrom(int i, int[] nums) {
        // 如果已经考虑完所有的房屋，则收益为0
        if(i >= nums.length) {
            return 0;
        }

        // 如果memo[i]不是-1，则已经计算过从i开始的最大收益，直接返回该值
        if(this.memo[i] > -1) {
            return this.memo[i];
        }

        // 否则，递归计算从i开始的最大收益
        // 可选方案1：不抢劫房屋i，抢劫从i+1开始的房屋
        // 可选方案2：抢劫房屋i，并从i+2开始抢劫后面的房屋
        // 在两者之间取最大值
        var option1 = this.robFrom(i + 1, nums);
        var option2 = this.robFrom(i + 2, nums) + nums[i];
        int ans = Math.max(option1, option2);

        this.memo[i] = ans;
        return ans;
    }

}
