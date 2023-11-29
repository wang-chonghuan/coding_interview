package org.E_Tree;

/*
111 minimum depth of binary tree

given a binary tree, find its minimum depth
the minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 */
public class DfsP1N111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 这是个叶子
        if(root.left == null && root.right == null) {
            return 1;
        }
        // 有子树
        int minDepth = Integer.MAX_VALUE;
        if(root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if(root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }
}
