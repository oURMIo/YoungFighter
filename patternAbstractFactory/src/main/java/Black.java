/**
 * ConcreteProduct
 */

public class Black implements Fur {
    @Override
    public String color() {
        return "Black";
    }

    @Override
    public boolean fluffy() {
        return false;
    }
}
