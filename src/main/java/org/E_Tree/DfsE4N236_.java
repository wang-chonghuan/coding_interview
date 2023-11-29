package org.E_Tree;

/*
236 lowest common ancestor of a binary tree
 */
public class DfsE4N236_ {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        // 递归
        var ancestorLeft = lowestCommonAncestor(root.left, p, q);
        var ancestorRight = lowestCommonAncestor(root.right, p, q);
        if(ancestorLeft != null && ancestorRight != null) {
            return root;
        }
        if(ancestorLeft != null && ancestorRight == null) {
            return ancestorLeft;
        }
        if(ancestorRight == null && ancestorRight != null) {
            return ancestorRight;
        }
        return null;
    }
}
