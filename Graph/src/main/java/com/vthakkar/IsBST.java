package com.vthakkar;

public class IsBST {

    /* ctci 4.5 pg 256
    4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
     */
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode x, Integer min, Integer max) {
        // leaf nodes left and right will return true
        if (x == null) {
            return true;
        }

        /* Assumption is that equal nodes in the tree go to left */
        if (x.data <= min || x.data > max) {
            return false;
        }

        return isBST(x.left, min, x.data) && isBST(x.right, x.data, max);
    }
}
