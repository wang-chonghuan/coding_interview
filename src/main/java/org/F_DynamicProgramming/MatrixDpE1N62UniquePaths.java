package org.F_DynamicProgramming;

import java.util.Arrays;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.


 */
public class MatrixDpE1N62UniquePaths {
    public int uniquePaths(int m, int n) {
        // 创建一个二维数组d,用于存储到达每个位置的路径数量
        int[][] d = new int[m][n];

        // 初始化二维数组,将第一行和第一列的所有元素设置为1
        // 因为起点到第一行的任一个位置,只有一条路径,第一列同理
        // 但是这个循环是对所以位置置1
        for(int[] row : d) {
            Arrays.fill(row, 1);
        }

        // 使用嵌套循环,从左上角遍历到右下角,计算到达每个格子的路径数量,遍历从(1,1)开始,因为0行和0列已经确定都是1了
        for(int row = 1; row < m; ++row) {
            for(int col = 1; col < n; ++col) {
                // 关键:到达当前格子的路径数量等于到达其左边格子的路径数量与到达其右边格子的路径数量之和
                d[row][col] = d[row][col-1] + d[row-1][col];
            }
        }

        return d[m-1][n-1];
    }
}
