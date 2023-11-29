package org.E_Tree;

/*
112 path sum
given the root of a binary tree
and an integer targetSum
return true if there is a path from the root to a leaf such that the sum of the nodes on the path is equal to targetSum. and return false otherwise

先考虑只有0个节点和1个节点的情况
再考虑多余1个节点的情况,先考虑左子树,再考虑右子树

 */
public class DfsE2N112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int tarSum, int curSum) {
        // 终止条件
        if(node == null) {
            return false;
        }
        if(node.left == null && node.right == null) {
            return curSum + node.val == tarSum;
        }
        // 递归条件
        boolean left = dfs(node.left, tarSum, curSum + node.val);
        boolean right = dfs(node.right, tarSum, curSum + node.val);
        return left || right;
    }
}
