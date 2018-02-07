package Arrays;


import java.util.Scanner;

public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name;
		int []vowelsCount=new int[5];
		int countA=0;
		int countE=0;
		int countI=0;
		int countO=0;
		int countU=0;
		System.out.println("Enter your name");
		Scanner kb=new Scanner(System.in);
		name=kb.nextLine();
		for(int i=0;i<name.length();i++){			
			if(name.charAt(i)=='a' ||name.charAt(i)=='A'){
				countA+=1;				
			}else if(name.charAt(i)=='e' ||name.charAt(i)=='E'){
				countE+=1;
			}else if(name.charAt(i)=='i' ||name.charAt(i)=='I'){
				countI+=1;
			}else if(name.charAt(i)=='o' ||name.charAt(i)=='O'){
				countO+=1;
			}else if(name.charAt(i)=='u' ||name.charAt(i)=='U'){
				countU+=1;
			}
		}
		if(countA==0 && countE==0 && countI==0 && countO==0 && countU==0){
			System.out.println("No vowels found in your name");
		}else{
			System.out.println("A is found " + countA+ " times");
			System.out.println("E is found " + countE+ " times");
			System.out.println("I is found " + countI+ " times");
			System.out.println("O is found " + countO+ " times");
			System.out.println("U is found " + countU+ " times");
		}
	}

}
