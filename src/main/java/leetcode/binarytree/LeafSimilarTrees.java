package leetcode.binarytree;

import leetcode.binarytree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    public static void main(String[] args) {

        //https://leetcode.com/problems/leaf-similar-trees

        System.out.println(leafSimilar(createTreeNode1(), createTreeNode2()));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        depthFirstSearch(root1, leaves1);
        depthFirstSearch(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public static void depthFirstSearch(TreeNode node, List<Integer> leaves) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        depthFirstSearch(node.left, leaves);
        depthFirstSearch(node.right, leaves);
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

    private static TreeNode createTreeNode2() {
        TreeNode nodeLeftRightRight = new TreeNode(4);
        TreeNode nodeLeftRightLeft = new TreeNode(7);
        TreeNode nodeRightRight = new TreeNode(8);
        TreeNode nodeRightLeft = new TreeNode(9);
        TreeNode nodeLeftRight = new TreeNode(2, nodeLeftRightLeft, nodeLeftRightRight);
        TreeNode nodeLeftLeft = new TreeNode(6);
        TreeNode nodeRight = new TreeNode(1, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(5, nodeLeftLeft, nodeLeftRight);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
