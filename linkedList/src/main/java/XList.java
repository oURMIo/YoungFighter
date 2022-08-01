package doublelinkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class XList implements List {
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Object get(int index) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    /**
     * Compares the specified object with this list for equality.  Returns
     * {@code true} if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements {@code e1} and
     * {@code e2} are <i>equal</i> if {@code Objects.equals(e1, e2)}.)
     * In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.  This
     * definition ensures that the equals method works properly across
     * different implementations of the {@code List} interface.
     *
     * @param o the object to be compared for equality with this list
     * @return {@code true} if the specified object is equal to this list
     */
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    /**
     * Returns the hash code value for this list.  The hash code of a list
     * is defined to be the result of the following calculation:
     * <pre>{@code
     *     int hashCode = 1;
     *     for (E e : list)
     *         hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
     * }</pre>
     * This ensures that {@code list1.equals(list2)} implies that
     * {@code list1.hashCode()==list2.hashCode()} for any two lists,
     * {@code list1} and {@code list2}, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this list
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    public int hashCode() {
        throw new UnsupportedOperationException("Not supported yet");
    }
}
