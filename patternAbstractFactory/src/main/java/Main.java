/**
 * Client
 */

public class Main {
    public static AbstractFactory getFactory() {
        if (Math.random() * 2 < 1) {
            return new CatFactory();
        } else {
            return new DogFactory();
        }
    }

    public static void main(String[] arg) {
        AbstractFactory factory = getFactory();
        Animal animal = factory.createAnimal();
        Fur fur = factory.createFur();

        Animal animal1 = factory.createAnimal();
        Fur fur1 = factory.createFur();

        AbstractFactory factory1 = getFactory();
        Animal animal2 = factory1.createAnimal();
        Fur fur2 = factory1.createFur();

        factory.print(animal, fur);
        factory.print(animal1, fur1);
        factory1.print(animal2, fur2);
    }
}
