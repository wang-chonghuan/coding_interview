package org.F_DynamicProgramming;

/*
给定一个包含 1 和 0 的 m x n 网格 grid，我们需要找到一个机器人从左上角到右下角的所有可能的路径数。1 表示一个障碍物，机器人不能通过；0 表示一个空位置，机器人可以通过。机器人只能向下或向右移动。

对于这类问题，我们可以使用动态规划（Dynamic Programming）来解决。动态规划方程如下所示：

如果 grid[i][j] == 1，我们设置 dp[i][j] = 0，因为有一个障碍物在这里，所以没有路径可以通过这个点。

如果 grid[i][j] == 0，我们可以设置 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，这是因为到达 (i, j) 这个位置只能从 (i-1, j) 或 (i, j-1) 这两个位置到达。
 */
public class MatrixDpP1N63UniquePathStone {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp代表到到达每个点的所有路径数
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0] == 0 ? 1 : 0; // 到达第0,0点的路径数是1或者0

        // 如果第一个元素是障碍物,直接返回0,因为没有路径可以到达终点
        if(dp[0][0] == 0) {
            return 0;
        }

        // 初始化第一行和第一列的dp值
        // 到达第一列的某点i,0,只能是从上方过来,如果该点是障碍物,就不可能通过,如果该点是通畅的,那么该点的路径数和其上面的点i-1,0是一样的,因为只能从上方过来
        for(int i = 1; i < m; i++) {
            dp[i][0] = (grid[i][0] == 1) ? 0 : dp[i-1][0];
        }
        // 到达第一行的某点0,j,只能从左方过来,如果该点是障碍物,就不可能通过,所以填0,如果该点是通畅的,那么该点的路径数和其上面的点0,j-1是一样的,因为只能从左方过来
        for(int j = 1; j < n; j++) {
            dp[0][j] = (grid[0][j] == 1) ? 0: dp[0][j - 1];
        }

        // 正序逐行计算到达每个点的路径数
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0; // 如果有障碍物,从i,j点到m,n点的路径数就是0
                }
            }
        }

        return dp[m-1][n-1];
    }
}
