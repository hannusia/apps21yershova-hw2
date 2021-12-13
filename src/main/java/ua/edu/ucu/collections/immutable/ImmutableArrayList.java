package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] items;

    public ImmutableArrayList(Object[] elements) {
        items = elements.clone();
    }

    public ImmutableArrayList() {
        items = new Object[0];
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] item = {e};
        return addAll(item);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        Object[] item = {e};
        return addAll(index, item);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);
        int newSize = size() + c.length;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < index; i++) {
            newArray[i] = items[i];
        }
        for (int i = index; i < index + c.length; i++) {
            newArray[i] = c[i-index];
        }
        for (int i = index + c.length; i < newSize; i++) {
            newArray[i] = items[i-c.length];
        }
        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return items[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        Object[] newArr = new Object[size()-1];
        for (int i = 0; i < index; i++) {
            newArr[i] = items[i];
        }
        for (int i = index + 1; i < size(); i++) {
            newArr[i-1] = items[i];
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        Object[] newArr = items.clone();
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (items[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return items.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return items.clone();
    }

    private void checkIndex(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException("1");
        } else if (index < 0) {
            throw new IndexOutOfBoundsException("2");
        }
    }
}
