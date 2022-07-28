public class Wolf implements Sender {
    String name = "Wolf";
//    boolean danger = false;

    @Override
    public void sendCage(Sender cage) {
        System.out.printf(" It's a %s. send it in specially cage %n", name);
    }
}