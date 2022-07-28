public class Main {
    public static void main(String[] arg){
        Info person1 = new InfoPerson();
        Info person2 = new InfoPerson();

        person1.fillInfo();
        person2.fillInfo();

        person1.printInfo();
        person2.printInfo();
    }
}
