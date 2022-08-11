import java.util.*;

public class MyList implements List {
    private Object value;
    private MyList next;

    private int id;
    private int size;
    private MyList head;

    MyList() {
        id = 0;
        next = null;
        value = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public MyList getNext() {
        return next;
    }

    public void setNext(MyList next) {
        this.next = next;
    }

    public void replaceId() {
        MyList time = head;
        for (int i = 0; i < size; i++) {
            time.id = i;
            time = time.next;
        }
    }

    public void reverse() {
        MyList prev = null;
        MyList current = head;
        MyList next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        replaceId();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        MyList curr = head;
        while (curr != null) {
            result.append(curr.id).append(" = ").append(curr.getValue()).append("\t");
            curr = curr.next;
        }
        return result.toString();
    }

    @Override
    public boolean add(Object o) {
        MyList newAll = new MyList();
        newAll.id = size;
        size++;
        newAll.value = o;
        if (head == null) {
            head = newAll;
        } else {
            MyList endList = head;
            MyList preEndList = head;
            while (endList != null) {
                preEndList = endList;
                endList = endList.next;
            }
            preEndList.next = newAll;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }
        if (head.value == o) {   /*   IF WE NEED FIRST   */
            head = head.next;
            size--;
            return true;
        }
        MyList find = head;
        while (find.next != null) {
            if (find.next.value == o) {
                find.next = find.next.next;
            }
            find = find.next;
        }
        size--;
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
    public Object get(int index) {
        MyList curr = head;
        Object time = null;
        while (curr != null) {
            if (curr.id == index) {
                time = curr.getValue();
            }
            curr = curr.next;
        }
        return time;
    }

    @Override
    public Object remove(int index) {
        if (isEmpty()) {
            return null;
        }
        Object time = null;
        if (head.id == index) {
            time = head.getValue();
            head = head.next;
            size--;
            return time;
        }
        MyList find = head;
        while (find.next != null) {
            if (find.next.id == index) {
                time = find.getValue();
                find.next = find.next.next;
            }
            find = find.next;
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
        MyList newAll = new MyList();
        newAll.id = index;
        newAll.value = element;
        size++;
        if (head == null) {
            head = newAll;
        } else {
            int i = 0;
            MyList endList = head;
            MyList preEndList = head;
            while (i != index) {
                preEndList = endList;
                newAll.next = endList.next;
                endList = endList.next;
                i++;
            }
            preEndList.next = newAll;
        }
        replaceId();
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty()) {
            return false;
        }
        MyList curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
                return true;
            }
            curr = curr.next;
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
        MyList curr = head;
        int i = 0;
        while (curr != null) {
            mas[i] = curr;
            i++;
            curr = curr.next;
        }
        return mas;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return a;
        }
        MyList curr = head;
        int i = 0;
        while (curr != null) {
            a[i] = curr;
            i++;
            curr = curr.next;
        }
        return a;
    }

    @Override
    public Object set(int index, Object element) {
        if (isEmpty()) {
            return null;
        }
        Object time = null;
        MyList curr = head;
        while (curr != null) {
            if (curr.id == index) {
                time = curr.getValue();
                curr.value = element;
            }
            curr = curr.next;
        }
        return time;
    }

    @Override
    public int indexOf(Object o) {
        int i = -1;
        if (isEmpty()) {
            return i;
        }
        MyList curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
                i = curr.id;
                return i;
            }
            curr = curr.next;
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i = -1;
        if (isEmpty()) {
            return i;
        }
        MyList curr = head;
        while (curr != null) {
            if (curr.getValue() == o) {
                i = curr.id;
            }
            curr = curr.next;
        }
        return i;
    }

/*
    /////////////////////////////
    /////////   done    /////////
    /////////////////////////////
*/

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /*!!!   question    */
    @Override
    public void clear() {
        head.next = null;
        head.setValue(null);
//        head.setId(null);
        size = 0;
    }

    /*!!!   question    */
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}