package com.company;

/**
 * Created by Ксения on 10.11.2016.
 */
public class Node {
    // значение узла
    private Token value;
    // указатель на следующий элемент
    private Node next;

    public Node(Token value) {
        this.value = value;
    }

    public Node(Token value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Token getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
