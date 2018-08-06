package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    public BinarySearchTree<Character, Integer> bst = new BinarySearchTree<Character, Integer>();

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
}