package leetcode.binarytree;

import leetcode.binarytree.model.TreeNode;

public class DeleteNodeInBinaryTree {

    public static void main(String[] args) {

        //https://leetcode.com/problems/delete-node-in-a-bst

        System.out.println(deleteNode(createTreeNode(), 9));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minimum = getMinimum(root.right);
            root.right = deleteNode(root.right, minimum.val);
            minimum.left = root.left;
            minimum.right = root.right;
            root = minimum;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private static TreeNode getMinimum(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeRightRight = new TreeNode(7);
        TreeNode nodeRightLeft = new TreeNode(15);
        TreeNode nodeRight = new TreeNode(20, nodeRightLeft, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(9, null, null);
        return new TreeNode(3, nodeLeft, nodeRight);
    }
}
