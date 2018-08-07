package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    public BinarySearchTree<Character, Integer> bst = new BinarySearchTree<>();
    public BinarySearchTree<Integer, String> bstInt = new BinarySearchTree<>();

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
}