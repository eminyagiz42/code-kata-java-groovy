package com.codekata.leetcode.interview75.second25.binarytree;

import com.codekata.leetcode.interview75.second25.binarytree.model.TreeNode;

/**
 * The type Counting good nodes.
 */
public class CountingGoodNodes {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/count-good-nodes-in-binary-tree/

        System.out.println(goodNodes(createTreeNode1()));
    }

    /**
     * Good nodes int.
     *
     * @param root the root
     * @return the int
     */
    public static int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return depthFirstSearch(root, root.val);
    }

    private static int depthFirstSearch(TreeNode root, int max) {
        if(root == null){
            return 0;
        }
        max = Math.max(max, root.val);
        if(root.val >= max){
            return 1 + depthFirstSearch(root.left, max) + depthFirstSearch(root.right, max);
        }else{
            return depthFirstSearch(root.left, max) + depthFirstSearch(root.right, max);
        }
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
