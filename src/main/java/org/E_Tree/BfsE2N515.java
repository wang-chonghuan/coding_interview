package org.E_Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
515 find largest value in each tree row
given the root of a binary tree,
return an array of the largest value in each row of the tree
 */
public class BfsE2N515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largestNodes = new LinkedList<>();
        if(root == null) {
            return largestNodes;
        }
        Deque<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.addLast(root);
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            int levelMax = Integer.MIN_VALUE;
            for(var node : levelNodes) {
                var curNode = levelNodes.removeFirst();
                if(curNode == null) {
                    continue;
                }
                levelMax = Math.max(levelMax, curNode.val);

                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
            }
            largestNodes.add(levelMax);
        }
        return largestNodes;

    }
}
