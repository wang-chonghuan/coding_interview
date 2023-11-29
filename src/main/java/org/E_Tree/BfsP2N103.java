package org.E_Tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
103 binary tree zigzag level order traversal
given the root of a binary tree,
return the zigzag level order traversal of its nodes values
first level left to right
second level right to left
so on

在给定的`BfsP2N103`类中，方法`zigzagLevelOrder`的主要任务是实现对一颗给定二叉树进行“之字形”层序遍历。该算法首先通过一层层地遍历树的各节点，将每一层的节点值记录下来，然后在添加到结果集之前根据该层的层序进行处理，即：对于偶数层，直接添加至结果集；对于奇数层，则将其反转后再添加。这样的处理确保了结果集的输出符合“之字形”要求。算法中引入了一个布尔类型变量`isLeftToRight`来指示每层的正常（或反向）添加状态。初始时，根节点入队，进入主循环。在每次主循环中，首先读取当前层的节点数量，然后在子循环中处理这些节点，并将它们的子节点（如果存在的话）入队，为处理下一层做准备。在子循环处理完当前层所有节点后，通过`isLeftToRight`判断是否需要反转本层节点值的顺序，并将其添加至结果集，再对`isLeftToRight`进行翻转，以便下一层能进行相反的处理。通过如上处理，直到队列中无节点，主循环结束。最终返回的结果集即为符合题目要求的“之字形”层序遍历结果。
 */
public class BfsP2N103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigOrderVals = new LinkedList<>();
        if(root == null) {
            return zigOrderVals;
        }
        Deque<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.add(root);
        boolean isLeftToRight = true;
        while(!levelNodes.isEmpty()) {
            int levelNodeAmount = levelNodes.size();
            var curLevelList = new LinkedList<Integer>();
            for(int i = 0; i < levelNodeAmount; i++) {
                var curNode = levelNodes.removeFirst();
                if(curNode == null) {
                    continue;
                }
                curLevelList.add(curNode.val);

                if(curNode.left != null) {
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    levelNodes.add(curNode.right);
                }
            }
            if(isLeftToRight) {
                zigOrderVals.add(curLevelList);
            } else {
                Collections.reverse(curLevelList);
                zigOrderVals.add(curLevelList);
            }
            isLeftToRight = !isLeftToRight;
        }
        return zigOrderVals;
    }
}
