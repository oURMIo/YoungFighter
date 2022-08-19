import java.util.*;

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
        list.add(random());
        list.add(l);
        list.add(random());
        System.out.println("list = " + list);

/*
        ArrayList<Object> col = new ArrayList<>(Arrays.asList(1, 2, 3, l, 55));
        System.out.println("Collection = "+col);
        list.retainAll(col);
        System.out.println("list = " + list);
        System.out.println(list.size());
        */

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
