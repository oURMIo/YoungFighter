import java.util.List;

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
        list.add(random());
        list.add("toto");
        list.add(random());
        list.add(l);
        System.out.println("list = " + list.toString());
        System.out.println("list = " + list2.toString());

        System.out.println(list.indexOf(l));
        System.out.println(list.indexOf("toto"));
        System.out.println(list.indexOf("t"));

        /*
        list.clear();
        System.out.println("list = " + list.toString());

        list.add(random());
        list.add(random());
        System.out.println("list = " + list.toString());
*/


    }
}
