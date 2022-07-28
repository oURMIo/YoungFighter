/*
 * Giena class
 *
 */

public class Giena extends Animal {
    public Giena() {
        super("Giena",true);
    }

    @Override
    public String voice() {
        return "GRR";
    }
}