import java.util.*;
import java.util.stream.IntStream;

public class TestZone {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    public static void main(String[] arg) {
        MyList list = new MyList();
        IntStream.range(0, 10).forEach(list::add);
        System.out.println("list = " + list);

        System.out.printf(" %n /// from head to last   /// %n");
        for (Iterator iterator = list.listIterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.print(next + " ");
        }

        System.out.printf(" %n /// from last to head   /// %n");
        for (ListIterator iterator = list.listIterator(list.size()); iterator.hasPrevious(); ) {
            Object prev = iterator.previous();
            System.out.print(prev + " ");
        }

    }
}
