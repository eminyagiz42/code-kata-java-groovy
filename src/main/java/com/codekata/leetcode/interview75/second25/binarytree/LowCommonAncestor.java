package com.codekata.leetcode.interview75.second25.binarytree;

import com.codekata.leetcode.interview75.second25.binarytree.model.TreeNode;

/**
 * The type Low common ancestor.
 */
public class LowCommonAncestor {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

        System.out.println("Lowest common ancestor for node 5 and 30:");
        TreeNode node5 = new TreeNode(5);
        TreeNode node30 = new TreeNode(30);
        System.out.println(lowestCommonAncestor(createBinaryTree(), node5, node30).val);
    }

    /**
     * Lowest common ancestor tree node.
     *
     * @param root the root
     * @param a    the a
     * @param b    the b
     * @return the tree node
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root.val == a.val || root.val == b.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    /**
     * Create binary tree tree node.
     *
     * @return the tree node
     */
    public static TreeNode createBinaryTree() {
        TreeNode node70 = new TreeNode(70);
        TreeNode node5 = new TreeNode(5);
        TreeNode node55 = new TreeNode(55);
        TreeNode node50 = new TreeNode(50, null, node55);
        TreeNode node60 = new TreeNode(60, node50, node70);
        TreeNode node10 = new TreeNode(10, node5, null);
        TreeNode node30 = new TreeNode(30);
        TreeNode node20 = new TreeNode(20, node10, node30);
        return new TreeNode(40, node20, node60);
    }
}