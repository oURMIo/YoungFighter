public class Teacher implements InfoGet{

    private final String type = "Teacher";
    private final int personCount = 20;
    private final int amountLike = 16;

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
        System.out.printf("It's a %s percent %n %n",((float) (getPersonCount()/getAmountLike()))*100.0 );
    }
}