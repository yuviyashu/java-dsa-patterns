package com.yuvaraj.dsa.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // --- hasCycle ---

    @Test
    void noCycleInStraightList() {
        assertFalse(listOf(1, 2, 3, 4, 5).hasCycle());
    }

    @Test
    void noCycleInSingleNode() {
        assertFalse(new LinkedList(1).hasCycle());
    }

    @Test
    void noCycleInTwoNodes() {
        assertFalse(listOf(1, 2).hasCycle());
    }

    @Test
    void detectsCycleBackToMiddle() {
        // 3 -> 2 -> 0 -> -4 -> back to 2
        LinkedList list = listOf(3, 2, 0, -4);
        list.linkTailTo(1);
        assertTrue(list.hasCycle());
    }

    @Test
    void detectsCycleBackToHead() {
        LinkedList list = listOf(1, 2, 3);
        list.linkTailTo(0);
        assertTrue(list.hasCycle());
    }

    @Test
    void detectsTwoNodeCycle() {
        LinkedList list = listOf(1, 2);
        list.linkTailTo(0);
        assertTrue(list.hasCycle());
    }

    @Test
    void detectsSingleNodePointingToItself() {
        LinkedList list = new LinkedList(1);
        list.linkTailTo(0);
        assertTrue(list.hasCycle());
    }

    @Test
    void detectsCycleOnlyAtTail() {
        // tail points to itself after a long straight run
        LinkedList list = listOf(1, 2, 3, 4, 5, 6, 7);
        list.linkTailTo(6);
        assertTrue(list.hasCycle());
    }

    @Test
    void noCycleWithDuplicateValues() {
        // equal values must not be mistaken for the same node
        assertFalse(listOf(7, 7, 7, 7).hasCycle());
    }

    @Test
    void noCycleAfterReverse() {
        LinkedList list = listOf(1, 2, 3);
        list.reverseLinkedList();
        assertFalse(list.hasCycle());
    }

    // --- findCycleStart ---

    @Test
    void findsCycleStartInMiddle() {
        // 3 -> 2 -> 0 -> -4 -> back to 2
        LinkedList list = listOf(3, 2, 0, -4);
        list.linkTailTo(1);
        assertEquals(2, list.findCycleStart());
    }

    @Test
    void findsCycleStartAtHead() {
        LinkedList list = listOf(1, 2, 3, 4);
        list.linkTailTo(0);
        assertEquals(1, list.findCycleStart());
    }

    @Test
    void findsCycleStartInTwoNodeLoop() {
        LinkedList list = listOf(1, 2);
        list.linkTailTo(0);
        assertEquals(1, list.findCycleStart());
    }

    @Test
    void findsCycleStartWhenSingleNodePointsToItself() {
        LinkedList list = new LinkedList(42);
        list.linkTailTo(0);
        assertEquals(42, list.findCycleStart());
    }

    @Test
    void findsCycleStartWhenTailPointsToItself() {
        LinkedList list = listOf(1, 2, 3, 4, 5, 6, 7);
        list.linkTailTo(6);
        assertEquals(7, list.findCycleStart());
    }

    @Test
    void findsCycleStartAfterLongRunIntoSmallLoop() {
        // 10 nodes before the loop, then a 3-node loop: 11 -> 12 -> 13 -> back to 11
        LinkedList list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);
        list.linkTailTo(10);
        assertEquals(11, list.findCycleStart());
    }

    @Test
    void findsCycleStartAtEveryPosition() {
        for (int start = 0; start < 8; start++) {
            LinkedList list = listOf(100, 101, 102, 103, 104, 105, 106, 107);
            list.linkTailTo(start);
            assertEquals(100 + start, list.findCycleStart(), "cycle starting at index " + start);
        }
    }

    @Test
    void returnsMinValueWhenNoCycle() {
        assertEquals(Integer.MIN_VALUE, listOf(1, 2, 3).findCycleStart());
    }

    @Test
    void returnsMinValueForSingleNodeWithoutCycle() {
        assertEquals(Integer.MIN_VALUE, new LinkedList(5).findCycleStart());
    }

    @Test
    void returnsMinValueWithDuplicatesButNoCycle() {
        assertEquals(Integer.MIN_VALUE, listOf(7, 7, 7).findCycleStart());
    }
}
