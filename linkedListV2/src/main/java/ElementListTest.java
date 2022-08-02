public class ElementListTest {
    static ElementList head;

    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    private static void add(Object obj) {
        ElementList newAll = new ElementList();
        newAll.value = obj;
        if (head == null) {
            head = newAll;
        } else {
            ElementList endList = head;
            ElementList preEndList = head;
            while (endList != null) {
                preEndList = endList;
                endList = endList.next;
            }
            preEndList.next = newAll;
        }
    }

    private static void printListAll() {
        ElementList currNode = head;
        while (currNode != null) {
            System.out.print("    " + currNode.value);
            currNode = currNode.next;
        }
        System.out.println();
    }

    private static void printAll(ElementList fir) {
        ElementList currNode = fir;
        System.out.print("PrintAll - ");
        while (currNode != null) {
            System.out.print("    " + currNode.value);
            currNode = currNode.next;
        }
        System.out.println();
    }

    private static int getSize() {
        ElementList currNode = head;
        int i = 0;
        while (currNode != null) {
            i++;
            currNode = currNode.next;
        }
        return i;
    }

    private static ElementList getUnit(int id) {
        ElementList currNode = head;
        int i = 0;
        while (i != id) {
            i++;
            currNode = currNode.next;
        }
        return currNode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            add(random());
        }
        ElementList first = getUnit(0);
        ElementList last = getUnit(9);
        printListAll();
        System.out.println("size = " + getSize());

        printAll(first);
        printAll(last);
    }
}
