public class Main {
    public static void all(Animal animal){
        animal.print();
        animal.feed();
        animal.send();
        System.out.println();
    }
    private static Animal createAnimal(){
        if (Math.random() * 2 < 1) {
            if (Math.random() * 2 < 1){
                return new Wild(new Cat());
            }else {
                return new Wild(new Dog());
            }
        } else {
            if (Math.random() * 2 < 1){
                return new Homely(new Cat());
            }else {
                return new Homely(new Dog());
            }
        }
    }

    public static void main(String[] args) {
        Animal animal1 = createAnimal();
        Animal animal2 = createAnimal();
        Animal animal3 = createAnimal();
        Animal animal4 = createAnimal();

        all(animal1);
        all(animal2);
        all(animal3);
        all(animal4);
    }
}