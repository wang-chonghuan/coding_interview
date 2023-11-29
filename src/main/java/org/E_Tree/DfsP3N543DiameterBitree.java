package org.E_Tree;

/*
543 diameter of bitree
given the root of a bitree
return the len of the diameter of the tree

the diameter of a bitree is the len of the longest path
between any two nodes in a tree
this path may or may not pass through the root

the len of a path between two nodes is represented by the number of edges between them

这一题的关键在于,最长直径,必然是某个节点的左最远叶子路径,加上右最远叶子路径
但该节点不一定是根节点,比如该节点是根的左孩子,其左右两最远叶子的距离最长
所以DFS每个节点，计算其最远叶子后代的距离和
用一个递归DFS函数计算每个节点的最远叶子，在递归的过程中，更新直径
 */
public class DfsP3N543DiameterBitree {
    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        diameter = 0;
        mostFarLeafPath(root);
        return diameter;
    }

    private int mostFarLeafPath(TreeNode node) {
        if(node == null) {
            return 0;
        }
        // 计算左右子树的长度
        int leftPath = mostFarLeafPath(node.left);
        int rightPath = mostFarLeafPath(node.right);
        // 左右子树的长度和是以node为圆心的直径
        this.diameter = Math.max(this.diameter, leftPath + rightPath);
        // 返回最长子树的长度
        int mostFarPath = Math.max(leftPath, rightPath);
        return mostFarPath + 1;// node的最长路径,要包含自身的1,所以加1
    }
}







