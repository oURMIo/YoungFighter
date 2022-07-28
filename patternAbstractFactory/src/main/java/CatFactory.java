/**
 * ConcreteFactory
 */

public class CatFactory implements AbstractFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }

    @Override
    public Fur createFur() {
        if (Math.random() * 2 < 1) {
            return new White();
        }
        return new Black();
    }
}