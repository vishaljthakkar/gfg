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

    //ctci222
    @Test
    void findNthToLastTest() {
        integerLinkedList.insert(30);
        System.out.println(integerLinkedList);
        System.out.println("Nth to last: 6");
        System.out.println(integerLinkedList.findNthToLast(6));
        System.out.println("Nth to last: 3");
        System.out.println(integerLinkedList.findNthToLast(3));
    }

    @Test
    void partitionTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(5);
        list.insert(2);
        list.insert(3);
        System.out.println("Before Partition");
        System.out.println(list);
        final LinkedList.Node partition = (LinkedList.Node) list.partition(3);
        System.out.println("After Partition");
        System.out.println(partition);
    }

    @Test
    void partitionTest2() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(4);
        list.insert(2);
        list.insert(10);
        System.out.println("Before Partition");
        System.out.println(list);
        final LinkedList.Node partition = (LinkedList.Node) list.partition(3);
        System.out.println("After Partition");
        System.out.println(partition);
    }

    @Test
    void partitionTest3() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(10);
        list.insert(4);
        list.insert(20);
        list.insert(10);
        list.insert(3);
        System.out.println("Before Partition");
        System.out.println(list);
        final LinkedList.Node partition = (LinkedList.Node) list.partition(3);
        System.out.println("After Partition");
        System.out.println(partition);
    }

    @Test
    void partitionTest4() {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(5);
        list.insert(2);
        System.out.println("Before Partition");
        System.out.println(list);
        final LinkedList.Node partition = (LinkedList.Node) list.partition(3);
        System.out.println("After Partition");
        System.out.println(partition);
    }


    /*
    https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
    CTCI 225
     */

    @Test
    void addTwoNumberTest1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.insert(7);
        list1.insert(1);
        list1.insert(6);
        list2.insert(5);
        list2.insert(9);
        list2.insert(2);
        System.out.println("Addition of below 2 list");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("Result");
        System.out.println(list1.addTwoNumbers(list1.head, list2.head));
    }

    @Test
    void addTwoNumberTest2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.insert(7);
        list1.insert(5);
        list1.insert(9);
        list1.insert(4);
        list1.insert(6);
        list2.insert(8);
        list2.insert(4);
        System.out.println("Addition of below 2 list");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("Result");
        System.out.println(list1.addTwoNumbers(list1.head, list2.head));
    }
}