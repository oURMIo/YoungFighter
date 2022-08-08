class ElementList {
    private Object value;
    private ElementList next;

    ElementList() {
        next = null;
        value = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ElementList getNext() {
        return next;
    }

    public void setNext(ElementList next) {
        this.next = next;
    }
}
