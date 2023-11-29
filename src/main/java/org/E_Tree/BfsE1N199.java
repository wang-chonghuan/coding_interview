package org.E_Tree;

import java.util.*;

/*
199 binary tree right side view
given the root of a binary tree
imagine yourself standing on the right side of it
return the values of the nodes you can see ordered from top to bottom

就是打印一棵树的最右侧节点
 */
public class BfsE1N199 {
    // 定义方法,参数是一个二叉树的根节点,返回值是一个整数列表
    public List<Integer> rightSideView(TreeNode root) {
        // 定义一个列表,返回值,用于存储每一层最右边的节点的值
        List<Integer> rightMostNodes = new ArrayList<>();
        // 定义一个队列,用于存储每一层的节点
        Queue<TreeNode> levelNodes = new LinkedList<>();
        // 将根节点添加到队列中
        levelNodes.add(root);

        while(!levelNodes.isEmpty()) {
            // 获取当前层节点的数量
            int levelCnt = levelNodes.size();
            // 遍历当前层的每一个节点
            for(int i = 0; i < levelCnt; i++) {
                TreeNode curNode = levelNodes.remove();
                if(curNode == null) {
                    continue;
                }
                if(i == levelCnt - 1) {
                    rightMostNodes.add(curNode.val);
                }
                // 制作当前节点的下一层,然后while再制作下一节点的下一层
                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
             }
        }

        return rightMostNodes;
    }
}
