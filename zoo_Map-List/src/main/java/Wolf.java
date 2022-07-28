/*
 * Wolf class
 *
 */

public class Wolf extends Animal {
    public Wolf() {
        super("Wolf",true);
    }

    @Override
    public String voice() {
        return "AYY";
    }
}