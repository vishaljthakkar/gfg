package com.vthakkar;

import java.util.*;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    public Node root;

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

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(key.toString()).append("->").append(value.toString());
            return sb.toString();
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

    /* Return the largest key in a tree */
    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("BST is empty");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else return max(x.right);
    }

    public void inOrderTraversalRecursive() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST is empty");
        }
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive (Node x) {
        if (x == null)
            return;
        inOrderTraversalRecursive(x.left);
        System.out.println(x.toString());
        inOrderTraversalRecursive(x.right);
    }

    public void inOrderTraversalIterative(Node x) {
        if (x == null) {
            throw new IllegalArgumentException("Null passed");
        }
        Stack<Node> stack = new Stack<>();
        Node current = x;
        stack.push(current);
        current = current.left;
        while(!stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current);
                current = current.right;
            }
        }
    }

    /* Morris Traversal */
    public void inOrderTraversalIterativeWithoutStack(Node x) {
        Node pre;
        if (x == null) {
            throw new IllegalArgumentException("Null passed");
        }
        Node current = x;
        while(current != null) {
            /* If there is no left child visit the node */
            if (current.left == null) {
                System.out.println(current);
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while(pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                    pre.right = null;
                    System.out.println(current);
                    current = current.right;
                }

            }
        }
    }

    public void preOrderTraversalRecursive() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST is Empty");
        }
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(Node x) {
        if (x == null) {
            return;
        }
        System.out.println(x);
        preOrderTraversalRecursive(x.left);
        preOrderTraversalRecursive(x.right);
    }

    public void postOrderTraversalRecursive() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST is Empty");
        }
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(Node x) {
        if (x == null)
            return;
        postOrderTraversalRecursive(x.left);
        postOrderTraversalRecursive(x.right);
        System.out.println(x);
    }

    /*
        Given root node of 2 BST return true if 2 BST are same else return false
     */
    public boolean isSameBst(Node x, Node y) {

        if (x == null && y == null) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return (x.key.compareTo(y.key) == 0) &&
                isSameBst(x.left, y.left) && isSameBst(x.right, y.right);
    }

    /*
        Given a root node of a bst return the height of the tree
     */
    public int heightOfBst() {
        return heightOfBst(root);
    }
    private int heightOfBst(Node x) {
        if (x == null) {
            return 0;
        }
        int leftHeight = heightOfBst(x.left);
        int rightHeight = heightOfBst(x.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean rootToLeafSum(Node x, Integer sum, List<Integer> result) {
        if (x == null) {
            return false;
        }
        //Leaf Node
        if (x.left == null && x.right == null) {
            if (x.value == sum) {
                result.add((Integer)x.value);
                return true;
            } else {
                return false;
            }
        }
        if (rootToLeafSum(x.left, sum - (Integer)x.value, result)) {
            result.add((Integer)x.value);
            return true;
        }
        if (rootToLeafSum(x.right, sum - (Integer)x.value, result)) {
            result.add((Integer)x.value);
            return true;
        }
        return false;
    }


    /* CTCI 4.5 pg. 256 */
    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node x, Integer min, Integer max) {
        // leaf nodes left and right will return true
        if (x == null) {
            return true;
        }

        /* Assumption is that equal nodes in the tree go to left */
        if ((Integer)x.key <= min || (Integer)x.key > max) {
            return false;
        }

        return isBST(x.left, min, (Integer)x.key) && isBST(x.right, (Integer)x.key, max);
    }

    public void levelOrderBst() {
        if (this == null || this.isEmpty()) {
            throw new NoSuchElementException("BST not initialized and/or is empty");
        }

//        LinkedList<Node> queue = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        Node current = this.root;
        queue.add(current);
        while(!queue.isEmpty()) {
//            current = queue.removeFirst();
            current = queue.poll();
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            System.out.println(current);
        }
    }


    /* Construct tree from inorder sequence and pre order sequence */
    static int preIndex = 0;
    /* Recursive function to construct binary of size len from
       Inorder traversal in[] and Preorder traversal pre[].
       Initial values of inStrt and inEnd should be 0 and len -1.
       The function doesn't do any error checking for cases where
       inorder and preorder do not form a tree */

    public Node constructTree(Character[] in, Character[] pre, int inStrt, int inEnd) {
        if (inStrt > inEnd)
            return null;
         /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
        Node tNode = new Node((Key)pre[preIndex], (Value)pre[preIndex], 1);
        preIndex += 1;
        /* If this node has no children then return */
        if (inStrt == inEnd)
            return tNode;
        /* search this node in inorder array */
        int inIndex = search(in, inStrt, inEnd, tNode.key);
        tNode.left = constructTree(in, pre, inStrt, inIndex - 1 );
        tNode.right = constructTree(in, pre, inIndex + 1, inEnd);
        return tNode;
    }

    private int search(Character[] in, int inStrt, int inEnd, Key key) {
        int i;
        for (i = inStrt; i <= inEnd; i++) {
            if (key.compareTo((Key)in[i]) == 0) {
                return i;
            }
        }
        return i;
    }

    public void rootToLeafPaths(Node x) {
        if (x == null) {
            throw new IllegalArgumentException("Passed null");
        }
        ArrayList<Node> path = new ArrayList<>();
        rootToLeafPathsRecurse(x, path);
    }

    private void rootToLeafPathsRecurse(Node x, ArrayList<Node> path) {
        if (x == null) {
            return;
        }
        path.add(x);
        if (x.left == null && x.right == null) {
            System.out.println(path);
            /* Before returning remove this node so that list is back
            to its original state before calling this stack frame */
            path.remove(path.size() - 1);
            return;
        }
        rootToLeafPathsRecurse(x.left, path);
        rootToLeafPathsRecurse(x.right, path);
        /*Basically when even you return from current stack frame you need to restore you array list*/
        path.remove(path.size() - 1);
    }

}
