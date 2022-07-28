/**
 * AbstractFactory
 */

public interface AbstractFactory {
    Animal createAnimal();

    Fur createFur();

    default void print(Animal obj1, Fur obj2) {
        System.out.printf("%n It's a %s and make sound %s with %s ",
                obj1.type(),
                obj1.sound(),
                obj2.color());
        if (obj2.fluffy()){
            System.out.println(" and very fluffy fur");
        } else {
            System.out.println(" and shabby fur");
        }
    }
}