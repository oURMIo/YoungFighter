public class ElementListTest2 {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    private static ElementList add(Object obj,ElementList first) {
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
        return first;
    }

    private static void printListAll(ElementList first) {
        ElementList currNode = first;
        while (currNode != null) {
            System.out.print("    " + currNode.getValue());
            currNode = currNode.getNext();
        }
        System.out.println();
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

    private static ElementList getUnit(int id,ElementList first) {
        ElementList currNode = first;
        int i = 0;
        while (i !=id) {
            i++;
            currNode = currNode.getNext();
        }
        return currNode;
    }

    private static ElementList getLastUnit(ElementList first) {
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
        ElementList first = null;
        ElementList last = null;
        boolean fir = true;
        for (int i = 0; i < 10; i++) {
            add(random(),first);
            if (fir){
                first = getLastUnit(first);
                fir = false;
            }
            last = getLastUnit(first);
        }
        System.out.println(getSize(first));
        printListAll(first);

        printAll(first);
        printAll(last);
    }
}
