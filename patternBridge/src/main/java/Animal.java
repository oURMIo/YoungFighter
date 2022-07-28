public class Animal {
    protected String character;
    protected boolean active;
    protected final AnimalType animalType;

    public Animal(String character,boolean active, AnimalType animalType){
        this.character = character;
        this.active = active;
        this.animalType = animalType;
    }

    public void feed() {
        System.out.printf("give %s kg meal %n", animalType.getKgMeat());
    }

    public void send() {
        if (active) {
            System.out.printf("This animal is %s so send in village %n",character);
        } else {
            System.out.printf("This animal is %s so send in home %n",character);
        }
    }

    public void print() {
        System.out.printf(" It's a %s %s! It needs %s kg meal %n",
                character,
                animalType.getType(),
                animalType.getKgMeat());
    }
}