public class Homely extends Animal{
    public Homely(AnimalType animalType) {
        super("Homely",false, animalType);
        if (animalType instanceof Cat){
            animalType.setType("Cat");
            animalType.setKgMeat(0.6);
        } else {
            animalType.setType("Dog");
            animalType.setKgMeat(1.2);
        }
    }
}
