import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

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

/*        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Object next = iterator.next();
            System.out.println(next);
        }*/
        list.iterator();
        for (Object o : list) {
            System.out.println(o);
        }
/*
        ArrayList<Object> c = new ArrayList<>();
        Collections.addAll(c, l,"toto",55,4,3,4,5);
        System.out.println(c);

        list.retainAll(c);
        System.out.println("list = " + list.toString());
        System.out.println(list.size());
*/



    }
}
