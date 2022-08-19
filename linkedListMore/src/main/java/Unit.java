class Unit {
    private int id;
    private Object value;
    private Unit next;

    /*  FOR ListIterator*/
    private Unit prev;

    public Unit getPrev() {
        return prev;
    }

    public void setPrev(Unit prev) {
        this.prev = prev;
    }
    /*/ FOR ListIterator*/

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Unit next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    public Unit getNext() {
        return next;
    }

    Unit() {
        id = 0;
        next = null;
        value = null;
        /*  FOR ListIterator*/
        prev = null;
    }
}
