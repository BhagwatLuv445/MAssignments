package BaseCampJava;

import java.util.Scanner;

class Manipulation{
	
	public void additionNumber(int num1,int num2){
		int sum=0;
		for(int i=num1;i<=num2;i++){
			sum+=i;
		}
		System.out.println("Sum of the number from " +num1+ " to " +num2+ " is " +sum);
	}
	public void additionString(String s1,String s2){
		String merge=s1.concat(s2);
		System.out.println("The concatenation of String is" +merge);
	}
	public void tableOfNumber(int num11){
		int i=1;
		while(i<=10){
			System.out.println("Table of the number is:" +num11+ "*" +i+ " =" +i*num11);
			i++;
		}
		
	}
	public void eligibility(int age){
		if(age>18){
			System.out.println("You are eligilble for voting");
		}else{
			System.out.println("You are under age, You cant vote...wait for" + (18-age) + "years to vote");
		}
	}
}
	
	



	class KoCapabilitiesJira{
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c;
	do{
		System.out.println("Which Operations Do yoy Wanna Perform...");
		System.out.println("1. Addition of Number");
		System.out.println("2. Addition Of String");
		System.out.println("3. Table of Number");
		System.out.println("4. Check for voting eligibility");
		int choice;		
		Manipulation adnum=new Manipulation();
		Scanner kb=new Scanner(System.in);
		System.out.println("Enter Your Choice");
		choice=kb.nextInt();
		switch(choice){
		case 1: System.out.println("Enter two number from which to that number");
				int num1,num2;
				num1=kb.nextInt();
				num2=kb.nextInt();
				adnum.additionNumber(num1,num2);
				break;
		case 2: System.out.println("Enter Two String");
				String s1=kb.next();
				String s2=kb.next();
				adnum.additionString(s1,s2);
				break;
		case 3: System.out.println("Enter the number");
				int num11=kb.nextInt();
				adnum.tableOfNumber(num11);
				break;
		case 4: System.out.println("Enter your age");
				int age=kb.nextInt();
				adnum.eligibility(age);
				break;
		
		default : System.out.println("Enter valid option"); 
		}
		System.out.println("Do you want to continue(1)");
		 c=kb.nextInt();		
	}while(c==1);
	}

}