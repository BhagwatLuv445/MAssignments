package StudentsRecord;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentInsertData {

		
	 Scanner sc=new Scanner(System.in);
	 
	public void setDtails(ArrayList<Student> arrayList){	
	
		System.out.println("How Many Students Record Do you wanna Store..");
		int num = sc.nextInt();
		int i=0;
		while(i<num){
			Student s=new Student();
		System.out.println("Enter RollNumber");
		int rollNumber = sc.nextInt();		
		System.out.println("Enter First Name");
		String firstName = sc.next();
		System.out.println("Enter Last Name");
		String lastName = sc.next();
		System.out.println("Enter Semester One");
		float sem1 = sc.nextFloat();
		System.out.println("Enter Semester Two");
		float sem2 = sc.nextFloat();
		System.out.println("Enter Semester Third");
		float sem3 = sc.nextFloat();
		System.out.println("Enter Semester Four");
		float sem4 = sc.nextFloat();
		s.setRollno(rollNumber);
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setSem1(sem1);
		s.setSem2(sem2);
		s.setSem3(sem3);
		s.setSem4(sem4);
		putDataInArrayList(s,arrayList);
		System.out.println("Details are Inserted...");
		i++;
		
		}
		//show(arrayList);	
	}
	private void putDataInArrayList(Student s, ArrayList<Student> arrayList){
		arrayList.add(s);
		//int j=0;
	
	}
	
	private void show(ArrayList<Student> arrayList){
		for(int i=0;i<arrayList.size();i++){
			System.out.println(arrayList.get(i).getfirstName());
			/*System.out.print(i.getfirstName());
			System.out.println(i.getLastName());
			System.out.println(i.getSem1());
			System.out.println(i.getSem2());
			System.out.println(i.getSem3());
			System.out.println(i.getSem4()); */
		}
	}
}
