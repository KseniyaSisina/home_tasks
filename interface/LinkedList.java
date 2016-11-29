package com.company;

/**
 * Created by Ксения on 28.11.2016.
 */
public class LinkedList implements List{

    Node top;
    Node last;
    int count;

    public void add(int value) {
        Node newNode = new Node();
        newNode.value = value;
        if  (top == null) {
            this.top = newNode;
            this.last = newNode;
        } else {
            Node current = this.top;
            while (current.next != null) {
                current = current.next;
            }
            current.next.value = newNode.value;
        }
        this.count++;
    }

    public int get(int index) {
        this.count = 1;
        Node current = this.top;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    /**
     * Created by Ксения on 28.11.2016.
     */
    public static class Node {
        public int value;
        public Node next;
    }

}
