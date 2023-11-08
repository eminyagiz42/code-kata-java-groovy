package com.codekata.leetcode75.second25.binarytree.model;

/**
 * The type Extended tree node.
 */
public class ExtendedTreeNode {

    /**
     * The Left max.
     */
    public int leftMax;
    /**
     * The Right max.
     */
    public int rightMax;
    /**
     * The Subtree max.
     */
    public int subtreeMax;

    /**
     * Instantiates a new Extended tree node.
     *
     * @param leftMax    the left max
     * @param rightMax   the right max
     * @param subtreeMax the subtree max
     */
    public ExtendedTreeNode(int leftMax, int rightMax, int subtreeMax) {
        this.leftMax = leftMax;
        this.rightMax = rightMax;
        this.subtreeMax = subtreeMax;
    }
}