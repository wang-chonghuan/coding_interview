package org.E_Tree;

/*
104 max depth of binary tree
given the root of a binary tree, find the length of the longest path from the root to a leaf
 */
public class DfsE1N104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }
}
