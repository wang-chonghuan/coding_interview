package org.C_Hashing;

import java.util.Arrays;
import java.util.HashMap;

/*
2352 equal row and column pairs
given a 0-indexed n * n integer matrix gird
return the number of pairs (r-i, c-j)
such that row r-i and column c-j are equal
a row and column pair is considered equal if they contain the same elements in the same order

用连贯的文字叙述这个解法的意思，解释。不要分点，分段。要一针见血。


这个解法首先遍历输入的`grid`，将每一行的数组元素转化为字符串形式并使用一个哈希表`rowCounter`记录每一个不同行字符串出现的次数，然后在列的层面上做类似的操作：遍历每一列，将列的元素转化为一个数组并进一步转化为字符串形式，通过在哈希表`rowCounter`中查找该字符串，找出与当前列相等的行的数量，并将这些数量累加到`count`变量中，最终返回的`count`即为满足条件的行列对的总数。
 */
public class MoreE4n2352 {
    public int equalPairs(int[][] grid) {
        int count = 0; // 等pair的总数
        int n = grid.length; // grid的维度

        // 把每行转换成一个字符串，存入频率表
        var rowCounter = new HashMap<String, Integer>();
        for(var row : grid) {
            var rowStr = Arrays.toString(row);
            rowCounter.put(rowStr, rowCounter.getOrDefault(rowStr, 0) + 1);
        }

        for(var c = 0; c < n; c++) {
            int[] col = new int[n];
            for(var r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }
            count += rowCounter.getOrDefault(Arrays.toString(col), 0);
        }
        return count;
    }
}
