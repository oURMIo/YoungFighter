public class Student implements InfoGet{

    private final String type = "Student";
    private final int personCount = 100;
    private final int amountLike = 50;

    //GETTERS
    private int getPersonCount() {
        return personCount;
    }

    private int getAmountLike(){
        return amountLike;
    }

    @Override
    public void printInfo(){
        System.out.printf(" %s = %s %n",type, getPersonCount());
        System.out.printf(" How many like work = %s %n", getAmountLike());
        System.out.printf("It's a %s  percent %n %n", getPersonCount() * getAmountLike() / 100.0);
    }
}