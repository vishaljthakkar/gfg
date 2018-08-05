package com.vthakkar;

import java.util.NoSuchElementException;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;            // sorted by key
        private Value value;        // value associated at this node
        private Node left, right;   // left and right subtree
        private int size;           // number of nodes in subtree

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BinarySearchTree() {

    }

    /* Check if BST is Empty */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* Size of the tree */
    public int size() {
        return size(root);
    }

    /* Size of the subtree rooted at Node node */
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    /* check if given key is present in the tree */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: passed key is null");
        }
        return get(key) != null;
    }

    /* Returs the value associated with this key */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: passed key is null");
        }
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.value;
    }

    /* Inserts the K,V pair in the tree
    * If passed value is null, delete the node from the tree.
    * */

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: Key argument is null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
//        assert check();
    }

    /* Inserts the K, V pair in the sub tree rooted at x */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /* Remove the smallest key and associated value from BST */
    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("BST is empty");
        root = deleteMin(root);
    }

    /* Remove the smallest key and value from a sub tree rooted at Node x */
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* Remove the largest key and associated value from BST */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST is empty");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* Delete the Key from the tree (if the key is present in the tree) */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("ERROR: Key argument is null");
        }
        root = delete(root, key);
    }

    /* Delete E

                S
              /   \
      t<- - -E     X
           /    \
          A      R
         / \    /
            C  H - - - > X
                \
                 M



        * Save a link to the node to be deleted in t.
        * Set x to point to its successor min(t.right).
        * Set the right link of x (which is supposed to point to the BST containing all the keys larger than x.key)
            to deleteMin(t.right), the link to the BST containing all the keys that are larger than x.key after the deletion.
        * Set the left link of x (which was null) to t.left (all the keys that are less than both the deleted key and its successor).

     */


    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /* Return the smallest key in the tree */
    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("BST is empty");
        return min(root).key;
    }

    /* Return the smallest key in the tree rooted at Node x */
    private Node min(Node x) {
        if (x.left == null)
            return x;
        else return min(x.left);
    }
}