package org.E_Tree;

/*
938 range sum of BiSearchTree
given the root node of a bistree
and two integers low and high
return the sum of values of all nodes
with a value in the inclusive range [low, high]
 */
public class BiSearchTreeE1N938 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        // 比low还小,再往左走就更小了,所以只能往右走
        if(root.val < low) {
            sum += rangeSumBST(root.right, low, high);
        } else if(root.val > high) {
            sum += rangeSumBST(root.left, low, high);
        }
        // 即当前节点的值在 low 和 high 之间（low <= root.val && root.val <= high）。在这个块中，代码对左右子树都调用递归方法，因为它们的值可能在这个范围内。
        else {
            sum += rangeSumBST(root.right, low, high);
            sum += rangeSumBST(root.left, low, high);
        }
        return sum;
    }
}
