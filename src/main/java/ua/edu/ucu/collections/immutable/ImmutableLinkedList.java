package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;

    public ImmutableLinkedList(Object[] elements) {
        head = new Node(elements[0], null, null);
        Node temp = head;
        for (int i = 1; i < elements.length; i++) {
            temp.setNext(new Node(elements[i], temp, null));
            temp = temp.getNext();
        }
        tail = temp;
    }

    public ImmutableLinkedList() {
        this.head = new Node();
        this.tail = head;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        Object[] item = {e};
        return add(item);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        Object[] item = {e};
        return add(index, item);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (index != size()) {
            checkIndex(index);
        }
        int newSize = size() + c.length;
        Object[] newElements = new Object[newSize];
        Node temp = head;
        for (int i = 0; i < index; i++) {
            newElements[i] = temp.getValue();
            temp = temp.getNext();
        }
        for (int i = index; i < index + c.length; i++) {
            newElements[i] = c[i - index];
        }
        for (int i = index + c.length; i < newSize; i++) {
            newElements[i] = temp.getValue();
            temp = temp.getNext();
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        int counter = 0;
        Node temp = head;
        while (counter < index) {
            temp = temp.getNext();
            counter ++;
        }
        return temp.getValue();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        Object[] thisArr = toArray();
        Object[] newArr = new Object[size() - 1];
        for (int i = 0; i < index; i++) {
            newArr[i] = thisArr[i];
        }
        for (int i = index + 1; i < size(); i++) {
            newArr[i-1] = thisArr[i];
        }
        return new ImmutableLinkedList(newArr);
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
        int counter = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.getValue() == e) {
                return counter;
            }
            counter++;
            temp = temp.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size ++;
            temp = temp.getNext();
        }
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node temp = head;
        int index = 0;
        while (temp.getNext() != null) {
            arr[index] = temp.getValue();
            temp = temp.getNext();
            index++;
        }
        arr[index] = temp.getValue();
        return arr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList newList = copy();
        if (head.getValue() == null){
            return newList;
        }
        newList.head = newList.head.getNext();
        newList.head.setPrevious(null);
        return newList;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList newList = copy();
        if (tail.getValue() == null){
            return newList;
        }
        newList.head = newList.head.getPrevious();
        newList.head.setNext(null);
        return newList;
    }

    private ImmutableLinkedList copy(){
        Object[] arr = this.toArray();
        ImmutableLinkedList newList = new ImmutableLinkedList(arr);
        return newList;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }
}
