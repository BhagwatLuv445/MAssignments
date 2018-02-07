package StudentsRecord;

public class Student  {
    private String firstName;
    private String lastName;
    private int rollno;
    private float sem1;
    private float sem2;
    private float sem3;
    private float sem4;

    public Student(){
    	
    }
    public Student(int rollno, String firstName, String lastName, float sem1, float sem2, float sem3, float sem4) {
         this.rollno = rollno;
         this.firstName = firstName;
         this.lastName=lastName;
         this.sem1 = sem1;
         this.sem2 = sem2;
         this.sem3 = sem3;
         this.sem4 = sem4;
    }

    public String getfirstName() {
         return firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName){
    	this.lastName = lastName;
    }
    public int getRollno() {
    	return rollno;
    }
    public void setRollno(int rollno) {
    	this.rollno = rollno;
    }
    public float getSem1() {
    	return sem1;
    }
    public void setSem1(float sem1){
    	this.sem1 = sem1;
    }
    public float getSem2(){
    	return sem2;
    }
    public void setSem2(float sem2) {
    	this.sem2 = sem2;
    }	
    public float getSem3(){
    	return sem3;
    }
    public void setSem3(float sem3){
    	this.sem3 = sem3;
    }
    public float getSem4(){
    	return sem4;
    }
    public void setSem4(float sem4){
    	this.sem4 = sem4;
    }


}
