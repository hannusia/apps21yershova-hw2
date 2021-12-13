package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elems;

    public Stack() {
        this.elems = new ImmutableLinkedList();
    }

    public Stack(Object[] arr) {
        this.elems = new ImmutableLinkedList(arr);
    }

    public void push(Object e) {
        this.elems = elems.addLast(e);
    }

    public Object pop() {
        Object toRemove = peek();
        this.elems = elems.removeLast();
        return toRemove;
    }

    public Object peek() {
        return elems.getLast();
    }
}