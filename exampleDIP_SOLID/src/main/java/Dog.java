public class Dog implements Sender {
    String name = "Dog";
//    boolean danger = false;

    @Override
    public void sendCage(Sender cage) {
        System.out.printf(" It's a %s. send it in usually cage %n", name);
    }
}