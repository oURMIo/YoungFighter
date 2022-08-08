public class ElementListTest {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    private static ElementList add(Object obj, ElementList first) {
        ElementList newAll = new ElementList();
        newAll.setValue(obj);
        if (first == null) {
            return newAll;
        } else {
            ElementList endList = first;
            ElementList preEndList = first;
            while (endList != null) {
                preEndList = endList;
                endList = endList.getNext();
            }
            preEndList.setNext(newAll);
        }
        return newAll;
    }

    private static int getSize(ElementList first) {
        ElementList currNode = first;
        int i = 0;
        while (currNode != null) {
            i++;
            currNode = currNode.getNext();
        }
        return i;
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

    private static ElementList reverse(ElementList fir) {
        System.out.printf("%n/////   REVERSE   /////%n");
        ElementList prev = null;
        ElementList curr = fir;
        while (curr != null) {
            ElementList next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ElementList first = null;
        ElementList last = null;
        boolean fir = true;
        for (int i = 0; i < 10; i++) {
            last = add(random(), last);
            if (fir) {
                first = last;
                fir = false;
            }
        }
        System.out.println("list size = " + getSize(first));

        printAll(first);
        printAll(last);

        last = first;
        first = reverse(first);
        printAll(first);
        printAll(last);

        last = first;
        first = reverse(first);
        printAll(first);
        printAll(last);

    }
}
