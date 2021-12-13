package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class ImmutableLinkedListTest extends TestCase {
    private ImmutableLinkedList linkedList;
    private ImmutableList newLinkedList;

    public void setUp() throws Exception {
        super.setUp();
        this.linkedList = new ImmutableLinkedList(new Object[] {1, 2, 3});
    }

    public void testAdd() {
        newLinkedList = linkedList.add(4);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 3, 4};
        for (int i = 0; i < 4; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testTestAdd() {
        newLinkedList = linkedList.add(2, 4);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 4, 3};
        for (int i = 0; i < 4; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testAddAll() {
        newLinkedList = linkedList.addAll(new Object[] {4, 5});
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 3, 4, 5};
        for (int i = 0; i < 5; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testTestAddAll() {
        newLinkedList = linkedList.addAll(2, new Object[] {4, 5});
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 4, 5, 3};
        for (int i = 0; i < 5; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testGet() {
        assertEquals(linkedList.get(1), 2);
    }

    public void testRemove() {
        newLinkedList = linkedList.remove(1);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 3};
        for (int i = 0; i < 2; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testSet() {
        newLinkedList = linkedList.set(2, 4);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 4};
        for (int i = 0; i < 3; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testIndexOf() {
        assertEquals(linkedList.indexOf(2), 1);
    }

    public void testSize() {
        assertEquals(linkedList.size(), 3);
    }

    public void testClear() {
        newLinkedList = linkedList.clear();
        Object[] actualRes = newLinkedList.toArray();
        for (int i =0; i < 3; ++i) {
            assertNull(actualRes[i]);
        }
    }

    public void testIsEmpty() {
        assertFalse(linkedList.isEmpty());
    }

    public void testToArray() {
        Object[] arr = linkedList.toArray();
        Object[] expectedRes = new Object[] {1, 2, 3};
        for (int i = 0; i < 3; ++i) {
            assertEquals(expectedRes[i], arr[i]);
        }
    }

    public void testAddFirst() {
        newLinkedList = linkedList.addFirst(0);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {0, 1, 2, 3};
        for (int i = 0; i < 4; ++i) {
            assertEquals(expectedRes[i], actualRes[i]);
        }
    }

    public void testAddLast() {
        newLinkedList = linkedList.addLast(5);
        Object[] actualRes = newLinkedList.toArray();
        Object[] expectedRes = {1, 2, 3, 5};
        for (int i = 0; i < 4; ++i) {
            assertEquals(expectedRes[i], actualRes[i]);
        }
    }

    public void testGetHead() {
        assertEquals(linkedList.getHead().getValue(), 1);
    }

    public void testGetTail() {
        assertEquals(linkedList.getTail().getValue(), 3);
    }

    public void testGetFirst() {
        assertEquals(linkedList.getFirst(), 1);
    }

    public void testGetLast() {
        assertEquals(linkedList.getLast(), 3);
    }

    public void testRemoveFirst() {
        newLinkedList = linkedList.removeFirst();
        Object[] expectedRes = new Object[] {2, 3};
        Object[] actualRes = newLinkedList.toArray();
        for (int i = 0; i < 2; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }

    public void testRemoveLast() {
        newLinkedList = linkedList.removeLast();
        Object[] expectedRes = new Object[] {1, 2};
        Object[] actualRes = newLinkedList.toArray();
        for (int i = 0; i < 2; ++i) {
            assertEquals(actualRes[i], expectedRes[i]);
        }
    }
}