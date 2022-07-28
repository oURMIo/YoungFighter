/**
 * ConcreteProduct
 */

public class Cat implements Animal {
    @Override
    public String type() {
        return "Cat";
    }

    @Override
    public String sound() {
        return "Meow";
    }
}
