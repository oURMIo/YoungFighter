package doublelinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleLinkedListTest {

    @Test
    void add() {
        var list = new DoubleLinkedList();
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
        list.add("1");
        assertEquals(1, list.getSize());
        assertFalse(list.isEmpty());
    }

    @Test
    void delete() {
        var list = new DoubleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.delete(0);
        assertEquals(3, list.getSize());
        list.delete(0);
        assertEquals(2, list.getSize());
    }

    @Test
    void reverse() {
        var list = new DoubleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.reverse();
        assertEquals(3, list.getSize());
    }

    @Test
    void delete2() {
        var list = new DoubleLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.delete(-1);
        list.delete(-1);
        list.add("4");
        assertEquals(4, list.getSize());
    }
}