package org.E_Tree;

/*
1448 count good nodes in binary tree
given the root of a binary tree, find the number of nodes that are good
a node is good if the path between the root and the node has no nodes with a greater value

 * 关键是思考每次迭代的中间变量,我认为本题是最大值
 * 本题有两个变量,一是节点个数,二是当前最大值
 */
public class DfsE3N1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int max) {
        // 递归的终止条件
        if(node == null) {
            return 0;
        }
        // 先判断本节点是否是好节点
        int numGoodNodes = 0;
        if(node.val >= max) {
            numGoodNodes++;
        }
        // 再判断其子树是否是好节点
        int numGoodNodesLeft = dfs(node.left, Math.max(max, node.val));
        int numGoodNodesRight = dfs(node.right, Math.max(max, node.val));
        numGoodNodes += (numGoodNodesLeft + numGoodNodesRight);
        return numGoodNodes;
    }
}
