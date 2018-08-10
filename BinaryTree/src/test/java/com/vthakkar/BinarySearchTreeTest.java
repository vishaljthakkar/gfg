package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    public BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();
    public BinarySearchTree<Integer, String> bstInt = new BinarySearchTree<>();
    public BinarySearchTree<Integer, Integer> bstInt2 = new BinarySearchTree<>();

    @BeforeEach
    void setUp() {
        bst.put('S', 1);
        bst.put('E', 2);
        bst.put('A', 3);
        bst.put('R', 4);
        bst.put('C', 5);
        bst.put('H', 6);
        bst.put('M', 7);
        bst.put('X', 8);

        bstInt.put(10, "TEN");
        bstInt.put(15, "FIFTEEN");
        bstInt.put(30, "THIRTY");
        bstInt.put(3, "THREE");
        bstInt.put(6, "SIX");
        bstInt.put(5, "FIVE");
        bstInt.put(2, "TWO");
        bstInt.put(9, "NINE");
        bstInt.put(8, "EIGHT");

        bstInt2.put(10, 10);
        bstInt2.put(15, 15);
        bstInt2.put(30, 30);
        bstInt2.put(3, 3);
        bstInt2.put(6, 6);
        bstInt2.put(5, 5);
        bstInt2.put(2, 2);
        bstInt2.put(9, 9);
        bstInt2.put(8, 8);
    }

    @Test
    void isEmpty() {
        assertFalse(bst.isEmpty());
    }

    @Test
    void size() {
        assertEquals(8, bst.size());
    }

    @Test
    void contains() {
        assertTrue(bst.contains('S'));
        assertFalse(bst.contains('Z'));
    }

    @Test
    void get() {
        assertEquals(Integer.valueOf(8), bst.get('X'));
        assertEquals(Integer.valueOf(7), bst.get('M'));
        assertNull(bst.get('D'));
    }

    @Test
    void put() {
        assertThrows(IllegalArgumentException.class, () -> bst.put(null, 20));
    }

    @Test
    void deleteMin() {
        IntStream.range(0, bst.size()).forEach(i -> {
            System.out.println("Deleting: " + bst.min());
            bst.deleteMin();
        });
        assertThrows(NoSuchElementException.class, () -> bst.deleteMin());
    }

    @Test
    void deleteMax() {
        assertEquals((Character)'X', bst.max());
        bst.deleteMax();
        assertEquals((Character)'S', bst.max());
    }

    @Test
    void delete() {
        bst.delete('X');
        assertEquals(7, bst.size());
    }

    @Test
    void min() {
        assertEquals((Character)'A', bst.min());
    }

    @Test
    void max() {
        assertEquals((Character)'X', bst.max());
    }

    @Test
    void inOrderTraversalRecursive() {
        System.out.println("In Order Traversal for BST1: ");
        bst.inOrderTraversalRecursive();
        System.out.println("In Order Traversal for BST2: ");
        bstInt.inOrderTraversalRecursive();
    }

    @Test
    void inOrderTraversalIterative() {
        // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
        System.out.println("In Order Traversal Iterative for BST1: ");
        bst.inOrderTraversalIterative(bst.root);
        System.out.println("In Order Traversal Iterative for BST2: ");
        bstInt.inOrderTraversalIterative(bstInt.root);
    }

    @Test
    void inOrderTraversalIterativeWithoutStack() {
        // https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
        System.out.println("In Order Morris for BST1: ");
        bst.inOrderTraversalIterativeWithoutStack(bst.root);
        System.out.println("In Order Morris for BST2: ");
        bstInt.inOrderTraversalIterativeWithoutStack(bstInt.root);
    }

    @Test
    void preOrderTraversalRecursive() {
        System.out.println("Pre Order Traversal for BST1: ");
        bst.preOrderTraversalRecursive();
        System.out.println("Pre Order Traversal for BST2: ");
        bstInt.preOrderTraversalRecursive();
    }

    @Test
    void postOrderTraversalRecursive() {
        System.out.println("Post Order Traversal for BST1: ");
        bst.postOrderTraversalRecursive();
        System.out.println("Post Order Traversal for BST2: ");
        bstInt.postOrderTraversalRecursive();
    }

    @Test
    void isSameBst() {
        assertTrue(bst.isSameBst(bst.root, bst.root));
        BinarySearchTree<Character, Integer> bst2= new BinarySearchTree<>();
        bst2.put('Z', 12);
        assertFalse(bst.isSameBst(bst.root, bst2.root));
    }

    @Test
    void heightOfBst() {
        assertEquals(0, new BinarySearchTree().heightOfBst());
        assertEquals(5, bst.heightOfBst());
        assertEquals(5, bstInt.heightOfBst());
    }

    @Test
    void rootToLeafSum() {
        ArrayList<Integer> result = new ArrayList<>();
        assertTrue(bstInt2.rootToLeafSum(bstInt2.root, 36, result));
        assertIterableEquals(Arrays.asList(8,9,6,3,10), result);
    }

    @Test
    void isBST() {
        /* https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/*/

        assertTrue(bstInt2.isBST());
    }

    @Test
    void levelOrderBst() {
        bstInt.levelOrderBst();
        bst.levelOrderBst();
    }
}