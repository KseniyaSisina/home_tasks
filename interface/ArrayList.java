package com.company;

/**
 * Created by Ксения on 28.11.2016.
 */
public class ArrayList implements List {

    int elements[];
    int index;

    public void add(int newElement) {
        if (this.index == 0) {
            this.elements[this.index] = newElement;
            this.index++;
        }
        this.elements[this.index] = newElement;
        this.index++;
    }

    public int get(int index) {
        return this.elements[index];
    }

}
