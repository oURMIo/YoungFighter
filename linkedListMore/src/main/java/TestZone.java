import java.util.ArrayList;
import java.util.Collections;

public class TestZone {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    public static void main(String[] arg) {
        MyList list = new MyList();
        MyList list2 = new MyList();
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
        System.out.println("list = " + list.toString());
//        System.out.println("list2 = " + list2.toString());

        ArrayList<Object> c = new ArrayList<Object>();
        Collections.addAll(c, 1,2,3,"lolo");

        list.retainAll(c);
        System.out.println("list = " + list.toString());


    }
}
