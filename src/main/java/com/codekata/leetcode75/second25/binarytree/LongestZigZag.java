package com.codekata.leetcode75.second25.binarytree;

import com.codekata.leetcode75.second25.binarytree.model.ExtendedTreeNode;
import com.codekata.leetcode75.second25.binarytree.model.TreeNode;

/**
 * The type Longest zig zag.
 */
public class LongestZigZag {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

        System.out.println(longestZigZag(createTreeNode1()));
    }

    /**
     * Longest zig zag int.
     *
     * @param root the root
     * @return the int
     */
    public static int longestZigZag(TreeNode root) {
        return depthFirstSearch(root).subtreeMax;
    }

    private static ExtendedTreeNode depthFirstSearch(TreeNode root) {
        if (root == null)
            return new ExtendedTreeNode(-1, -1, -1);
        ExtendedTreeNode left = depthFirstSearch(root.left);
        ExtendedTreeNode right = depthFirstSearch(root.right);
        final int leftZigZag = left.rightMax + 1;
        final int rightZigZag = right.leftMax + 1;
        final int subtreeMax = Math.max(Math.max(leftZigZag, rightZigZag), Math.max(left.subtreeMax, right.subtreeMax));
        return new ExtendedTreeNode(leftZigZag, rightZigZag, subtreeMax);
    }

    private static TreeNode createTreeNode1() {
        TreeNode nodeRightRightRight = new TreeNode(8);
        TreeNode nodeRightRightLeft = new TreeNode(9);
        TreeNode nodeRightRight = new TreeNode(2, nodeRightRightLeft, nodeRightRightRight);
        TreeNode nodeRightLeft = new TreeNode(4);
        TreeNode nodeLeftRight = new TreeNode(7);
        TreeNode nodeLeftLeft = new TreeNode(6);
        TreeNode nodeRight = new TreeNode(1, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(5, nodeLeftLeft, nodeLeftRight);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
