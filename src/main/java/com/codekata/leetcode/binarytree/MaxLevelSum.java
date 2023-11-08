package com.codekata.leetcode.binarytree;

import com.codekata.leetcode.binarytree.model.TreeNode;

import java.util.*;

/**
 * The type Max level sum.
 */
public class MaxLevelSum {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree

        System.out.println(maxLevelSum(createTreeNode()));
    }

    /**
     * Max level sum int.
     *
     * @param root the root
     * @return the int
     */
    public static int maxLevelSum(TreeNode root) {
        int ans = 1;
        int maxLevelSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));

        for (int level = 1; !queue.isEmpty(); ++level) {
            int levelSum = 0;
            for (int sz = queue.size(); sz > 0; --sz) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            if (maxLevelSum < levelSum) {
                maxLevelSum = levelSum;
                ans = level;
            }
        }
        return ans;
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeRightRight = new TreeNode(7);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRight = new TreeNode(20, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(9, null, null);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
