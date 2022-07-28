/*
 * Dog class
 *
 */

public class Dog extends Animal {
    public Dog() {
        super("Dog", false);
    }

    @Override
    public int run() {
        return 3;
    }

    @Override
    public String voice() {
        return "GAV";
    }
/*
    //NOT USED
    public void lol() {
        System.out.printf("I'm a " + name + " and i'm not dangerous, so put meat in plate %n");

        System.out.println(superMethod());
        System.out.println(super.superMethod());
    }
    //NOT USED
    protected String superMethod(){
        return "I'm a dog!";
    }
*/
}