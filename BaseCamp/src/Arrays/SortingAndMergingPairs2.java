package Arrays;

import java.util.Random;
import java.util.Scanner;

public class SortingAndMergingPairs2 {

	public static void main(String[] args) {
		
		Scanner kb=new Scanner(System.in);
		Random rand=new Random();
		int size;
		System.out.println("Enter the size");
		size=kb.nextInt();
		int sum=0;
		StringBuffer sb=new StringBuffer("abcdefghijklmnopqrstuvwxyz");
		int arr[]=new int[size];
		
		for(int i=0;i<100;i++){
			int a=rand.nextInt(100);
			sb.append(a);		
		}
		  //String []str=
		  
//System.out.println(sb);
		int alphabetLength = sb.length();
	    StringBuffer as=new StringBuffer();
	    for (int i = 0; i < size; i++)
	        as.append(sb.charAt(rand.nextInt(alphabetLength)));
	    
	    System.out.println(as);
		StringBuffer alpha=new StringBuffer();	
		for(int j=0;j<size;j++){
			
		}StringBuffer num=new StringBuffer();
		
		for(int i=0;i<as.length();i++){
			char c=as.charAt(i);
			if(!Character.isDigit(c)){
				alpha.append(c);
			}else {
				num.append(c);
			}
		}
				
		int count=0;
		for(int i=0;i<alpha.length();i++){
			if(alpha.charAt(i)=='a' || alpha.charAt(i)=='e' ||alpha.charAt(i)=='i' || alpha.charAt(i)=='o' || alpha.charAt(i)=='u'){
				count+=1;
			}
	}
		for(int a=0;a<num.length();a++){
			sum+=num.charAt(a);
		}
		System.out.println(sum+" "+count);

	}
}
