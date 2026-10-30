package com.yuvaraj.dsa.linkedlist;

/**
 * Problem: https://leetcode.com/problems/reverse-linked-list/
 *          https://leetcode.com/problems/linked-list-cycle/
 *          https://leetcode.com/problems/linked-list-cycle-ii/
 * Pattern: Linked List
 * Intuition: Reverse — like a conga line turning around: each person lets go of the one in front
 * and grabs the one behind instead. Cycle — like two runners on a track, one twice as fast: on a
 * loop the fast one always laps the slow one; on a straight road it just reaches the end. Cycle
 * start — after they meet, send one runner back to the start line; walking at the same pace, the
 * two meet again exactly where the loop begins.
 * Time: append O(1), reverse / hasCycle / findCycleStart O(n)   Space: O(1) extra
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Creates a list containing a single node with {@code value}.
     *
     * @param value the value of the first node
     */
    public LinkedList(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        length++;
    }

    /**
     * Adds a node with {@code value} to the end of the list in O(1) time using the tail pointer.
     *
     * @param value the value to add
     */
    public void append(int value){
        Node node = new Node(value);
        if(this.head == null){
            this.head = node;
            this.tail = node;
            length++;
        }else{
            tail.next = node;
            tail = node;
            length++;
        }
    }

    /**
     * Returns the list as {@code "1->2->3->null"}, or {@code "[]"} if it has no nodes.
     */
    @Override
    public String toString(){
        if(head == null){
            return "[]";
        }else{
            Node curr = head;
            StringBuilder sb = new StringBuilder();
            while(curr != null){
                sb.append(curr.val+"->");
                curr = curr.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }

    /**
     * Reverses the list in place by flipping each node's {@code next} pointer, and swaps
     * {@code head} and {@code tail} so that later appends still go to the end.
     */
    public void reverseLinkedList(){
        Node prev = null;
        Node curr = head;


        head = tail;
        tail = curr;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

    }

    /**
     * Returns whether the list loops back on itself, using Floyd's fast and slow pointers.
     *
     * @return {@code true} if following {@code next} pointers never reaches {@code null}
     */
    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the value of the node where the cycle begins, using Floyd's algorithm: once the fast
     * and slow pointers meet, restart one from {@code head} and step both one node at a time.
     *
     * @return the value of the first node in the cycle, or {@link Integer#MIN_VALUE} if the list
     *     has no cycle
     */
    public int findCycleStart(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                 slow = head;

                 while( slow != fast){
                     slow = slow.next;
                     fast = fast.next;
                 }
                 return slow.val;
            }
        }
        return Integer.MIN_VALUE;
    }


    /**
     * Test helper: points the tail's {@code next} back at the node at {@code index}, creating a
     * cycle. The public API can't create one, so tests need this to exercise {@link #hasCycle()}.
     * Once called, {@link #toString()} and {@link #reverseLinkedList()} would loop forever.
     */
    void linkTailTo(int index) {
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        tail.next = target;
    }

    /**
     * Returns the number of nodes in the list.
     *
     * @return the number of nodes
     */
    public int getLength(){
        return length;
    }

}
