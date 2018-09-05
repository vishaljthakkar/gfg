package com.vthakkar;
/* ctci 4.6 pg. 259
4.6 Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
You may assume that each node has a link to its parent.

 */
public class FindSuccessor {

    public TreeNode findSuccessor(TreeNode node) {
        if (node == null)
            return null;

        /* Right subtree is not empty. findt he left most node in the right subtree */
        if (node.right != null) {
            return leftMostChild(node.right);
        } else {
            TreeNode current = node;
            TreeNode parent = node.parent;
            while(parent != null || parent.left != current) {
                current = parent;
                parent = parent.parent;
            }
            return current;
        }
    }

    private TreeNode leftMostChild(TreeNode node) {
        if (node == null)
            return null;
        else {
            while(node.left != null) {
                node = node.left;
            }
        }
        return node;
    }
}
