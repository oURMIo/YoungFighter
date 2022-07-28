/*
 * Animal
 *
 */

public abstract class Animal {
    protected final String name;        //JUST NAME
    protected final boolean danger;     //DANGER OR NOT
    private final int legs = 4;

    //ASSIGNMENT FOR EACH CHILD CLASS
    protected Animal(String name, boolean danger) {
        this.name = name;
        this.danger = danger;
    }

    //geters
    public String getName() {
        return name;
    }
    public boolean getDanger(){
        return danger;
    }

    public int run(){
        return legs;
    }

    /*
     *   METOD VOICE (more pafas)
     *   RETURN VOICE
     */
    public abstract String voice();

    //METOD WRITE TEXT
    public void nameDanger() {
        if (danger) {
            System.out.printf("I'm a %s and I'm dangerous and I say %s! So throw meat and run away!!! run-%s %n",name, voice(), run());  /* IF CLASS DANGER*/
        } else {
            System.out.printf("I'm a %s and I'm not dangerous and I say %s! So put meat in plate run-%s %n",name, voice(), run());       /* IF CLASS NOT DANGER*/
        }
    }
/*
    //NOT USED
    protected String superMethod(){
        return "I'm an animal with name " + name;
    }
 */
}