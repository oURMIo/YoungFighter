package linkedlist;

public class OneLinkedList {
    Node head;
    int size;

    public void add(Object obj) {
        Node newAll = new Node();
        newAll.id = size;
        size++;
        newAll.val = obj;
        if (head == null) {
            head = newAll;
        } else {
            Node endList = head;
            Node preEndList = head;
            while (endList != null) {
                preEndList = endList;
                endList = endList.next;
            }
            preEndList.next = newAll;
        }
    }

    public void delete(int id) {
        if (head == null) {   /*   IF LIST IS NULL   */
            return;
        }
        if (id < 0) {
            return;
        }
        if (head.id == id) {   /*   IF WE NEED FIRST   */
            head = head.next;
            size--;
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
        replacId();
        System.out.printf("/////   YOU DELETE UNIT WITH ID = %s /////%n%n", id);
    }

    public void replacId() {
        Node time = head;

        for (int i = 0; i < size; i++) {
            time.id = i;
            time = time.next;
        }
    }

    public void printListAll() {
        Node currNode = head;
        while (currNode != null) {
            System.out.printf("   id %s - [ %s ]   ", currNode.id, currNode.val);
            currNode = currNode.next;
        }
        System.out.println();
    }

    public void printUnitById(int id) {
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
