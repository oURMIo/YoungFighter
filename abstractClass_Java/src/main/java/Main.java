/*
 * Main class
 *
 */

public class Main {
    private static int i = 0;

    public static void main(String[] args) {
        //OBJECT
        Dog dog = new Dog();
        Wolf wolf = new Wolf();
        Shakal shakal = new Shakal();
        Giena giena = new Giena();

        dog.nameDanger();
        feed(dog);

        wolf.nameDanger();
        feed(wolf);

        shakal.nameDanger();
        feed(shakal);

        giena.nameDanger();
        feed(giena);

        getAnimal().nameDanger();
        getAnimal().nameDanger();
        getAnimal().nameDanger();
        getAnimal().nameDanger();
    }

    //METOD FOR FEED
    private static void feed(Animal pers) {
        System.out.printf(" feed - %s %n %n", pers.name);
    }

    private static Animal getAnimal() {
        if (i == 0) {
            i += 1;
            return new Dog();
        } else if (i == 1) {
            i += 1;
            return new Giena();
        } else if (i == 2) {
            i += 1;
            return new Shakal();
        }
        i = 0;
        return new Wolf();
    }
}