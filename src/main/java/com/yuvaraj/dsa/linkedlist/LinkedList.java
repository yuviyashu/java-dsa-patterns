package com.yuvaraj.dsa.linkedlist;

/**
 * Problem: https://leetcode.com/problems/reverse-linked-list/
 * Pattern: Linked List
 * Intuition: Like a conga line turning around — walk down the line and have each person let go of
 * the one in front and grab the one behind instead; the last person becomes the new leader.
 * Time: append O(1), reverse O(n)   Space: O(1) extra for reverse
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
     * Returns the number of nodes in the list.
     *
     * @return the number of nodes
     */
    public int getLength(){
        return length;
    }

}
