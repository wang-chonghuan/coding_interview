package org.E_Tree;

/*
1026 Max diff between node and ancestor
given the root of a binary tree, find the max value v for which there exist diff nodes a and b where v = |a.val-b.val| and a is an ancestor of b
A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b

这个算法通过深度优先搜索（DFS）遍历二叉树的每一个节点，其目的是找到树中两个节点值的最大绝对差值，其中一个节点是另一个的祖先。初始调用`dfs`函数时，设定当前节点（`node`）以及沿途经过的路径上的最大和最小节点值（`maxLineVal` 和 `minLineVal`）。在每次递归中，它计算当前节点值与路径上的最大最小值的差，更新全局最大差值（`maxDiff`）。然后，算法通过递归遍历该节点的左右子树，同时更新路径上的最大和最小节点值。最终，递归返回的是左右子树中找到的最大差值，这个差值在树的所有路径中被视为最终的最大差值。
 */
public class DfsP2N543_ {
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val, 0);
    }

    /**
     *
     * @param node 当前节点
     * @param maxLineVal 该条线上的节点的最大值
     * @param minLineVal 该条线上的节点的最小值
     * @param maxDiff 全局最大差值
     * @return 更新后的全局最大差值
     */
    private int dfs(TreeNode node, int maxLineVal, int minLineVal, int maxDiff) {
        if(node == null) {
            return maxDiff;
        }
        // 当前节点在该线上的最大差值
        int nodeMaxDiff = Math.max(
          Math.abs(node.val - maxLineVal),
          Math.abs(node.val - minLineVal)
        );
        // 为了递归,更新全局最大差值
        maxDiff = Math.max(maxDiff, nodeMaxDiff);
        // 为了递归,更新当前线的最大值
        maxLineVal = Math.max(maxLineVal, node.val);
        minLineVal = Math.min(minLineVal, node.val);
        // 分别获得左右子树的最大差值
        int maxDiffLeft = dfs(node.left, maxLineVal,minLineVal, maxDiff);
        int maxDiffRight = dfs(node.right, maxLineVal, minLineVal, maxDiff);
        return Math.max(maxDiffLeft, maxDiffRight);
    }
}
