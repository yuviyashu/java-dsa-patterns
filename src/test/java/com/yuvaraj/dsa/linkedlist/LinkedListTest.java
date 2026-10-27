package com.yuvaraj.dsa.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    private static LinkedList listOf(int first, int... rest) {
        LinkedList list = new LinkedList(first);
        for (int value : rest) {
            list.append(value);
        }
        return list;
    }

    @Test
    void constructorCreatesSingleNodeList() {
        LinkedList list = new LinkedList(7);
        assertEquals("7->null", list.toString());
        assertEquals(1, list.getLength());
    }

    @Test
    void appendAddsToEndAndUpdatesLength() {
        LinkedList list = listOf(1, 2, 3);
        assertEquals("1->2->3->null", list.toString());
        assertEquals(3, list.getLength());
    }

    @Test
    void reversesSeveralNodes() {
        LinkedList list = listOf(1, 2, 3, 4, 5);
        list.reverseLinkedList();
        assertEquals("5->4->3->2->1->null", list.toString());
    }

    @Test
    void reversesTwoNodes() {
        LinkedList list = listOf(1, 2);
        list.reverseLinkedList();
        assertEquals("2->1->null", list.toString());
    }

    @Test
    void reversingSingleNodeLeavesItUnchanged() {
        LinkedList list = new LinkedList(9);
        list.reverseLinkedList();
        assertEquals("9->null", list.toString());
        assertEquals(1, list.getLength());
    }

    @Test
    void reverseKeepsLength() {
        LinkedList list = listOf(1, 2, 3);
        list.reverseLinkedList();
        assertEquals(3, list.getLength());
    }

    @Test
    void reversingTwiceRestoresOriginalOrder() {
        LinkedList list = listOf(1, 2, 3, 4);
        list.reverseLinkedList();
        list.reverseLinkedList();
        assertEquals("1->2->3->4->null", list.toString());
    }

    @Test
    void appendAfterReverseGoesToNewEnd() {
        // checks that reverse also moved the tail pointer to the old head
        LinkedList list = listOf(1, 2, 3);
        list.reverseLinkedList();
        list.append(4);
        assertEquals("3->2->1->4->null", list.toString());
        assertEquals(4, list.getLength());
    }

    @Test
    void handlesDuplicatesAndNegatives() {
        LinkedList list = listOf(-1, 0, 0, -1, 5);
        list.reverseLinkedList();
        assertEquals("5->-1->0->0->-1->null", list.toString());
    }
}
