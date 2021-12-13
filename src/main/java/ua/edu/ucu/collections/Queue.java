package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList items = new ImmutableLinkedList();

    public Object peek() {
        return items.getFirst();
    }

    public Object dequeue() {
        Object val = items.getFirst();
        items = items.removeFirst();
        return val;
    }

    public void enqueue(Object e) {
        items = items.addLast(e);
    }
}
