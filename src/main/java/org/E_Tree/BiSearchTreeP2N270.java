package org.E_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
给定root二叉搜索树的 和一个target值，返回BST 中最接近 的值 target。如果有多个答案，则打印最小的一个。
 */
public class BiSearchTreeP2N270 {
    public void inorder(TreeNode root, List<Integer> nums) {
        if(root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int closestValue(TreeNode root, double target) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        return Collections.min(nums, new Comparator<Integer>() {
            // 我要返回小的,就小的取-1
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
            }
        });
    }
}
