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

    public static void printListAll() {
        ElementList currNode = head;
        while (currNode != null) {
            System.out.print("    " + currNode.value);
            currNode = currNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ElementList first = null;
        ElementList last = null;
        for (int i = 0; i < 10; i++) {
            add(random());
        }
        printListAll();
    }
}
