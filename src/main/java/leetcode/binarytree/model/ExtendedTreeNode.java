package leetcode.binarytree.model;

public class ExtendedTreeNode {

    public int leftMax;
    public int rightMax;
    public int subtreeMax;

    public ExtendedTreeNode(int leftMax, int rightMax, int subtreeMax) {
        this.leftMax = leftMax;
        this.rightMax = rightMax;
        this.subtreeMax = subtreeMax;
    }
}