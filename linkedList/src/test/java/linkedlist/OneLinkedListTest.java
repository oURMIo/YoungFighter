package linkedlist;


import doublelinkedlist.DoubleLinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OneLinkedListTest {

    @Test
    void add() {
        OneLinkedList list = new OneLinkedList();
        Assertions.assertEquals(0, list.getSize());
        list.add("test");
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    void remove() {
        OneLinkedList list = new OneLinkedList();
        list.add("test");
        list.add("test1");
        Assertions.assertEquals(2, list.getSize());
        list.delete(0);
        Assertions.assertEquals(1, list.getSize());
        list.delete(0);
        Assertions.assertEquals(0, list.getSize());
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