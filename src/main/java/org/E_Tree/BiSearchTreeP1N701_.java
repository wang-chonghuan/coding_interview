package org.E_Tree;

/*
您将得到一棵二叉搜索树（BST）的根节点和一个要插入树中的值。插入后，返回 BST 的根节点。保证新值不存在于原始 BST 中。

请注意，只要插入后的树仍然是 BST，就可能存在多种有效的插入方式。您可以返回其中任何一种。
 */
public class BiSearchTreeP1N701_ {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        // insert into the right subtree
        if(val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        // insert into the left subtree
        else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
