package com.codekata.leetcode.binarytree;

import com.codekata.leetcode.binarytree.model.TreeNode;

/**
 * The type Search in binary tree.
 */
public class SearchInBinaryTree {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/search-in-a-binary-search-tree

        System.out.println(searchBST(createTreeNode(), 9));
    }

    /**
     * Search bst tree node.
     *
     * @param root the root
     * @param val  the val
     * @return the tree node
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeRightRight = new TreeNode(7);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRight = new TreeNode(20, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(9, null, null);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
