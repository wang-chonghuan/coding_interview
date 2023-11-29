package org.E_Tree;

/*
98 validate binary search tree
given the root of a binary tree
determine if it is a valid bst

默认bst中没有重复元素,如果有,题目一定会特别说明,参考501

 */
public class BiSearchTreeE3N98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long small, long large) {
        if(node == null) {
            return true;
        }
        if(node.val >= large || node.val <= small) {
            return false;
        }
        boolean left = dfs(node.left, small, node.val);
        boolean right = dfs(node.right, node.val, large);
        return left && right;
    }
}
