package com.vthakkar;

import java.util.ArrayList;
import java.util.LinkedList;

/* CTCI 4.3 pg 254 */
/*
List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
(e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepth {

    private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,
                                              int level) {
        if (root == null) return; //base case
        LinkedList<TreeNode> list = null;

        /* levels are always traversed in order. So, if this is the first time  we have visitied level i, we must have
        seen levels 0 through i - 1. We can therefore safely add the level at the end.
         */
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }
}
