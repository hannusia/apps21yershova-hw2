package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.InputMismatchException;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        this.head = null;
        this.tail = null;
        this.length = 0;
        Node cur = null;
        for (Object el : elements) {
            Node newNode = new Node();
            newNode.setValue(el);
            if (cur != null) {
                cur.setNext(newNode);
            }
            newNode.setPrevious(cur);
            cur = newNode;
            if (this.length == 0) {
                this.head = newNode;
            }
            if (this.length == elements.length - 1) {
                this.tail = newNode;
            }
            this.length++;
        }
    }

    public ImmutableLinkedList() {
        this.length = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return this.addAll(this.length, new Object[] {e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return this.addAll(index, new Object [] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return this.addAll(this.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] ourList = Arrays.copyOf(this.toArray(), this.length);
        Object[] finalArray = new Object[this.length + c.length];
        for (int i = 0; i < finalArray.length; ++i) {
            if (i < index) {
                finalArray[i] = ourList[i];
            } else if (i < index + c.length) {
                finalArray[i] = c[i-index];
            } else {
                finalArray[i] = ourList[i - c.length];
            }
        }
        return new ImmutableLinkedList(finalArray);
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Node curNode = this.head;
        int cur = 0;
        while (curNode != null) {
            if (cur == index) {
                return curNode.getValue();
            }
            curNode = curNode.getNext();
            ++cur;
        }
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] ourList = Arrays.copyOf(this.toArray(), this.length);
        Object[] newList = new Object[this.length-1];
        int counter = 0;
        for (int i = 0; i < this.length; ++i) {
            if (i == index) {
                continue;
            }
            newList[counter++] = ourList[i];
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList linkedList = this.remove(index);
        return linkedList.add(index, e);
    }

    @Override
    public int indexOf(Object e) {
        Node curNode = this.head;
        int counter = 0;
        while (curNode != null) {
            if (curNode.getValue() == e) {
                return counter;
            }
            ++counter;
            curNode = curNode.getNext();
        }
        throw new InputMismatchException();
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] res = new Object[this.length];
        return new ImmutableLinkedList(res);
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[this.length];
        Node curNode = this.head;
        int counter = 0;
        while (curNode != null) {
            res[counter++] = curNode.getValue();
            curNode = curNode.getNext();
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] ourList = Arrays.copyOf(this.toArray(), this.length);
        Object[] afterAdd = new Object[this.length + 1];
        afterAdd[0] = e;
        for (int i = 1; i <= this.length; ++i) {
            afterAdd[i] = ourList[i-1];
        }
        return new ImmutableLinkedList(afterAdd);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] ourList = Arrays.copyOf(this.toArray(), this.length);
        Object[] afterAdd = new Object[this.length + 1];
        afterAdd[this.length] = e;
        for (int i = 0; i < this.length; ++i) {
            afterAdd[i] = ourList[i];
        }
        return new ImmutableLinkedList(afterAdd);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
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
        return remove(length-1);
    }
}
