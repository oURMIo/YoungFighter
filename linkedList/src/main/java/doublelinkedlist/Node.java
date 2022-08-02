package doublelinkedlist;

class Node {
    int id;
    Node next;
    Node prev;
    Object val;

    /**
     * Constructor
     * <p>
     * param - int b
     */
    Node() {
        id = 0;
        next = null;
        prev = null;
        val = null;
    }
}
