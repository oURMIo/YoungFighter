public class AnimalType {
    protected String type;
    protected double kgMeat;

    public AnimalType(String type, double kgMeat) {
        this.type = type;
        this.kgMeat = kgMeat;
    }

    //getters
    public String getType() {
        return type;
    }
    public double getKgMeat() {
        return kgMeat;
    }

    //setters
    public void setType(String type){
        this.type = type;
    }
    public void setKgMeat(double kgMeat){
        this.kgMeat = kgMeat;
    }
}