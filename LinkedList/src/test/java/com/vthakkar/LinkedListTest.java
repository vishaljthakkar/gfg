package com.vthakkar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    public LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
    @BeforeEach
    void setUp() {
        integerLinkedList.insert(3);
        integerLinkedList.insert(5);
        integerLinkedList.insert(30);
        integerLinkedList.insert(30);
    }

    @Test
    void insert() {
        System.out.println("Insert node 30");
        integerLinkedList.insert(30);
        System.out.println(integerLinkedList);
    }

    @Test
    void deleteDuplicatesSorted() {
        System.out.println("Before Remove Duplicates Sorted List:");
        integerLinkedList.insert(30);
        System.out.println(integerLinkedList);
        integerLinkedList.deleteDuplicatesSorted();
        System.out.println("After Remove Duplicates Sorted List:");
        System.out.println(integerLinkedList);
    }

    @Test
    // ctct 219
    void deleteDuplicatesUnsorted() {
        System.out.println("Before Remove Duplicates Unsorted List:");
        integerLinkedList.insert(30);
        System.out.println(integerLinkedList);
        integerLinkedList.deleteDuplicatesUnSorted();
        System.out.println("After Remove Duplicates Unsorted List:");
        System.out.println(integerLinkedList);
    }
}