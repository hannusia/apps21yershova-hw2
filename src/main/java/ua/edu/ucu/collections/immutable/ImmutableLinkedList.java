package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int size;

    public ImmutableLinkedList(Object[] elements) {
        head = new Node(elements[0], null, null);
        Node temp = head;
        size = elements.length;
        for (int i = 1; i < size; i++) {
            temp.setNext(new Node(elements[i], temp, null));
            temp = temp.getNext();
        }
        tail = temp;
    }

    public ImmutableLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] val = {e};
        return addAll(this.size, val);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] val = {e};
        return addAll(index, val);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkIndex(index);
        Object[] thisList = Arrays.copyOf(toArray(), size);
        Object[] newList = new Object[size + c.length];
        for (int i = 0; i < newList.length; i++) {
            if (i < index) {
                newList[i] = thisList[i];
            } else if (i < index + c.length) {
                newList[i] = c[i-index];
            } else {
                newList[i] = thisList[i - c.length];
            }
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (counter == index) {
                return temp.getValue();
            }
            temp = temp.getNext();
            counter++;
        }
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        Object[] ourList = Arrays.copyOf(toArray(), size);
        Object[] newList = new Object[size -1];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                continue;
            }
            newList[counter++] = ourList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        Object[] thisArr = toArray();
        Object[] newArr = new Object[size()];
        for (int i = 0; i < size(); i++) {
            if (i != index) {
                newArr[i] = thisArr[i];
            } else {
                newArr[i] = e;
            }
        }
        return new ImmutableLinkedList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            if (temp.getValue() == e) {
                return counter;
            }
            ++counter;
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        Object[] res = new Object[size];
        return new ImmutableLinkedList(res);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        Node temp = this.head;
        int counter = 0;
        while (temp != null) {
            res[counter++] = temp.getValue();
            temp = temp.getNext();
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] ourList = Arrays.copyOf(toArray(), size);
        Object[] afterAdd = new Object[size + 1];
        afterAdd[0] = e;
        for (int i = 1; i <= size; ++i) {
            afterAdd[i] = ourList[i-1];
        }
        return new ImmutableLinkedList(afterAdd);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] thisList = Arrays.copyOf(toArray(), size);
        Object[] newList = new Object[size + 1];
        newList[size] = e;
        for (int i = 0; i < size; ++i) {
            newList[i] = thisList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (this.head != null) {
            return head.getValue();
        }
        throw new InputMismatchException();
    }

    public Object getLast() {
        if (this.tail != null) {
            return tail.getValue();
        }
        throw new InputMismatchException();
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size -1);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
