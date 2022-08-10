public class TestZone {
    private static int random() {
        return (int) (Math.random() * 100 - Math.random() * 50);
    }

    public static void main(String[] arg) {
        MyList list = new MyList();
        MyList list2 = new MyList();
        list.add(random());
        list.add("lolo");
        list.add(random());
        list.add("toto");
        list.add(random());
        System.out.println("list = " + list.toString());
        System.out.println("list = " + list2.toString());

        list.clear();
        System.out.println("list = " + list.toString());
//        list.add(3,"NOW");
//        System.out.println("list = " + list.toString());
    }
}
