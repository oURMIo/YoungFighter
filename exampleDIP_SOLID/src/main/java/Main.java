public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Wolf wolf = new Wolf();

        dog.sendCage(new Sender() {
            @Override
            public void sendCage(Sender cage) {

            }
        });

        wolf.sendCage(new Sender() {
            @Override
            public void sendCage(Sender cage) {

            }
        });
    }
}