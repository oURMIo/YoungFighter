import java.util.*;

public class MyList implements List {

    private int size;
    private Unit head;

    public void replaceId() {
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

    public Object getVal(int index) {
        Unit curr = head;
        Object time = null;
        while (curr != null) {
            if (curr.getId() == index) {
                time = curr.getValue();
            }
            curr = curr.getNext();
        }
        return time;
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
        size++;
        newAll.setValue(o);
        if (head == null) {
            head = newAll;
        } else {
            Unit endList = head;
            Unit preEndList = head;
            while (endList != null) {
                preEndList = endList;
                endList = endList.getNext();
            }
            preEndList.setNext(newAll);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        if (head.getValue() == o) {   /*   IF WE NEED FIRST   */
            head = head.getNext();
            size--;
            return true;
        }
        Unit find = head;
        while (find.getNext() != null) {
            if (find.getNext().getValue() == o) {
                find.setNext(find.getNext().getNext());
                size--;
            }
            find = find.getNext();
        }
        replaceId();
        return true;
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
    public Unit get(int index) {
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

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            return null;
        }
        Object time = null;
        if (head.getId() == index) {
            time = head.getValue();
            head = head.getNext();
            size--;
            return time;
        }
        Unit find = head;
        while (find.getNext() != null) {
            if (find.getNext().getId() == index) {
                time = find.getValue();
                find.setNext(find.getNext().getNext());
            }
            find = find.getNext();
        }
        size--;
        replaceId();
        return time;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size) {
            return;
        }
        Unit newAll = new Unit();
        newAll.setId(index);
        newAll.setValue(element);
        size++;
        if (head == null) {
            head = newAll;
        } else {
            int i = 0;
            Unit endList = head;
            Unit preEndList = head;
            while (i != index) {
                preEndList = endList;
                newAll.setNext(endList.getNext());
                endList = endList.getNext();
                i++;
            }
            preEndList.setNext(newAll);
        }
        replaceId();
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        Unit curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
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
            mas[i] = curr;
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

    private class ListItr implements Iterator<Object> {
        private Unit lastReturned;
        private Unit next;
        private int nextIndex;
//        private int expectedModCount = modCount;

        ListItr(int index) {
            // assert isPositionIndex(index);
            if (index == size) next = null;
            else next = head;
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.getNext();
            nextIndex++;
            return lastReturned.getValue();
        }
    }

    private class ListItr002 implements ListIterator<Object> {
        private Unit lastReturned;
        private Unit next;
        private Unit prev;
        private int nextIndex;
        private Unit last;
        private Unit first;

        public ListItr002(int index) {
            if (index == size) next = null;
            else next = head;
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

            if (next == null) lastReturned = next = last;
            else lastReturned = next = next.getPrev();
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
                first = next;
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
//            modCount++;
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
        }

        @Override
        public void set(Object o) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.setValue(o);
        }

        void linkLast(Object o) {
            final Unit l = last;
            final Unit newNode = new Unit();
            newNode.setValue(o);
            last = newNode;
            if (l == null)
                head = newNode;
            else
                l.setNext(newNode);
            size++;
        }

        void linkBefore(Object e, Unit succ) {
            final Unit pred = succ.getPrev();
            final Unit newNode = new Unit();
            newNode.setValue(e);
            succ.setPrev(newNode);
            if (pred == null)
                head = newNode;
            else
                prev.setNext(newNode);
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
        }
    }

    @Override
    public Iterator iterator() {
        return new ListItr(0);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        MyList newline = new MyList();
        Unit curr = get(fromIndex);
        while (curr != get(toIndex)) {
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
        head = time.get(0);
        size = timeSize;
        if (isEmpty()) {
            return false;
        }
        return true;
    }

    /*
        /////////////////////////////
        /////////   done    /////////
        /////////////////////////////
    */

    @Override
    public ListIterator listIterator() {
        return new ListItr002(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ListItr002(index);
    }

}
