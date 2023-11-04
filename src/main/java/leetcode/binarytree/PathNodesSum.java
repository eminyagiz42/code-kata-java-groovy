package leetcode.binarytree;

import leetcode.binarytree.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathNodesSum {

    private static int sum;

    public static void main(String[] args) {

        // https://leetcode.com/problems/path-sum-iii

        System.out.println(pathSum(createTreeNode(), 8)); // output : 3
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)0, 1);

        dfs(root, targetSum, map, (long)0);

        return sum;
    }

    public static void dfs(TreeNode root, int target, Map<Long, Integer> map, long current) {

        if (root == null)
            return;

        current = current + root.val;

        if (map.containsKey(current - target)) {
            sum += map.get(current - target);
        }

        map.put(current, map.getOrDefault(current, 0) + 1);

        if (root.left != null)
            dfs(root.left, target, map, current);

        if (root.right != null)
            dfs(root.right, target, map, current);

        map.put(current, map.get(current) - 1);
    }

    private static TreeNode createTreeNode() {
        TreeNode nodeLeftRightRight = new TreeNode(1);
        TreeNode nodeLeftLeftRight = new TreeNode(-2);
        TreeNode nodeLeftLeftLeft = new TreeNode(3);
        TreeNode nodeRightRight = new TreeNode(11);
        TreeNode nodeLeftRight = new TreeNode(2, null, nodeLeftRightRight);
        TreeNode nodeLeftLeft = new TreeNode(3 , nodeLeftLeftLeft, nodeLeftLeftRight);
        TreeNode nodeRight = new TreeNode(-3, null, nodeRightRight);
        TreeNode nodeLeft = new TreeNode(5, nodeLeftLeft, nodeLeftRight);
        return new TreeNode(10, nodeLeft, nodeRight);
    }
}
