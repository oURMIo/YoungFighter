class Unit {

    private int id;
    private Object value;
    private Unit next;

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
    }
}
