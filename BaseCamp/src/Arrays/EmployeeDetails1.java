package Arrays;


import java.util.Scanner;


public class EmployeeDetails1 {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][]str=new String[3][4];
		
	Scanner kb=new Scanner(System.in);		
	for(int i=0;i<3;i++){
		System.out.println("Enter your Name, Department, Phone, Address");
		for(int j=0;j<4;j++){
			if(j==0){
				
				str[i][j]=kb.nextLine();
			}else if(j==1){
				
				str[i][j]=kb.nextLine();
			}else if(j==2){
				
				str[i][j]=kb.nextLine();
			}else if(j==3){
				
				str[i][j]=kb.nextLine();
			}
			
		}
	}
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				System.out.println(str[i][j]);
			}
		}
	System.out.println("Do your wanna Search the data...or delete the data(Search)");
	String sd=kb.next();
	if(sd.equalsIgnoreCase("search")){
		System.out.println("Enter the criteria to search\n 1. Name\n 2. Dept\n 3. phone\n 4. Address\n");
		int choice=kb.nextInt();
		switch(choice){
		case 1: System.out.println("Enter name to search");
		        String name;
		        name=kb.next();
				EmployeeDetailsManipulation.searchByName(str, name);
				break;
		case 2: System.out.println("Enter dept to search");
		        String dept=kb.next();
		        EmployeeDetailsManipulation.searchByDept(str, dept);
				break;
		case 3: System.out.println("Enter phone to search");
		        String phone=kb.next();
		        EmployeeDetailsManipulation.searchByPhone(str, phone);
				break;
		case 4: System.out.println("Enter address to search");
		        String add=kb.next();
		        EmployeeDetailsManipulation.searchByAddress(str, add);
				break;
		default :System.out.println("Enter correct");
		}
	}else{
		System.out.println("Thanks...");
	}	
					
	}

}