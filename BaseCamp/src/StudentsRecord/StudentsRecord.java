package StudentsRecord;

import java.util.*;

public class StudentsRecord {

	int studentId;
	String studentFirstName;
	String studentLastName;
	int semesterOneMarks;
	int semesterTwoMarks;
	int semesterThreeMarks;
	int smesterFourMarks;
	
	public StudentsRecord(int studentId, String studentFirstName, String studentLastName, int semesterOneMarks, int semesterTwoMarks, int semesterThreeMarks, int semesterFourMarks){
		this.studentId=studentId;
		this.studentFirstName=studentFirstName;
		this.studentLastName=studentLastName;
		this.semesterOneMarks=semesterOneMarks;
		this.semesterTwoMarks=semesterTwoMarks;
		this.semesterThreeMarks=semesterThreeMarks;
		this.smesterFourMarks=semesterFourMarks;
	}
	// public String toString() {
	  //      return (this.studentId+" "+this.studentFirstName+" "+this.studentLastName+" "+this.semesterOneMarks+" "+this.semesterTwoMarks+" "+this.semesterThreeMarks+" "+this.smesterFourMarks);
	  // }
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Students Details.");
		int choice=0;
		List<String> stuName=new ArrayList<>();
		List<Integer> stuMarks=new ArrayList<>();
		String studentFirstName1;
		int studentId1;
		String studentLastName1;
		int semesterOneMarks1;
		int semesterTwoMarks1;
		int semesterThreeMarks1;
		int semesterFourMarks1;
		System.out.println("How many Record do you wanna to Enter");
		choice =sc.nextInt();
		while(choice>0)
		{		
		System.out.println("Enter the Student's Id");
		 studentId1=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student's First Name");
		 studentFirstName1=sc.nextLine();
		System.out.println("Enter Student's LastName");
		 studentLastName1=sc.nextLine();
		System.out.println("Enter Semester Marks");
		System.out.println("Enter FirsSemester's Marks, SecondSemester's Marks, ThirdSemester's Marks, FouthSemester's Marks");
		 semesterOneMarks1=sc.nextInt();		
		 semesterTwoMarks1=sc.nextInt();		
		 semesterThreeMarks1=sc.nextInt();		
		 semesterFourMarks1=sc.nextInt();
		 StudentsRecord stuRecord=new StudentsRecord(studentId1,studentFirstName1,studentLastName1,semesterOneMarks1,semesterTwoMarks1,semesterThreeMarks1,semesterFourMarks1);
		 stuName.add(studentLastName1);
		 stuName.add(studentFirstName1);
		 stuMarks.add(studentId1);
		 stuMarks.add(semesterOneMarks1);
		 stuMarks.add(semesterTwoMarks1);
		 stuMarks.add(semesterThreeMarks1);
		 stuMarks.add(semesterFourMarks1);
		 choice--; 
		}
		ListIterator i= stuName.listIterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		ListIterator j= stuMarks.listIterator();
		while(j.hasNext()){
			System.out.println(j.next());
		}

		System.out.println("Search a Record 1.ByFirstName 2.ByID 3.ByLastName 4.BySemester");
		int ch=sc.nextInt();
		sc.nextLine();
		switch(ch){
		case 1: System.out.println("Enter Name");
				String name=sc.nextLine();
				if(checkValue(name,stuName) !=-1){
					for(int i1=0;i1<stuName.size();i1++)
					System.out.println(stuName.get(i1));
				}
				
		}
		
	}
	
	static int checkValue(String name, List<String> stuName){
		for(int i=0;i<stuName.size();i++){
			if(stuName.get(i).equals(name))
				return i;
		}
		return -1;
	}

}
