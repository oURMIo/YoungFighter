/*
 * Adapter(Gof)
 */

public class InfoPerson implements Info {
    private final Person person = new Person();

    @Override
    public void fillInfo() {
        // не придумал ничего лучше чем зарание записать(
        person.setName("/NAME/ ");
        person.setNumber((int) (Math.random() * 100) + (int) (Math.random() * 100));
        person.setAssessmentMath(1 + (int) (Math.random()*5));
        person.setAssessmentPhysics(1 + (int) (Math.random()*5));
        person.setAssessmentPhilosophy(1 + (int) (Math.random()*5));
        person.setAssessmentPhilosophy(1 + (int) (Math.random()*5));
    }

    @Override
    public void printInfo() {
        System.out.printf(" NAME = %s  with number=%s and grades M/Phy/Phi %s %s %s %n",
                person.getName(),
                person.getNumber(),
                person.getAssessmentMath(),
                person.getAssessmentPhysics(),
                person.getAssessmentPhilosophy());
        System.out.printf(" average score = %s %n",
                (person.getAssessmentMath()+ person.getAssessmentPhysics()+ person.getAssessmentPhilosophy())/3.0);
    }
}
