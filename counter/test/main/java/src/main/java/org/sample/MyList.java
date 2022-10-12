package org.sample;

import java.util.*;

public class MyList implements List {

    private int size;
    private Unit head;
    private Unit last;

    private void replaceId() {
        Unit time = head;
        for (int i = 0; i < size; i++) {
            time.setId(i);
            time = time.getNext();
        }
    }

    public void reverse() {
        Unit prev = null;
        Unit current = head;
        Unit next;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        replaceId();
    }

    public boolean unRetainAll(Collection c) {
        if (isEmpty()) {
            return false;
        }
        Unit find = head;
        while (find != null) {
            for (Object curr : c) {
                if (curr == find.getValue()) {
                    remove(curr);
                }
            }
            find = find.getNext();
        }
        return true;
    }

    private Unit getUnit(int index) {
        Unit curr = head;
        Unit time = null;
        while (curr != null) {
            if (curr.getId() == index) {
                time = curr;
            }
            curr = curr.getNext();
        }
        return time;
    }

    public void printBack() {
        Unit time = last;
        System.out.print("List back - ");
        while (time != null) {
            System.out.printf("[%s] ", time.getValue());
            time = time.getPrev();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Unit curr = head;
        while (curr != null) {
            if (curr.getValue() != null) {
                result.append(curr.getId()).append(" = ").append(curr.getValue()).append("\t");
            }
            curr = curr.getNext();
        }
        return result.toString();
    }

    @Override
    public boolean add(Object o) {
        Unit newAll = new Unit();
        newAll.setId(size);
        newAll.setValue(o);
        size++;
        if (head == null) {
            head = newAll;
        } else {
            last.setNext(newAll);
        }
        newAll.setPrev(last);
        last = newAll;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        if (head.getValue() == o) {   /*   IF WE NEED FIRST   */
            head.getNext().setPrev(null);
            head = head.getNext();
            size--;
            return true;
        }
        if (last.getValue() == o) {    /* IF LAST */
            last.getPrev().setNext(null);
            last = last.getPrev();
            size--;
            return true;
        }
        Unit find = head;
        while (find.getNext() != null) {
            if (find.getNext().getValue() == o) {
                find.setNext(find.getNext().getNext());
                find.getNext().setPrev(find);
                size--;
            }
            find = find.getNext();
        }
        replaceId();
        return true;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            return null;
        }
        Object time = null;
        if (head.getId() == index) {    /* IF FIRST */
            time = head.getValue();
            head.getNext().setPrev(null);
            head = head.getNext();
            size--;
            return time;
        }
        if (last.getId() == index) {    /* IF LAST */
            time = last.getValue();
            last.getPrev().setNext(null);
            last = last.getPrev();
            size--;
            return time;
        }
        Unit find = head;
        while (find.getNext() != null) {
            if (find.getNext().getId() == index) {
                time = find.getValue();
                find.setNext(find.getNext().getNext());
                find.getNext().setPrev(find);
                size--;
                replaceId();
                return time;
            }
            find = find.getNext();
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object get(int index) {
        Unit curr = head;
        while (curr != null) {
            if (curr.getId() == index) {
                return curr.getValue();
            }
            curr = curr.getNext();
        }
        return null;
    }


    @Override
    public void add(int index, Object element) {
        if (index > size) {
            return;
        }
        if (index == size) {
            add(element);
            return;
        }
        Unit newAll = new Unit();
        newAll.setId(index);
        newAll.setValue(element);
        if (index == 0) {
            head.setPrev(newAll);
            newAll.setNext(head);
            head = newAll;
            size++;
            return;
        }
        if (head == null) {
            head = newAll;
            last = newAll;
        } else {
            int i = 0;
            Unit endList = head;
            Unit preEndList = head;
            while (i != index) {
                preEndList = endList;
                newAll.setNext(endList.getNext());
                newAll.setPrev(endList.getPrev());
                endList = endList.getNext();
                i++;
            }
            newAll.setPrev(preEndList);
            preEndList.getNext().setPrev(newAll);
            preEndList.setNext(newAll);
        }
        size++;
        replaceId();
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        Unit curr = head;
        while (curr != null) {
            if (curr.getValue().equals(o)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] mas = new Object[size];
        if (isEmpty()) {
            System.out.println("List is empty");
            return mas;
        }
        Unit curr = head;
        int i = 0;
        while (curr != null) {
            mas[i] = curr.getValue();
            i++;
            curr = curr.getNext();
        }
        return mas;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return a;
        }
        Unit curr = head;
        int i = 0;
        while (curr != null) {
            a[i] = curr;
            i++;
            curr = curr.getNext();
        }
        return a;
    }

    @Override
    public Object set(int index, Object element) {
        if (isEmpty()) {
            return null;
        }
        Object time = null;
        Unit curr = head;
        while (curr != null) {
            if (curr.getId() == index) {
                time = curr.getValue();
                curr.setValue(element);
            }
            curr = curr.getNext();
        }
        return time;
    }

    @Override
    public int indexOf(Object o) {
        int i = -1;
        if (isEmpty()) {
            return i;
        }
        Unit curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
                i = curr.getId();
                return i;
            }
            curr = curr.getNext();
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = -1;
        if (isEmpty()) {
            return i;
        }
        Unit curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
                i = curr.getId();
            }
            curr = curr.getNext();
        }
        return i;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object curr : c) {
            add(curr);
        }
        return true;
    }

    @Override
    public void clear() {
        head.setNext(null);
        head.setValue(null);
        size = 0;
        head.setId(0);
    }

    @Override
    public boolean removeAll(Collection c) {
        if (isEmpty()) {
            return false;
        }
        for (Object curr : c) {
            remove(curr);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        int i = 0;
        for (Object curr : c) {
            add(index + (i++), curr);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean fir = true;
        for (Object curr : c) {
            if (!fir) {
                return false;
            }
            fir = contains(curr);
        }
        return fir;
    }

    private class ListItr002 implements ListIterator<Object> {
        private Unit lastReturned;
        private Unit next;
        private Unit prev;
        private int nextIndex;
        private int expectedModCount = 0;

        public ListItr002(int index) {
            if (index == size) {
                next = null;
                last = MyList.this.last;
            } else {
                next = head;
                last = MyList.this.last;
            }
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.getNext();
            nextIndex++;
            return lastReturned.getValue();
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public Object previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            if (next == null) {
                lastReturned = last;
                next = last;
            } else {
                lastReturned = next.getPrev();
                next = next.getPrev();
            }
            nextIndex--;
            return lastReturned.getValue();
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        private Object unlink(Unit x) {
            // assert x != null;
            final Object element = x.getValue();
            final Unit next = x.getNext();
            final Unit prev = x.getPrev();

            if (prev == null) {
                head = next;
            } else {
                prev.setNext(next);
                x.setPrev(null);
            }

            if (next == null) {
                last = prev;
            } else {
                next.setPrev(prev);
                x.setNext(null);
            }

            x.setValue(null);
            size--;
            return element;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            Unit lastNext = lastReturned.getNext();
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void set(Object o) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.setValue(o);
        }

        void linkLast(Object o) {
            final Unit l = last;
            final Unit newUnit = new Unit();
            newUnit.setValue(o);
            last = newUnit;
            if (l == null) {
                head = newUnit;
            } else {
                l.setNext(newUnit);
            }
            size++;
        }

        void linkBefore(Object e, Unit succ) {
            final Unit pred = succ.getPrev();
            final Unit newUnit = new Unit();
            newUnit.setValue(e);
            succ.setPrev(newUnit);
            if (pred == null)
                head = newUnit;
            else
                prev.setNext(newUnit);
            size++;
        }

        @Override
        public void add(Object o) {
            lastReturned = null;
            if (next == null)
                linkLast(o);
            else
                linkBefore(o, next);
            nextIndex++;
            expectedModCount++;
        }
    }

    @Override
    public Iterator iterator() {
        return new ListItr002(0);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        MyList newline = new MyList();
        Unit curr = getUnit(fromIndex);
        while (curr != getUnit(toIndex).getNext()) {
            newline.add(curr.getValue());
            curr = curr.getNext();
        }
        return newline;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (isEmpty()) {
            return false;
        }
        MyList time = new MyList();
        Unit curr = head;
        int timeSize = 0;
        while (curr != null) {
            for (Object o : c) {
                if (curr.getValue() == o) {
                    time.add(curr.getValue());
                    timeSize++;
                }
            }
            curr = curr.getNext();
        }
        System.out.println(time);
        clear();
        head = time.getUnit(0);
        last = time.getUnit(timeSize - 1);
        size = timeSize;
        return !isEmpty();
    }

    @Override
    public ListIterator listIterator() {
        return new ListItr002(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ListItr002(index);
    }

}
