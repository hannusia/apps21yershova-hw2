package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAddEnd() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        ImmutableArrayList newArrayList = arrayList.add(1);
        Object[] old = {};
        Object[] expected = {1};
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }
    @Test
    public void testAddIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,2,3,4};
        ImmutableArrayList newArrayList = arrayList.add(2, 3);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testAddAllEnd() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,2,4,5,6};
        Object[] toAdd = {5,6};
        ImmutableArrayList newArrayList = arrayList.addAll(toAdd);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testAddAllIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,5,6,2,4};
        Object[] toAdd = {5,6};
        ImmutableArrayList newArrayList = arrayList.addAll(1, toAdd);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,5,6,2,4};
        Object[] toAdd = {5,6};
        ImmutableArrayList newArrayList = arrayList.addAll(10, toAdd);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testGet() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        assertEquals(1, arrayList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        assertEquals(1, arrayList.get(10));
    }

    @Test
    public void testRemove() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,4};
        ImmutableArrayList newArrayList = arrayList.remove(1);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testRemoveOneElem() {
        Object[] old = {1};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {};
        ImmutableArrayList newArrayList = arrayList.remove(0);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,4};
        ImmutableArrayList newArrayList = arrayList.remove(10);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testSet() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,3,4};
        ImmutableArrayList newArrayList = arrayList.set(1, 3);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWrongIndex() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {1,3,4};
        ImmutableArrayList newArrayList = arrayList.set(10, 3);
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void testIndexOfNormal() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        int got = arrayList.indexOf(2);
        assertEquals(1, got);
    }

    @Test
    public void testIndexOfAbsent() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        int got = arrayList.indexOf(3);
        assertEquals(-1, got);
    }

    @Test
    public void testSize() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testSizeEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testClear() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        Object[] expected = {};
        ImmutableArrayList newArrayList = (ImmutableArrayList) arrayList.clear();
        assertArrayEquals(expected, newArrayList.toArray());
        assertArrayEquals(old, arrayList.toArray());
    }

    @Test
    public void isEmptyFalse() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void isEmptyTrue() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void toArray() {
        Object[] old = {1,2,4};
        ImmutableArrayList arrayList = new ImmutableArrayList(old);
        assertArrayEquals(old, arrayList.toArray());
    }
}