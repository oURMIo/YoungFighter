public class ElementListTest {
    static ElementList first;
    static ElementList last;

    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    private static void add(Object obj) {
        ElementList newAll = new ElementList();
        newAll.setValue(obj);
        if (first == null) {
            first = newAll;
        } else {
            ElementList endList = first;
            ElementList preEndList = first;
            while (endList != null) {
                preEndList = endList;
                endList = endList.getNext();
            }
            preEndList.setNext(newAll);
        }
    }

    private static void printListAll() {
        ElementList currNode = first;
        while (currNode != null) {
            System.out.print("    " + currNode.getValue());
            currNode = currNode.getNext();
        }
        System.out.println();
    }

    private static int getSize() {
        ElementList currNode = first;
        int i = 0;
        while (currNode != null) {
            i++;
            currNode = currNode.getNext();
        }
        return i;
    }

    private static ElementList getUnit(int id) {
        ElementList currNode = first;
        int i = 0;
        while (i !=id) {
            i++;
            currNode = currNode.getNext();
        }
        return currNode;
    }

    private static ElementList getLastUnit() {
        ElementList currNode = first;
        ElementList precurrNode = null;
        while (currNode != null) {
            precurrNode = currNode;
            currNode = currNode.getNext();
        }
        return precurrNode;
    }

    private static void printAll(ElementList fir) {
        ElementList currNode = fir;
        System.out.print("PrintAll - ");
        while (currNode != null) {
            System.out.print("    " + currNode.getValue());
            currNode = currNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean fir = true;
        for (int i = 0; i < 10; i++) {
            add(random());
            if (fir){
                first = getLastUnit();
                fir = false;
            }
            last = getLastUnit();
        }
        printAll(first);
        printAll(last);
    }
}
