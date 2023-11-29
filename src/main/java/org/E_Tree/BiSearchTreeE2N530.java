package org.E_Tree;

import java.util.ArrayList;
import java.util.List;

/*
530 mini abs diff in bistree
given the root of a bistree
return the min abs diff between the values of any two diff nodes in the tree

insight: 最小值必是两个相邻元素的差值,所以先升序排序
 */
public class BiSearchTreeE2N530 {

    public int getMinimumDifference(TreeNode root) {
        var ascList = getSortedVal(root);
        int minDiff = Integer.MAX_VALUE;
        if(ascList.size() <= 1) {
            return minDiff;
        }
        for(int i = 1; i < ascList.size(); i++) {
            var curDiff = Math.abs(ascList.get(i) - ascList.get(i-1));
            minDiff = Math.min(minDiff, curDiff);
        }
        return minDiff;
    }

    // 使用bst中序遍历的方法获得升序数组
    private List<Integer> getSortedVal(TreeNode node) {
        if(node == null) {
            return new ArrayList<>();
        }
        var leftList = getSortedVal(node.left);
        var rightList = getSortedVal(node.right);
        leftList.add(node.val);
        leftList.addAll(rightList);
        return leftList;
    }
}
