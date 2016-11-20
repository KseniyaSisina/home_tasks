package com.company;

/**
 * Created by Ксения on 14.11.2016.
 */
public class LinkedList {
    // указатель на первый элемент списка
    private Node top;
    private Node last;
    private Node current;
    private int count;

    public void add(Token value) {
        Node newNode = new Node(value);

        if (top == null) {
            this.top = newNode;
            this.last = newNode;
        } else {
            Node current = this.top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.count++;
    }

    public void print() {
        Node current = this.top;
        while (current != null) {
            System.out.println(current.getValue().getBegin());
            System.out.println(current.getValue().getEnd());
            System.out.println(current.getValue().getText());
            System.out.println(current.getValue().getType());
            System.out.println();
            current = current.getNext();
        }
    }

}
