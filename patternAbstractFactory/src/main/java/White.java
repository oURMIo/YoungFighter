/**
 * ConcreteProduct
 */

public class White implements Fur{
    @Override
    public String color() {
        return "White";
    }

    @Override
    public boolean fluffy() {
        return true;
    }
}
