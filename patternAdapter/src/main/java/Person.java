/*
 * Adaptee(Gof)
 */

public class Person {
    private String name;
    private int number;
    private int assessmentMath;
    private int assessmentPhysics;
    private int assessmentPhilosophy;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number=number;
    }
    public int getAssessmentMath(){
        return assessmentMath;
    }
    public void setAssessmentMath(int assessmentMath) {
        this.assessmentMath = assessmentMath;
    }
    public int getAssessmentPhysics() {
        return assessmentPhysics;
    }
    public void setAssessmentPhysics(int assessmentPhysics) {
        this.assessmentPhysics = assessmentPhysics;
    }
    public int getAssessmentPhilosophy() {
        return assessmentPhilosophy;
    }
    public void setAssessmentPhilosophy(int assessmentPhilosophy) {
        this.assessmentPhilosophy = assessmentPhilosophy;
    }
}
