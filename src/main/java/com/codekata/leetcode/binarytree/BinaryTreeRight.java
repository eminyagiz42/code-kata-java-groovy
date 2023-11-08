package com.codekata.leetcode.binarytree;

import com.codekata.leetcode.binarytree.model.TreeNode;

import java.util.*;

/**
 * The type Binary tree right.
 */
public class BinaryTreeRight {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/binary-tree-right-side-view

        System.out.println(rightSideView(createTreeNode()));
    }

    /**
     * Right side view list.
     *
     * @param root the root
     * @return the list
     */
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> integerList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(Collections.singletonList(root));

        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (i == size - 1)
                    integerList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return integerList;
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeRightRight = new TreeNode(7);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRight = new TreeNode(20, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(9, null, null);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
