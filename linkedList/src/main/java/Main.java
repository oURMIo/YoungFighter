import doublelinkedlist.DoubleLinkedList;
import linkedlist.OneLinkedList;
import org.w3c.dom.Node;

public class Main {
    private static void oneList() {
        System.out.printf("%n█████ Singly Liked List █████ %n");
        OneLinkedList list = new OneLinkedList();
        list.add(random());
        list.add("LOL");
        list.add(random());
        list.add("bears");
        list.add(random());
        list.add("dog");
        list.add(random());
        list.add("pizza");
        list.add((long) random());
        list.add("dog");

        list.printListAll();
        System.out.println("LIST SIZE = " + list.getSize());
        list.delete(0);
        list.printListAll();
        System.out.println("LIST SIZE = " + list.getSize());
        list.printUnitById((int) (Math.random() * 8+1));
    }

    public static void doubleList(){
        System.out.printf("%n█████ Doubly Liked List █████ %n");
        DoubleLinkedList list = new DoubleLinkedList();
        list.add(random());
        list.add("LOL");
        list.add(random());
        list.add("bears");
        list.add(random());
        list.add("dog");
        list.add(random());
        list.add("pizza");
        list.add((long) random());
        list.add("dog");

        list.printListAll();
        list.reverse();
        list.printListBack();
        System.out.println("LIST SIZE = " + list.getSize());
        list.delete(3);
        list.printListAll();
        System.out.println("LIST SIZE = " + list.getSize());
        list.printUnitById((int) (Math.random() * 8+1));
    }

    private static int random(){
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    public static void main(String[] args) {
        oneList();
        doubleList();

    }
}
