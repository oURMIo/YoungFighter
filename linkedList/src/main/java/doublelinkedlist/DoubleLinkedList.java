package doublelinkedlist;

public class DoubleLinkedList {
    Node head;
    Node back;
    int size;

    public DoubleLinkedList() {
        head = null;
        back = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Object obj) {
        Node newAll = new Node();
        size++;
        newAll.id = size;
        newAll.val = obj;
        if (isEmpty()) {
            head = newAll;
        } else {
            back.next = newAll;
        }
        newAll.prev = back;
        back = newAll;
    }

    public void delete(int id) {
        if (head == null) {   /*   IF LIST IS NULL   */
            return;
        }
        if (head.id == id) {   /*   IF WE NEED FIRST   */
            head = head.next;
            size--;
            return;
        }
        if (id < 0) {
            return;
        }
        Node find = head;
        while (find.next != null) {
            if (find.next.id == id) {
                find.next = find.next.next;

            }
            find = find.next;
        }
        size--;
        replaceId();
        System.out.printf("/////   YOU DELETE UNIT WITH ID = %s /////%n%n", id);
    }

    public void replaceId() {
        Node time = head;

        for (int i = 0; i < size; i++) {
            time.id = i;
            time = time.next;
        }
    }

    public void printListAll() {
        Node currNode = head;
        System.out.print("Print list - ");
        while (currNode != null) {
            System.out.printf(" id %s - [ %s ]   ", currNode.id, currNode.val);
            currNode = currNode.next;
        }
        System.out.println();
    }

    public void swap(Node node)
    {
        Node prev = node.prev;
        node.prev = node.next;
        node.next = prev;
    }

    public void reverse()
    {
        System.out.printf("%n/////   REVERSE    /////%n");
        Node prev = null;
        Node curr = head;
        while (curr != null)
        {
            swap(curr);
            prev = curr;
            curr = curr.prev;
        }
        if (prev != null) {
            head = prev;
        }
        //end reverse
        replaceId();
        printListAll();
        //return old list
        System.out.printf("/////   CANSEL REVERSE    /////%n %n");
        prev = null;
        curr = head;
        while (curr != null)
        {
            swap(curr);
            prev = curr;
            curr = curr.prev;
        }
        if (prev != null) {
            head = prev;
        }
        replaceId();
    }

    public void printListBack() {
        if (isEmpty()){
            return;
        }
        Node currNode = back;
        System.out.print("Print list Back- ");
        while (currNode != null) {
            System.out.printf(" id %s - [ %s ]   ", currNode.id, currNode.val);
            currNode = currNode.prev;
        }
        System.out.println();
    }

    public void printUnitById(int id) {
        if (isEmpty()){
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            if (currNode.id == id) {
                System.out.printf("Unit with id %s = [ %s ]", id, currNode.val);
            }
            currNode = currNode.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
