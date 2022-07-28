/**
 * ConcreteProduct
 */

public class Dog implements Animal{
    @Override
    public String type() {
        return "Dog";
    }

    @Override
    public String sound() {
        return "Gav";
    }
}
