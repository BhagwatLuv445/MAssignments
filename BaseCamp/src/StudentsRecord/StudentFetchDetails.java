package StudentsRecord;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentFetchDetails {
	
	Scanner sc=new Scanner(System.in);
	//static ArrayList<Student> arrayList=new ArrayList();	
	
	public void searchDetails(ArrayList<Student> arrayList){
		System.out.println("Select the option to search...\n 1. Roll Number \n 2. First Name \n 3. Last Name \n 4. Semester \n ");
		int choice=sc.nextInt();
		switch(choice){
		case 1: System.out.println("Enter Roll Number");
		 		int rollNumber=sc.nextInt();
		 		for(Student s:arrayList){
		 		//	System.out.print(s.getRollno());
		 			if(s.getRollno()==rollNumber){
		 				System.out.print(s.getfirstName()+" "+s.getLastName()+" "+s.getSem1()+" "+s.getSem2()+" "+s.getSem3()+" "+s.getSem4());
		 				System.out.println();
		 			}		 			
		 		}
		 		break;
		case 2: System.out.println("Enter First Name");
				String firstName=sc.next();
				for(Student s:arrayList){
					if(s.getfirstName().equalsIgnoreCase(firstName)){
						System.out.print(s.getfirstName()+" "+s.getLastName()+" "+s.getSem1()+" "+s.getSem2()+" "+s.getSem3()+" "+s.getSem4());
						System.out.println();
					}
				}
				break;
		case 3: System.out.println("Enter Last Name");
		 		String lastName = sc.next();
		 		for(Student s:arrayList){
		 			if(s.getLastName().equalsIgnoreCase(lastName)){
		 				System.out.print(s.getfirstName()+" "+s.getLastName()+" "+s.getSem1()+" "+s.getSem2()+" "+s.getSem3()+" "+s.getSem4());
		 				System.out.println();
		 			}
		 		}
		 		break;
		case 4: System.out.println("\t 1. Semester 1\n \t 2. Semester 2\n \t 3. Semester 3\n \t 4. Semester 4");
				int semChoice = sc.nextInt();
				switch(semChoice){
				case 1: for(Student s:arrayList){
						System.out.println(s.getfirstName()+" "+s.getLastName()+" "+s.getSem1());
						}
						break;
				case 2: for(Student s:arrayList){
						System.out.println(s.getfirstName()+" "+s.getLastName()+" "+s.getSem2());
						}
						break;
				case 3:for(Student s:arrayList){
						System.out.println(s.getfirstName()+" "+s.getLastName()+" "+s.getSem3());
						}
						break;
				case 4:for(Student s:arrayList){
						System.out.println(s.getfirstName()+" "+s.getLastName()+" "+s.getSem4());
						}
						break;
				}
				break;
		default :System.out.println("Choose Correct Option To search...");
		}
	}
}
