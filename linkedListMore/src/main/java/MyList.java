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
            next = (index == size) ? null : head;
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

        /*  New things  */

        Unit prev;
        transient Unit last;
        transient Unit first;

/*        void linkLast(Object e) {
            final Unit l = last;
            final Unit newNode = new Unit();
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.setNext(newNode);
            size++;
//            modCount++;
        }

        void linkBefore(Object e, Unit succ) {
            // assert succ != null;
            final Unit pred = succ.prev;
            final Unit newNode = new Unit();
            succ.prev = newNode;
            if (pred == null)
                first = newNode;
            else
                pred.setNext(newNode);
            size++;
//            modCount++;
        }

        public void add(Object e) {
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
        }*/
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

    /*
        /////////////////////////////
        /////////   done    /////////
        /////////////////////////////
    */

    @Override
    public ListIterator listIterator() {
        ListItr newlist = new ListItr(0);
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        if (isEmpty()) {
            return false;
        }
        boolean changed = false;
        for (int i = size() - 1; i >= 0; i--) {
            Object obj = get(i);
            if (!contains(obj)) {
                remove(i);
                changed = true;
            }
        }
        return changed;
    }

}
