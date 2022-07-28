/**
 * ConcreteFactory
 */

public class DogFactory implements AbstractFactory{
    @Override
    public Animal createAnimal() {
            return new Dog();
    }

    @Override
    public Fur createFur() {
        if(Math.random() * 2 < 1){
            return new White();
        }
        return new Black();
    }
}