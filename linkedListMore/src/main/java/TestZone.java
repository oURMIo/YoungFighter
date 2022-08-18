import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class TestZone {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    public static void main(String[] arg) {
        MyList list = new MyList();
        String l = "lolo";
        list.add(random());
        list.add(l);
        list.add(55);
        list.add("toto");
        list.add(random());
        list.add(random());
        list.add(random());
        list.add(l);
        list.add(random());
        System.out.println("list = " + list);

        for (Iterator iterator = list.listIterator(); iterator.hasNext(); ) {
            Object next = (Object) iterator.next();
            System.out.println(next);
        }

        System.out.println("////////////");
        for (ListIterator iterator = list.listIterator(list.size()); iterator.hasPrevious(); ) {
            Object prev = (Object) iterator.previous();
            System.out.println(prev);
        }

    }
}
