package com.codekata.leetcode.binarytree;

import com.codekata.leetcode.binarytree.model.TreeNode;

public class MaxDepthTree {

    public static void main(String[] args) {

        //https://leetcode.com/problems/maximum-depth-of-binary-tree

        System.out.println(maxDepth(createTreeNode()));
    }

    public static int maxDepth(TreeNode root) {
        return calculateDepth(root, 1);
    }

    public static int calculateDepth(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int left = calculateDepth(root.left, i);
        int right = calculateDepth(root.right, i);
        return Math.max(left, right) + i;
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeRightRight = new TreeNode(7);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRight = new TreeNode(20, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(9, null, null);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
